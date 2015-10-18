'use strict';

angular.module('app')
   	.controller('CategoriaCtrl',['$scope','$http','categoriaService','API_CONF','addToShop','showCategory','showSubCategory',
   	           function ($scope,$http,categoriaService,apiConf,addToShop,showCategory,showSubCategory) {
   		
   		showCategory.query(function(data){// chiamata a servizio che ritorna l enum delle categorie presente nel database
   			$scope.categorie = data;
   		})
		$scope.mostraSottoCat = function(categ){// setto la scelta dell utente su quale categoria lui clicca
 			var categorie = {};
 			categorie= categ;
   			categoriaService.setSelectedProd(categorie);
 				showSubCategory.send(categorie,function(res){
 					console.log('Ciao');
 				})
   		}
   		
   		
  }])
   .controller('SottocategoriaCtrl',['$scope','$http','categoriaService', 'subCatService','API_CONF','showSubCategory',
		  function ($scope,$http,categoriaService,subCatService,apiConf,showSubCategory) {
	   var sottocategoria = {};
  	   sottocategoria = categoriaService.getSelectedProd();// recupero la scelta fatta dall utente
	   $scope.showEmpty = false;
	  
	    if(sottocategoria == false){
	  		$scope.showEmpty = true;
	  	}
	  	else{
//	  		showSubCategory.query(function(data){
//	  			 $scope.items = data;
//	  		})
//	  	}
	  		
		if(sottocategoria.categoria  == "Informatica"){
			var callCateg = apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=Informatica';
	   		$http.get(callCateg)
			.success(function(data){
				$scope.items = data;
	   		});
	  	}
	    else if(sottocategoria.categoria == "Elettronica"){
	    	var callCategElet = apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=Elettronica';
	   		$http.get(callCategElet)
			.success(function(data){
	   			$scope.items = data;
	   		});
	  	}
	  	}
		
		 $scope.selected = function(prod){// setto la sottocategoria scelta dall utente 
			subCatService.setSelectedProd(prod);
				//console.log(categ);				
		}
   }])
    .controller('DescrizioneCtrl',['$scope','dataSc','addProd','$http','addToShop','$location','$modal','$rootScope',
                                 function ($scope,dataSc,addProd,$http,addToShop,$location,$modal,$rootScope) {
     	
      $scope.selectProd = dataSc.getSelectedProd();
      $scope.quantita=[1,2,3,4,5,6,7,8,9,10];
      
      $scope.add = function(elemento){
    	  if(!$scope.qta){
        		// se la quantità non c'è apro la modale settando prima il messaggio di errore 
        		$rootScope.ins_qta = "Inserisci la quantità prima di procedere";
        		var modalInstance = $modal.open({
					templateUrl: 'app/common/alertMsg/ins_qta.html',
					controller: 'ModalCtrl',
					resolve: {}
				})
            }else{
	            addProd.setElemSelect(elemento);
	            var itemSelected = {
	            	codProd: $scope.selectProd.codice,
	            	qta: $scope.qta,           	
	            }
	            addToShop.buy(itemSelected,
	            		function(res){
	            	console.log(res);
	            		
	            })
            }
       } 
  }])
.controller('descrizione1Ctrl',['$scope','addToCarr','$http','addToShop',
          function ($scope,addToCarr,$http,addToShop) {
               $scope.prodotti = addToCarr.getProd();  
               $scope.add = function(product){
                 	addToCarr.setProd(product);
                    var itemSelected = {
                        	codProd: $scope.prodotti.codice,
                        	qta: 1,
                        }
                        addToShop.buy(itemSelected,
                        		function(res){
                        })
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

