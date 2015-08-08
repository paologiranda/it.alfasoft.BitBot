'use strict';

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
  
 .controller('inserisciProdCtrl',['$scope','$http','$window','API_CONF',
    		function ($scope,$http,$window,apiConf) {
    	
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
		  		 		  
		  var callServAddProd =  apiConf.server + apiConf.base_url + '/magazzino/inserisceProdotto?' + $scope.ItemToUpload;
		  $http.get(callServAddProd)
		  .success(function(data){
			  console.log(data);
			  alert('Il prodotto è stato inserito correttamente');
			  $window.location.reload();
		  });		  
	  }	  
}])
 .controller('listaClientiCtrl',['$scope','$http','categoriaService','$window','API_CONF',
		 function ($scope,$http,categoriaService,$window,apiConf) {
	 

	  var callServListClienti = apiConf.server + apiConf.base_url + '/registrazione/listaClienti';
	  $http.get(callServListClienti)
	  .success(function(data){
		  $scope.users = data;
		  
	  }) 
	  $scope.cancellaUtente = function(elemento){
		  categoriaService.setSelectedProd(elemento);
		  var x = elemento;
		  var y = 'mail' + '=' + x.mail;
		  var callService = apiConf.server + apiConf.base_url + '/registrazione/eliminaCliente?' + y;
		  $http.get(callService)
		  .success(function(data){
			  $window.location.reload()
		 });
	  }
 }])
  .controller('prodottiInMagCtrl',['$scope','$http','API_CONF',
                                   function ($scope,$http,apiConf) {
	 
	  var prodottoInMagazzino = apiConf.server + apiConf.base_url + '/prodotti/elenco2';
	  $http.get(prodottoInMagazzino)
	  .success(function(data){
		  $scope.items = data;
	  });
	  
  }])
  .controller('ordiniEffettuatiCtrl', ['$scope','$http','API_CONF',
                                       function ($scope,$http,apiConf) {
	 
	  var ordiniEffettuati =  apiConf.server + apiConf.base_url + '/ordini/acquisti';
	  $http.get(ordiniEffettuati)
	  .success(function(data){
		  $scope.items = data;
	  })
	  
  }]);