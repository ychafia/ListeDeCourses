<!DOCTYPE html>
<html>
	<head>
		<!-- <meta charset="utf-8" />
		<meta http-equiv="Access-Control-Allow-Origin" content="http://localhost:8080">
		<title>Liste de courses</title>
		<header name = "Access-Control-Allow-Origin" value = "http://localhost:8080" /> -->
	</head>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/index.css">
	
	<body ng-app="myApp" ng-controller="myCtrl">
		<section id="sectionprincipale">
			<h2>Liste de courses</h2>
			<form ng-submit="ajouterElement()">
				<input type="text" ng-model="element_libelle" size="50" placeholder="Saisie ici qlqc">
				<input type="submit" value="Ajouter">
			</form>
			<br>
			<div ng-repeat="x in elements">
				<span ng-bind="x.nomElement"></span><a ng-click="supprimerElement(x.idElement)"> Supprimer</a>
			</div>
			<!--<p><button ng-click="remove()">Remove marked</button></p>-->
		</section>
	<script>
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
		});
	</script>

	</body>
</html>
