'use strict';

/**
 * @ngdoc function
 * @name bitBotApp.controller:RegistrazioneprivatoCtrl
 * @description
 * # RegistrazioneprivatoCtrl
 * Controller of the bitBotApp
 */
angular.module('bitBotApp')
  .controller('RegistrazioneprivatoCtrl',['$scope','$http','$location','regPrivato','API_CONF',
                                          function ($scope,$http,$location,regPrivato,apiConf) {

	  //chiamata servizio tipovia
	  var callServiceTipovia = apiConf.server + apiConf.base_url + '/registrazione/tipovia';
	  $http.get(callServiceTipovia)
	  .success(function(data){
		  $scope.tipovia = data;
	  });
	  
	  $scope.Privato ={
			  nome: "",
			  cognome: "",
			  cf: "",
	  		  telefono: "",
	  		  tipovia:"",
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
	  $scope.showErrorReg = false;
	  
	  
	  $scope.registrazionePrivato = function(elemento){
		  
		  
		  var nome = 'NOME' + '=' + $scope.Privato.nome + '&'; 
		  var cognome = 'COGNOME' + '=' + $scope.Privato.cognome + '&';
		  var cf = 'CF' + '=' + $scope.Privato.cf + '&';
		  var telefono = 'TELEFONO' + '=' + $scope.Privato.telefono + '&';
		  var tipovia = 'TIPOVIA' + '=' + $scope.Privato.tipovia + '&';
		  var nomevia = 'NOMEVIA' + '=' + $scope.Privato.nomevia + '&';
		  var numerocivico = 'NUMEROCIVICO' + '=' + $scope.Privato.numerocivico + '&';
		  var scala = 'SCALA' + '=' + $scope.Privato.scala + '&';
		  var piano = 'PIANO' + '=' + $scope.Privato.piano + '&';
		  var citta = 'CITTA' + '=' + $scope.Privato.citta + '&';
		  var provincia = 'PROVINCIA' + '=' + $scope.Privato.provincia + '&';
		  var cap = 'CAP' + '=' + $scope.Privato.cap + '&';
		  var paese = 'PAESE' + '=' + $scope.Privato.paese + '&';
		  var mail = 'mail' + '=' + $scope.Privato.mail1 + '&';
		  var pwd = 'PASSWORD' + '=' + $scope.Privato.password1;
		  $scope.datiPrivatoTot = nome + cognome + cf + telefono + tipovia + nomevia + numerocivico + scala + piano 
		  					+ citta + provincia + cap + paese + mail + pwd;
		  
//			  console.log($scope.datiPrivatoTot);
			  /*if(($scope.Privato.mail1 != $scope.Privato.mail2)&&
				($scope.Privato.password1 != $scope.Privato.password2)){
				  console.log('Errore');
			  }*/
			  var regPrivService = apiConf.server + apiConf.base_url + '/registrazione/registraPrivato?' + $scope.datiPrivatoTot;
			  $http({
				  method: 'get',
				  url: regPrivService,
				  data: $.param($scope.Privato),
			  })
			  .success(function(data){			  
//				  console.log(data);
				  var callServiceError = apiConf.server + apiConf.base_url + '/errori/errore';
				  $http.get(callServiceError).
        		  success(function(data){
//        		   		console.log(data);
        		   				if(data != null){
        		   					$scope.errore = data;
//        		   					console.log($scope.errore);
        		   					$scope.showErrorReg = true;
        		   				}else{	
							  	$scope.dataUser = data;
								$location.path('/inserisciCodiceConferma');
								regPrivato.setElemSelect(elemento);
        		   				}
					 
        		   		})
			  })
	  }	
  }]);
