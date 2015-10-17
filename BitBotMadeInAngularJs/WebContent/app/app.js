	'use strict';

/**
 * @ngdoc overview
 * @name bitBotApp
 * @description
 * # bitBotApp
 *
 * Main module of the application.
 */
angular.module('app', [
			    'ngAnimate',
			    'ngCookies',
			    'ngResource',
			    'ngRoute',
			    'ngSanitize',
			    'ngTouch',
			    'app.resources',	
			    'ngStorage',
			    'angular-loading-bar',
			    'app.httpRequestTracker',
			    'ui.bootstrap'
			  ])
			  .config(['$routeProvider','$httpProvider', 
			           function ($routeProvider,$httpProvider) {
		
				  $routeProvider.when('/', {
        templateUrl: 'app/main/main.html',
      })
      .when('/about', {
        templateUrl: 'app/common/about.html',
      })
      .when('/contact', {
        templateUrl: 'app/common/contact.html',
      })
      .when('/areariservata', {
        templateUrl: 'app/common/areariservata.html',
      })
      .when('/footer', {
        templateUrl: 'app/common/footer.html',
      })
      .when('/descrizione', {
        templateUrl: 'app/prodotti/descrizione.html',
        controller: 'DescrizioneCtrl'
      })
      .when('/carrello', {
        templateUrl: 'app/acquisto/carrello.html',
        controller: 'CarrelloCtrl'
      })
      .when('/sceltaPagamento', {
        templateUrl: 'app/acquisto/sceltapagamento.html',
        controller: 'SceltapagamentoCtrl'
      })
      .when('/registrazione', {
        templateUrl: 'app/registrazione/registrazione.html',
        controller: 'RegistrazioneCtrl'
      })
      .when('/registrazionePrivato', {
        templateUrl: 'app/registrazione/registrazioneprivato.html',
        controller: 'RegistrazioneprivatoCtrl'
      })
      .when('/registrazioneAzienda', {
        templateUrl: 'app/registrazione/registrazioneazienda.html',
        controller: 'RegistrazioneaziendaCtrl'
      })
      .when('/categoria', {
        templateUrl: 'app/prodotti/categoria.html',
        controller: 'CategoriaCtrl'
      })
      .when('/header', {
        templateUrl: 'app/common/header.html',
        controller: 'HeaderCtrl'
      })
      .when('/sottoCategoria', {
        templateUrl: 'app/prodotti/sottocategoria.html',
        controller: 'SottocategoriaCtrl'
      })
      .when('/inserisciCodiceConferma', {
        templateUrl: 'app/registrazione/inserisciCodiceConferma.html',
        controller: 'codiceConfermaCtrl'
      })
      .when('/login', {
        templateUrl: 'app/login/login.html',
      })
      .when('/logoutSuccess', {
        templateUrl: 'app/login/logoutSuccess.html',
      })
       .when('/inserisciProdotto', {
        templateUrl: 'app/admin/inserisciProdotto.html',
        controller: 'inserisciProdCtrl'
      })
      .when('/listaClienti', {
        templateUrl: 'app/admin/listaClienti.html',
        controller: 'listaClientiCtrl'
      })
        .when('/prodottiInMag', {
        templateUrl: 'app/admin/prodottiInMag.html',
        controller: 'prodottiInMagCtrl'
      })
      .when('/itemSubCategory', {
        templateUrl: 'app/prodotti/itemSubCategory.html',
        controller: 'itemSubCategoryCtrl'
      })
      .when('/descrizione1', {
        templateUrl: 'app/prodotti/descrizione1.html',
        controller: 'descrizione1Ctrl'
      })
      .when('/mainAdmin', {
        templateUrl: 'app/admin/mainAdmin.html',
        controller: 'mainAdminCtrl'
      })
      .when('/richiediPwd', {
        templateUrl: 'app/registrazione/richiediPwd.html',
        controller: 'richiediPwdCtrl'
      })
      .when('/myShopping', {
        templateUrl: 'app/clienti/myShopping.html',
        controller: 'myShopppingCtrl'
      })
      .when('/ordiniEffettuati', {
        templateUrl: 'app/admin/ordiniEffettuati.html',
        controller: 'ordiniEffettuatiCtrl'
      })
      
      .otherwise({
        templateUrl: 'assets/404.html',
      })
  
      
   $httpProvider.interceptors.push(['$q', '$location', '$localStorage', function($q, $location, $localStorage) {
          return {
              'request': function (config) {
                  config.headers = config.headers || {};
                  if ($localStorage.token) {
                      config.headers.Authorization = 'Bearer ' + $localStorage.token;
                  }
                  return config;
              },
              'responseError': function(response) {
                  if(response.status === 401 || response.status === 403) {
                      $location.path('/signin');
                  }
                  return $q.reject(response);
              }
          };
      }])      
}]); 

