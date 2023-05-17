angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    // console.log(123);

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                // console.log(response.data)
                $scope.StudentsList = response.data;
            });
    };

    $scope.deleteStudent = function (studentId) {
        $http.get(contextPath + '/students/delete/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    // GET http://localhost:8189/app/students/change_score?studentId=1&delta=2
    $scope.changeScore = function (studentId, delta) {
        // console.log('Click!');
        $http({
            url: contextPath + '/students/change_score',
            method: 'GET',
            params: {
                studentId: studentId,
                delta: delta
            }
        }).then(function (response) {
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

    $scope.sumTwoNumbers = function () {
        console.log($scope.calcAdd);
        $http({
            url: contextPath + '/calc/add',
            method: 'get',
            params: {
                a: $scope.calcAdd.a,
                b: $scope.calcAdd.b
            }
        }).then(function (response) {
            alert('Сумма равна ' + response.data.value);
            $scope.calcAdd.a = 10000;
        });
    }

    $scope.loadStudents();
});