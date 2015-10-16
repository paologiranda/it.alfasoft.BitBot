'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.service:loginCommon
 * @description # loginCommon service of the bitBotApp
 */
angular.module('app')
  .service('loginCommon',[ function(){

	  var utente = {};	
	  
	  return{
		  getUser: function(){
			  return utente;
		  },
		  setUser: function(userLoggato){
			  utente = userLoggato;
		  }
	  }
	  
	  
  }])