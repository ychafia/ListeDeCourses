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
		<section id="sectiontitre">
			Liste de courses
		</section>
		<section id="sectionprincipale">
			<form ng-submit="ajouterElement()">
				<input type="text" id="elementid" ng-model="element_libelle" size="50" placeholder="...." maxlength="30">
			</form>
			<br>
			<div ng-repeat="x in elements">
				
				<img id="imgdelete" ng-click="supprimerElement(x.idElement)" src="images/delete.png" />
				<label>{{x.nomElement}}</label>
				<img id="imgdone" ng-click="validerElement(x.idElement)" src="images/done.png" />
				
			</div>
		</section>
	</body>
	<script src="js/app.js"></script>
</html>
