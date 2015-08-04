'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')   

.controller('LoginCtrl',['$scope','$http','$location','$window','API_CONF',
		function ($scope,$http,$location,$window,apiConf) {
    

    $scope.user = {
       email: "",
       pwd:"",
    };
    $scope.showErrorMail = false;
    $scope.menuCliente = false;
    $scope.submitForm = function(userLoggato){  
    	var userEmail = 'email' + '=' + $scope.user.email + '&';
        var userPwd = 'password' + '=' + $scope.user.pwd;
        $scope.userTemp = userEmail + userPwd;
        $scope.showErrorMail = false;
        $scope.loginServic =  apiConf.server + apiConf.base_url + '/login/loggin?' + $scope.userTemp;
        $http({
          method:'get',
          url: $scope.loginServic,
          data: $.param($scope.user),
         }) 
        .success(function(data){       	
        	$scope.userData = data; 
        	var callServErrore = apiConf.server + apiConf.base_url + '/errori/errore';
        	$http.get(callServErrore).
	        		success(function(data){
	        			if(data != null){
	        				$scope.wrong = data;
	        			}
			        	if($scope.userData.mail != null && $scope.userData != undefined){
			    		    if($scope.userData.profilo == "Admin"){
			    				 console.log('Benvenuto' + $scope.userData.profilo);   			
			    				 $location.path('/mainAdmin');
			    				 $window.location.reload();
			    			 }
			    			 else if($scope.userData.profilo == "Cliente"){
			    				 console.log('Benvenuto Cliente');
			    				 $scope.menuCliente = true;
			    				 $location.path('/');
			    				 $window.location.reload();
			    			 }   		    
			    		 }
	        		})
        })
    }
}]);
    

           
