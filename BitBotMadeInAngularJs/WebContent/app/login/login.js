'use strict';


angular.module('app').controller('LoginCtrl',['$scope','$http','$location','$window','API_CONF','$rootScope','loginFactory',
                                              '$localStorage','erroriProvenientiDalServer','$timeout','$modal',
		function ($scope,$http,$location,$window,apiConf,$rootScope,loginFactory,$localStorage,erroriProvenientiDalServer,$timeout,$modal) {
    
    $scope.errorFromServer = false;
    var IamFromCarrello = $rootScope.DoYouFrom;
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
    	 			$rootScope.credenziali_errate="Credenziali errate"; 
    	 			
    	 			var modalInstance = $modal.open({
    					templateUrl: 'erroriFromServer.html',
    					controller: 'ModalCtrl',
    					resolve: {}
    				})
    		 		});
    		 }else{
//				   $localStorage.token = res.data.token;
    			 if(IamFromCarrello){
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
    		$rootScope.$watch("alertMsg", function (event, args) {
			$scope.isAuthentic = true;
    	  })
    	}
       	//se vengo dalla home invece nascondo i mex per l acquisto
    	var IamFromHome = $rootScope.DoyouFromHome;
 	    if(IamFromHome){
 	    	$scope.$watch("alertMsg", function (event, args) {
 	    		if(IamFromHome == "http://localhost:9000/#/"){
 	    			$scope.isAuthentic = false;
 	    		}
 	    	})
 	    }
}]);

	


           
