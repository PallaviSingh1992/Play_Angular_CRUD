
var internApp = angular.module('internApp', []);


        internApp.controller('UpdateController', function ($scope, $http){
        $scope.updateIt = function(){

       var data1 = {"id":parseInt($scope.id),"name":$scope.name,"email":$scope.email,"mobile":$scope.mobile,"address":$scope.address,"emergency":$scope.emergency};

                      window.location = '/showlist';
       return $http({
                     method:'POST',
                     url:'/update/'+$scope.id,
                     data: JSON.stringify(data1),
                     contentType: 'application/json',
                     dataType:'json'
                 })

        }

        })

        internApp.controller('DeleteController', function ($scope, $http){
                  $scope.Delete=function(){

                    $http.get('/delete/'+$scope.id).success(function(data) {
                    alert("Deleted "+$scope.id+" successfully" )});
                    window.location = '/showlist'
                }
        })


