'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:RegistrazioneaziendaCtrl
 * @description # RegistrazioneaziendaCtrl Controller of the bitBotApp
 */
angular.module('app')
  .controller('RegistrazioneaziendaCtrl',['$scope','$http','$location','regPrivato','API_CONF',
               function ($scope,$http,$location,regPrivato,apiConf) {
	 
	  // chiamata servizio tipovia
	  var callServiceTipovia = apiConf.server + apiConf.base_url + '/registrazione/tipovia';
	  $http.get(callServiceTipovia)
	  .success(function(data){
		  $scope.tipovia = data;
	  })
	  
	  
	  $scope.Azienda ={
			  piva: "",
			  ragionesociale: "",
	  		  telefono: "",
	  		  tipovia: "",
	  		  nomevia: "",
	  		  numerocivico: "",
	  		  scala: "",
	  		  piano:"",
	  		  citta:"",
	  		  provincia:"",
	  		  cap:"",
	  		  paese:"",
	  		  mail1:"",
	  		  mail2:"",
	  		  password1:"",
	  		  password2:"",
	  }
	  
	  $scope.registrazioneAzienda = function(elemento){
		  var piva = 'PIVA' + '=' + $scope.Azienda.piva + '&'; 
		  var ragionesociale = 'RAGIONESOCIALE' + '=' + $scope.Azienda.ragionesociale + '&';
		  var telefono = 'TELEFONO' + '=' + $scope.Azienda.telefono + '&';
		  var tipovia = 'TIPOVIA' + '=' + $scope.Azienda.tipovia + '&';
		  var nomevia = 'NOMEVIA' + '=' + $scope.Azienda.nomevia + '&';
		  var numerocivico = 'NUMEROCIVICO' + '=' + $scope.Azienda.numerocivico + '&';
		  var scala = 'SCALA' + '=' + $scope.Azienda.scala + '&';
		  var piano = 'PIANO' + '=' + $scope.Azienda.piano + '&';
		  var citta = 'CITTA' + '=' + $scope.Azienda.citta + '&';
		  var provincia = 'PROVINCIA' + '=' + $scope.Azienda.provincia + '&';
		  var cap = 'CAP' + '=' + $scope.Azienda.cap + '&';
		  var paese = 'PAESE' + '=' + $scope.Azienda.paese + '&';
		  var mail = 'mail' + '=' + $scope.Azienda.mail1 + '&';
		  var pwd = 'PASSWORD' + '=' + $scope.Azienda.password1;
		  
		  $scope.dataUser = piva + ragionesociale + telefono + tipovia + nomevia + 
		  numerocivico + scala + piano + citta + provincia + cap + paese + mail + pwd;
		  
	      console.log($scope.dataUser);
		  
		 
		  var callSerRegAz = apiConf.server + apiConf.base_url +  '/registrazione/registraAzienda?' + $scope.dataUser;
		  $http({
			  method:'get',
			  url: callSerRegAz,
			  data: $.param($scope.Azienda),
			  })
		  .success(function(data){
			 
				  $location.path('/inserisciCodiceConferma');
				  regPrivato.setElemSelect(elemento);
				  console.log(elemento);
				 
		 }) 		  
	  }
	  
	  
  }]);
