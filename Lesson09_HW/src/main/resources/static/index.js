angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';


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
            $scope.ProductList = response.data.content;
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






    $scope.loadProduct();
});