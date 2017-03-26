angulaAppModulo.controller('landingController', function (landingService, $scope) {

    $scope.fazendas = []; // basic > dados basicos do usuario na landing page = lPage

    $scope.adicionaFazenda = function () {

        langindService.cadastrarFazenda($scope.fazenda)
          //.then(function (response) {
          //      // Chamado quando a resposta contém status de sucesso.
          //      // Exibir no console o conteúdo da resposta.
        //        console.log(response.data);

                // Criar aluno com o dado (Json) de resposta do servidor.
            //    var aluno = response.data;
                $scope.fazendas.push(fazenda);
            });
    };
