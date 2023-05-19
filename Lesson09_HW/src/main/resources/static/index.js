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
            url: contextPath + '/products/change-price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }

    $scope.changePriceToDelta = function (id, delta) {
        $http({
            url: contextPath + '/products/change-price-to-delta',
            method: 'GET',
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
        console.log($scope.saveNewProduct);
        $http.post(contextPath + '/products', $scope.saveNewProduct)
            .then(function (response) {
                $scope.loadProduct();
            });
    }


    //============================================================
    //============================================================
    // $scope.filterPriceBetweenFun = function () {
    //     console.log($scope.filterPriceBetween);
    //     $http({
    //         url: contextPath + '/products/price-between',
    //         method: 'GET',
    //         params: {
    //             min: $scope.filterPriceBetween.min,
    //             max: $scope.filterPriceBetween.max
    //         }
    //     }).then(function (response) {
    //         $scope.ProductList = response.data;
    //     });
    // }


    $scope.loadProduct = function () {
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
    });
}


    $scope.loadProduct();
});