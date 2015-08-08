'use strict';

angular.module('bitBotApp')
 .controller('MainCtrl',['$scope','dataSc','$http','$location','$window','callItem',
                         'API_CONF','callLoggato','loginCommon',
    function($scope,dataSc,$http,$location,$window,callItem,apiConf,callLoggato,loginCommon) {
	 
	 callItem.query(function(data){// chiamata tutti prodotti presenti nel
		   $scope.prodotti = data;
	 });
	 
	 
	 	var x = apiConf.server + apiConf.base_url + '/login/loggato';
	 	$http.get(x)
 		.success(function(data){
	    	$scope.userData = data;
	    	$scope.isUser = false;
	    	$scope.isAdmin = false;
	    	$scope.loggato = false;
	    	$scope.menuVetrina = true;
			 if($scope.userData == null){
				 $scope.loggato = false;
			 }
			 else if($scope.userData != null){
				 $scope.loggato = true;
				 if($scope.userData.profilo == "Admin"){
					 console.log('Benvenuto' + $scope.userData.profilo);
					 $scope.menuVetrina = false;
					 $scope.isAdmin = true;
					 $location.path('/mainAdmin');
				 }
				 else if($scope.userData.profilo == "Cliente"){
					 console.log('Benvenuto Cliente');
					 $scope.isUser = true;
					 $scope.menuVetrina = true;
				 }
				 
			 }
    });
	    $scope.selected = function(num){
	        dataSc.setSelectedProd(num);
	    }
	   
   // servizio che distrugge la sessione
    $scope.logout = function(){
    	var logout = apiConf.server + apiConf.base_url + '/login/logout';
    	$http.get(logout)
    	.success(function(){
    		 $window.location.reload();		
    	})
    }   	 
 }]);
