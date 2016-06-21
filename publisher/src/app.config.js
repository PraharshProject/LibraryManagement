"use strict";
	angular.module("bookLib").config(["$stateProvider","$urlRouterProvider",
		function($stateProvider,$urlRouterProvider){
			$urlRouterProvider.otherwise("/login");
		}]);
