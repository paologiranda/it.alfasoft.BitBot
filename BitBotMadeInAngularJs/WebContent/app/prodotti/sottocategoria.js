'use strict';

angular.module('bitBotApp')
  .controller('SottocategoriaCtrl',['$scope','$http','categoriaService', 'subCatService','API_CONF',
		  function ($scope,$http,categoriaService, subCatService,apiConf) {
   
	  
  	$scope.sottocategoria = categoriaService.getSelectedProd();
  	$scope.showEmpty = false;
  	if($scope.sottocategoria == false){
  		$scope.showEmpty = true;
  	}
  	
		
		if($scope.sottocategoria.categoria  == "Informatica"){
			var callCateg = apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=Informatica';
	   		$http.get(callCateg)
			.success(function(data){
				$scope.items = data;
	   		});
	  	}
	    else if($scope.sottocategoria.categoria == "Elettronica"){
	    	var callCategElet = apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=Elettronica';
	   		$http.get(callCategElet)
			.success(function(data){
	   			$scope.items = data;
	   		});
	  	}
		
		
		
		var callCatInfo =apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=Informatica';
		$http.get(callCatInfo)
		.success(function(data){
			$scope.informatica = data;
		})
		var callCatElet = apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=Elettronica';
		$http.get(callCatElet)
		.success(function(data){
			$scope.elettronica = data;
		})
		
		
		
		
		$scope.selected = function(prod){
			subCatService.setSelectedProd(prod);
				//console.log(categ);				
		}
}]);
