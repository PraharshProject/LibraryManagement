"use strict";

angular.module("ProductApp")
.factory("productFactory",["$http",function($http){
	return{
		searchBooks:function(data){
			var config = {
				headers: {
					"Content-Type":"application/json",
					"Accept":"application/json"
				}
				
			}
			console.log(data);
			var getStr = "/api/library-ws/check/"+data.criteria+"/"+data.searchString;
			return $http.get(getStr,config);
		},
		allocateBook:function(data){
			var config = {
				headers: {
					"Content-Type":"application/json",
					"Accept":"application/json"
				}
				
			}
			return $http.post("/api/library-ws/raise",data,config);
		}
	};


}]);