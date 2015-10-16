'use strict';

angular.module('app').controller('LoginCtrl',['$scope','$http','$location','$window','API_CONF','$rootScope','loginFactory','$localStorage','erroriProvenientiDalServer',
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
    		 }else{
//				   $localStorage.token = res.data.token;
    			 if(whereAreYouFrom){
    				  $window.location.reload();
    				  $location.path('/carrello');
    			  }else{
    				  $rootScope.token = res.token;
    				  $window.location.reload();
    				  $window.location = "/";  
    			 }
			  } 		 
    		})
    	 }
    // gestione della navigazione per mostrare o meno i messaggi di accesso all area risevata per proseguire con l'acquisto
    	var IamFromCarrello = $rootScope.DoYouFromCarrello;
    	$scope.isAuthentic = false;
    	if(IamFromCarrello){
    		$scope.$watch("alertMsg", function (event, args) {
//			var a = args.scope.loggatoNull;  
			$scope.isAuthentic = true;
		  });
    	}
	    var IamFromHome = $rootScope.DoyouFromHome;
	    if(IamFromHome &&(IamFromHome == "http://localhost:9000/#/")){
	    		$scope.isAuthentic = false;
	    }
	 	
}]);
    

           
