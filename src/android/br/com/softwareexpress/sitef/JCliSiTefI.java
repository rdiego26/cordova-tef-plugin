package br.com.softwareexpress.sitef;

public class JCliSiTefI {
    private static final String VERSAO = "1.00.c.005.2";
    private byte[] DadosRx;
    private static int Comando;
    private String EnderecoSiTef;
    private String Buffer = "";
    private String Campo;
    private String ChaveAcesso;
    private String ChaveSecreta;
    private String ChaveSeguranca;
    private String ChaveTrnCancelamento;
    private String CodigoEmBarras;
    private String CodigoLoja;
    private static short CodigoResposta;
    private static String CodigoServico;
    private static short ConfiguraResultado;
    private static short Confirma;
    private static int ContinuaNavegacao;
    private String DadosContas;
    private String DadosDesfazimento;
    private String DadosTransacao;
    private String DadosServico;
    private String DadosCaptura;
    private String Totalizador;
    private String DataFiscal;
    private static short Delimitador;
    private static short FuncaoSiTef;
    private String Horario;
    private static short IndiceParametro;
    private static int Modalidade;
    private String MsgDisplay;
    private String NumeroCuponFiscal;
    private String NumeroTerminal;
    private static short OffsetCartao;
    private String Operador;
    private String Supervisor;
    private String Parametro;
    private String ParametrosAdicionais;
    private static short ParametroCartao;
    private String Produtos;
    private static int ProximoComando;
    private static short RedeDestino;
    private String Senha;
    private static short eSenha;
    private String SenhaPinPad;
    private static short TamanhoMinimo;
    private static short TamanhoMaximo;
    private static short TamMaxDadosRx;
    private static short TamMaxDadosServico;
    private static short TempoEsperaRx;
    private static short TipoTransacao;
    private static int TipoCampo;
    private static short TipoCodigoEmBarras;
    private String TipoTrilha1;
    private String TipoTrilha2;
    private String Trilha1;
    private String Trilha2;
    private String Trilha3;
    private String Valor;
    private String ValorTotalCupon;
    private String ValorTotalBonus;
    private String CodigoAutorizacao;
    private String CodigoProduto;
    private static short NumeroProdutos;
    private static short IndiceProduto;
    private static short Quantidade;
    private static short TipoCancelamento;
    private String NumeroCuponFiscalOriginal;
    private String DataFiscalOriginal;
    private String NumeroDocumentoOriginal;
    private String IdentificacaoPdvOriginal;
    private String VersaoCliSiTef;
    private String VersaoCliSiTefI;
    private String TotalGeral;
    private String DadosSaida;
    private String NomeArquivo;
    private static short Timeout;
    private static int TipoConsulta;
    private static int TipoOperacao;
    private byte[] DadosTx;
    private static short TamDadosTx;
    private byte[] DadosEntrada;
    private static int TamDadosEntrada;
    private String NSUSiTef;
    private String ValorUnitario;
    private static int QuantidadeProduto;
    private static int Sequencial;

    public JCliSiTefI() {
    }

    private native int _ConfiguraIntSiTefInterativo();

    private native int _ConfiguraIntSiTefInterativoEx();

    private native int _IniciaFuncaoSiTefInterativo();

    private native int _IniciaFuncaoAASiTefInterativo();

    private native int _IniciaConfiguracaoSiTefInterativo();

    private native int _EfetuaPagamentoSiTefInterativo();

    private native int _FinalizaTransacaoSiTefInterativo();

    private native int _FinalizaTransacaoSiTefInterativoEx();

    private native int _FinalizaTransacaoSiTefInterativoBonus();

    private native int _FinalizaFuncaoSiTefInterativo();

    private native int _FinalizaTransacaoIdentificadaSiTef();

    private native int _FinalizaTransacaoIdentificadaSiTefBonus();

    private native int _DescarregaMensagens();

    private native int _DesfazTransacaoSiTefInterativo();

    private native int _FuncoesGerenciaisSiTefInterativo();

    private native int _IniciaCancelamentoIdentificadoSiTefInterativo();

    private native int _CorrespondenteBancarioSiTefInterativo();

    private native int _IniciaCancelamentoPagamentoContasSiTefInterativo();

    private native int _ValidaCampoCodigoEmBarras();

    private native int _EnviaRecebeSitServicos();

    private native int _EnviaRecebeSiTefDireto();

    private native int _ForneceParametroEnviaRecebeSiTefDireto();

    private native int _ExecutaEnviaRecebeSiTefDireto();

    private native int _ObtemRetornoEnviaRecebeSiTefDireto();

    private native int _ContinuaFuncaoSiTefInterativo();

    private native int _LeCartaoInterativo();

    private native int _LeCartaoDireto();

    private native int _LeCartaoDiretoEx();

    private native int _InterrompeLeCartaoDireto();

    private native int _LeSenhaInterativo();

    private native int _LeSenhaDireto();

    private native int _LeSenhaDiretoEx();

    private native int _VerificaPresencaPinPad();

    private native int _AbrePinPad();

    private native int _FechaPinPad();

    private native int _EscreveMensagemPinPad();

    private native int _LeSimNaoPinPad();

    private native int _EscreveMensagemPermanentePinPad();

    private native int _LeCampoPinPad();

    private native int _LeTeclaPinPad();

    private native int _IniciaFuncaoSiTefInterativoConsultaVidalink();

    private native int _InformaProdutoVendaVidalink();

    private native int _IniciaFuncaoSiTefInterativoVendaVidalink();

    private native int _InformaProdutoCancelamentoVidalink();

