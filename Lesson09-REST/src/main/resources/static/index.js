angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    // console.log(123);

    $scope.loadStudents = function (pageIndex = 1) {
        $http({
            url: contextPath + '/students',
            method: 'GET',
            params: {
                name_part: $scope.filter ? $scope.filter.name_part : null,
                min_score: $scope.filter ? $scope.filter.min_score : null,
                max_score: $scope.filter ? $scope.filter.max_score : null
            }
        }).then(function (response) {
            $scope.StudentsList = response.data.content;
        });
    };

    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + '/students/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.createStudentJson = function () {
        console.log($scope.newStudentJson);
        $http.post(contextPath + '/students', $scope.newStudentJson)
            .then(function (response) {
                $scope.loadStudents();
            });
    }
    //
    // $scope.sumTwoNumbers = function () {
    //     console.log($scope.calcAdd);
    //     $http({
    //         url: contextPath + '/calc/add',
    //         method: 'get',
    //         params: {
    //             a: $scope.calcAdd.a,
    //             b: $scope.calcAdd.b
    //         }
    //     }).then(function (response) {
    //         alert('Сумма равна ' + response.data.value);
    //         $scope.calcAdd.a = 10000;
    //     });
    // }

    $scope.loadStudents();
});