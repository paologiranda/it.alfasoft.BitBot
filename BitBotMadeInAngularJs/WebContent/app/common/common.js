angular.module('app').controller('common', ['$scope', 'httpRequestTracker',
    function ($scope, httpRequestTracker) {
        $scope.hasPendingRequests = function () {
            return httpRequestTracker.hasPendingRequests();
        };
    }]);




