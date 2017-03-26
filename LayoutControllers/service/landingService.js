angulaAppModulo.factory("landingService", function($http) {

    var urlBase = "localhost:8080/RestEasyApp/fazenda";

  //  var _listarAlunos = function() {
  //      return $http.get(urlBase + "/aluno/listar/")
//    };

    var _cadastrarFazenda = function(aluno){
		return $http.post(urlBase + "/fazenda/inserir", fazenda)
	};

    return {
      //  listarAlunos: _listarAlunos,
        cadastrarFazenda: _cadastrarFazenda
    };
});
