'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # listaClientiCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('listaClientiCtrl', function ($scope,$http,categoriaService,$window) {
	 

	  var callServListClienti = 'http://localhost:8081/rest/registrazione/listaClienti';
	  $http.get(callServListClienti)
	  .success(function(data){
		  $scope.users = data;
		  
	  }) 
	  $scope.cancellaUtente = function(elemento){
		  categoriaService.setSelectedProd(elemento);
		  var x = elemento;
		  var y = 'mail' + '=' + x.mail;
		  var callService = 'http://localhost:8081/BitBotMadeInAngularJs/rest/registrazione/eliminaCliente?' + y;
		  $http.get(callService)
		  .success(function(data){
			  $window.location.reload()
		 })
	  }
			  
 });
