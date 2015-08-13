'use strict';

angular.module('bitBotApp')
  .directive('slideShow', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/main/directive/slideShow.html",
		    transclude : true
		  }

});
