angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $rootScope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    if ($localStorage.springWebUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
    }


    //============================================================
    //Page<Product> findByFilter()
    $scope.loadProduct = function (pageIndex = 1) {
        console.log($scope.filter);
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                namePart: $scope.filter ? $scope.filter.namePart : null,
                minPrice: $scope.filter ? $scope.filter.minPrice : null,
                maxPrice: $scope.filter ? $scope.filter.maxPrice : null
            }
        }).then(function (response) {
            console.log(response.data);
            $scope.ProductList = response.data;
            // $scope.loadBasket();
        });
    }

    //============================================================
    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProduct();
            });
    }

    $scope.changePrice = function (id, newPrice) {
        $http({
            url: contextPath + '/products/change-price',
            method: 'PATCH',
            params: {
                productId: id,
                newPrice: newPrice
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }

    $scope.changePriceToDelta = function (id, delta) {
        $http({
            url: contextPath + '/products/change-price-to-delta',
            method: 'PATCH',
            params: {
                id: id,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }

    //============================================================
    $scope.saveNewProductFun = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProduct();
            });
    }

    /*
        //============================================================
        //Page<Product> findByFilter()
        $scope.loadBasket = function (id) {
            // console.log($scope.filter);
            $http({
                url: contextPath + '/baskets',
                method: 'GET',
                params: {
                    id: $scope.filter ? $scope.filter.id : null
                }
            }).then(function (response) {
                $scope.BasketList = response.data;
                // $scope.loadProduct();
            });
        }
    */

    //============================================================
    $scope.tryToAuth = function () {
        $http.post('http://localhost:8189/app/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    //============================================================
    $scope.showCurrentUserInfo = function () {
        $http.get('http://localhost:8189/app/api/v1/profile')
            .then(function successCallback(response) {
                // alert('MY NAME IS: ' + response.data.username);
                alert('My Name == ' + response.data.username + '\n'
                    // + 'My Role == ' + response.data.password + '\n'
                );
            }, function errorCallback(response) {
                alert('UNAUTHORIZED');
            });
    }

    //============================================================
    // $scope.saveNewUser = function () {
    //     console.log($scope.newUser);
    //     $http.post('http://localhost:8189/app/user-registration', $scope.newUser)
    //         .then(function (response) {
    //             console.log($scope.newUser);
    //             // $scope.loadProduct();
    //         });
    // }

    $scope.saveNewUser = function (name, password, email) {
        console.log($scope.newUser);
        $http({
            url: 'http://localhost:8189/app/user-registration',
            method: 'POST',
            params: {
                name: name,
                password: password,
                email: email
            }
        })
            .then(function (response) {
                console.log($scope.newUser);
                // $scope.loadProduct();
            });
    }

    //============================================================


    $scope.loadProduct();
});