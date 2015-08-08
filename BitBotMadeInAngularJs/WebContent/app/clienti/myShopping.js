'use strict';

angular.module('bitBotApp')
  .controller('myShopppingCtrl',['$scope','$http','API_CONF',
                                 function ($scope,$http,apiConf) {
	  
	 var server =  apiConf.server + apiConf.base_url;
	  var myProdcut = server + '/ordini/acquistiCliente?codCliente=24';
		  $http.get(myProdcut)
		  .success(function(data){
			  $scope.myProducts = data;
		  })
  }]);
