package br.com.softwareexpress.sitef.android;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Build.VERSION;
import br.com.softwareexpress.sitef.JCliSiTefI;
import br.com.softwareexpress.sitef.android.PinPad;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CliSiTefI {
    private static final String VERSAO = "1.011";
    private static final String Arq_Config = "CLSIT";
    public static final int CMD_RETORNO_VALOR = 0;
    public static final int CMD_MENSAGEM_OPERADOR = 1;
    public static final int CMD_MENSAGEM_CLIENTE = 2;
    public static final int CMD_MENSAGEM = 3;
    public static final int CMD_TITULO_MENU = 4;
    public static final int CMD_REMOVE_MENSAGEM_OPERADOR = 11;
    public static final int CMD_REMOVE_MENSAGEM_CLIENTE = 12;
    public static final int CMD_REMOVE_MENSAGEM = 13;
    public static final int CMD_REMOVE_TITULO_MENU = 14;
    public static final int CMD_EXIBE_CABECALHO = 15;
    public static final int CMD_REMOVE_CABECALHO = 16;
    public static final int CMD_CONFIRMA_CANCELA = 20;
    public static final int CMD_SELECIONA_MENU = 21;
    public static final int CMD_OBTEM_QUALQUER_TECLA = 22;
    public static final int CMD_PERGUNTA_SE_INTERROMPE = 23;
    public static final int CMD_OBTEM_CAMPO_SEM_COLETA = 29;
    public static final int CMD_OBTEM_CAMPO = 30;
    public static final int CMD_OBTEM_CHEQUE = 31;
    public static final int CMD_OBTEM_VALOR = 34;
    public static final int CMD_OBTEM_CODIGO_EM_BARRAS = 35;
    private static final int CMD_PINPAD_LE = 40;
    public static final int EVT_INICIA_ATIVACAO_BT = 1;
    public static final int EVT_FIM_ATIVACAO_BT = 2;
    public static final int EVT_INICIA_AGUARDA_CONEXAO_PP = 3;
    public static final int EVT_FIM_AGUARDA_CONEXAO_PP = 4;
    public static final int EVT_PP_BT_CONFIGURANDO = 5;
    public static final int EVT_PP_BT_CONFIGURADO = 6;
    public static final int EVT_PP_BT_DESCONECTADO = 7;
    public static final int EVT_INICIO_MODO_DISCOVER_BT = 9;
    public static final int EVT_FIM_MODO_DISCOVER_BT = 16;
    public static final int EVT_CONTINUA_CADASTRO_PIN_BT = 17;
    public static final int EVT_SUCESSO_CADASTRO_PIN_BT = 32;
    public static final int EVT_FALHA_CADASTRO_PIN_BT = 33;
    private static final int PPBT_CMD_CONFIGURA_BIBLIOTECA = 0;
    private static final int PPBT_CMD_TRACE = 80;
    private static final int PPI_CMD_VERIFICA_PRESENCA_PINPAD = 1;
    private static final int PPI_CMD_ESCREVE_MENSAGEM_PERMANENTE = 2;
    private static final int PPI_CMD_LE_SIM_NAO_PINPAD = 3;
    private static final int PPI_CMD_GET_INFO = 4;
    private static final int PPI_CMD_LE_CARTAO_SEGURO = 5;
    private static final int PPI_CMD_LE_SENHA = 6;
    private static final int CAMPO_PINPAD_ABRE = 650;
    private static final int CAMPO_PINPAD_FECHA = 651;
    private static final int CAMPO_PINPAD_ABORTA = 652;
    private static final int CAMPO_PINPAD_ESCREVE = 653;
    private static final int CAMPO_PINPAD_LE = 654;
    private static final int CAMPO_TIPO_CONEXAO_PINPAD = 671;
    private static final int CAMPO_RESULTADO_FUNCAO = 2150;
    private static CliSiTefI instance;
    private JCliSiTefI clisitefi = null;
    private Activity activity = null;
    private Context appContext = null;
    private PinPad pinpad = null;
    private boolean primeiraVez = true;
    private boolean D = false;
    private int modalidadeAtual = -1;
    private String informacoesPinPad = "";

    public CliSiTefI(Activity var1) {
        instance = this;
        this.primeiraVez = true;
        this.activity = var1;
        this.appContext = var1.getApplicationContext();
        this.copiaArquivosConfiguracao();
        this.clisitefi = new JCliSiTefI();
        this.pinpad = new PinPad(this.clisitefi, var1);
    }

    public static CliSiTefI getInstance() {
        return instance;
    }

    public String getVersion() {
        return "1.011";
    }

    private final void log(String var1) {
        if(this.D) {
            System.err.println(var1);
        }

    }

    public final void setDebug(boolean var1) {
        this.D = var1;
        this.pinpad.setDebug(this.D);
    }

    public void setMessageHandler(Handler var1) {
        this.pinpad.setMessageHandler(var1);
    }

    public final String getBuffer() {
        return this.clisitefi.getBuffer();
    }

    public final void setBuffer(String var1) {
        this.clisitefi.setBuffer(var1);
    }

    public final void setContinuaNavegacao(int var1) {
        this.clisitefi.setContinuaNavegacao(var1);
    }

    public final int getProximoComando() {
        return this.clisitefi.getProximoComando();
    }

    public final int getTipoCampo() {
        return this.clisitefi.getTipoCampo();
    }

    public final short getTamanhoMaximo() {
        return this.clisitefi.getTamanhoMaximo();
    }

    public final short getTamanhoMinimo() {
        return this.clisitefi.getTamanhoMinimo();
    }

    public String getVersaoCliSiTef() {
        return this.clisitefi.getVersaoCliSiTef();
    }

    public String getVersaoCliSiTefI() {
        return this.clisitefi.getVersaoCliSiTefI();
    }

    private static final String obtemConfiguracao(String var0, String var1) {
        String var4 = null;
        if(var0 != null) {
            int var2 = var0.indexOf(91);
            if(var2 >= 0) {
                int var3 = var0.indexOf(93, var2);
                if(var3 >= 0) {
                    String var5 = var0.substring(var2 + 1, var3);
                    StringTokenizer var6 = new StringTokenizer(var5, ";");

                    while(var4 == null && var6.hasMoreTokens()) {
                        StringTokenizer var7 = new StringTokenizer(var6.nextToken(), "=");
                        if(var7.nextToken().equalsIgnoreCase(var1)) {
                            var4 = var7.nextToken();
                        }
                    }
                }
            }
        }

        return var4;
    }

    public int configuraIntSiTefInterativoEx(String var1, String var2, String var3, String var4) {
        String var5 = obtemConfiguracao(var4, "TIPOPINPAD");
        if(var5 == null) {
            var5 = "Android_AUTO";
        }

        this.log("TipoPinPad=" + var5);
        if(var5.equalsIgnoreCase("Android_USB")) {
            this.pinpad.setTipoPinPad(3);
        } else if(var5.equalsIgnoreCase("Android_BT")) {
            this.pinpad.setTipoPinPad(2);
        } else if(var5.equalsIgnoreCase("Android_AUTO")) {
            this.pinpad.setTipoPinPad(1);
        } else {
            this.pinpad.setTipoPinPad(0);
        }

        StringBuffer var6 = new StringBuffer();
        var6.append(var4);
        if(obtemConfiguracao(var4, "DIRETORIOAPP") == null) {
            try {
                PackageInfo var7 = this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 4096);
                var6.append(";[DiretorioApp=/data/data/");
                var6.append(var7.packageName);
                var6.append("]");
            } catch (Exception var10) {
                ;
            }
        }

        int var12 = this.clisitefi.configuraIntSiTefInterativoEx(var1, var2, var3, var6.toString());
        var6.setLength(0);
        if(var12 == 0 && this.primeiraVez) {
            this.primeiraVez = false;
            var6.append("{Comunicacao=BT_SIMPLES;jclisitef-android=");
            var6.append("1.011");
            var6.append("}");
            this.clisitefi.pinPadBTExecuta(0, var6.toString());
            var6.setLength(0);

            try {
                PackageInfo var8 = this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 4096);
                var6.append("\nPackage = ");
                var6.append(var8.packageName);
                var6.append("\nActivity = ");
                var6.append(this.activity.getClass().getName());
                if(var8.requestedPermissions != null && var8.requestedPermissions.length > 0) {
                    var6.append("\n\nPermissoes:\n");

                    for(int var9 = 0; var9 < var8.requestedPermissions.length; ++var9) {
                        var6.append(" ");
                        var6.append(var8.requestedPermissions[var9]);
                        var6.append("\n");
                    }
                }
            } catch (Exception var11) {
                ;
            }

            var6.append("\nDispositivo:");
            var6.append("\n MANUFACTURER=[" + Build.MANUFACTURER + "]");
            var6.append("\n MODEL=[" + Build.MODEL + "]");
            var6.append("\n PRODUCT=[" + Build.PRODUCT + "]");
            var6.append("\n DEVICE=[" + Build.DEVICE + "]");
            var6.append("\n BRAND=[" + Build.BRAND + "]");
            var6.append("\n BOARD=[" + Build.BOARD + "]");
            var6.append("\n VERSION.RELEASE=[" + VERSION.RELEASE + "]");
            var6.append("\n VERSION.INCREMENTAL=[" + VERSION.INCREMENTAL + "]");
            var6.append("\n VERSION.SDK=[" + VERSION.SDK_INT + "]");
            var6.append("\n HOST=[" + Build.HOST + "]");
            var6.append("\n ID=[" + Build.ID + "]");
            var6.append("\n FINGERPRINT=[" + Build.FINGERPRINT + "]");
            this.clisitefi.pinPadBTExecuta(80, var6.toString());
        }

        return var12;
    }

    public int iniciaFuncaoSiTefInterativo(int var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        this.modalidadeAtual = var1;
        int var8 = this.clisitefi.iniciaFuncaoSiTefInterativo(var1, var2, var3, var4, var5, var6, var7);
        if(var8 == 10000) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        return var8;
    }

    public int correspondenteBancarioSiTefInterativo(String var1, String var2, String var3, String var4, String var5) {
        int var6 = this.clisitefi.correspondenteBancarioSiTefInterativo(var1, var2, var3, var4, var5);
        if(var6 == 10000) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        return var6;
    }

    public int continuaFuncaoSiTefInterativo() {
        int var1;
        boolean var2;
        do {
            var1 = this.clisitefi.continuaFuncaoSiTefInterativo();
            this.clisitefi.setContinuaNavegacao(0);
            var2 = false;
            if(var1 == 10000) {
                int var3 = this.getTipoCampo();
                String var4;
                switch(var3) {
                case 650:
                    if(this.pinpad.PPConecta() != 0) {
                        this.clisitefi.setContinuaNavegacao(-1);
                    }

                    var2 = true;
                    break;
                case 651:
                    this.pinpad.PPDesconecta(false);
                    var2 = true;
                    break;
                case 652:
                case 653:
                    this.log("Escreve TipoCampo: " + var3);
                    var4 = this.clisitefi.getBuffer();
                    this.clisitefi.setContinuaNavegacao(this.pinpad.PPEnvia(var4));
                    var2 = true;
                    break;
                case 654:
                    this.clisitefi.setContinuaNavegacao(this.pinpad.PPRecebe());
                    var4 = this.pinpad.getMsgBuffer();
                    if(var4 != null) {
                        this.clisitefi.setBuffer(var4);
                    }

                    var2 = true;
                    break;
                case 671:
                    this.clisitefi.setBuffer("" + this.pinpad.getTipoConexao());
                    var2 = true;
                    break;
                case 2150:
                    this.informacoesPinPad = this.clisitefi.getBuffer();
                    var2 = true;
                }

                if(this.clisitefi.getProximoComando() == 40) {
                    var2 = true;
                }
            } else if(var1 != 0 || this.modalidadeAtual != 761) {
                this.pinpad.PPDesconecta(true);
            }
        } while(var2);

        return var1;
    }

    public int continuaFuncaoSiTefInterativo(String var1, int var2) {
        this.clisitefi.setBuffer(var1);
        this.clisitefi.setContinuaNavegacao(var2);
        return this.continuaFuncaoSiTefInterativo();
    }

    public int finalizaTransacaoSiTefInterativoEx(int var1, String var2, String var3, String var4, String var5) {
        int var6 = this.clisitefi.finalizaTransacaoSiTefInterativoEx((short)var1, var2, var3, var4, var5 == null?"":var5);
        if(var6 == 10000) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        return var6;
    }

    public final int obtemQuantidadeTransacoesPendentes(String var1, String var2) {
        return this.clisitefi.obtemQuantidadeTransacoesPendentes(var1, var2);
    }

    public final int validaCampoCodigoEmBarras(String var1) {
        this.clisitefi.setCodigoEmBarras(var1);
        this.clisitefi.setTipoCodigoEmBarras(0);
        return this.clisitefi.validaCampoCodigoEmBarras();
    }

    public final int getTipoCodigoEmBarras() {
        return this.clisitefi.getTipoCodigoEmBarras();
    }

    public final int obtemVersao() {
        return this.clisitefi.obtemVersao();
    }

    public int descarregaMensagens() {
        return this.clisitefi.descarregaMensagens();
    }

    public final int verificaPresencaPinPad() {
        int var1;
        for(var1 = this.clisitefi.pinPadInterativo(1, ""); var1 == 10000; var1 = this.continuaFuncaoSiTefInterativo()) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        return var1;
    }

    public int escreveMensagemPermanentePinPad(String var1) {
        int var2;
        for(var2 = this.clisitefi.pinPadInterativo(2, var1); var2 == 10000; var2 = this.continuaFuncaoSiTefInterativo()) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        return var2;
    }

    public int leSimNaoPinPad(String var1) {
        int var2;
        for(var2 = this.clisitefi.pinPadInterativo(3, var1); var2 == 10000; var2 = this.continuaFuncaoSiTefInterativo()) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        return var2;
    }

    public int obtemInformacoesPinPad() {
        int var1;
        for(var1 = this.clisitefi.pinPadInterativo(4, ""); var1 == 10000; var1 = this.continuaFuncaoSiTefInterativo()) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        if(var1 == 0) {
            this.clisitefi.setBuffer(this.informacoesPinPad);
        }

        return var1;
    }

    public int leCartaoDiretoSeguro(String var1) {
        int var2;
        for(var2 = this.clisitefi.pinPadInterativo(5, var1); var2 == 10000; var2 = this.continuaFuncaoSiTefInterativo()) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        if(var2 == 0) {
            this.clisitefi.setBuffer(this.informacoesPinPad);
        }

        return var2;
    }

    public int leSenhaDireto(String var1) {
        int var2;
        for(var2 = this.clisitefi.pinPadInterativo(6, var1); var2 == 10000; var2 = this.continuaFuncaoSiTefInterativo()) {
            this.clisitefi.setBuffer("");
            this.clisitefi.setContinuaNavegacao(0);
        }

        if(var2 == 0) {
            this.clisitefi.setBuffer(this.informacoesPinPad);
        }

        return var2;
    }

    private void copiaArquivo(String var1) {
        try {
            FileOutputStream var2 = this.appContext.openFileOutput(var1, 3);
            InputStream var3 = this.appContext.getAssets().open(var1);
            byte[] var4 = new byte[1024];

            int var5;
            while((var5 = var3.read(var4)) > 0) {
                var2.write(var4, 0, var5);
            }

            var2.flush();
            var3.close();
            var2.close();
        } catch (Exception var6) {
            System.err.println("Copia arquivo [" + var1 + "]" + var6.getMessage());
        }

    }

    private void copiaArquivosConfiguracao() {
        CliSiTefI.INIFile var1 = new CliSiTefI.INIFile(this.appContext);
        var1.readFromFile("CLSIT");
        this.copiaArquivo("CLSIT");
        this.copiaArquivo(var1.getValue("Cheques", "NomeArqCheques", "Cheque.ini"));
        String var2 = var1.getValue("TabTraducao", "NomeArqTraducao", (String)null);
        if(var2 != null) {
            this.copiaArquivo(var2);
        }

    }

    public int pinpadConecta() {
        return this.pinpad.PPConecta();
    }

    public int pinpadDesconecta() {
        return this.pinpad.PPDesconecta(true);
    }

    static {
        System.loadLibrary("clisitef32");
        instance = null;
    }

    private class INIFile {
        private Context appContext = null;
        private HashMap<String, String> map = null;
        private StringBuffer sbCampo = null;

        public INIFile(Context var2) {
            this.appContext = var2;
            this.map = new HashMap();
            this.sbCampo = new StringBuffer();
        }

        public void readFromFile(String var1) {
            this.map.clear();
            StringBuffer var2 = new StringBuffer();

            int var6;
            try {
                InputStream var3 = this.appContext.getAssets().open(var1);
                byte[] var4 = new byte[1024];

                int var5;
                while((var5 = var3.read(var4)) > 0) {
                    for(var6 = 0; var6 < var5; ++var6) {
                        var2.append((char)var4[var6]);
                    }
                }

                var3.close();
            } catch (Exception var10) {
                System.err.println("INIFile.readFromFile:" + var10.getMessage());
            }

            String var11 = "";
            StringTokenizer var12 = new StringTokenizer(var2.toString(), "\r\n");

            while(var12.hasMoreTokens()) {
                String var13 = var12.nextToken();
                var6 = var13.indexOf(91);
                int var7;
                if(var6 >= 0) {
                    var7 = var13.indexOf(93, var6 + 1);
                    if(var7 >= 0) {
                        int var8 = var13.indexOf(59);
                        if(var8 < 0 || var8 > var6) {
                            var11 = var13.substring(var6 + 1, var7).trim().toUpperCase();
                            continue;
                        }
                    }
                }

                var7 = var13.indexOf(61);
                if(var7 >= 0) {
                    String var14 = var13.substring(0, var7).trim().toUpperCase();
                    if(var14.charAt(0) != 59) {
                        String var9 = var13.substring(var7 + 1);
                        this.sbCampo.setLength(0);
                        this.sbCampo.append("[");
                        this.sbCampo.append(var11);
                        this.sbCampo.append("].");
                        this.sbCampo.append(var14);
                        this.map.put(this.sbCampo.toString(), var9);
                    }
                }
            }

        }

        public String getValue(String var1, String var2, String var3) {
            this.sbCampo.setLength(0);
            this.sbCampo.append("[");
            this.sbCampo.append(var1.toUpperCase());
            this.sbCampo.append("].");
            this.sbCampo.append(var2.toUpperCase());
            String var4 = (String)this.map.get(this.sbCampo.toString());
            if(var4 == null) {
                var4 = var3;
            }

            return var4;
        }
    }
}
