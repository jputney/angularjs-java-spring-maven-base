
var sampleModule = angular.module('sampleModule', []);

sampleModule.controller('SampleController', ['$scope', '$http',
  // 'sampleFactory',
  function (
          $scope,
          $http
          //, sampleFactory
          ) {
    console.log(document.title);
    console.log(document.URL);
    console.log("Scope: ", $scope);

    $scope.items = [
      {name: "bobbie", id: 7},
      {name: "marie", id: 8},
      {name: "freddie", id: 2}
    ];

    $http({method: 'JSONP', url: 'sample-service.json?callback=JSON_CALLBACK'})
	//$http.get('sample-service.json')
			.success(function (data) {
      $scope.serviceData = data;
    });

  }]);



