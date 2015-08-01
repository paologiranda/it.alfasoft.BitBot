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
	  
  }]);
