'use strict';


angular.module('app').service('loginCommon',[ function(){

	  var utente = {};	
	  
	  return{
		  getUser: function(){
			  return utente;
		  },
		  setUser: function(userLoggato){
			  utente = userLoggato;
		  }
	  }
	  
	  
}]);

angular.module('app.httpRequestTracker', []);
angular.module('app.httpRequestTracker').factory('httpRequestTracker', ['$http', function($http){

  var httpRequestTracker = {};
  httpRequestTracker.hasPendingRequests = function() {
    return $http.pendingRequests.length > 0;
  };

  return httpRequestTracker;
}]);