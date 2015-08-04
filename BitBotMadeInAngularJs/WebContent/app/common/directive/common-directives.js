'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.directive:menuUtente
 * @description
 * # menuUtente
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .directive('menuUtente', function () {
	  return {
		  restrict : 'E',		  
		  scope:{
			 menuCliente: '=', 
		  },    
		  templateUrl : "app/common/directive/menuUtente.html",
		    transclude : true,
		  };
  })
  .directive('menuAdmin', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/common/directive/menuAdmin.html",
		    transclude : true
		  };
  })
.directive('areaRiservata', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/common/directive/areaRiservata.html",
		    transclude : true
		  };
})
.directive('dashBoard', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/common/directive/dashBoard.html",
		    transclude : true
		  };
})
.directive('heaDer', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/common/directive/header.html",
		    transclude : true
		  };
});
