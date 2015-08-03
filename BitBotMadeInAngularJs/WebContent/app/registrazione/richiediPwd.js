'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # richiediPwdCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('richiediPwdCtrl', function ($scope,$http) {
	  
	  $scope.newPwd = "";
	  $scope.showNewPwd = false;
	  
	  $scope.send = function(){
		  
		  $scope.dataToSend = 'email' + '=' + $scope.newPwd;
		  
		  var callService = 'http://localhost:8081/BitBotMadeInAngularJs/rest/registrazione'+
		      '/recuperaPwd?' + $scope.dataToSend;
//		      console.log(callService);
		  $http.get(callService)
		  .success(function(data){
			 console.log(data);
			 $scope.nuovaPwd = data;
			 $scope.showNewPwd = true;
		  })
		  
	  }
	  
  });
