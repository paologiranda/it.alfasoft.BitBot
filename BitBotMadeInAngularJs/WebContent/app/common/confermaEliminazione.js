'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:AboutCtrl
 * @description
 * # ConfermaEliminazioneCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('ConfermaEliminazioneCtrl', function ($scope,categoriaService) {
  
	  $scope.datiUtente = categoriaService.getSelectedProd();
	  console.log($scope.datiUtente.mail);
  
  });
