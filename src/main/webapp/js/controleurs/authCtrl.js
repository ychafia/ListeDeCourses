
angular.module('Authentication').controller('authCtrl', ['$scope', '$http', 'serviceAuth', '$location', function($scope, $http, serviceAuth, $location) {
	console.log("APICourses prête à lancer ...");
	
	serviceAuth.ClearCredentials();
	
	$scope.seConnecter = function(){
		//Construction de l'objet ? poster
		var obj_elt = {
			identifiant : $scope.identifiant,
			motDePasse : $scope.password
		};
		
		serviceAuth.seConnecter(obj_elt).then(function(response) {
			$scope.autoriser = response.data;
			if($scope.autoriser == true){
				serviceAuth.SetCredentials($scope.identifiant, $scope.password);
				$location.path('/mescourses');
			}
			else{
				$scope.password = '';
				$location.path('/')
			}
			console.log($scope.autoriser);
		}, function(response) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: response}));
		});
	};
	
}]);