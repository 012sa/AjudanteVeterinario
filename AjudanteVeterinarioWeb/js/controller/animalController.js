angulaAppModulo.controller('animalController', function (animalService, $scope, $state) {

    $scope.animais = [];

    $scope.criarAnimais = function () {

        animalService.criarAnimais($scope.animal))

            .then(function (response) {
                console.log(response.data);

                $scope.animal = response.data;

                $scope.animais.push($scope.animal);
            });
    };


});
