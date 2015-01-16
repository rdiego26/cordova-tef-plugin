
package br.com.softwareexpress.sitef.android;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Build.VERSION;
import android.util.Log;
import br.com.softwareexpress.sitef.JCliSiTefI;
import br.com.softwareexpress.sitef.android.IPinPadDriver;
import br.com.softwareexpress.sitef.android.PinPadDriverBT;
import br.com.softwareexpress.sitef.android.PinPadDriverUSB;

class PinPad {
    protected static final byte SERIAL_ACK = 6;
    protected static final byte SERIAL_NAK = 21;
    protected static final byte SERIAL_SYN = 22;
    protected static final byte SERIAL_ETB = 23;
    private static final short MSK_CRC_16 = 4129;
    public static final int PPCOMP_OK = 0;
    public static final int PPCOMP_PROCESSING = 1;
    public static final int PPCOMP_NOTIFY = 2;
    public static final int PPCOMP_F1 = 4;
    public static final int PPCOMP_F2 = 5;
    public static final int PPCOMP_F3 = 6;
    public static final int PPCOMP_F4 = 7;
    public static final int PPCOMP_BACKSP = 8;
    public static final int PPCOMP_INVCALL = 10;
    public static final int PPCOMP_INVPARM = 11;
    public static final int PPCOMP_TIMEOUT = 12;
    public static final int PPCOMP_CANCEL = 13;
    public static final int PPCOMP_ALREADYOPEN = 14;
    public static final int PPCOMP_NOTOPEN = 15;
    public static final int PPCOMP_EXECERR = 16;
    public static final int PPCOMP_INVMODEL = 17;
    public static final int PPCOMP_NOFUNC = 18;
    public static final int PPCOMP_ERRMANDAT = 19;
    public static final int PPCOMP_TABEXP = 20;
    public static final int PPCOMP_TABERR = 21;
    public static final int PPCOMP_PORTERR = 30;
    public static final int PPCOMP_COMMERR = 31;
    public static final int PPCOMP_UNKNOWNSTAT = 32;
    public static final int PPCOMP_RSPERR = 33;
    public static final int PPCOMP_INTERR = 40;
    public static final int PPCOMP_MCDATAERR = 41;
    public static final int PPCOMP_ERRPIN = 42;
    public static final int PPCOMP_NOCARD = 43;
    public static final int PPCOMP_SAMERR = 50;
    public static final int PPCOMP_NOSAM = 51;
    public static final int PPCOMP_SAMINV = 52;
    public static final int PPCOMP_DUMBCARD = 60;
    public static final int PPCOMP_ERRCARD = 61;
    public static final int PPCOMP_CARDINV = 62;
    public static final int PPCOMP_CARDBLOCKED = 63;
    public static final int PPCOMP_CARDNAUTH = 64;
    public static final int PPCOMP_CARDEXPIRED = 65;
    public static final int PPCOMP_CARDERRSTRUCT = 66;
    public static final int PPCOMP_CARDINVALIDAT = 67;
    public static final int PPCOMP_CARDPROBLEMS = 68;
    public static final int PPCOMP_CARDINVDATA = 69;
    public static final int PPCOMP_CARDAPPNAV = 70;
    public static final int PPCOMP_CARDAPPNAUT = 71;
    public static final int PPCOMP_NOBALANCE = 72;
    public static final int PPCOMP_LIMITEXC = 73;
    public static final int PPCOMP_ERRO_CRIPTO = 100;
    public static final int PINPAD_TIPO_NENHUM = 0;
    public static final int PINPAD_TIPO_AUTO = 1;
    public static final int PINPAD_TIPO_BLUETOOTH = 2;
    public static final int PINPAD_TIPO_USB = 3;
    public static final int TIPO_CONEXAO_NENHUM = 0;
    public static final int TIPO_CONEXAO_SERIAL_USB = 1;
    public static final int TIPO_CONEXAO_BLUETOOTH = 2;
    private static BluetoothAdapter btAdapter;
    private static IPinPadDriver driver = null;
    private int tipoPinPad = 0;
    protected String msgBuffer = null;
    protected Activity activity = null;
    private JCliSiTefI clisitefi = null;
    private Handler hndMessage = null;
    private boolean pinpadFechado = true;
    private int tipoConexao = 0;
    private boolean D = false;

    public PinPad(JCliSiTefI var1, Activity var2) {
        try {
            btAdapter = BluetoothAdapter.getDefaultAdapter();
        } catch (Exception var4) {
            System.err.println("PinPad: " + var4.getMessage());
        }

        this.activity = var2;
        this.clisitefi = var1;
    }

