'use strict';

angular.module('bitBotApp')
.controller('CarrelloCtrl',['$scope', 'addProd', '$http', '$location','$window','API_CONF', 
                            function($scope, addProd, $http, $location,$window,apiConf) {

	$scope.elemAggiunto = addProd.getElemSelect();
	
	var carrelloCallService =  apiConf.server + apiConf.base_url + '/ordini/visualizzaCarrello?codCliente=9';
	$http.get(carrelloCallService)
	.success(function(data){
			$scope.carrello = data;
			var carrelloTemp = $scope.carrello;
			$scope.remove = function(carrelloTemp) {
				var x = 'codProd' + '=' + 'DOMO002';
				var callService =  apiConf.server + apiConf.base_url + '/ordini/eliminaProdottoCarrello?'+x;
				$http.get(callService)
				.success(function(data){
					console.log(data);
					$window.location.reload();	
				})			
			}			
	})	
	$scope.empty = function(){
		var logout =   apiConf.server + apiConf.base_url + '/login/logout';
    	$http.get(logout)
    	.success(function(){
    		//console.log('Ti sei disconnesso con successo!');
    		//$location.path('/');
    		//location.reload(); ricaricare una pagina in javascript
    		 $window.location.reload();
    		
    	})
	}
	
	$scope.confermaOrdine = function() {
		var loggato =  apiConf.server + apiConf.base_url + '/login/loggato';
		$http.get(loggato)
		.success(function(data) {
			$scope.loggato = data;
			if ($scope.loggato.mail == null) {
			console.log('Devi essere loggato');
			$location.path('/login');
			}
			else
			$location.path('/sceltaPagamento')					
		})
	}
}]);
