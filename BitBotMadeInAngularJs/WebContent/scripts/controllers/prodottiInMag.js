'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # prodottiInMagCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('prodottiInMagCtrl', function ($scope,$http) {
	 
	  var prodottoInMagazzino = 'http://localhost:8081/BitBotMadeInAngularJs/rest/prodotti/elenco2';
	  $http.get(prodottoInMagazzino)
	  .success(function(data){
		  $scope.items = data;
	  })
	  
  });
