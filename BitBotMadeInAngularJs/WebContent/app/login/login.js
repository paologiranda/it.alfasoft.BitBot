'use strict';

angular.module('bitBotApp')   

.controller('LoginCtrl',['$scope','$http','$location','$window','API_CONF','$rootScope','loginFactory','$localStorage','erroriProvenientiDalServer',
		function ($scope,$http,$location,$window,apiConf,$rootScope,loginFactory,$localStorage,erroriProvenientiDalServer) {
    

    $scope.errorFromServer = false;

    $scope.submitForm = function(){  
    	 var FormData = {
           email: $scope.email,
           password: $scope.password,
         }
    	 loginFactory.send(FormData,
        		 function(res){
    		 		if (res == "") {     		 			
    		 			erroriProvenientiDalServer.query(function(data){
    		 				$scope.errorFromServer = true; 
    	 					$scope.new_string=data; 
    		 			});
    		 		}
    			    else{
//						$localStorage.token = res.data.token;
	 					$window.location.reload();
	 					$window.location = "/";  
				}
    		 
    	 })
    }
}]);
    

           