    private native int _IniciaFuncaoSiTefInterativoCancelamentoVidalink();

    private native int _IniciaFuncaoSiTefInterativoConsultaPBM();

    private native int _ObtemQuantidadeTransacoesPendentes();

    private native int _LeTrilhaChipInterativo();

    private native int _ObtemVersao();

    private native int _LeTrilha3();

    private native int _LeCartaoSeguro();

    private native int _LeCartaoDiretoSeguro();

    private native int _LeDoisDigitosPinPad();

    private native int _LeDigitoPinPad();

    private native int _LeCampoCriptografadoPinPad();

    private native int _ObtemStatusLeitoraSPTrans();

    private native int _ObtemSenha();

    private native int _ObtemDadoPinPad();

    private native int _ObtemDadoPinPadDireto();

    private native int _ObtemDadoPinPadEx();

    private native int _ObtemDadoPinPadDiretoEx();

    private native int _InformaTotalizadorVenda();

    private native int _ObtemParametrosSiTef();

    private native int _FlashVendasSitef();

    private native int _ConsultaParametrosSiTef();

    private native int _RegistraTefPromocaoSiTef();

    private native int _RegistraBonusOffLineSiTef();

    private native int _ObtemChaveSeguranca();

    private native int _ObtemDadosCriptografados();

    private native int _GravaDadosCriptografados();

    private native int _PinPadBTExecuta();

    private native int _PinPadInterativo();

    private native int _ConsultaDescontoSocioTorcedor();

    private native int _RegistraDescontoSocioTorcedor();

    private native int _ObtemInformacoesPinPad();

    private native int _ConsultaQtdeDescontoSocioTorcedor();

    private native int _RegistraDescontoSocioTorcedorSequencial();

    public int configuraIntSiTefInterativo() {
        return this._ConfiguraIntSiTefInterativo();
    }

