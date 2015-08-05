'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # mainAdminCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('mainAdminCtrl',['$scope','$http','API_CONF',
                function ($scope,$http,apiConf) {
	  
	  var url =  apiConf.server + apiConf.base_url + '/login/loggato';
	    $http.get(url)
	    .success(function(data){
	    	console.log(data);
	    	$scope.admin = data;
	    })   
  }])
  
  
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
	      'http://localhost:8081/rest/magazzino/inserisceProdotto?' + $scope.ItemToUpload;
		  $http.get(callServAddProd)
		  .success(function(data){
			  console.log(data);
			  alert('Il prodotto è stato inserito correttamente');
			  $window.location.reload();
		  })
		  
	  }
	  
})
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
 })
  .controller('prodottiInMagCtrl', function ($scope,$http) {
	 
	  var prodottoInMagazzino = 'http://localhost:8081/rest/prodotti/elenco2';
	  $http.get(prodottoInMagazzino)
	  .success(function(data){
		  $scope.items = data;
	  })
	  
  });