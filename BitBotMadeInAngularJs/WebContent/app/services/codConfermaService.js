'use strict';

/**
 * @ngdoc service
 * @name bitBotApp.data
 * @description
 * # codConfermaService
 * Service in the bitBotApp.
 */
angular.module('bitBotApp')
  .service('codConfermaService', function () {
   
  var codiceConferma="";
  
  	return {
  		getSelectedProd: function(){
  			return codiceConferma;
  		},
  		setCodiceConferma: function(codice){
  			codiceConferma = codice;
  		}
  	};
});
