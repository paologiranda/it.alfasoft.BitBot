'use strict';

/**
 * @ngdoc factory
 * @name bitBotApp.addProd
 * @description
 * # callServiceResource
 * factory in the bitBotApp.
 */
angular.module('bitBotApp.resources',['ngResource'])
  .factory('callItem',['$resource','API_CONF', 
    function($resource,apiConf) {	
	    	var callService = apiConf.server + apiConf.base_url + '/prodotti/elenco2';
	    	var result = $resource(callService,{
	    		save:{method:'GET'}
	    	});
	    	return result;
  }])
  .factory('callLoggato',['$resource','API_CONF', 
    function($resource,apiConf) {	
	    	var callService = apiConf.server + apiConf.base_url + '/login/loggato';
	    	var result =  $resource(callService,{
	    		save:{method:'GET'}
	    	});
	    	return result;
  }]);
