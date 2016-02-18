angular.module('reportsApp').controller('FormController', ['$http', '$scope', function ($http, $scope) {
    $scope.formData = {};
    this.processForm = function () {
        $http({
            method: 'GET',
            url: 'Login',
            data: this.formData,
            params: {
                username: this.formData.username,
                password: this.formData.password
            }
        }).then(function (response) {
            $scope.error = response.data.errorMessage;
            $scope.formData = {};
            $scope.loginForm.$setPristine();
        });
    };

    }]);