angular.module('app.controllers', [])

  .controller('dashboardCtrl', function ($scope, $http) {
    //$scope.result = "";
    $scope.aantalProjecten = "N/A";
    $scope.aantalPrototypes = 0;
    $scope.aantalAanvragen = 0;
    $scope.aantalBestellingen = 0;

    $http.get('http://localhost:8080/rest/projecten')
      .success(function (data, status, headers, config) {
        console.log('data success');
        $scope.aantalProjecten = data.length;
      })
      .error(function (data, status, headers, config) {
        console.log('data error');
      });
  })

  .controller('projectenCtrl', function ($scope, $http) {
    $scope.projecten = "";
    $http.get('http://localhost:8080/rest/projecten')
      .success(function (data, status, headers, config) {
        $scope.projecten = data;
      })
      .error(function (data, status, headers, config) {
        console.log('data error');
      });
  })

  .controller('accountCtrl', function ($scope) {

  })

  .controller('loginCtrl', function ($scope) {

  })

  .controller('signupCtrl', function ($scope) {

  })

  .controller('prototypesCtrl', function ($scope) {

  })

  .controller('teamsCtrl', function ($scope) {

  })

  .controller('onderzoekersCtrl', function ($scope) {

  })

  .controller('projectCtrl', function ($scope, $stateParams, $http) {
    console.log($stateParams);
    $http.get('http://localhost:8080/rest/projecten')
      .success(function (data, status, headers, config) {
        for (var i = 0; i < data.length; i++)
          if (data[i].id == $stateParams.id)
            $scope.project = data[i];
      })
      .error(function (data, status, headers, config) {
        console.log('data error');
      });
  })

  .controller('projectAanpassenCtrl', function ($scope, $stateParams, $http) {
    $http.get('http://localhost:8080/rest/projecten')
      .success(function (data, status, headers, config) {
        for (var i = 0; i < data.length; i++)
          if (data[i].id == $stateParams.id)
            $scope.project = data[i];
      })
      .error(function (data, status, headers, config) {
        console.log('data error');
      });
  })
