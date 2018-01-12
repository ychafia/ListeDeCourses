'use strict';
 
/**
* @ngdoc doc
* @name Youness
* @description
* # Mesourses
*
* Main module of the application.
*/

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('CV', []);

angular.module('mesCoursesApp', ['Authentication', 'Home', 'CV', 'ngRoute', 'ngCookies'])
	.config(['$routeProvider', function ($routeProvider) {
        
        // Système de routage
        $routeProvider
        .when('/', {
            templateUrl: 'pages/auth.html',
            controller: 'authCtrl'
        })
        .when('/mescourses', {
            templateUrl: 'pages/mesCourses.html',
            controller: 'coursesCtrl'
        })
		.when('/monCV', {
            templateUrl: 'pages/monCV.html',
            controller: 'cvCtrl'
        })
		.when('/mesFormations', {
            templateUrl: 'pages/mesFormations.html',
            controller: 'cvCtrl'
        })
		.when('/mesExperiencesSG', {
            templateUrl: 'pages/mesExperiencesSG.html',
            controller: 'cvCtrl'
        })
		.when('/mesExperiencesLCL', {
            templateUrl: 'pages/mesExperiencesLCL.html',
            controller: 'cvCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}])

.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
		
        if ($rootScope.globals.currentUser) {
			$rootScope.isConnected = true;
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() !== '/mesFormations' && $location.path() !== '/mesExperiencesSG' && $location.path() !== '/mesExperiencesLCL' && $location.path() !== '/monCV' && $location.path() !== '/' && !$rootScope.globals.currentUser) {
                $location.path('/');
            }
        });
	}
]);