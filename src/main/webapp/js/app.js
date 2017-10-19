var app = angular.module("myApp", []);
app.controller('myCtrl', function($scope, $http) {
	console.log("Je suis pret");
	$http.get("http://localhost:8080/MesCoursesAPI/rest/json/mescourses/get").then(function(response) {
		$scope.elements = response.data;
		console.log($scope.elements);
		console.log("Succes");
	});
	$scope.ajouterElement = function(){
		//Construction de l'objet à poster
		var obj_elt = {
			idElement : $scope.idElement,
			nomElement : $scope.element_libelle 
		};
		//poster l'element
		var res = $http.post('http://localhost:8080/MesCoursesAPI/rest/json/mescourses/post', obj_elt);
		res.success(function(data, status, headers, config) {
			$scope.elements = data;
			$scope.element_libelle = '';
			console.log('Ajouté avec succès');
		});
		res.error(function(data, status, headers, config) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: data}));
			alert("Erreur grave : l'élément n'a pas été ajouté.");
		});
	};
	$scope.supprimerElement = function(idSupp){
		console.log(idSupp);
		var res = $http.post('http://localhost:8080/MesCoursesAPI/rest/json/mescourses/supprimer', idSupp);
		res.success(function(data, status, headers, config) {
			$scope.elements = data;
			console.log('Suppression avec succès');
		});
		res.error(function(data, status, headers, config) {
			console.log( "Erreur lors de l'ajout de l'element: " + JSON.stringify({data: data}));
			alert("Erreur grave : l'élément n'a pas été ajouté.");
		});
	};
	$scope.validerElement = function(idvalider){
		alert("coucou" + idvalider);
	}
});