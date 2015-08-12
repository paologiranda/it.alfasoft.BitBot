'use strict';

angular.module('bitBotApp')
    .factory('loginFactory', ['$http', '$localStorage','API_CONF',
                             function($http, $localStorage,apiConf){
    	 function changeUser(user) {
             angular.extend(currentUser, user);
         }

         function urlBase64Decode(str) {
             var output = str.replace('-', '+').replace('_', '/');
             switch (output.length % 4) {
                 case 0:
                     break;
                 case 2:
                     output += '==';
                     break;
                 case 3:
                     output += '=';
                     break;
                 default:
                     throw 'Illegal base64url string!';
             }
             return window.atob(output);
         }

         function getUserFromToken() {
             var token = $localStorage.token;
             console.log(token);

             var user = {};
             if (typeof token !== 'undefined') {
                 var encoded = token.split('.')[1];
                 user = JSON.parse(urlBase64Decode(encoded));
             }
             return user;
         }

         var currentUser = getUserFromToken();

         return {
        	send: function(data, success, error) {
                $http.get(apiConf.server + apiConf.base_url + '/login/loggin?email=' + data.email +'&password=' + data.password)
                .success(success)
                .error(error)
            },
            logout: function(success) {
                changeUser({});
                delete $localStorage.token;
                success();
            },               		
            	     
        }     
}])
.factory('erroriProvenientiDalServer', ['$http','API_CONF','$resource',
                    function($http,apiConf,$resource){
	

		 var url = apiConf.server + apiConf.base_url + '/errori/errore';
		 var result = $resource(url,{
			save:{method:'GET'}
		 });
		 return result;
	
}]);