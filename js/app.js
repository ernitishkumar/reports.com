(function () {
    angular.module('reportsApp', ['ngRoute']);

    angular.module('reportsApp').config(function ($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: 'templates/pages/login/login.html',
            controller: 'FormController',
            controllerAs: 'fc'
        });
    });

})();