angular.module('app')
.controller('common', ['$scope', 'httpRequestTracker',
    function ($scope, httpRequestTracker) {
        $scope.hasPendingRequests = function () {
            return httpRequestTracker.hasPendingRequests();
        };
}]);

// controllo delle modali
angular.module('app')
.controller('ModalCtrl',['$scope','$modalInstance','$rootScope',
                         function($scope, $modalInstance,$rootScope){
	
	$scope.close = function(){
		$modalInstance.close();
	}
}])

