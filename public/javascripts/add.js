
var internApp = angular.module('internApp', []);

alert("Coming here 1");
        internApp.controller('AddController', function ($scope, $http){
            alert("Coming here 2");

        $scope.SaveIt = function(){
var data1 = {"id":1,"name":$scope.name,"email":$scope.email,"mobile":$scope.mobile,"address":$scope.address,"emergency":$scope.emergency};
alert(data1);
       return $http({
                     method:'POST',
                     url:'/insert',
                     data: JSON.stringify(data1),
                     contentType: 'application/json',
                     dataType:'json'
                 })


        }})


