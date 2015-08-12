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
  }])
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
   }])
    .controller('DescrizioneCtrl',['$scope','dataSc','addProd','$http','$window',
                                 function ($scope,dataSc,addProd,$http, $window) {
     	
      $scope.selectProd = dataSc.getSelectedProd();
 
        $scope.add = function(elemento){
            addProd.setElemSelect(elemento);
           	var codProd = 'codProd' + '=' + $scope.selectProd.codice + '&';
            var qta = 'qta' + '=' + '1'; 
           	var prodSelez = codProd + qta;
            
            var url = 'http://localhost:8081/rest/ordini/inserisciCarrello?'+ prodSelez;
           $http({
            method : "get",
            url : url,
            data: $.param($scope.selectProd)
            })
        $window.location.reload();
       } 
  }])
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
                 	$window.location.reload();
                 	}           
}])
.controller('itemSubCategoryCtrl',['$scope','$http','subCatService','addToCarr','API_CONF',
		  function ($scope,$http,subCatService,addToCarr,apiConf) {
	  	  
		  $scope.prod = subCatService.getSelectedProd();
		  $scope.CatIsEmpty = false;
		 
		  if($scope.prod == false){
			  $scope.CatIsEmpty = true;
		  }
		  $scope.send = function(product){
				addToCarr.setProd(product);
		    }
		  
		  var completedUrlInfo = '/prodotti/prodottisottocategoria?categoria=Informatica&sottocategoria=';
		  var completedUrlElet = '/prodotti/prodottisottocategoria?categoria=Elettronica&sottocategoria=';
		  switch($scope.prod.sottocategoria){
		  	case "Education":
				  var servEduc =  apiConf.server + apiConf.base_url + completedUrlElet + 'Education';
				  $http.get(servEduc)
				  .success(function(data){
					  if(data == false){
						  $scope.CatIsEmpty = true;
					  }else{
					  $scope.items = data;
					  }
					  
				  });
				  return $scope.items;
		  		break;
		  		
		    case "Hardware":
					  var servEduc = apiConf.server + apiConf.base_url + completedUrlElet + 'Elettronica&sottocategoria=Hardware';
					  $http.get(servEduc)
					  .success(function(data){
						  if(data == false){
							  $scope.CatIsEmpty = true;
						  }else{
						  	$scope.items = data;
						  }
					  });
					  return $scope.items;
			break;
			
		    case "Software":
				  var servEduc = apiConf.server + apiConf.base_url + '/prodotti/prodottisottocategoria?categoria=informatica&sottocategoria=software';
				  $http.get(servEduc)
				  .success(function(data){
					  if(data == false){
						  $scope.CatIsEmpty = true;
					  }else{
					  $scope.items = data;
					  }
			});
				  
				  return $scope.items;
			break;
			
		    case "Sicurezza":
				  var servEduc = apiConf.server + apiConf.base_url + '/prodotti/prodottisottocategoria?categoria=informatica&sottocategoria=sicurezza';
				  $http.get(servEduc)
				  .success(function(data){
					  if(data == false){
						  $scope.CatIsEmpty = true;
					  }else{
					  $scope.items = data;	
					  }  
				});
				  return $scope.items;
			break;
			
		    case "Sorveglianza":
				  var servEduc = apiConf.server + apiConf.base_url + '/prodotti/prodottisottocategoria?categoria=elettronica&sottocategoria=sorveglianza';
				  $http.get(servEduc)
				  .success(function(data){
					  if (data == false){
						  $scope.CatIsEmpty = true;
					  }else{
					  $scope.items = data;	
					  }
				  });
				  return $scope.items;
			break;
			
		    case "Domotica":
				  var servEduc = apiConf.server + apiConf.base_url + '/prodotti/prodottisottocategoria?categoria=elettronica&sottocategoria=domotica';
				  $http.get(servEduc)
				  .success(function(data){
					  if (data == false){
						  $scope.CatIsEmpty = true;
					  }else{
					  $scope.items = data;	
					  }
				  });
				  return $scope.items;
			break;
			
		    case "Automation":
				  var servEduc =apiConf.server + apiConf.base_url + '/prodotti/prodottisottocategoria?categoria=elettronica&sottocategoria=automation';
				  $http.get(servEduc)
				  .success(function(data){
					  if (data == false){
						  $scope.CatIsEmpty = true;
					  }else{
					  $scope.items = data;	
					  }	 
				  });
				  return $scope.items;
			break;
			
		    case "default":
		    	console.log("ciao");
  		}
		  
		
  }]);

