"use strict";

angular.module("bookLib",["LoginApp","ProductApp","HomeApp"])

.config(["$routeProvider",
	function($routeProvider){
	 $routeProvider.
	      
	      when('/login', {
	        templateUrl: 'src/modules/login/view/login.html',
	        controller: 'loginController'
	      }).
	      when('/register', {
	        templateUrl: 'src/modules/register/view/register.html',
	        controller: 'loginController'
	      }).
	      when('/product', {
	        templateUrl: 'src/modules/product/view/productList.html',
	        controller: 'productController'
	      }).
	      when('/home', {
	        templateUrl: 'src/modules/home/view/home.html',
	        controller: 'homeController'
	      }).
	      
	      otherwise({
	        redirectTo: '/login'
	      });

}]);

