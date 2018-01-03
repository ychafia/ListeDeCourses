
angular.module('mesCoursesApp').controller('authCtrl', ['$scope', '$http', 'serviceAuth', function($scope, $http, serviceAuth) {
	console.log("APICourses prête à lancer ...");
	
	$scope.seConnecter = function(){
		//Construction de l'objet ? poster
		var obj_elt = {
			identifiant : $scope.identifiant,
			motDePasse : $scope.password
		};
		
		console.log(obj_elt);
		serviceAuth.seConnecter(obj_elt).then(function(response) {
			$scope.autoriser = response.data;
			console.log(response.data);
		}, function(response) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: response}));
		});
	};
	
}]);