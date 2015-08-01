'use strict';

/**
 * @ngdoc overview
 * @name bitBotApp
 * @description
 * # bitBotApp
 *
 * Main module of the application.
 */
angular.module('bitBotApp', [
			    'ngAnimate',
			    'ngCookies',
			    'ngResource',
			    'ngRoute',
			    'ngSanitize',
			    'ngTouch',
			    'bitBotApp.resources',
			  ])
			  .config(function ($routeProvider) {
					       
				  $routeProvider
			      .when('/', {
        templateUrl: 'views/main.html',
      })
      .when('/about', {
        templateUrl: 'views/about.html',
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
      })
      .when('/areariservata', {
        templateUrl: 'views/areariservata.html',
      })
      .when('/footer', {
        templateUrl: 'views/footer.html',
      })
      .when('/descrizione', {
        templateUrl: 'views/descrizione.html',
        controller: 'DescrizioneCtrl'
      })
      .when('/carrello', {
        templateUrl: 'views/carrello.html',
        controller: 'CarrelloCtrl'
      })
      .when('/sceltaPagamento', {
        templateUrl: 'views/sceltapagamento.html',
        controller: 'SceltapagamentoCtrl'
      })
      .when('/registrazione', {
        templateUrl: 'views/registrazione.html',
        controller: 'RegistrazioneCtrl'
      })
      .when('/registrazionePrivato', {
        templateUrl: 'views/registrazioneprivato.html',
        controller: 'RegistrazioneprivatoCtrl'
      })
      .when('/registrazioneAzienda', {
        templateUrl: 'views/registrazioneazienda.html',
        controller: 'RegistrazioneaziendaCtrl'
      })
      .when('/categoria', {
        templateUrl: 'views/categoria.html',
        controller: 'CategoriaCtrl'
      })
      .when('/header', {
        templateUrl: 'views/header.html',
        controller: 'HeaderCtrl'
      })
      .when('/sottoCategoria', {
        templateUrl: 'views/sottocategoria.html',
        controller: 'SottocategoriaCtrl'
      })
      .when('/informatica', {
        templateUrl: 'views/informatica.html',
        controller: 'InformaticaCtrl'
      })
      .when('/inserisciCodiceConferma', {
        templateUrl: 'views/inserisciCodiceConferma.html',
        controller: 'codiceConfermaCtrl'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .when('/logoutSuccess', {
        templateUrl: 'views/logoutSuccess.html',
        controller: ''
      })
       .when('/inserisciProdotto', {
        templateUrl: 'views/inserisciProdotto.html',
        controller: 'inserisciProdCtrl'
      })
      .when('/listaClienti', {
        templateUrl: 'views/listaClienti.html',
        controller: 'listaClientiCtrl'
      })
        .when('/prodottiInMag', {
        templateUrl: 'views/prodottiInMag.html',
        controller: 'prodottiInMagCtrl'
      })
      .when('/itemSubCategory', {
        templateUrl: 'views/itemSubCategory.html',
        controller: 'itemSubCategoryCtrl'
      })
      .when('/descrizione1', {
        templateUrl: 'views/descrizione1.html',
        controller: 'descrizione1Ctrl'
      })
      .when('/mainAdmin', {
        templateUrl: 'views/mainAdmin.html',
        controller: 'mainAdminCtrl'
      })
       .when('/confermaEliminazione', {
        templateUrl: 'views/confermaEliminazione.html',
        controller: 'ConfermaEliminazioneCtrl'
      })
      .when('/richiediPwd', {
        templateUrl: 'views/richiediPwd.html',
        controller: 'richiediPwdCtrl'
      })
      
      .otherwise({
        templateUrl: 'views/404.html',
      })
  })



