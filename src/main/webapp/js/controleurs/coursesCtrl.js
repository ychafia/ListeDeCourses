﻿
angular.module('Home').controller('coursesCtrl', ['$scope', '$rootScope', '$http', 'CoursesSave', function($scope, $rootScope, $http, CoursesSave) {
	
	CoursesSave.getMesCourses().success(function(data){
		$scope.elements = data;
	});
	$scope.ajouterElement = function(){
		//Construction de l'objet à poster
		var obj_elt = {
			idElement : $scope.idElement,
			nomElement : $scope.element_libelle,
			complete : 'false'
		};
		CoursesSave.saveElement(obj_elt).then(function(response) {
			$scope.elements = response.data;
			$scope.element_libelle = '';
			console.log('Ajouté avec succés');
		}, function(response) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: response}));
		});
	};
	$scope.supprimerElement = function(idSupp){
		CoursesSave.deleteElement(idSupp)
	    .then(function(response) {
			$scope.elements = response.data;	
			console.log('Supprimé avec succés');
		}, function(response) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: response}));
		});
	};
	$scope.validerElement = function(elt){
		CoursesSave.mettreAjourElement(elt.idElement)
		.then(function(response) {
			//$scope.elements = response.data;	
			console.log('MAJ avec succés');
		}, function(response) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: response}));
		});
	};
}]);