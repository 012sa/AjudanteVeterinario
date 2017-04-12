angulaAppModulo.factory("animalService", function ($http) {

    var urlBase = "localhost:8080/RestEasyApp/animal";

    var _criarAnimais = function (animal) {
		return $http.post(urlBase + "/animal/inserir", animal);
	};

    var _removerAnimais = function (animal){
        return $http.delete(urlBase + "/animal/remover", animal);

    };
    var _consultarAnimais = function (animal){
      return $http.get(urlBase + "/animal/consultar", animal);

}
    return {
        criaAnimais: _criarAnimais,
        removerAnimais: _removerAnimais,
        consultarAnimais: _consultarAnimal
    };


});
