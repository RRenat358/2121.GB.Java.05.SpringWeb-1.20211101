angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPach = 'http://localhost:8189/app';
});

$scope.loadStudents = function () {
    $http.get(contextPach + '/students')
        .then(function (response) {
            $scope.StudentsList = response.data;
        });

    $scope.loadStudents();
};