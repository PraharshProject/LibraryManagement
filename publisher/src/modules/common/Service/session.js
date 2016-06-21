"use strict";

angular.module("bookLib")

.factory("session",function(){
	var formData = {};

	return{
		getData:function(){
			return formData;
		},
		setData:function(data){
			formData = data;
		}
	}

});