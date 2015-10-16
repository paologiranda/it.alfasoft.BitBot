'use strict';

/**
 * @ngdoc service
 * @name bitBotApp.addProd
 * @description
 * # addProd
 * Service in the bitBotApp.
 */
angular.module('app')
  .service('addProd', function () {

    var elem = [];

   
    return {
    	getElemSelect: function(){
    		return elem;
    	},
    	setElemSelect: function(elemento){
    		elem = elemento;
    	}
    }


  });
