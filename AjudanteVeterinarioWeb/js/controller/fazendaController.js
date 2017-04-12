angulaAppModulo.controller('fazendaController', function (fazendaService, $scope, $state) {

  $scope.fazendas = [];
$scope.criarFazendas = function () {

      fazendaService.criarFazendas($scope.fazenda))

        .then(function (response) {
            console.log(response.data);

            $scope.fazenda = response.data;

            $scope.fazenda.push($scope.fazendas);
          });
  };
