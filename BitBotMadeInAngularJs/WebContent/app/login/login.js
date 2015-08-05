'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')   

.controller('LoginCtrl',['$scope','$http','$location','$window','API_CONF','$rootScope','generaToken','$localStorage',
		function ($scope,$http,$location,$window,apiConf,$rootScope,generaToken,$localStorage) {
    

    $scope.isLoginWrong = false;
    $scope.menuCliente = false;
    
    $scope.submitForm = function(){  
    	
    	 var FormData = {
           email: $scope.email,
           password: $scope.password,
         }
    	 
         generaToken.send(FormData,
        		 function(res){
        	 		console.log(res);
        	 		if (res.type == "undefined") {
					     $scope.isLoginWrong = true; 
					     $scope.wrong = res.data;
        	 		}else {
					   $localStorage.token = res.token;
					   $window.location.reload();
					    window.location = "/";  
					   
        	 		}
				 },
				 function(){
				    $rootScope.error = 'Failed to signin';
				 })
    	
				 $scope.token = $localStorage.token;
    	
//    	var userEmail = 'email' + '=' + $scope.user.email + '&';
//        var userPwd = 'password' + '=' + $scope.user.pwd;
//        $scope.userTemp = userEmail + userPwd;
//        $scope.showErrorMail = false;
//        $scope.loginServic =  apiConf.server + apiConf.base_url + '/login/loggin?' + $scope.userTemp;
//        $http({
//          method:'get',
//          url: $scope.loginServic,
//          data: $.param($scope.user),
//         }) 
//        .success(function(data){       	
//        	$scope.userData = data; 
//        	var callServErrore = apiConf.server + apiConf.base_url + '/errori/errore';
//        	$http.get(callServErrore).
//	        		success(function(data){
//	        			if(data != null){
//	        				$scope.wrong = data;
//	        			}
//			        	if($scope.userData.mail != null && $scope.userData != undefined){
//			    		    if($scope.userData.profilo == "Admin"){
//			    				 console.log('Benvenuto' + $scope.userData.profilo);   			
//			    				 $location.path('/mainAdmin');
//			    				 $window.location.reload();
//			    			 }
//			    			 else if($scope.userData.profilo == "Cliente"){
//			    				 console.log('Benvenuto Cliente');
//			    				 $scope.menuCliente = true;
//			    				 $location.path('/');
//			    				 $window.location.reload();
//			    			 }   		    
//			    		 }
//	        		})
//        })
    }
}]);
    

           
