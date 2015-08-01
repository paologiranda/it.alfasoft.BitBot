'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')   

.controller('LoginCtrl',['$scope','$http','$cookies','$cookieStore','$location','$window','API_CONF',
		function ($scope,$http,$cookies,$cookieStore,$location,$window,apiConf) {
    

    $scope.user = {
       email: "",
       pwd:"",
    };
    $scope.showErrorMail = false;
    
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
        	$http.get(callServiceError)
        	.success(function(data){
      		    if(data != null){
      		   		$scope.errore = data;
				    scope.showErrorMail = true;				    
				    }
			    else{
			    	$window.location.reload();
			    	location.path('/');
			    	
				}
        	});    
        });
    }
}])

           
