angulaAppModulo.controller('tarefaController', function (tarefaService, $scope, $state) {

$scope.criarTarefas = function () {

      tarefasService.criarFazendas($scope.fazenda))

        .then(function (response) {
            console.log(response.data);

            $scope.fazenda = response.data;

            $scope.fazenda.push($scope.fazendas);
          });
  };
