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

angular.module('mesCoursesApp', ['Authentication', 'Home', 'ngRoute', 'ngCookies'])
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
        .otherwise({
            redirectTo: '/'
        });
}])

.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
		
        if ($rootScope.globals.currentUser) {
			console.log($rootScope.globals.currentUser);
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if (!$rootScope.globals.currentUser) {
                $location.path('/');
            }
        });
	}
]);