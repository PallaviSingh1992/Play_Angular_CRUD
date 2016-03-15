  var internApp = angular.module('internApp', []);
        internApp.controller('DeleteController', function ($scope, $http){

          $scope.Delete=function(){
            var data={"id":$scope.id}

            $http.get('/delete/'+data).success(function(data) {
          
        }
})