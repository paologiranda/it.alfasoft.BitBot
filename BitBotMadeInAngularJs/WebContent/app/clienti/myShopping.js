'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:myShopppingCtrl'
 * @description
 * # myShopppingCtrl'
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('myShopppingCtrl',['$scope','$http','API_CONF',
                                 function ($scope,$http,apiConf) {
	  
	 var server =  apiConf.server + apiConf.base_url;
	  var myProdcut = server + '/ordini/acquisti';
		  $http.get(myProdcut)
		  .success(function(data){
			  $scope.myProducts = data;
		  })
  }]);
