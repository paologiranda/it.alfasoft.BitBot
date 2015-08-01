'use strict';

/**
 * @ngdoc service
 * @name bitBotApp.loginService
 * @description
 * # loginService
 * Service in the bitBotApp.
 */

angular.module('bitBotApp')
.service('loginService', function(){
	
	var name = [];
	  
	  	return {
	  		getLogin: function(){
	  			return name;
	  		},
	  		setLogin: function(nam){
	  			nam = "Paolo"
	  			name = nam;
	  		}
	  	};
 });
