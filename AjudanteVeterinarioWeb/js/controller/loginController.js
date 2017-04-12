angulaAppModulo.controller('loginController', function (loginService, $scope, $state) {

$scope.login = function () {

      loginService.login($scope.login)

          .then(function (response) {
              console.log(response.data);

              var vet = response.data;

              $state.go('menu');

          });
  };
