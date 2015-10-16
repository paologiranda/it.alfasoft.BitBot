'use strict';

angular.module('app')
.factory('addToShop',['$http','API_CONF','$resource','$window','$location',
                      function($http,apiConf,$resource,$window,$location){
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
			$location.path('/carrello');
			$window.location.reload();
		},
	}
}])
.factory('showCategory',['$http','API_CONF','$resource','$window',
              function($http,apiConf,$resource,$window){
                        
		    var url = apiConf.server + apiConf.base_url + '/prodotti/categoria';
			var response = $resource(url,{},{
				get:{
					isArray: true,
					method: 'GET',
				}
			})
			response.query();
			return response;
}])
.factory('showSubCategory',['$http','API_CONF','$resource',
              function($http,apiConf,$resource){
          
	     return{  
        	   send: function(data){
        		   var url = apiConf.server + apiConf.base_url + '/prodotti/sottocategory?categoria=' + data.categoria;
//        		   console.log(url);
        		   var response = $resource(url,{},{
					    query:{method: 'GET',}    		   
				  })
				  return response;
        		 },       	  
           }     
}]);