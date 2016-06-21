"use strict";

angular.module("HomeApp",["ngRoute","ui.grid", "ui.grid.pagination"])

.controller("homeController",["$scope","session","$location",function($scope,session,$location){
	
	

	$scope.myBookGridOptions = {
	  enableSorting: true,
	  enableColumnMenus :false,
	  paginationPageSizes :[5,10,20],
	  paginationPageSize :5,
	  enableScrollbars : false, 
	  columnDefs: [ 
	    { 	
	    	displayName: "Book Name", 
	    	field : "bookId",
	    	width : 300
		},
		{ 	
	    	displayName: "Issued on", 
	    	field : "dt",
	    	width : 200
		},
		{ 	
	    	displayName: " Demand Status", 
	    	field : "status",
	    	width : 300
		}
	   ]
	};
	
	console.log(session.getData().bookData);

	$scope.myBookGridOptions.data = session.getData().bookData.data;

	$scope.searchProducts = function(){

		$location.path("/product");

	};

	
}]);