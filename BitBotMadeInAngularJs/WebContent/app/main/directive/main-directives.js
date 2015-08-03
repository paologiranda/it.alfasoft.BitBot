'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.directiver:mainDirectives
 * @description
 * # mainDirectives
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .directive('slideShow', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/main/directive/slideShow.html",
		    transclude : true
		  }

});
