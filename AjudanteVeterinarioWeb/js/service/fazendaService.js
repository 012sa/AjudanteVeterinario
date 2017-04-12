angulaAppModulo.factory("fazendaService", function ($http) {

    var urlBase = "localhost:8080/RestEasyApp/fazenda";

    var _criarFazendas = function (fazenda) {
		return $http.post(urlBase + "/fazenda/inserir", fazenda);
	};

    var _removerFazendas = function (fazenda){
        return $http.delete(urlBase + "/fazenda/remover", fazenda);

    };
    var _consultarFazendas = function (fazenda){
      return $http.get(urlBase + "/fazenda/consultar", fazenda);

}
    return {
        criarFazendas: _criarFazendas,
        removerFazendas: _removerFazendas,
        consultarFazendas: _consultarFazendas
    };


});
