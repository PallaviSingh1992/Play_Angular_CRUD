
var internApp = angular.module('internApp', []);

    alert("Coming here 1");
        internApp.controller('UpdateController', function ($scope, $http){
        $scope.updateIt = function(){
        alert("");
var data1 = {"id":parseInt($scope.id),"name":$scope.name,"email":$scope.email,"mobile":$scope.mobile,"address":$scope.address,"emergency":$scope.emergency};
/*alert(data1);*/

       return $http({
                     method:'POST',
                     url:'/update/'+$scope.id,
                     data: JSON.stringify(data1),
                     contentType: 'application/json',
                     dataType:'json'
                 })
        }})


