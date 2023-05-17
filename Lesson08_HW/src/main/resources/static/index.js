angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProduct();
            });
    }

    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }


    //============================================================
    $scope.saveNewProductFun = function () {
        console.log($scope.saveNewProduct);
        $http.post(contextPath + '/products', $scope.saveNewProduct)
            .then(function (response) {
                $scope.loadProduct();
            });
    }


    //============================================================
    //============================================================

    // $scope.filterPriceBetweenFun = function (min, max) {
    //     console.log($scope.findAllByPriceBetween);
    //     $http.post(contextPath + '/products/price_between', $scope.findAllByPriceBetween)
    //         .then(function (response) {
    //             $scope.ProductList = response.data;
    //             $scope.loadProduct();
    //         });
    // }


    $scope.filterPriceBetweenFun = function () {
        console.log($scope.filterPriceBetween);
        $http({
            url: contextPath + '/products/price_between',
            method: 'GET',
            params: {
                min: $scope.filterPriceBetween.min,
                max: $scope.filterPriceBetween.max
            }
        }).then(function (response) {
            $scope.ProductList = response.data;
            // $scope.loadProduct();
        });
    }



    $scope.loadProduct();
});