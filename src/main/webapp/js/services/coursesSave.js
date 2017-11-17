'use strict';
 
angular.module('mesCoursesApp').factory('CoursesSave', ['$http', function ($http) {
    return{
		getMesCourses : function(){
			return $http.get("http://XXX.XXX.XXX.XXX:XX/MesCoursesAPI/rest/json/mescourses/get");
		},
	  
	   saveElement : function(obj_elt){
			return $http({
				url: 'http://XXX.XXX.XXX.XXX:XX/MesCoursesAPI/rest/json/mescourses/ajouter',
				method: "PUT",
				data: obj_elt
			});
		},
		deleteElement : function(idElement){
			return $http({
				url: 'http://XXX.XXX.XXX.XXX:XX/MesCoursesAPI/rest/json/mescourses/supprimer',
				method: "DELETE",
				data: idElement
			});
		},
		mettreAjourElement : function(idElement){
			return $http({
				url: 'http://XXX.XXX.XXX.XXX:XX/MesCoursesAPI/rest/json/mescourses/mettreAjour',
				method: "POST",
				data: idElement
			});
		}
	};
}]);