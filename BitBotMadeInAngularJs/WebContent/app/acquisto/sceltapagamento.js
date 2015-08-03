'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:SceltapagamentoCtrl
 * @description
 * # SceltapagamentoCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('SceltapagamentoCtrl', function ($scope,$http) {

	  var callService = 'http://localhost:8081/rest/ordini/confermaOrdine';	
	  $http.get(callService)  
	  .success(function(data){
		  console.log(data);
	  })
	  
	  
  });
