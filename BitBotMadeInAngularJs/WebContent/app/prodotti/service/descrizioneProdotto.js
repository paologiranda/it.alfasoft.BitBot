'use strict';

angular.module('bitBotApp')
.factory('addToShop',['$http','API_CONF','$resource','$window',
                      function($http,apiConf,$resource,$window){
	return{
		buy: function(data,success){
			var url = apiConf.server + apiConf.base_url + '/ordini/inserisciCarrello?codProd=' + data.codProd + '&qta=' + data.qta;
			var response = $resource(url,{},{
				query:{
					isArray: true,
					method: 'GET',
					transfomrResponse: function (data){
						return angular.fromJson(data).body;
					}
				}
			})
			response.query();
			$window.location.reload();
		}
	}
}])