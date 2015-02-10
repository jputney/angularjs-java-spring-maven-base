myAppDev = angular.module('sampleModuleDev', ['sampleModule', 'ngMockE2E']);

myAppDev.run(function ($httpBackend) {
  var data = [
    {name: 'bob', title: 'mayor', age: 99, powers: [{name: 'flying', level: 3}, {name: 'strength', level: 1}]},
    {name: 'jill', title: 'spy', age: 13, powers: [{name: 'judo-chop', level: 9}, {name: 'invisibility', level: 12}]},
  ];

  // return the whole data object
  $httpBackend.whenGET(/.*sample-service.*/).respond(data);

  $httpBackend.whenGET(/sample-lookup\/.*/).respond(function (method, url, d) {
    var name = splitPath(url)[1];
    var match = [];
    angular.forEach(data, function(x) {
        if (x.name == name) {
          this.push(x);
        }
      }, match);
    return [200, match[0]];
  });

  // Split path on '/' and trim and trailing .json or .jsonp extension, so we can use stuff like service-call/arg1/arg2/arg3.jsonp etc
  var splitPath = function (url) {
    var pathElements = url.split("/");
    // if .json or .jsonp was added to the end of the request, chop it off
    pathElements[pathElements.length - 1] = pathElements[pathElements.length - 1].replace(/\.jsonp?$/i, '');
    return pathElements;
  }

});