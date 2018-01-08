'use strict';
 
angular.module('Home').factory('CoursesSave', ['$http', function ($http) {
    return{
		getMesCourses : function(){
			return $http.get("http://192.168.1.17:8080/MesCoursesAPI/rest/json/mescourses/get");
		},
	  
	   saveElement : function(obj_elt){
			return $http({
				url: 'http://192.168.1.17:8080/MesCoursesAPI/rest/json/mescourses/ajouter',
				method: "PUT",
				data: obj_elt
			});
		},
		deleteElement : function(idElement){
			return $http({
				url: 'http://192.168.1.17:8080/MesCoursesAPI/rest/json/mescourses/supprimer',
				method: "DELETE",
				data: idElement
			});
		},
		mettreAjourElement : function(idElement){
			return $http({
				url: 'http://192.168.1.17:8080/MesCoursesAPI/rest/json/mescourses/mettreAjour',
				method: "POST",
				data: idElement
			});
		}
	};
}]);