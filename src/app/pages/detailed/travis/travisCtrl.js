  angular.module('BlurAdmin.pages.detailed.travis').controller('travisCtrl', travisCtrl);

  function travisCtrl($scope, $http, $window) 
  {
  	var travisData;

 //  	var config = {
	// 	// params: {name: "Rohan", startDate: "2016-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "travis"},
	// 	// headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
	// };

 //  	$http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails", config)
 //  	.then(function(response){
 //  		travisData = response.data.travisDetails;
 //  		$scope.repos = travisData.data;
 //  	});
  	
  	$http({
		url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails", 
		method: "POST",
		data: JSON.stringify({name: "Rohan", startDate: "2016-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "travis"}),
		headers: {
			"Content-Type": "application/json"
		}
	})
	.then(function(response){
  		travisData = response.data.travisDetails;
  		$scope.repos = travisData.data;
  	});
  }