var app = angular.module('twitter', []);

app.controller('TwitterController', function ($scope, $http) {

  $scope.location = null;
  $scope.tweets = [];
    
  $scope.loadTweetsByLocation = function(location) {
    $scope.location = location;
    $http({url: "/twitter/location/"+location, method:"GET"})
    .success(function(data) {
      console.log("SUCCESS", data);
      $scope.tweets = data.tweets;
    })
    .error(function(/*data, status, headers, config*/){
      console.log("ERROR");
    });
  };

  $scope.loadTweetsByTerm = function(term) {
    $scope.term = term;
    $http({url: "/twitter/term/"+term, method:"GET"})
    .success(function(data) {
      console.log("SUCCESS", data);
      $scope.tweets = data.tweets;
    })
    .error(function(/*data, status, headers, config*/){
      console.log("ERROR");
    });
  };
  
  $scope.loadTweetsByLocation("-85.605165,30.355756999999997,250mi");
  $scope.loadTweetsByTerm("hello");


});
