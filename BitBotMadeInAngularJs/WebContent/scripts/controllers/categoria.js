'use strict';

angular.module('bitBotApp')
   	.controller('CategoriaCtrl',['$scope','$http','categoriaService','API_CONF',
   	           function ($scope,$http,categoriaService,apiConf) {
   		
   		var callCateg =  apiConf.server + apiConf.base_url + '/prodotti/categoria';
   		$http.get(callCateg)
		.success(function(data){
   			$scope.categorie = data;
   		});
		$scope.mostraSottoCat = function(categ){
 				categoriaService.setSelectedProd(categ);
		}		
  }]);
