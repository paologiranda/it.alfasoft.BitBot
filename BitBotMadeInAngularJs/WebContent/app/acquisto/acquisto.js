'use strict';

angular.module('app')
.controller('CarrelloCtrl',['$scope', 'addProd', '$http', '$location','$window','API_CONF','$rootScope','$routeParams','$modal', 
                            function($scope, addProd, $http, $location,$window,apiConf,$rootScope,$routeParams,$modal) {

	$scope.elemAggiunto = addProd.getElemSelect();
	$scope.isEmpty = true;
	$scope.UserNotLoggato = false;
	$rootScope.showModal = false;
	var carrelloCallService =  apiConf.server + apiConf.base_url + '/ordini/visualizzaCarrello?codCliente=24';
	$http.get(carrelloCallService)
	.success(function(res){
		if(res){
			$scope.isEmpty=false;
			$scope.carrello = res;
		}
	})	
	$scope.remove = function() {
			var carrelloTemp = {};
			carrelloTemp = $scope.carrello;
			var codiceProdotto = carrelloTemp[0].codiceProdotto;
			var item = 'codProd' + '=' + codiceProdotto;
			var callService =  apiConf.server + apiConf.base_url + '/ordini/eliminaProdottoCarrello?'+item;
			$http.get(callService)
			.success(function(data){
//				console.log(data);
				alert("Hai eliminato con successo il prodotto");
				$window.location.reload();	
			})			
		}	
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
	$scope.showModalNow=false;
	$scope.confermaOrdine = function() {
		$scope.showModalNow=true;
		var loggato =  apiConf.server + apiConf.base_url + '/login/loggato';
		$http.get(loggato)
		.success(function(data) {
			$scope.loggato = data;
			if ($scope.loggato == null) {
				$rootScope.showModal = true;
				$rootScope.$broadcast("alertMsg");
				var IamFromCarrello = self.location.href;// recupera l'url della pagina
				$rootScope.DoYouFromCarrello = IamFromCarrello;
				var modalInstance = $modal.open({
					templateUrl: 'erroriFromServer.html',
					controller: 'ModalCtrl',
					resolve: {}
				})
				
//				$rootScope.userNonLoggato="Effettua il login prima di procedere con l'acquisto";// variabile che uso se non è loggato e lo reindizzo al login
				$location.path('/login');
			}else{
				$location.path('/sceltaPagamento');
			}
		})
	}
}]);
 angular.module('app')
 .controller('SceltapagamentoCtrl',['$scope','$http','API_CONF',
                                    function ($scope,$http,apiConf) {
	 
   var callService = apiConf.server + apiConf.base_url + '/ordini/confermaOrdine';	
	  $http.get(callService)  
	  .success(function(data){
		  console.log(data);
	  })  
	  
 }]);
angular.module('app')
.controller('ModalCtrl', function($scope, $modalInstance){
	
	$scope.close = function(){
		$modalInstance.close();
	}
	$scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
})