    public int iniciaFuncaoSiTefInterativo() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoSiTefInterativo();
    }

    public int iniciaFuncaoAASiTefInterativo() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoAASiTefInterativo();
    }

    public int efetuaPagamentoSiTefInterativo() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._EfetuaPagamentoSiTefInterativo();
    }

    public int funcoesGerenciaisSiTefInterativo() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._FuncoesGerenciaisSiTefInterativo();
    }

    public int iniciaFuncaoSiTefInterativoConsultaVidalink() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoSiTefInterativoConsultaVidalink();
    }

    public int informaProdutoVendaVidalink() {
        return this._InformaProdutoVendaVidalink();
    }

    public int iniciaFuncaoSiTefInterativoVendaVidalink() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoSiTefInterativoVendaVidalink();
    }

    public int informaProdutoCancelamentoVidalink() {
        return this._InformaProdutoCancelamentoVidalink();
    }

    public int iniciaFuncaoSiTefInterativoCancelamentoVidalink() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoSiTefInterativoCancelamentoVidalink();
    }

    public int iniciaFuncaoSiTefInterativoConsultaPBM() {
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoSiTefInterativoConsultaPBM();
    }

    public int continuaFuncaoSiTefInterativo() {
        return this._ContinuaFuncaoSiTefInterativo();
    }

    public int enviaRecebeSiTefDireto() {
        this.DadosRx = new byte[TamMaxDadosRx];
        return this._EnviaRecebeSiTefDireto();
    }

    public int configuraIntSiTefInterativoEx() {
        return this._ConfiguraIntSiTefInterativoEx();
    }

    /** @deprecated */
    public int iniciaConfiguracaoSiTefInterativo() {
        return this._IniciaConfiguracaoSiTefInterativo();
    }

    public int finalizaTransacaoSiTefInterativo() {
        return this._FinalizaTransacaoSiTefInterativo();
    }

    public int finalizaTransacaoSiTefInterativoBonus() {
        return this._FinalizaTransacaoSiTefInterativoBonus();
    }

    public int finalizaFuncaoSiTefInterativo() {
        return this._FinalizaFuncaoSiTefInterativo();
    }

    public int finalizaTransacaoSiTefInterativoEx() {
        return this._FinalizaTransacaoSiTefInterativoEx();
    }

    public int finalizaTransacaoIdentificadaSiTef() {
        return this._FinalizaTransacaoIdentificadaSiTef();
    }

    public int finalizaTransacaoIdentificadaSiTefBonus() {
        return this._FinalizaTransacaoIdentificadaSiTefBonus();
    }

    public int descarregaMensagens() {
        return this._DescarregaMensagens();
    }

    public int desfazTransacaoSiTefInterativo() {
        return this._DesfazTransacaoSiTefInterativo();
    }

    public int iniciaCancelamentoIdentificadoSiTefInterativo() {
        return this._IniciaCancelamentoIdentificadoSiTefInterativo();
    }

    public int correspondenteBancarioSiTefInterativo() {
        return this._CorrespondenteBancarioSiTefInterativo();
    }

    public int iniciaCancelamentoPagamentoContasSiTefInterativo() {
        return this._IniciaCancelamentoPagamentoContasSiTefInterativo();
    }

    public int validaCampoCodigoEmBarras() {
        return this._ValidaCampoCodigoEmBarras();
    }

    public int enviaRecebeSitServicos() {
        this.DadosRx = new byte[TamMaxDadosRx];
        return this._EnviaRecebeSitServicos();
    }

    public int forneceParametroEnviaRecebeSiTefDireto() {
        return this._ForneceParametroEnviaRecebeSiTefDireto();
    }

    public int executaEnviaRecebeSiTefDireto() {
        return this._ExecutaEnviaRecebeSiTefDireto();
    }

    public int obtemRetornoEnviaRecebeSiTefDireto() {
        return this._ObtemRetornoEnviaRecebeSiTefDireto();
    }

    /** @deprecated */
    public int leCartaoInterativo() {
        return this._LeCartaoInterativo();
    }

    /** @deprecated */
    public int leCartaoDireto() {
        return this._LeCartaoDireto();
    }

    /** @deprecated */
    public int leCartaoDiretoEx() {
        return this._LeCartaoDiretoEx();
    }

    public int leSenhaInterativo() {
        return this._LeSenhaInterativo();
    }

    public int leSenhaDireto() {
        return this._LeSenhaDireto();
    }

    public int leSenhaDiretoEx() {
        return this._LeSenhaDiretoEx();
    }

    public int interrompeLeCartaoDireto() {
        return this._InterrompeLeCartaoDireto();
    }

    public int escreveMensagemPinPad() {
        return this._EscreveMensagemPinPad();
    }

    public int leSimNaoPinPad() {
        return this._LeSimNaoPinPad();
    }

    public int escreveMensagemPermanentePinPad() {
        return this._EscreveMensagemPermanentePinPad();
    }

    public int leCampoPinPad() {
        return this._LeCampoPinPad();
    }

    public int obtemQuantidadeTransacoesPendentes() {
        return this._ObtemQuantidadeTransacoesPendentes();
    }

    public int leTrilhaChipInterativo() {
        return this._LeTrilhaChipInterativo();
    }

    public int obtemVersao() {
        return this._ObtemVersao();
    }

    public int leTrilha3() {
        return this._LeTrilha3();
    }

    /** @deprecated */
    public int leCartaoSeguro() {
        return this._LeCartaoSeguro();
    }

    public int leCartaoDiretoSeguro() {
        return this._LeCartaoDiretoSeguro();
    }

    public int leDoisDigitosPinPad() {
        return this._LeDoisDigitosPinPad();
    }

    public int leDigitoPinPad() {
        return this._LeDigitoPinPad();
    }

    public int leCampoCriptografadoPinPad() {
        return this._LeCampoCriptografadoPinPad();
    }

    public int obtemStatusLeitoraSPTrans() {
        return this._ObtemStatusLeitoraSPTrans();
    }

    public int obtemSenha() {
        return this._ObtemSenha();
    }

    public int obtemDadoPinPad() {
        return this._ObtemDadoPinPad();
    }

    public int obtemDadoPinPadDireto() {
        return this._ObtemDadoPinPadDireto();
    }

    public int obtemDadoPinPadEx() {
        return this._ObtemDadoPinPadEx();
    }

    public int obtemDadoPinPadDiretoEx() {
        return this._ObtemDadoPinPadDiretoEx();
    }

    public int informaTotalizadorVenda() {
        return this._InformaTotalizadorVenda();
    }

    public int obtemParametrosSiTef() {
        return this._ObtemParametrosSiTef();
    }

    public int flashVendasSitef() {
        return this._FlashVendasSitef();
    }

    public int consultaParametrosSiTef() {
        return this._ConsultaParametrosSiTef();
    }

    public int registraTefPromocaoSiTef() {
        return this._RegistraTefPromocaoSiTef();
    }

    public int registraBonusOffLineSiTef() {
        return this._RegistraBonusOffLineSiTef();
    }

    public int obtemChaveSeguranca() {
        return this._ObtemChaveSeguranca();
    }

    public int obtemDadosCriptografados() {
        return this._ObtemDadosCriptografados();
    }

    public int gravaDadosCriptografados() {
        return this._GravaDadosCriptografados();
    }

    public int consultaDescontoSocioTorcedor() {
        return this._ConsultaDescontoSocioTorcedor();
    }

    public int registraDescontoSocioTorcedor() {
        return this._RegistraDescontoSocioTorcedor();
    }

    public int obtemInformacoesPinPad() {
        return this._ObtemInformacoesPinPad();
    }

    public int consultaQtdeDescontoSocioTorcedor() {
        return this._ConsultaQtdeDescontoSocioTorcedor();
    }

    public int registraDescontoSocioTorcedorSequencial() {
        return this._RegistraDescontoSocioTorcedorSequencial();
    }

    public int configuraIntSiTefInterativo(String var1, String var2, String var3) {
        this.EnderecoSiTef = var1;
        this.CodigoLoja = var2;
        this.NumeroTerminal = var3;
        return this._ConfiguraIntSiTefInterativo();
    }

    public int configuraIntSiTefInterativoEx(String var1, String var2, String var3, String var4) {
        this.EnderecoSiTef = var1;
        this.CodigoLoja = var2;
        this.NumeroTerminal = var3;
        this.ParametrosAdicionais = var4;
        return this._ConfiguraIntSiTefInterativoEx();
    }

    /** @deprecated */
    public int iniciaConfiguracaoSiTefInterativo(String var1, String var2, String var3) {
        this.EnderecoSiTef = var1;
        this.CodigoLoja = var2;
        this.NumeroTerminal = var3;
        return this._IniciaConfiguracaoSiTefInterativo();
    }

    public int iniciaFuncaoSiTefInterativo(int var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        Modalidade = var1;
        this.Valor = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        this.ParametrosAdicionais = var7;
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoSiTefInterativo();
    }

    public int iniciaFuncaoAASiTefInterativo(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
        Modalidade = var1;
        this.Valor = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        this.ParametrosAdicionais = var7;
        this.Produtos = var8;
        ProximoComando = 0;
        TipoCampo = 0;
        TamanhoMinimo = 0;
        TamanhoMaximo = 0;
        return this._IniciaFuncaoAASiTefInterativo();
    }

    public int finalizaTransacaoSiTefInterativo(short var1, String var2, String var3, String var4) {
        Confirma = var1;
        this.NumeroCuponFiscal = var2;
        this.DataFiscal = var3;
        this.Horario = var4;
        return this._FinalizaTransacaoSiTefInterativo();
    }

    public int finalizaTransacaoSiTefInterativoEx(short var1, String var2, String var3, String var4, String var5) {
        Confirma = var1;
        this.NumeroCuponFiscal = var2;
        this.DataFiscal = var3;
        this.Horario = var4;
        this.ParametrosAdicionais = var5;
        return this._FinalizaTransacaoSiTefInterativoEx();
    }

    public int finalizaTransacaoSiTefInterativoBonus(short var1, String var2, String var3, String var4, String var5, String var6) {
        Confirma = var1;
        this.NumeroCuponFiscal = var2;
        this.DataFiscal = var3;
        this.Horario = var4;
        this.ValorTotalCupon = var5;
        this.ValorTotalBonus = var6;
        return this._FinalizaTransacaoSiTefInterativoBonus();
    }

    public int finalizaFuncaoSiTefInterativo(short var1, String var2, String var3, String var4, String var5) {
        Confirma = var1;
        this.NumeroCuponFiscal = var2;
        this.DataFiscal = var3;
        this.Horario = var4;
        this.ParametrosAdicionais = var5;
        return this._FinalizaFuncaoSiTefInterativo();
    }

    public int finalizaTransacaoIdentificadaSiTef(short var1, short var2, String var3, String var4, String var5, String var6) {
        FuncaoSiTef = var1;
        Confirma = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.DadosTransacao = var6;
        return this._FinalizaTransacaoIdentificadaSiTef();
    }

    public int finalizaTransacaoIdentificadaSiTefBonus(short var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        Confirma = var1;
        this.NumeroCuponFiscal = var2;
        this.DataFiscal = var3;
        this.Horario = var4;
        this.ValorTotalCupon = var5;
        this.ValorTotalBonus = var6;
        this.DadosTransacao = var7;
        return this._FinalizaTransacaoIdentificadaSiTefBonus();
    }

    public int desfazTransacaoSiTefInterativo(String var1) {
        this.DadosDesfazimento = var1;
        return this._DesfazTransacaoSiTefInterativo();
    }

    public int iniciaCancelamentoIdentificadoSiTefInterativo(String var1, String var2, String var3, String var4, String var5) {
        this.NumeroCuponFiscal = var1;
        this.DataFiscal = var2;
        this.Horario = var3;
        this.Operador = var4;
        this.ChaveTrnCancelamento = var5;
        return this._IniciaCancelamentoIdentificadoSiTefInterativo();
    }

    public int correspondenteBancarioSiTefInterativo(String var1, String var2, String var3, String var4, String var5) {
        this.NumeroCuponFiscal = var1;
        this.DataFiscal = var2;
        this.Horario = var3;
        this.Operador = var4;
        this.ParametrosAdicionais = var5;
        return this._CorrespondenteBancarioSiTefInterativo();
    }

    public int iniciaCancelamentoPagamentoContasSiTefInterativo(String var1, String var2, String var3, String var4, String var5) {
        this.NumeroCuponFiscal = var1;
        this.DataFiscal = var2;
        this.Horario = var3;
        this.Operador = var4;
        this.ParametrosAdicionais = var5;
        return this._IniciaCancelamentoPagamentoContasSiTefInterativo();
    }

    public int validaCampoCodigoEmBarras(String var1, short var2) {
        this.CodigoEmBarras = var1;
        TipoCodigoEmBarras = var2;
        return this._ValidaCampoCodigoEmBarras();
    }

    public int enviaRecebeSitServicos(short var1, byte[] var2, short var3, short var4, short var5, String var6, String var7, String var8, String var9) {
        RedeDestino = var1;
        this.DadosTx = var2;
        TamDadosTx = var3;
        TamMaxDadosRx = var4;
        TempoEsperaRx = var5;
        this.NumeroCuponFiscal = var6;
        this.DataFiscal = var7;
        this.Horario = var8;
        this.Operador = var9;
        this.DadosRx = new byte[var4];
        return this._EnviaRecebeSitServicos();
    }

    public int enviaRecebeSiTefDireto(short var1, short var2, short var3, byte[] var4, short var5, short var6, short var7, String var8, String var9, String var10, String var11, short var12) {
        RedeDestino = var1;
        FuncaoSiTef = var2;
        OffsetCartao = var3;
        this.DadosTx = var4;
        TamDadosTx = var5;
        TamMaxDadosRx = var6;
        TempoEsperaRx = var7;
        this.NumeroCuponFiscal = var8;
        this.DataFiscal = var9;
        this.Horario = var10;
        this.Operador = var11;
        TipoTransacao = var12;
        this.DadosRx = new byte[var6];
        return this._EnviaRecebeSiTefDireto();
    }

    public int forneceParametroEnviaRecebeSiTefDireto(short var1, String var2, short var3, short var4) {
        IndiceParametro = var1;
        this.Parametro = var2;
        ParametroCartao = var3;
        Delimitador = var4;
        return this._ForneceParametroEnviaRecebeSiTefDireto();
    }

    public int executaEnviaRecebeSiTefDireto(short var1, short var2, short var3, String var4, String var5, String var6, String var7, short var8) {
        RedeDestino = var1;
        FuncaoSiTef = var2;
        TempoEsperaRx = var3;
        this.NumeroCuponFiscal = var4;
        this.DataFiscal = var5;
        this.Horario = var6;
        this.Operador = var7;
        TipoTransacao = var8;
        return this._ExecutaEnviaRecebeSiTefDireto();
    }

    public int obtemRetornoEnviaRecebeSiTefDireto(String var1, short var2) {
        CodigoServico = var1;
        TamMaxDadosServico = var2;
        return this._ObtemRetornoEnviaRecebeSiTefDireto();
    }

    /** @deprecated */
    public int leCartaoInterativo(String var1) {
        this.MsgDisplay = var1;
        return this._LeCartaoInterativo();
    }

    /** @deprecated */
    public int leCartaoDireto(String var1) {
        this.MsgDisplay = var1;
        return this._LeCartaoDireto();
    }

    /** @deprecated */
    public int leCartaoDiretoEx(String var1, short var2) {
        this.MsgDisplay = var1;
        Timeout = var2;
        return this._LeCartaoDiretoEx();
    }

    public int leSenhaInterativo(String var1) {
        this.MsgDisplay = var1;
        return this._LeSenhaInterativo();
    }

    public int leSenhaDireto(String var1, String var2) {
        this.ChaveSeguranca = var1;
        this.MsgDisplay = var2;
        return this._LeSenhaDireto();
    }

    public int leSenhaDiretoEx(String var1, String var2, short var3) {
        this.ChaveSeguranca = var1;
        this.MsgDisplay = var2;
        Timeout = var3;
        return this._LeSenhaDiretoEx();
    }

    public int verificaPresencaPinPad() {
        return this._VerificaPresencaPinPad();
    }

    public int abrePinPad() {
        return this._AbrePinPad();
    }

    public int fechaPinPad() {
        return this._FechaPinPad();
    }

    public int escreveMensagemPinPad(String var1) {
        this.MsgDisplay = var1;
        return this._EscreveMensagemPinPad();
    }

    public int leSimNaoPinPad(String var1) {
        this.MsgDisplay = var1;
        return this._LeSimNaoPinPad();
    }

    public int escreveMensagemPermanentePinPad(String var1) {
        this.MsgDisplay = var1;
        return this._EscreveMensagemPermanentePinPad();
    }

    public int leCampoPinPad(String var1, short var2, short var3) {
        this.MsgDisplay = var1;
        TamanhoMaximo = var2;
        eSenha = var3;
        return this._LeCampoPinPad();
    }

    public int leTeclaPinPad() {
        return this._LeTeclaPinPad();
    }

    public int efetuaPagamentoSiTefInterativo(int var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        Modalidade = var1;
        this.Valor = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        this.ParametrosAdicionais = var7;
        return this._EfetuaPagamentoSiTefInterativo();
    }

    public int funcoesGerenciaisSiTefInterativo(String var1, String var2, String var3, String var4) {
        this.NumeroCuponFiscal = var1;
        this.DataFiscal = var2;
        this.Horario = var3;
        this.Operador = var4;
        return this._FuncoesGerenciaisSiTefInterativo();
    }

    public int obtemQuantidadeTransacoesPendentes(String var1, String var2) {
        this.DataFiscal = var1;
        this.NumeroCuponFiscal = var2;
        return this._ObtemQuantidadeTransacoesPendentes();
    }

    public int LeTrilhaChipInterativo(int var1) {
        Modalidade = var1;
        return this._LeTrilhaChipInterativo();
    }

    public int iniciaFuncaoSiTefInterativoConsultaVidalink(String var1, String var2, String var3, String var4, String var5, String var6) {
        this.CodigoAutorizacao = var1;
        this.CodigoProduto = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        return this._IniciaFuncaoSiTefInterativoConsultaVidalink();
    }

    public int informaProdutoVendaVidalink(short var1, String var2, short var3, String var4) {
        IndiceProduto = var1;
        this.CodigoProduto = var2;
        Quantidade = var3;
        this.Valor = var4;
        return this._InformaProdutoVendaVidalink();
    }

    public int iniciaFuncaoSiTefInterativoVendaVidalink(String var1, short var2, String var3, String var4, String var5, String var6) {
        this.CodigoAutorizacao = var1;
        NumeroProdutos = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        return this._IniciaFuncaoSiTefInterativoVendaVidalink();
    }

    public int informaProdutoCancelamentoVidalink(short var1, String var2, short var3) {
        IndiceProduto = var1;
        this.CodigoProduto = var2;
        Quantidade = var3;
        return this._InformaProdutoCancelamentoVidalink();
    }

    public int iniciaFuncaoSiTefInterativoCancelamentoVidalink(short var1, short var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) {
        TipoCancelamento = var1;
        NumeroProdutos = var2;
        this.NumeroCuponFiscalOriginal = var3;
        this.DataFiscalOriginal = var4;
        this.NumeroDocumentoOriginal = var5;
        this.IdentificacaoPdvOriginal = var6;
        this.NumeroCuponFiscal = var7;
        this.DataFiscal = var8;
        this.Horario = var9;
        this.Operador = var10;
        return this._IniciaFuncaoSiTefInterativoCancelamentoVidalink();
    }

    public int iniciaFuncaoSiTefInterativoConsultaPBM(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        this.CodigoAutorizacao = var1;
        this.CodigoProduto = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        this.ParametrosAdicionais = var7;
        return this._IniciaFuncaoSiTefInterativoConsultaPBM();
    }

    public int leTrilha3(String var1) {
        this.MsgDisplay = var1;
        return this._LeTrilha3();
    }

    public int leCartaoSeguro(String var1) {
        this.MsgDisplay = var1;
        return this._LeCartaoSeguro();
    }

    public int leCartaoDiretoSeguro(String var1, short var2) {
        this.MsgDisplay = var1;
        Timeout = var2;
        return this._LeCartaoDiretoSeguro();
    }

    public int leDoisDigitosPinPad(String var1) {
        this.MsgDisplay = var1;
        return this._LeDoisDigitosPinPad();
    }

    public int leDigitoPinPad(String var1) {
        this.MsgDisplay = var1;
        return this._LeDigitoPinPad();
    }

    public int leCampoCriptografadoPinPad(String var1, String var2, short var3, short var4) {
        this.MsgDisplay = var1;
        this.ChaveSeguranca = var2;
        TamanhoMinimo = var3;
        TamanhoMaximo = var4;
        return this._LeCampoCriptografadoPinPad();
    }

    public int obtemSenha(String var1, String var2, String var3) {
        this.ChaveSecreta = var1;
        this.ChaveSeguranca = var2;
        this.SenhaPinPad = var3;
        return this._ObtemSenha();
    }

    public int obtemDadoPinPad(String var1, String var2) {
        this.ChaveSecreta = var1;
        this.DadosCaptura = var2;
        return this._ObtemDadoPinPad();
    }

    public int obtemDadoPinPadDireto(String var1, String var2) {
        this.ChaveSecreta = var1;
        this.DadosCaptura = var2;
        return this._ObtemDadoPinPadDireto();
    }

    public int obtemDadoPinPadEx(String var1, String var2, String var3) {
        this.ChaveAcesso = var1;
        this.ChaveSecreta = var2;
        this.DadosCaptura = var3;
        return this._ObtemDadoPinPadEx();
    }

    public int obtemDadoPinPadDiretoEx(String var1, String var2, String var3) {
        this.ChaveAcesso = var1;
        this.ChaveSecreta = var2;
        this.DadosCaptura = var3;
        return this._ObtemDadoPinPadDiretoEx();
    }

    public int informaTotalizadorVenda(String var1) {
        this.Totalizador = var1;
        return this._InformaTotalizadorVenda();
    }

    public int obtemParametrosSiTef(int var1, String var2) {
        TipoConsulta = var1;
        this.ParametrosAdicionais = var2;
        return this._ObtemParametrosSiTef();
    }

    public int flashVendasSitef(String var1, String var2, String var3, String var4, String var5) {
        this.TotalGeral = var1;
        this.NumeroCuponFiscal = var2;
        this.DataFiscal = var3;
        this.Horario = var4;
        this.Operador = var5;
        return this._FlashVendasSitef();
    }

    public int consultaParametrosSiTef(int var1) {
        TipoConsulta = var1;
        return this._ConsultaParametrosSiTef();
    }

    public int registraTefPromocaoSiTef(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        this.ValorTotalBonus = var1;
        this.ValorTotalCupon = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        this.Supervisor = var7;
        return this._RegistraTefPromocaoSiTef();
    }

    public int registraBonusOffLineSiTef(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        this.ValorTotalBonus = var1;
        this.ValorTotalCupon = var2;
        this.NumeroCuponFiscal = var3;
        this.DataFiscal = var4;
        this.Horario = var5;
        this.Operador = var6;
        this.Supervisor = var7;
        return this._RegistraBonusOffLineSiTef();
    }

    public int obtemChaveSeguranca(String var1, String var2) {
        this.Trilha2 = var1;
        this.ChaveSecreta = var2;
        return this._ObtemChaveSeguranca();
    }

    public int obtemDadosCriptografados(String var1, int var2, String var3) {
        this.NomeArquivo = var1;
        TipoOperacao = var2;
        this.ParametrosAdicionais = var3;
        return this._ObtemDadosCriptografados();
    }

    public int gravaDadosCriptografados(String var1, int var2, byte[] var3, int var4, String var5) {
        this.NomeArquivo = var1;
        TipoOperacao = var2;
        this.DadosEntrada = var3;
        TamDadosEntrada = var4;
        this.ParametrosAdicionais = var5;
        return this._GravaDadosCriptografados();
    }

    public int pinPadBTExecuta(int var1, String var2) {
        Comando = var1;
        this.Buffer = var2;
        return this._PinPadBTExecuta();
    }

    public int pinPadInterativo(int var1, String var2) {
        Comando = var1;
        this.Buffer = var2;
        return this._PinPadInterativo();
    }

    public int consultaDescontoSocioTorcedor(String var1) {
        this.CodigoProduto = var1;
        return this._ConsultaDescontoSocioTorcedor();
    }

    public int registraDescontoSocioTorcedor(String var1, String var2, String var3, String var4, String var5, String var6) {
        this.NumeroCuponFiscal = var1;
        this.DataFiscal = var2;
        this.Horario = var3;
        this.Operador = var4;
        this.NSUSiTef = var5;
        this.Produtos = var6;
        return this._RegistraDescontoSocioTorcedor();
    }

    public int consultaQtdeDescontoSocioTorcedor(String var1, int var2, String var3, String var4) {
        this.CodigoProduto = var1;
        QuantidadeProduto = var2;
        this.NSUSiTef = var3;
        this.ValorUnitario = var4;
        return this._ConsultaQtdeDescontoSocioTorcedor();
    }

    public int registraDescontoSocioTorcedorSequencial(String var1, String var2, String var3, String var4, String var5, String var6, int var7) {
        this.NumeroCuponFiscal = var1;
        this.DataFiscal = var2;
        this.Horario = var3;
        this.Operador = var4;
        this.NSUSiTef = var5;
        this.Produtos = var6;
        Sequencial = var7;
        return this._RegistraDescontoSocioTorcedorSequencial();
    }

    public void setEnderecoSiTef(String var1) {
        this.EnderecoSiTef = var1;
    }

    public void setBuffer(String var1) {
        this.Buffer = var1;
    }

    public String getBuffer() {
        return this.Buffer;
    }

    public String getCampo() {
        return this.Campo;
    }

    public void setChaveAcesso(String var1) {
        this.ChaveAcesso = var1;
    }

    public void setChaveSecreta(String var1) {
        this.ChaveSecreta = var1;
    }

    public void setChaveSeguranca(String var1) {
        this.ChaveSeguranca = var1;
    }

    public String getChaveSeguranca() {
        return this.ChaveSeguranca;
    }

    public void setChaveTrnCancelamento(String var1) {
        this.ChaveTrnCancelamento = var1;
    }

    public void setCodigoEmBarras(String var1) {
        this.CodigoEmBarras = var1;
    }

    public void setCodigoLoja(String var1) {
        this.CodigoLoja = var1;
    }

    public short getCodigoResposta() {
        return CodigoResposta;
    }

    public void setCodigoServico(String var1) {
        CodigoServico = var1;
    }

    public void setConfiguraResultado(short var1) {
        ConfiguraResultado = var1;
    }

    public void setConfiguraResultado(int var1) {
        this.setConfiguraResultado((short)((short)var1));
    }

    public void setConfirma(short var1) {
        Confirma = var1;
    }

    public void setConfirma(int var1) {
        this.setConfirma((short)((short)var1));
    }

    public void setContinuaNavegacao(int var1) {
        ContinuaNavegacao = var1;
    }

    public void setDadosContas(String var1) {
        this.DadosContas = var1;
    }

    public String getDadosContas() {
        return this.DadosContas;
    }

    public void setDadosDesfazimento(String var1) {
        this.DadosDesfazimento = var1;
    }

    public String getDadosDesfazimento() {
        return this.DadosDesfazimento;
    }

    public void setDadosTransacao(String var1) {
        this.DadosTransacao = var1;
    }

    public String getDadosServico() {
        return this.DadosServico;
    }

    public void setDadosCaptura(String var1) {
        this.DadosCaptura = var1;
    }

    public void setTotalizador(String var1) {
        this.Totalizador = var1;
    }

    public void setDataFiscal(String var1) {
        this.DataFiscal = var1;
    }

    public void setDelimitador(short var1) {
        Delimitador = var1;
    }

    public void setDelimitador(int var1) {
        this.setDelimitador((short)((short)var1));
    }

    public void setFuncaoSiTef(short var1) {
        FuncaoSiTef = var1;
    }

    public void setFuncaoSiTef(int var1) {
        this.setFuncaoSiTef((short)((short)var1));
    }

    public void setHorario(String var1) {
        this.Horario = var1;
    }

    public void setIndiceParametro(short var1) {
        IndiceParametro = var1;
    }

    public void setIndiceParametro(int var1) {
        this.setIndiceParametro((short)((short)var1));
    }

    public void setModalidade(int var1) {
        Modalidade = var1;
    }

    public void setMsgDisplay(String var1) {
        this.MsgDisplay = var1;
    }

    public void setNumeroCuponFiscal(String var1) {
        this.NumeroCuponFiscal = var1;
    }

    public void setNumeroTerminal(String var1) {
        this.NumeroTerminal = var1;
    }

    public void setOffsetCartao(short var1) {
        OffsetCartao = var1;
    }

    public void setOffsetCartao(int var1) {
        this.setOffsetCartao((short)((short)var1));
    }

    public void setOperador(String var1) {
        this.Operador = var1;
    }

    public void setSupervisor(String var1) {
        this.Supervisor = var1;
    }

    public void setParametro(String var1) {
        this.Parametro = var1;
    }

    public void setRestricoes(String var1) {
        this.ParametrosAdicionais = var1;
    }

    public void setParametrosAdicionais(String var1) {
        this.setRestricoes(var1);
    }

    public void setParametroCartao(short var1) {
        ParametroCartao = var1;
    }

    public void setParametroCartao(int var1) {
        this.setParametroCartao((short)((short)var1));
    }

    public void setProdutos(String var1) {
        this.Produtos = var1;
    }

    public int getProximoComando() {
        return ProximoComando;
    }

    public void setRedeDestino(short var1) {
        RedeDestino = var1;
    }

    public void setRedeDestino(int var1) {
        this.setRedeDestino((short)((short)var1));
    }

    public String getSenha() {
        return this.Senha;
    }

    public void seteSenha(short var1) {
        eSenha = var1;
    }

    public void seteSenha(int var1) {
        this.seteSenha((short)((short)var1));
    }

    public void setSenhaPinPad(String var1) {
        this.SenhaPinPad = var1;
    }

    public void setTamanhoMinimo(short var1) {
        TamanhoMinimo = var1;
    }

    public void setTamanhoMinimo(int var1) {
        this.setTamanhoMinimo((short)((short)var1));
    }

    public short getTamanhoMinimo() {
        return TamanhoMinimo;
    }

    public void setTamanhoMaximo(short var1) {
        TamanhoMaximo = var1;
    }

    public void setTamanhoMaximo(int var1) {
        this.setTamanhoMaximo((short)((short)var1));
    }

    public short getTamanhoMaximo() {
        return TamanhoMaximo;
    }

    public void setTamMaxDadosRx(short var1) {
        TamMaxDadosRx = var1;
    }

    public void setTamMaxDadosRx(int var1) {
        this.setTamMaxDadosRx((short)((short)var1));
    }

    public void setTamMaxDadosServico(short var1) {
        TamMaxDadosServico = var1;
    }

    public void setTamMaxDadosServico(int var1) {
        this.setTamMaxDadosServico((short)((short)var1));
    }

    public void setTempoEsperaRx(short var1) {
        TempoEsperaRx = var1;
    }

    public void setTempoEsperaRx(int var1) {
        this.setTempoEsperaRx((short)((short)var1));
    }

    public void setTipoTransacao(short var1) {
        TipoTransacao = var1;
    }

    public void setTipoTransacao(int var1) {
        this.setTipoTransacao((short)((short)var1));
    }

    public int getTipoCampo() {
        return TipoCampo;
    }

    public void setTipoCodigoEmBarras(short var1) {
        TipoCodigoEmBarras = var1;
    }

    public void setTipoCodigoEmBarras(int var1) {
        this.setTipoCodigoEmBarras((short)((short)var1));
    }

    public short getTipoCodigoEmBarras() {
        return TipoCodigoEmBarras;
    }

    public void setTipoTrilha1(String var1) {
        this.TipoTrilha1 = var1;
    }

    public String getTipoTrilha1() {
        return this.TipoTrilha1;
    }

    public void setTipoTrilha2(String var1) {
        this.TipoTrilha2 = var1;
    }

    public String getTipoTrilha2() {
        return this.TipoTrilha2;
    }

    public void setTrilha1(String var1) {
        this.Trilha1 = var1;
    }

    public String getTrilha1() {
        return this.Trilha1;
    }

    public void setTrilha2(String var1) {
        this.Trilha2 = var1;
    }

    public String getTrilha2() {
        return this.Trilha2;
    }

    public void setTrilha3(String var1) {
        this.Trilha3 = var1;
    }

    public String getTrilha3() {
        return this.Trilha3;
    }

    public void setValor(String var1) {
        this.Valor = var1;
    }

    public void setValorTotalCupon(String var1) {
        this.ValorTotalCupon = var1;
    }

    public void setValorTotalBonus(String var1) {
        this.ValorTotalBonus = var1;
    }

    public void setCodigoAutorizacao(String var1) {
        this.CodigoAutorizacao = var1;
    }

    public void setCodigoProduto(String var1) {
        this.CodigoProduto = var1;
    }

    public void setNumeroProdutos(short var1) {
        NumeroProdutos = var1;
    }

    public void setNumeroProdutos(int var1) {
        this.setNumeroProdutos((short)((short)var1));
    }

    public void setIndiceProduto(short var1) {
        IndiceProduto = var1;
    }

    public void setIndiceProduto(int var1) {
        this.setIndiceProduto((short)((short)var1));
    }

    public void setQuantidade(short var1) {
        Quantidade = var1;
    }

    public void setQuantidade(int var1) {
        this.setQuantidade((short)((short)var1));
    }

    public void setTipoCancelamento(short var1) {
        TipoCancelamento = var1;
    }

    public void setTipoCancelamento(int var1) {
        this.setTipoCancelamento((short)((short)var1));
    }

    public void setNumeroCuponFiscalOriginal(String var1) {
        this.NumeroCuponFiscalOriginal = var1;
    }

    public void setDataFiscalOriginal(String var1) {
        this.DataFiscalOriginal = var1;
    }

    public void setNumeroDocumentoOriginal(String var1) {
        this.NumeroDocumentoOriginal = var1;
    }

    public void setIdentificacaoPdvOriginal(String var1) {
        this.IdentificacaoPdvOriginal = var1;
    }

    public String getVersaoCliSiTef() {
        return this.VersaoCliSiTef;
    }

    public String getVersaoCliSiTefI() {
        return this.VersaoCliSiTefI;
    }

    public void setTotalGeral(String var1) {
        this.TotalGeral = var1;
    }

    public String getDadosSaida() {
        return this.DadosSaida;
    }

    public void setNomeArquivo(String var1) {
        this.NomeArquivo = var1;
    }

    public void setTimeout(short var1) {
        Timeout = var1;
    }

    public void setTimeout(int var1) {
        this.setTimeout((short)((short)var1));
    }

    public void setTipoConsulta(int var1) {
        TipoConsulta = var1;
    }

    public void setTipoOperacao(int var1) {
        TipoOperacao = var1;
    }

    public void setDadosTx(byte[] var1) {
        this.DadosTx = var1;
    }

    public void setTamDadosTx(short var1) {
        TamDadosTx = var1;
    }

    public void setTamDadosTx(int var1) {
        this.setTamDadosTx((short)((short)var1));
    }

    public byte[] getDadosRx() {
        return this.DadosRx;
    }

    public void setDadosEntrada(byte[] var1) {
        this.DadosEntrada = var1;
    }

    public void setTamDadosEntrada(int var1) {
        TamDadosEntrada = var1;
    }

    public String getVersion() {
        return "1.00.c.005.2";
    }

    public void setNSUSiTef(String var1) {
        this.NSUSiTef = var1;
    }

    public void setValorUnitario(String var1) {
        this.ValorUnitario = var1;
    }

    public void setQuantidadeProduto(int var1) {
        QuantidadeProduto = var1;
    }

    public void setSequencial(int var1) {
        Sequencial = var1;
    }

    static {
        System.loadLibrary("jCliSiTefI");
    }
}