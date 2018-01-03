'use strict';
 
/**
* @ngdoc doc
* @name Youness
* @description
* # Mesourses
*
* Main module of the application.
*/
angular.module('mesCoursesApp', ['ngRoute'])
	.config(function($routeProvider) {
        
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
});