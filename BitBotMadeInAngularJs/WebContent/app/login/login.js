'use strict';

angular.module('bitBotApp')   

.controller('LoginCtrl',['$scope','$http','$location','$window','API_CONF','$rootScope','loginFactory','$localStorage',
		function ($scope,$http,$location,$window,apiConf,$rootScope,loginFactory,$localStorage) {
    

    $scope.isLoginWrong = false;
    
    $scope.submitForm = function(){  
    	
    	 var FormData = {
           email: $scope.email,
           password: $scope.password,
         }
    	 
    	 loginFactory.send(FormData,
        		 function(res){
        	 		if (res.type != false) {
        	 			var callServiceError = apiConf.server + apiConf.base_url + '/errori/errore';
        	 			$http.get(callServiceError).
        	 				success(function(data){
        	 						if(data != null){
        	 							$scope.isLoginWrong = true; 
		        	 					$scope.wrong = data;        	 					
        	 						}
        	 						else{
        	 							$localStorage.token = res.data.token;
		        	 					$window.location.reload();
		        	 					$window.location = "/";  
        	 						}

        	 				   })  
        	 				 }
        	 		})	 		
    }
}]);
    

           
