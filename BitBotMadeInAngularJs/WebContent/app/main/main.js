'use strict';

angular.module('bitBotApp')
 .controller('MainCtrl',['$scope','dataSc','$http','$location','$window','callItem',
                         'API_CONF','callLoggato','loginCommon',
    function($scope,dataSc,$http,$location,$window,callItem,apiConf,callLoggato,loginCommon) {
	 
	 callItem.query(function(data){// chiamata tutti prodotti presenti nel
									// magazzino
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
    };
    var callCateg = apiConf.server + apiConf.base_url + '/prodotti/categoria';
    $http.get(callCateg)
    .success(function(data){
    	$scope.categorie = data;
    })
    
    // ----------------------------LOGIN MODULE FOR HOMEPAGE
	// ---------------------
    
    
    
    $scope.user = {
        email: "",
        pwd:"",
     };
    $scope.menuCliente = false;
     $scope.submitForm = function(){                
    	    	var userEmail = 'email' + '=' + $scope.user.email;
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
	    	        			var data = data;
    	        	
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
