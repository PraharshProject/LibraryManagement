"use strict";

angular.module("LoginApp")
.factory("loginFactory",["$http",function($http){
	return{
		authenticateUser:function(data){
			var config = {
				headers: {
					"Content-Type":"application/json",
					"Accept":"application/json"
				}
				
			}
			return $http.post("/api/library-ws/authenticate",data,config);
		},
		retrieveDemand:function(data){
			var config = {
				headers: {
					"Content-Type":"application/json",
					"Accept":"application/json"
				}
				
			}
			var getString = "/api/library-ws/retrieve/"+data;
			return $http.get(getString,config);
		}
	};


}]);