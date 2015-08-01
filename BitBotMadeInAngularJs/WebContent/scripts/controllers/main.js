'use strict';

angular.module('bitBotApp')
 .controller('MainCtrl',['$scope','dataSc','$http','$location','$window','callItem','loginService',
                         'API_CONF','callLoggato',
    function($scope,dataSc,$http,$location,$window,callItem,apiConf,callLoggato,loginService) {
	 
	 callItem.query(function(data){// 	chiamata tutti prodotti presenti nel magazzino	
		 $scope.prodotti = data;
	 });
	 $scope.person = function(nam){
		 $scope.name = loginService.setLogin;
		 console.log($scope.name);
	 }  
	 
	 $scope.showUserData = false;// chiamata servizio che restituisce se sei loggato o meno
//     callLoggato.query(function(result){
	 	var x = apiConf.server + apiConf.base_url + '/login/loggato';
	 	$http.get(x)
 		.success(function(data){
    	$scope.userData = data;
    	$scope.profilo = false;
		 if($scope.userData == null){
			 $scope.loggato = false;
		 }
		 else if($scope.userData != null){
			 $scope.loggato = true;
			 if($scope.userData.profilo == "Admin"){
				 //console.log('Benvenuto amministratore');
				 $scope.profilo = true;
				 $location.path('/mainAdmin');
			 }
			 else if($scope.userData.profilo == "Cliente"){
				 console.log('Benvenuto Cliente');
				 $scope.profilo = false;
				 $scope.showUserData = true;
			 }
			 
		 }
    });
	    $scope.selected = function(num){
	        dataSc.setSelectedProd(num);
	    }
	   
   //servizio che distrugge la sessione 
    $scope.logout = function(){
    	var logout = apiConf.server + apiConf.base_url + '/login/logout';
    	$http.get(logout)
    	.success(function(){
    		 $window.location.reload();		
    	})
    }
    var callCateg = apiConf.server + apiConf.base_url + '/prodotti/categoria';
    $http.get(callCateg)
    .success(function(data){
    	$scope.categorie = data;
    })
    
    //----------------------------LOGIN MODULE FOR HOMEPAGE ---------------------
    
    
    
    $scope.user = {
        email: "",
        pwd:"",
     };

     $scope.submitForm = function(){          
           var userEmail = 'email' + '=' + $scope.user.email + '&';
           var userPwd = 'password' + '=' + $scope.user.pwd;
           $scope.userTemp = userEmail + userPwd;
           $scope.showErrorMail = false;
           $scope.loginServic =  apiConf.server + apiConf.base_url + '/login/loggin?' + $scope.userTemp;
           {{$scope.loginServic}};
           $http({
             method:'get',
             url: $scope.loginServic,
             data: $.param($scope.user),
            }) 
           .success(function(data){       	        		   
        	var callServiceError = apiConf.server + apiConf.base_url + '/errori/errore';
         	$http.get(callServiceError).
         	success(function(data){
         		 console.log(data); 
         		   if(data !== null){
         		   		$scope.errore = data;
				        $scope.showErrorMail = true;  
				    }
				    else{
				         $window.location.reload();
				         $location.path('/');
				   }
         	});    
  	
           });
     }
 }]);
