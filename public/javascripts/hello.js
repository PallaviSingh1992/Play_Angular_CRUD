if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

     var internApp = angular.module('internApp', []);
        internApp.controller('InternCtrl', function ($scope,$http){
        $scope.saveIt = function(){
        var data = {"id":parseInt($scope.id),"name":$scope.name,"email":$scope.email,"address":$scope.address,"mobile":$scope.mobile,"emergency":$scope.emergency};
          $http({
                          method: 'POST',
                          url:'/insert',
                          data: JSON.stringify(data),
                          contentType: "application/json",
                          dataType: "json"
                      });
        }
      });
