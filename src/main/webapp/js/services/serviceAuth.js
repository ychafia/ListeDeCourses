'use strict';
 
angular.module('mesCoursesApp').factory('serviceAuth', ['$http', function ($http) {
    return{
		seConnecter : function(obj_elt){
			return $http({
				url: 'http://192.168.1.17:8080/MesCoursesAPI/rest/json/mescourses/seConnecter',
				method: "PUT",
				data: obj_elt
			});
		}
	};
}]);