
package br.com.softwareexpress.sitef.android;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import br.com.softwareexpress.sitef.android.IPinPadDriver;
import br.com.softwareexpress.sitef.android.PinPad;
import java.util.HashMap;
import java.util.Iterator;

class PinPadDriverUSB implements IPinPadDriver {
    protected static final int OPERACAO_NENHUMA = 0;
    protected static final int OPERACAO_LEITURA = 1;
    protected static final int OPERACAO_ESCRITA = 2;
    protected static final int OPERACAO_FLUSH = 3;
    protected static final int OPERACAO_TERMINA_THREAD = 4;
    protected static final int OPERACAO_VALIDA_PERMISSAO_USB = 5;
    protected static final int OPERACAO_ABRE_CONEXAO_USB = 6;
    private PinPadDriverUSB.Driver driver;
    private PinPad pinpad;

    PinPadDriverUSB(Activity var1, PinPad var2) throws Exception {
        this.pinpad = var2;
        this.driver = new PinPadDriverUSB.Driver(var1);
    }

    private void iniciaAguardaTratamento() {
        this.driver.processing = true;

        while(this.driver.processing) {
            try {
                Thread.sleep(100L);
            } catch (Exception var2) {
                this.pinpad.log(var2.getMessage());
            }
        }

    }

    public boolean start() {
        this.driver.start();
        this.driver.operacao = 6;
        this.iniciaAguardaTratamento();
        boolean var1;
        if(this.driver.mUsbCon == null) {
            this.driver = null;
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public void terminate() {
        this.driver.operacao = 4;
        this.iniciaAguardaTratamento();
        this.driver = null;
    }

    public void flush() {
        this.driver.operacao = 3;
        this.iniciaAguardaTratamento();
    }

    public int write(byte[] var1, int var2) {
        if(!this.driver.connected) {
            return -1;
        } else {
            this.driver.input = var1;
            this.driver.written = 0;
            this.driver.operacao = 2;
            this.driver.timeout = var2;
            this.driver.output.setLength(0);
            this.iniciaAguardaTratamento();
            return this.driver.written;
        }
    }

    public int read(byte[] var1, int var2, int var3) {
        if(!this.driver.connected) {
            return -1;
        } else {
            if(this.driver.output.length() < var2) {
                this.driver.operacao = 1;
                this.driver.timeout = var3;
                this.iniciaAguardaTratamento();
            }

            int var4 = this.driver.output.length();
            int var5 = 0;

            while(var5 < var4 && var5 < var2) {
                var1[var5++] = (byte)this.driver.output.charAt(0);
                this.driver.output.deleteCharAt(0);
            }

            this.pinpad.log("read\t" + var5);
            return var5;
        }
    }

    private class Driver extends Thread {
        private static final String ACTION_USB_PERMISSION = "com.android.pinpad.USB_PERMISSION";
        protected boolean processing;
        protected boolean connected = false;
        protected int operacao;
        protected int timeout;
        protected StringBuffer output;
        protected int written;
        protected byte[] input;
        private int interfaceIndex = 1;
        protected boolean aguardandoPermissao;
        protected Activity activity = null;
        protected UsbManager mUsbManager = null;
        protected UsbDevice mUsbDevice = null;
        protected UsbInterface mUsbInterface = null;
        protected UsbDeviceConnection mUsbCon = null;
        protected UsbEndpoint mUsbEndpR = null;
        protected UsbEndpoint mUsbEndpW = null;
        private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
            public void onReceive(Context var1, Intent var2) {
                String var3 = var2.getAction();
                if("com.android.pinpad.USB_PERMISSION".equals(var3)) {
                    Driver.this.aguardandoPermissao = false;
                    Driver.this.activity.unregisterReceiver(this);
                }

            }
        };
        private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
            public void onReceive(Context var1, Intent var2) {
                String var3 = var2.getAction();
                PinPadDriverUSB.this.pinpad.log("Recebeu evento " + var3);
                if("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(var3)) {
                    Driver.this.connected = false;
                    PinPadDriverUSB.this.pinpad.sendMessage(7);
                }

            }
        };

        public Driver(Activity var2) throws Exception {
            this.activity = var2;
            this.processing = false;
            this.aguardandoPermissao = false;
            this.operacao = 0;
            this.input = null;
            this.output = new StringBuffer();
            this.mUsbManager = (UsbManager)var2.getSystemService("usb");
            Intent var3 = new Intent(var2.getApplicationContext(), var2.getClass());
            this.mUsbDevice = (UsbDevice)var3.getParcelableExtra("device");
            if(this.mUsbDevice == null) {
                HashMap var4 = this.mUsbManager.getDeviceList();
                Iterator var5 = var4.values().iterator();

                while(var5.hasNext()) {
                    UsbDevice var6 = (UsbDevice)var5.next();
                    PinPadDriverUSB.this.pinpad.log(String.format("Vendor: %x; ProductId: %x", new Object[]{Integer.valueOf(var6.getVendorId()), Integer.valueOf(var6.getProductId())}));
                    if(var6.getVendorId() == 1947 && var6.getProductId() == 40) {
                        this.interfaceIndex = 1;
                        this.mUsbDevice = var6;
                        break;
                    }

                    if(var6.getVendorId() == 5971 && var6.getProductId() == '줁') {
                        this.interfaceIndex = 1;
                        this.mUsbDevice = var6;
                        break;
                    }

                    if(var6.getVendorId() == 5971 && var6.getProductId() == '줂') {
                        this.interfaceIndex = 1;
                        this.mUsbDevice = var6;
                        break;
                    }

                    if(var6.getVendorId() == 5971) {
                        this.interfaceIndex = 1;
                        this.mUsbDevice = var6;
                        break;
                    }

                    if(var6.getVendorId() == 4660 && var6.getProductId() == 257) {
                        this.interfaceIndex = 0;
                        this.mUsbDevice = var6;
                        break;
                    }
                }
            }

            if(this.mUsbDevice == null) {
                throw new Exception("Nao encontrado pinpad USB compativel");
            } else {
                if(!this.mUsbManager.hasPermission(this.mUsbDevice)) {
                    PendingIntent var7 = PendingIntent.getBroadcast(var2.getApplicationContext(), 0, new Intent("com.android.pinpad.USB_PERMISSION"), 0);
                    IntentFilter var8 = new IntentFilter("com.android.pinpad.USB_PERMISSION");
                    var2.registerReceiver(this.mUsbReceiver, var8);
                    this.mUsbManager.requestPermission(this.mUsbDevice, var7);
                    this.aguardandoPermissao = true;
                }

            }
        }

        public void run() {
            try {
                byte[] var1 = new byte[64];
                this.activity.registerReceiver(this.mReceiver, new IntentFilter("android.hardware.usb.action.USB_DEVICE_DETACHED"));

                while(true) {
                    while(!this.processing || this.aguardandoPermissao) {
                        sleep(50L);
                    }

                    if(this.operacao != 6 && !this.connected) {
                        break;
                    }

                    int var2;
                    int var3;
                    if(this.operacao == 1) {
                        PinPadDriverUSB.this.pinpad.log("Thr\tLendo");
                        var2 = -1;
                        var3 = 0;
                        boolean var4 = false;

                        int var11;
                        do {
                            var11 = this.mUsbCon.bulkTransfer(this.mUsbEndpR, var1, var1.length, this.timeout);
                            if(var11 > 0) {
                                for(int var5 = 0; var5 < var11; ++var5) {
                                    this.output.append((char)var1[var5]);
                                    if(var1[var5] == 23) {
                                        var2 = var3;
                                    }

                                    ++var3;
                                }
                            }

                            if(var2 > 0 && var3 > var2 + 2) {
                                break;
                            }

                            this.timeout = 500;
                        } while(var11 > 0);

                        PinPadDriverUSB.this.pinpad.log("Thr.Leu\t" + var3);
                    } else if(this.operacao == 2) {
                        byte[] var9 = new byte[1];
                        if(this.input.length > 0) {
                            var9[0] = this.input[this.input.length - 1];
                        }

                        var3 = this.mUsbCon.bulkTransfer(this.mUsbEndpW, this.input, this.input.length - 1, this.timeout);
                        if(var3 == this.input.length - 1 && this.input.length > 0) {
                            try {
                                sleep(10L);
                            } catch (Exception var7) {
                                ;
                            }

                            var3 += this.mUsbCon.bulkTransfer(this.mUsbEndpW, var9, 1, this.timeout);
                        }

                        if(var3 >= 0) {
                            PinPadDriverUSB.this.pinpad.log("Thr.Escreveu\t" + var3);
                            this.written += var3;
                        } else {
                            PinPadDriverUSB.this.pinpad.log("Thr\tErro na escrita: " + var3);
                            this.written = -1;
                        }
                    } else if(this.operacao == 3) {
                        boolean var10 = false;
                        this.mUsbCon.controlTransfer(64, 0, 1, 0, (byte[])null, 0, 0);
                        this.mUsbCon.controlTransfer(64, 0, 2, 0, (byte[])null, 0, 0);

                        do {
                            var2 = this.mUsbCon.bulkTransfer(this.mUsbEndpR, var1, var1.length, 100);
                        } while(var2 > 0);

                        this.output.setLength(0);
                    } else if(this.operacao == 6) {
                        this.mUsbCon = this.mUsbManager.openDevice(this.mUsbDevice);
                        if(this.mUsbCon == null) {
                            throw new Exception("USBDriver: Erro abrindo conexao com pinpad");
                        }

                        this.mUsbInterface = this.mUsbDevice.getInterface(this.interfaceIndex);

                        for(var2 = 0; var2 < this.mUsbInterface.getEndpointCount(); ++var2) {
                            UsbEndpoint var12 = this.mUsbInterface.getEndpoint(var2);
                            if(var12.getType() == 2) {
                                if(var12.getDirection() == 128) {
                                    this.mUsbEndpR = var12;
                                } else {
                                    this.mUsbEndpW = var12;
                                }
                            }
                        }

                        this.mUsbCon.claimInterface(this.mUsbInterface, true);
                        this.mUsbCon.controlTransfer(64, 3, '考', 0, (byte[])null, 0, 0);
                        this.connected = true;
                    } else if(this.operacao == 4) {
                        break;
                    }

                    this.operacao = 0;
                    this.processing = false;
                }
            } catch (Exception var8) {
                System.err.println("USBDriver: " + var8.getMessage());
            }

            PinPadDriverUSB.this.pinpad.log("Thr.Escreveu\t");

            try {
                this.activity.unregisterReceiver(this.mReceiver);
            } catch (Exception var6) {
                ;
            }

            this.mUsbEndpW = null;
            this.mUsbEndpR = null;
            if(this.mUsbCon != null) {
                this.mUsbCon.releaseInterface(this.mUsbInterface);
                this.mUsbCon.close();
                this.mUsbCon = null;
            }

            this.operacao = 0;
            this.processing = false;
        }
    }
}
