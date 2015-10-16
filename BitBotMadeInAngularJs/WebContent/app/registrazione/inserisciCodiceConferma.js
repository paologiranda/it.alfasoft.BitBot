'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:RegistrazioneeffettuataCtrl
 * @description
 * # RegistrazioneeffettuataCtrl
 * Controller of the bitBotApp
 */
angular.module('app')
  .controller('codiceConfermaCtrl',['$scope','$http','regPrivato','$location',
                                    function($scope,$http,regPrivato,$location){
  		
	  $scope.PrivatoRegistrato = regPrivato.getElemSelect();
	  $scope.showMessagge = false;
	  $scope.codiceConferma="";
	  $scope.email = 'mail' + '=' + $scope.PrivatoRegistrato.mail1;
	  
	
	  var callServCodConf = 'http://localhost:8081/rest/registrazione/mostraCodiceConferma?' + $scope.email;
	  
	   $http.get(callServCodConf)
 	  .success(function(data){
 		  $scope.cConferma = data;
 		  $scope.mailUtente = 'mail' + '=' + $scope.PrivatoRegistrato.mail1 + '&';
 		  $scope.codConferma = 'conferma' + '=' + $scope.cConferma;
 		  	$scope.dataToSend = $scope.mailUtente + $scope.codConferma;
 		  		
 		  	$scope.codConferma = function(){
 		  		 var callServattivazione = 'http://localhost:8081/rest/registrazione/attivazione?' + $scope.dataToSend;	
 		  		$http.get(callServattivazione)
 		  		.success(function(){
 		  			$scope.showMessagge = true;
 		  			$location.path('/');
 		  		})
 		  		}
  	  })
	 
  }]);