    public void setTipoPinPad(int var1) {
        if(this.tipoPinPad != var1) {
            this.PPDesconecta(true);
        }

        this.tipoPinPad = var1;
    }

    public int getTipoConexao() {
        return this.tipoConexao;
    }

    public int PPConecta() {
        byte var1 = -43;
        if(driver != null) {
            this.pinpadFechado = false;
            return 0;
        } else {
            try {
                this.sendMessage(3);
                this.log("PPConecta\tProcurando");
                driver = null;
                this.tipoConexao = 0;
                if(driver == null && (this.tipoPinPad == 3 || this.tipoPinPad == 1)) {
                    if(VERSION.SDK_INT >= 12) {
                        try {
                            driver = new PinPadDriverUSB(this.activity, this);
                            this.tipoConexao = 1;
                        } catch (Exception var4) {
                            this.log("PPConecta.USB\t" + var4.getMessage());
                        }
                    } else {
                        this.log("PPConecta.USB: Versao do SDK nao suportada [" + VERSION.SDK + "]");
                    }
                }

                if(driver == null && (this.tipoPinPad == 2 || this.tipoPinPad == 1)) {
                    try {
                        driver = new PinPadDriverBT(this.activity, this, btAdapter);
                        this.tipoConexao = 2;
                    } catch (Exception var3) {
                        this.log("PPConecta.BT\t" + var3.getMessage());
                    }
                }

                if(driver == null) {
                    this.log("PPConecta\tdriver nao especificado");
                } else if(driver.start()) {
                    this.log("PPConecta\tConectado");
                    this.sendMessage(4);
                    this.sendMessage(5);
                    this.sendMessage(6);
                    this.pinpadFechado = false;
                    var1 = 0;
                } else {
                    driver = null;
                    this.tipoConexao = 0;
                    this.sendMessage(4);
                }
            } catch (Exception var5) {
                this.log("PPConecta\t" + var5.getMessage());
                this.PPDesconecta(true);
            }

            return var1;
        }
    }

    public int PPDesconecta(boolean var1) {
        byte var2 = -43;
        this.pinpadFechado = true;
        if(var1 && driver != null) {
            this.log("PPDesconecta\tFechando PinPad");
            driver.terminate();
            driver = null;
            this.tipoConexao = 0;
            this.sendMessage(7);
        }

        return var2;
    }

    public int PPEnvia(String var1) {
        byte[] var2 = new byte[1];
        byte var3 = 0;
        if(!this.pinpadFechado && driver != null) {
            if(var1 != null && !var1.equals("")) {
                var2[0] = -1;

                try {
                    for(int var4 = 3; var4 > 0 && var2[0] != 6; --var4) {
                        driver.flush();
                        byte[] var5 = AscToBcd(var1);
                        int var6 = driver.write(var5, 1000);
                        if(var6 != var5.length) {
                            return 31;
                        }

                        int var7 = driver.read(var2, 1, 2000);
                        if(var7 != 1) {
                            return 31;
                        }
                    }

                    if(var2[0] != 6) {
                        var3 = 31;
                        this.log("PPEnvia\tErro escrita");
                    }
                } catch (Exception var8) {
                    this.log("PPEnvia\t" + var8.getMessage());
                    var3 = 31;
                }
            }
        } else {
            var3 = 15;
        }

        return var3;
    }

    public int PPRecebe() {
        byte[] var2 = new byte[1024];
        byte[] var3 = new byte[1024];
        this.msgBuffer = null;
        if(!this.pinpadFechado && driver != null) {
            byte var1 = 1;

            try {
                for(int var4 = 0; var4 < 3; ++var4) {
                    boolean var5 = false;
                    this.log("PPRecebe\tTentativa Leitura: " + var4);
                    int var8 = driver.read(var3, 10, 2000);
                    if(var8 == 10) {
                        System.arraycopy(var3, 0, var2, 0, 10);
                        if(var3[0] == 22 && (char)var3[4] == 48 && (char)var3[5] == 48 && (char)var3[6] == 48 && (char)var3[7] >= 48 && (char)var3[7] <= 57 && (char)var3[8] >= 48 && (char)var3[8] <= 57 && (char)var3[9] >= 48 && (char)var3[9] <= 57) {
                            int var6 = (var3[7] - 48) * 100;
                            var6 += (var3[8] - 48) * 10;
                            var6 += var3[9] - 48;
                            var6 += 3;
                            this.log("PPRecebe\t" + new String(var3, 1, 9));
                            var6 = driver.read(var3, var6, 2000);
                            System.arraycopy(var3, 0, var2, 10, var6);
                            var8 += var6;
                        } else {
                            this.log("PPRecebe\t" + new String(var3, 1, 6));
                        }

                        if(this.validaPacoteCompartilhada(var2, var8) != 0) {
                            this.log("PPRecebe\tPacote valido");
                            driver.write(new byte[]{(byte)6}, 1000);
                            this.msgBuffer = BcdToAsc(var2, 0, var8);
                            var1 = 0;
                            break;
                        }
                    }

                    if(var8 == 0) {
                        break;
                    }

                    if(var8 < 0) {
                        var1 = -1;
                        this.PPDesconecta(true);
                        break;
                    }

                    this.log("PPRecebe\tEnviando NAK");
                    driver.flush();
                    driver.write(new byte[]{(byte)21}, 1000);
                }
            } catch (Exception var7) {
                this.log("PPRecebe\t" + var7.getMessage());
                var1 = -1;
                this.PPDesconecta(true);
            }

            return var1;
        } else {
            return 15;
        }
    }

