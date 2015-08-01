'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # itemSubCategoryCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
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
