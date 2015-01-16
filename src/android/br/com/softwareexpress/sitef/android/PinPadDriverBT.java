
package br.com.softwareexpress.sitef.android;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import br.com.softwareexpress.sitef.android.IPinPadDriver;
import br.com.softwareexpress.sitef.android.PinPad;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

class PinPadDriverBT implements IPinPadDriver {
    protected static final int OPERACAO_NENHUMA = 0;
    protected static final int OPERACAO_LEITURA = 1;
    protected static final int OPERACAO_ESCRITA = 2;
    protected static final int OPERACAO_FLUSH = 3;
    protected static final int OPERACAO_TERMINA_THREAD = 4;
    private PinPadDriverBT.Driver driver;
    private PinPad pinpad;

    public PinPadDriverBT(Activity var1, PinPad var2, BluetoothAdapter var3) throws Exception {
        this.pinpad = var2;
        this.driver = new PinPadDriverBT.Driver(var1, var3);
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
        return true;
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
                this.driver.esperados = var2 - this.driver.output.length();
                this.driver.timeout = var3;
                this.iniciaAguardaTratamento();
            }

            int var4 = 0;
            if(this.driver.output != null) {
                int var5 = this.driver.output.length();

                while(var4 < var5 && var4 < var2) {
                    var1[var4++] = (byte)this.driver.output.charAt(0);
                    this.driver.output.deleteCharAt(0);
                }

                this.pinpad.log("read\t" + var4);
            } else {
                var4 = -1;
            }

            return var4;
        }
    }

    private class Driver extends Thread {
        private final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        protected boolean processing;
        protected boolean connected;
        protected int operacao;
        protected int timeout;
        protected int esperados;
        protected StringBuffer output;
        protected int written;
        protected byte[] input;
        private BluetoothAdapter btAdapter;
        private Activity activity;
        private BluetoothSocket socket;
        private DataInputStream in = null;
        private DataOutputStream out = null;
        private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
            public void onReceive(Context var1, Intent var2) {
                String var3 = var2.getAction();
                PinPadDriverBT.this.pinpad.log("Driver\tEvento " + var3);
                if("android.bluetooth.device.action.ACL_DISCONNECTED".equals(var3) || "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED".equals(var3)) {
                    Driver.this.connected = false;
                    PinPadDriverBT.this.pinpad.sendMessage(7);
                }

            }
        };

        public Driver(Activity var2, BluetoothAdapter var3) throws Exception {
            byte var4 = -1;
            this.activity = var2;
            this.btAdapter = var3;
            this.processing = false;
            this.connected = false;
            this.esperados = 0;
            this.operacao = 0;
            this.input = null;
            this.output = new StringBuffer();
            if(!var3.isEnabled()) {
                PinPadDriverBT.this.pinpad.sendMessage(1);
                var3.enable();

                while(!var3.isEnabled()) {
                    try {
                        Thread.sleep(250L);
                    } catch (Exception var8) {
                        PinPadDriverBT.this.pinpad.log("BTDriver.enabled\t" + var8.getMessage());
                    }
                }

                PinPadDriverBT.this.pinpad.sendMessage(2);
            } else {
                var3.cancelDiscovery();
            }

            if(var3.isEnabled()) {
                Set var5 = var3.getBondedDevices();
                if(var5.size() > 0) {
                    Iterator var6 = var5.iterator();

                    while(var6.hasNext()) {
                        BluetoothDevice var7 = (BluetoothDevice)var6.next();
                        if(var7.getName().startsWith("PAX") || var7.getName().startsWith("Ingenico") || var7.getName().startsWith("MOBIPIN")) {
                            this.socket = var7.createRfcommSocketToServiceRecord(this.MY_UUID);
                            PinPadDriverBT.this.pinpad.log("BTDriver\tConectando");
                            this.socket.connect();
                            this.in = new DataInputStream(this.socket.getInputStream());
                            this.out = new DataOutputStream(this.socket.getOutputStream());
                            PinPadDriverBT.this.pinpad.log("BTDriver\tEncontrado " + this.socket.getRemoteDevice().getName() + " [" + this.socket.getRemoteDevice().getAddress() + "]");
                            this.connected = true;
                            var2.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
                            var2.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED"));
                            var4 = 0;
                        }
                    }
                }

                if(var4 != 0) {
                    throw new Exception("Nao encontrado pinpad BT compativel");
                }
            }

        }

        public void run() {
            try {
                byte[] var1 = new byte[1024];

                while(true) {
                    while(!this.processing) {
                        sleep(50L);
                    }

                    if(!this.connected) {
                        break;
                    }

                    if(this.operacao == 1) {
                        PinPadDriverBT.this.pinpad.log("Thr\tLendo");
                        int var2 = -1;
                        int var3 = 0;
                        boolean var4 = false;

                        int var5;
                        for(var5 = 0; var5 < this.timeout / 250 && this.in.available() <= 0; ++var5) {
                            sleep(250L);
                        }

                        while(this.in.available() > 0) {
                            int var9 = this.in.read(var1, 0, var1.length);
                            if(var9 <= 0) {
                                break;
                            }

                            for(var5 = 0; var5 < var9; ++var5) {
                                this.output.append((char)var1[var5]);
                                if(var1[var5] == 23) {
                                    var2 = var3;
                                }

                                ++var3;
                            }

                            if(var2 > 0 && var3 > var2 + 2) {
                                break;
                            }

                            if(var3 < this.esperados) {
                                sleep(500L);
                            } else {
                                sleep(100L);
                            }
                        }

                        PinPadDriverBT.this.pinpad.log("Thr.Leu\t" + var3);
                    } else if(this.operacao == 2) {
                        this.out.write(this.input, 0, this.input.length);
                        this.out.flush();
                        PinPadDriverBT.this.pinpad.log("Thr.Escreveu\t" + this.input.length);
                        this.written += this.input.length;
                    } else if(this.operacao == 3) {
                        while(this.in.available() > 0) {
                            this.in.read(var1, 0, var1.length);
                            sleep(250L);
                        }

                        this.output.setLength(0);
                    } else if(this.operacao == 4) {
                        PinPadDriverBT.this.pinpad.log("Thr\tFinalizando");
                        break;
                    }

                    this.operacao = 0;
                    this.processing = false;
                }
            } catch (Exception var8) {
                System.err.println("BTDriver: " + var8.getMessage());
            }

            PinPadDriverBT.this.pinpad.log("Thr.Escreveu\t");

            try {
                this.activity.unregisterReceiver(this.mReceiver);
            } catch (Exception var7) {
                ;
            }

            try {
                if(this.in != null) {
                    this.in.close();
                    this.in = null;
                }

                if(this.out != null) {
                    this.out.close();
                    this.out = null;
                }

                if(this.socket != null) {
                    this.socket.close();
                    this.socket = null;
                }
            } catch (Exception var6) {
                System.err.println("BTDriver: " + var6.getMessage());
            }

            this.operacao = 0;
            this.processing = false;
        }
    }
}