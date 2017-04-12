angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {

    // Rota padrão.
    $urlRouterProvider.otherwise("/");

    // Estados
    $stateProvider
        .state('index', {
            url: '/',
            templateUrl: 'index.html'
        })
        .state('login', {
            url: '/login',
            templateUrl: 'login.html'
        })
        .state('menu', {s
            url: '/menu',
            templateUrl: 'menu.html'
        })
        .state("cadastro", {
            url: '/cadastro',
            templateUrl: 'cadastro.html'
        })

});
