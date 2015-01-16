/**
 * Created by ramos on 13/01/15.
 */
var tef = {

    hello:  function() {
        console.log('Hello...');
    },

    ConfiguraIntSitefInterativo: function(successFunc, errorFunc, _ipSiTef, _idLoja, _idTerminal, _reservado) {
        cordova.exec(successFunc, errorFunc, "SiTefHelper", "sitef", [{enderecoSiTef:_ipSiTef, codigoLoja: _idLoja, numeroTerminal:_idTerminal, parametrosAdicionais:_reservado}]);
    }

};

module.exports = Object.freeze(tef);