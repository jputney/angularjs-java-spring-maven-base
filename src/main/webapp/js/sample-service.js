
sampleModule.factory('sample-service', ['$http', function ($http) {

    var service = {};
    service.getData = function (x) {
      $http.get('sample-service').success(x);
    }

    service.getPromise = function (x) {
      return $http.get('sample-lookup/' + x + '.json');
    }

    return service;

  }]);
