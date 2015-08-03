'use strict';

/**
 * @ngdoc service
 * @name bitBotApp.data
 * @description
 * # data
 * Service in the bitBotApp.
 */
angular.module('bitBotApp')
  .service('dataSc', function () {
   
  var prod="";
  
  	return {
  		getSelectedProd: function(){
  			return prod;
  		},
  		setSelectedProd: function(num){
  			prod = num;
  		}
  	};
});
