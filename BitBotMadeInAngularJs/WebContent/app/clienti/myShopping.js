'use strict';

angular.module('bitBotApp')
  .controller('myShopppingCtrl',['$scope','$http','API_CONF','$rootScope',
                                 function ($scope,$http,apiConf,$rootScope) {
	  
	  var server =  apiConf.server + apiConf.base_url;
	  var myProdcut = server + '/ordini/acquistiCliente?codCliente=24';
		  $http.get(myProdcut)
		  .success(function(data){
			  $scope.myProducts = data;
		  })
	
	   $scope.NoToken=false;
	   $scope.SiToken=true;
	   var tokenUser = $rootScope.isUser;// token per l'user proveniente dal mail principale// token per l'admin proveniente dal mail principale
	   var tokenAdmin = $rootScope.tokenAdmin;// token per l'admin proveniente dal main Admin
	   if(token=="undefined"){
			  $scope.NoToken=true;
			  $scope.SiToken=false;	 
	   }
	   if(tokenUser){
		   $scope.SiToken=true;
		   $scope.NoToken=true;
	   }
	   
  }]);
