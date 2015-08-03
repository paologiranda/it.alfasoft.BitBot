'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # descrizione1Ctrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('descrizione1Ctrl',['$scope','addToCarr','$http','API_CONF','$window',
               function ($scope,addToCarr,$http,apiConf,$window) {
	  
	  $scope.prodotti = addToCarr.getProd();  
	  $scope.add = function(product){
		  addToCarr.setProd(product);
          	var codProd = 'codProd' + '=' + $scope.prodotti.codice + '&';
            var qta = 'qta' + '=' + '1'; 
          	var prodSelez = codProd + qta;
            var url =  apiConf.server + apiConf.base_url + '/ordini/inserisciCarrello?'+ prodSelez;
	          $http({
	           method : "get",
	           url : url,
	           data: $.param($scope.prodotti)
	          });
	  }
  }]);
