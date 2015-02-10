var sampleModule = angular.module('sampleModule', []);

sampleModule.controller('SampleController', ['$scope', '$http', '$q', 'sample-service',
  // 'sampleFactory',
  function (
          $scope,
          $http,
          $q,
          sampleService
          ) {
    console.log(document.title);
    console.log(document.URL);
    console.log("Scope: ", $scope);

    $scope.items = [
      {name: "bobbie", id: 7},
      {name: "marie", id: 8},
      {name: "freddie", id: 2}
    ];

    // Have service lookup data on page load
    sampleService.getData(function (data) {
      $scope.serviceData = data;
    });

    // provide lookupData method to view.
    $scope.lookupData = function (x) {
      sampleService.getPromise(x).success(function (val) {
        console.log(val);
        $scope.selectedVal = val;
      });
    }

  }]);





