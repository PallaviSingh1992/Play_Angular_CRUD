
var internApp = angular.module('internApp', ['ngRoute']);
        internApp.controller('Add', function ($scope,$http){
        alert("hello");
        $scope.saveIt = function(){
        alert("hi");
        var data = {"id":parseInt($scope.id),"name":$scope.name,"email":$scope.email,"mobile":$scope.mobile,"address":$scope.address,"emergency":$scope.emergency};
          $http({
                          method: 'POST',
                          url:'/insert',
                          data: JSON.stringify(data),
                          contentType: "application/json",
                          dataType: "json"
                      });
        }

      });
