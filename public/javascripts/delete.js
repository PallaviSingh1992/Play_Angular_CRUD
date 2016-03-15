  var internApp = angular.module('internApp', []);
        internApp.controller('DeleteController', function ($scope, $http){
        alert("aham");
          $scope.Delete=function(){
            var data={"id":$scope.id}
            alert(data);
            $http.get('/delete/'+data).success(function(data) {
            alert("deleted" +data)});
        }
})