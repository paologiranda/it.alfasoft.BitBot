'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:DescrizioneCtrl
 * @description
 * # DescrizioneCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('DescrizioneCtrl', function ($scope,dataSc,addProd,$http) {
     	
      $scope.selectProd = dataSc.getSelectedProd();
      //console.log($scope.selectProd);
 
        $scope.add = function(elemento){
            addProd.setElemSelect(elemento);
           	var codProd = 'codProd' + '=' + $scope.selectProd.codice + '&';
            var qta = 'qta' + '=' + '1'; 
           	var prodSelez = codProd + qta;
            
            var url = 'http://10.174.54.245:8081/rest/ordini/inserisciCarrello?'+ prodSelez;
           $http({
            method : "get",
            url : url,
            data: $.param($scope.selectProd)
            })
        $window.location.reload();
       } 
  });
