
angular.module('Authentication').controller('authCtrl', ['$scope', '$rootScope', 'Base64', '$http', 'serviceAuth', '$location', function($scope, $rootScope, Base64, $http, serviceAuth, $location) {
	console.log("APICourses prête à lancer ...");
	
	serviceAuth.ClearCredentials();
	$scope.error = false;
	
	$scope.seConnecter = function(){
		//Construction de l'objet à poster
		var authdata = Base64.encode($scope.identifiant + ':' + $scope.password);
		
		var obj_elt = {
			identifiant : $scope.identifiant,
			motDePasse : authdata
		};
		
		serviceAuth.seConnecter(obj_elt).then(function(response) {
			$scope.autoriser = response.data;
			if($scope.autoriser == true){
				serviceAuth.SetCredentials($scope.identifiant, $scope.password);
				$rootScope.isConnected = true;
				$location.path('/mescourses');
			}
			else{
				$rootScope.isConnected = false;
				$scope.password = '';
				$scope.error = true;
				$location.path('/')
			}
			console.log($scope.autoriser);
		}, function(response) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: response}));
		});
	};
	
}]);