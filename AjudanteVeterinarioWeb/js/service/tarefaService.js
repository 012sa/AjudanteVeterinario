angulaAppModulo.factory("tarefaService", function ($http) {

    var urlBase = "localhost:8080/RestEasyApp/tarefa";

    var _criarTarefas = function (tarefa) {
		return $http.post(urlBase + "/tarefa/inserir", tarefa);
	};

    var _removerTarefas  = function (tarefa){
        return $http.delete(urlBase + "/tarefa/remover", tarefa);

    };
    var _consultaTarefas  = function (tarefa){
      return $http.get(urlBase + "/tarefa/consultar", tarefa);

}
    return {
        criarTarefas: _criarTarefas,
        removerTarefas: _removerTarefas,
        consultarTarefas: _consultarTarefas
    };


});
