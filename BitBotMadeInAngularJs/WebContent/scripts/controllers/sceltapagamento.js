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

	  var callService = 'http://192.168.18.238/rest/ordini/confermaOrdine';	
	  $http.get(callService)  
	  .success(function(data){
		  console.log(data);
	  })
	  
	  
  });
