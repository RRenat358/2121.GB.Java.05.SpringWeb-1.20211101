angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';


    //============================================================
    //Page<Product> findByFilter()
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
            $scope.ProductList = response.data.content;
        });
    }

    //============================================================
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
        console.log($scope.newProduct);
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProduct();
            });
    }






    $scope.loadProduct();
});