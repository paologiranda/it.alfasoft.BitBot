'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:DescrizioneCtrl
 * @description
 * # DescrizioneCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('DescrizioneCtrl',['$scope','dataSc','addProd','$http','$window',
                                 function ($scope,dataSc,addProd,$http, $window) {
     	
      $scope.selectProd = dataSc.getSelectedProd();
 
        $scope.add = function(elemento){
            addProd.setElemSelect(elemento);
           	var codProd = 'codProd' + '=' + $scope.selectProd.codice + '&';
            var qta = 'qta' + '=' + '1'; 
           	var prodSelez = codProd + qta;
            
            var url = 'http://localhost:8081/rest/ordini/inserisciCarrello?'+ prodSelez;
           $http({
            method : "get",
            url : url,
            data: $.param($scope.selectProd)
            })
        $window.location.reload();
       } 
  }]);
