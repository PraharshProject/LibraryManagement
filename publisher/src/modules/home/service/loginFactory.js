"use strict";

angular.module("LoginApp",["ngRoute"])
.factory("loginFactory",["$http",function($http){
	return{
		authenticateUser:function(data){
			var config = {
				headers: {
					"Content-Type":"application/json",
					"Accept":"application/json"
				};
				
			}
			return $http.post("/api/library-ws/authenticate",data,config);
		}
	}


}]);