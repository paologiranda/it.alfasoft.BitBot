'use strict';

/**
 * @ngdoc service
 * @name bitBotApp.categoria
 * @description
 * # categoria
 * Service in the bitBotApp.
 */
angular.module('app')
  .service('categoriaService', function () {
    
    var cat=[];
  
  	return {
  		getSelectedProd: function(){
  			return cat;
  		},
  		setSelectedProd: function(categ){
  			cat = categ;
  		}
  	};
  });
