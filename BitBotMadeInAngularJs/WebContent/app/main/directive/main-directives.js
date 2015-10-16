'use strict';

angular.module('app')
  .directive('slideShow', function () {
	  return {
		    restrict : 'E',		   
		    templateUrl : "app/main/directive/slideShow.html",
		    transclude : true
		  }

});