    private int validaPacoteCompartilhada(byte[] var1, int var2) {
        byte var6 = -1;
        int var4 = -1;

        for(int var3 = 0; var3 < var2; ++var3) {
            if(var1[var3] == 22) {
                var4 = var3;
            } else if(var4 >= 0 && var1[var3] == 23 && var3 + 2 < var2) {
                short var7 = (short)((var1[var3 + 1] & 255) << 8 | var1[var3 + 2] & 255);
                short var8 = crc16(var1, 1, var3);
                if(var8 == var7) {
                    var6 = 1;
                } else {
                    var6 = 0;
                }
                break;
            }
        }

        return var6;
    }

    public void sendMessage(int var1) {
        if(this.hndMessage != null) {
            this.hndMessage.sendEmptyMessage(var1);
        }

    }

    private static String BcdToAsc(byte[] var0, int var1, int var2) {
        StringBuffer var3 = new StringBuffer(var2 * 2);

        for(int var5 = 0; var5 < var2; ++var5) {
            int var4 = var0[var1 + var5] >> 4 & 15;
            if(var4 >= 0 && var4 <= 9) {
                var3.append((char)(var4 + 48));
            } else {
                var3.append((char)(var4 - 10 + 65));
            }

            var4 = var0[var1 + var5] & 15;
            if(var4 >= 0 && var4 <= 9) {
                var3.append((char)(var4 + 48));
            } else {
                var3.append((char)(var4 - 10 + 65));
            }
        }

        return var3.toString();
    }

    private static byte[] AscToBcd(String var0) {
        int var1 = 0;
        boolean var2 = false;
        boolean var3 = false;
        byte[] var4 = new byte[var0.length() / 2];
        char[] var5 = var0.toCharArray();

        for(int var6 = 0; var6 < var5.length; var6 += 2) {
            int var7 = ToBcd(var5[var6]);
            int var8 = ToBcd(var5[var6 + 1]);
            var4[var1++] = (byte)(var8 + (var7 << 4));
        }

        return var4;
    }

    private static int ToBcd(char var0) {
        int var1 = 0;
        if(var0 >= 48 && var0 <= 57) {
            var1 = (byte)var0 - 48;
        } else if(var0 >= 65 && var0 <= 70) {
            var1 = (byte)var0 - 65 + 10;
        } else if(var0 >= 97 && var0 <= 102) {
            var1 = (byte)var0 - 97 + 10;
        }

        return var1;
    }

    private static short crc16(byte[] var0, int var1, int var2) {
        short var4 = 0;

        for(int var5 = 0; var5 < var2; ++var5) {
            short var3 = (short)(var0[var1 + var5] << 8);

            for(int var6 = 0; var6 < 8; ++var6) {
                if(((var4 ^ var3) & '耀') != 0) {
                    var4 = (short)(var4 << 1);
                    var4 = (short)(var4 ^ 4129);
                } else {
                    var4 = (short)(var4 << 1);
                }

                var3 = (short)(var3 << 1);
            }
        }

        return var4;
    }

    public void setMessageHandler(Handler var1) {
        this.hndMessage = var1;
    }

    public String getMsgBuffer() {
        return this.msgBuffer;
    }

    public void log(String var1) {
        this.clisitefi.pinPadBTExecuta(80, var1);
        if(this.D) {
            Log.e("JCliSiTefI", var1);
        }

    }

    public final void setDebug(boolean var1) {
        this.D = var1;
    }
}