'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # inserisciProdCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('inserisciProdCtrl',function ($scope,$http,$window) {
	  
	  $scope.numbers = [1,2,3,4,5,6,7,8,9,10];
	  
	  $scope.Item = {
		 category: "",	
		 subCategory: "",
		 name: "",
		 code: "",
		 price: "",
		 qta: "",
		 descrizione: "",
	  }
	 
	  
	  $scope.send = function(){
		
		  var cat = 'categoria' + '=' + $scope.Item.category + '&';
		  var subcat = 'sottocategoria' + '=' + $scope.Item.subCategory + '&';
		  var tipoProd = 'tipoprodotto' + '=' + 'ProdottoServizio' + '&';
		  var codProd = 'codprod' + '=' + $scope.Item.code + '&';
		  var name = 'nome' + '=' + $scope.Item.name + '&';
		  var descrizione = 'descrizione' + '=' + $scope.Item.descrizione + '&';
		  var riservato = 'riservato' + '=' + 'si' + '&';
		  var qta = 'qta' + '=' + $scope.Item.qta;
		  
		  $scope.ItemToUpload = cat + subcat + tipoProd + codProd + name + descrizione 
		  						+  riservato + qta;
		  
		 		  
		  var callServAddProd = 
	      'http://10.174.54.245:8081/rest/magazzino/inserisceProdotto?' + $scope.ItemToUpload;
		  $http.get(callServAddProd)
		  .success(function(data){
			  console.log(data);
			  alert('Il prodotto è stato inserito correttamente');
			  $window.location.reload();
		  })
		  
		  
	  }
	  
	  //----------------------danger code!!!! Pay attention.............
	  
	  
	  $scope.danger = function(){
		  //console.log('Per selezionare una quantità maggiore di dieci la preghiamo di conta' +
				  //'ttare il dba');
	  }
  });
