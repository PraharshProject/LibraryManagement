"use strict";

angular.module("LoginApp",["ngRoute",'ui.bootstrap'])

.controller("loginController",["$scope","$location","session","loginFactory","$uibModal",function($scope,$location,session,loginFactory,$uibModal){
	 $scope.login = function(){
	 	var data = [];
	 	var login = {};
	 	login.username = $scope.email;
	 	login.password = $scope.password;
	 	data.push(login);
	 	//data.push(password);
	 	$scope.alerts = [
		    
		  ];

		  
		  $scope.closeAlert = function(index) {
		    $scope.alerts.splice(index, 1);
		  };

	 	var book1 = {};
		book1.Id = 1;
		book1.Name = "Alchemist";
		book1.Language = "English";
		book1.Auther = "Paulo Coelho";
		book1.Quantity = 0;

		var book2 = {};
		book2.Id = 1;
		book2.Name = "The secret";
		book2.Language = "English";
		book2.Auther = "Rhonda Byrne";
		book2.Quantity = 5;

		var book3 = {};
		book3.Id = 3;
		book3.Name = "Mritunjay";
		book3.Language = "Marathi";
		book3.Auther = "Shivaji Sawant";
		book3.Quantity = 1;

		var bookData = [];
		bookData.push(book1);
		bookData.push(book2);	 
		bookData.push(book2);	 
		bookData.push(book3);
		bookData.push(book3);
		bookData.push(book1);

	 	console.log(data);

	 	var jsonArray = JSON.stringify(login);

	 	console.log(jsonArray);
	 	loginFactory.authenticateUser(jsonArray)
	 	.then(function(response){
	 		console.log("success");

	 		console.log(response);

	 		if(response.data.status.toUpperCase() == "SUCCESS")
	 		{
		 		loginFactory.retrieveDemand($scope.email)
				 	.then(function(response){
				 		console.log("success");
				 		
				 		$location.path("/home");
				 		var User = {};
				 		User.bookData = response;
				 		User.email = $scope.email;
				 		session.setData(User);
				 		
				 	},function(error){
				 		console.log("error");
				 		$location.path("/home");
				 		var User = {};
				 		User.email = $scope.email;
				 		User.bookData = bookData;
				 		session.setData(User);


				 	});
			 }
			 else
			 {
			 	 $scope.alerts.push({msg: 'Invalid username or password.',type:"danger"});
				
			 }
	 		
	 	},function(error){
	 		console.log("error");
	 		/*$location.path("/home");
	 		var User = {};
	 		User.email = $scope.email;
	 		User.bookData = bookData;
	 		session.setData(User);*/
	 		
	 		$scope.alerts.push({msg: 'Internal server error.',type:"danger"});		
	 		
	 	});
	 };

	
}]);