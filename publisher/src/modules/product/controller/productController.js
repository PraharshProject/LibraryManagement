"use strict";

angular.module("ProductApp",["ngRoute","ui.grid", "ui.grid.pagination",'ui.bootstrap'])

.controller("productController",["$scope","productFactory","session","$location","$uibModal",function($scope,productFactory,session,$location,$uibModal){
	
	$scope.alerts = [
		    
		  ];
		$scope.closeAlert = function(index) {
		    $scope.alerts.splice(index, 1);
		  };

	var criteria1 = {};
	criteria1.Name = "Publisher";
	criteria1.selected = false;

	var criteria2 = {};
	criteria2.Name = "Title";
	criteria2.selected = false;

	var criteria3 = {};
	criteria3.Name = "Author";
	criteria3.selected = false;

	var searchCriteria = [];
	searchCriteria.push(criteria2);
	searchCriteria.push(criteria1);
	searchCriteria.push(criteria3);	

	$scope.selectedCriteria = "Title";

	$scope.searchCriterias = searchCriteria;

	$scope.selectedCriterias = [];

	$scope.addCriteria = function(criteria){
		$scope.selectedCriteria = criteria.Name;
		console.log(criteria);
		delete criteria.$$hashKey;
		if(criteria.selected)
		{	
			$scope.selectedCriterias.push(criteria);
		}
		else
		{
			var index = $scope.selectedCriterias.indexOf(criteria);
			if(index > -1){
				$scope.selectedCriterias.splice(index,1);
			}
		}
		console.log($scope.selectedCriterias);
	};

	var profileStatusTmpl = "<div class=\"ui-grid-cell-contents text-center\">"+
	        					"<div class=\"status-switch\">"+
	        	 					"<button id=\"status-switch{{rowRenderIndex + 1}}\" type=\"button\" class=\"btn\" ng-click=\"grid.appScope.requestBook(row)\" >Raise a Demand</span>"+
		        	 					"</button>"+
	        	 				"</div>"+
	        	 			"</div>";

	$scope.requestBook = function(row){
		console.log("book requested");
		console.log(row);
		console.log(session.getData().email);
		
			var data = {};
			data.bookid = row.entity.id;
			data.username = session.getData().email;
			var requestData = JSON.stringify(data);

			productFactory.allocateBook(requestData)
			.then(function(response){
		 		console.log("success");
		 		$scope.alerts.push({msg: 'Demand raised successfully.',type:"success"});	
		 		console.log($scope.alerts);
		 	},function(error){
		 		console.log("error");
		 		
		 	});
	};


	$scope.bookGridOptions = {
	  enableSorting: true,
	  enableColumnMenus :false,
	  paginationPageSizes :[5,10,20],
	  paginationPageSize :5,
	  enableScrollbars : false, 
	  columnDefs: [ 
	    { 	
	    	displayName: "Title", 
	    	field : "title",
	    	width : 400
		},
		{ 	
	    	displayName: "Author", 
	    	field : "author",
	    	width : 200
		},
		{ 	
	    	displayName: "Publisher", 
	    	field : "publisher",
	    	width : 200
		},
		{ 
        	displayName: "",
        	field:"Id",
        	width:200,
        	enableSorting: false, 
        	enableFiltering: false,
        	cellTemplate: profileStatusTmpl
        }
	   ]
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

	var books = [];
	books.push(book1);
	books.push(book2);	 
	books.push(book2);	 
	books.push(book3);
	books.push(book3);
	books.push(book1);

	$scope.search = function(){
	 	//var jsonCriteriaArray = JSON.stringify($scope.selectedCriterias);
	 	//console.log(jsonCriteriaArray);
	 	console.log($scope.selectedCriteria);
	 	var data = {};
		data.searchString = $scope.searchText;
		data.criteria = $scope.selectedCriteria;
		var searchData = JSON.stringify(data);
		console.log(data);
		productFactory.searchBooks(data)
		.then(function(response){
	 		console.log("success");
	 		console.log(response);
	 		
	 			$scope.bookGridOptions.data = response.data;
	 			
	 		
	 		
	 	},function(error){
	 		console.log("error");
	 		$scope.alerts.push({msg: 'Data not found.',type:"danger"});	
	 		$scope.bookGridOptions.data = [];	
	 	});
	};

	$scope.backToHome = function(){
		$location.path("/home");
	}

	
}]);