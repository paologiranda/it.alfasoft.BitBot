'use strict';

angular.module('app')
    .factory('loginFactory', ['$http', '$localStorage','API_CONF',
                             function($http, $localStorage,apiConf){
   
         return {
        	send: function(data, success, error) {
                $http.get(apiConf.server + apiConf.base_url + '/login/loggin?email=' + data.email +'&password=' + data.password)
                .success(success)
                .error(error)
            },
            logout: function(success) {
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