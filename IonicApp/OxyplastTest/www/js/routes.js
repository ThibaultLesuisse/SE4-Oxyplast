angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
  

      .state('tabsController.dashboard', {
    url: '/page2',
    views: {
      'tab1': {
        templateUrl: 'templates/dashboard.html',
        controller: 'dashboardCtrl'
      }
    }
  })

  .state('tabsController.projecten', {
    url: '/page3',
    views: {
      'tab2': {
        templateUrl: 'templates/projecten.html',
        controller: 'projectenCtrl'
      }
    }
  })

  .state('tabsController.account', {
    url: '/page4',
    views: {
      'tab3': {
        templateUrl: 'templates/account.html',
        controller: 'accountCtrl'
      }
    }
  })

  .state('tabsController', {
    url: '/page1',
    templateUrl: 'templates/tabsController.html',
    abstract:true
  })

  .state('login', {
    url: '/page5',
    templateUrl: 'templates/login.html',
    controller: 'loginCtrl'
  })

  .state('signup', {
    url: '/page6',
    templateUrl: 'templates/signup.html',
    controller: 'signupCtrl'
  })

  .state('prototypes', {
    url: '/page7',
    templateUrl: 'templates/prototypes.html',
    controller: 'prototypesCtrl'
  })

  .state('teams', {
    url: '/page8',
    templateUrl: 'templates/teams.html',
    controller: 'teamsCtrl'
  })

  .state('onderzoekers', {
    url: '/page9',
    templateUrl: 'templates/onderzoekers.html',
    controller: 'onderzoekersCtrl'
  })

  .state('project', {
    url: '/page10/:id',
    templateUrl: 'templates/project.html',
    controller: 'projectCtrl'
  })

  .state('projectAanpassen', {
    url: '/page11/:id',
    templateUrl: 'templates/projectAanpassen.html',
    controller: 'projectAanpassenCtrl'
  })

$urlRouterProvider.otherwise('/page1/page2')

  

});
