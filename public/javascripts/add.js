
var internApp = angular.module('internApp', []);

        internApp.controller('AddController', function ($scope, $http){


        $scope.SaveIt = function(){
var data1 = {"id":1,"name":$scope.name,"email":$scope.email,"mobile":$scope.mobile,"address":$scope.address,"emergency":$scope.emergency};
                 window.location = '/showlist'
        $http({
                     method:'POST',
                     url:'/insert',
                     data: JSON.stringify(data1),
                     contentType: 'application/json',
                     dataType:'json',

                 });
        }})


