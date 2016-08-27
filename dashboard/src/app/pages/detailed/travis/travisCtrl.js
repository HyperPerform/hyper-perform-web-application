  angular.module('BlurAdmin.pages.detailed.travis').controller('travisCtrl', travisCtrl);

  function travisCtrl($scope, $http) 
  {
  	var travisData;

  	$http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails")
  	.then(function(response){
  		travisData = response.data.travisDetails;
  		$scope.repos = travisData.data;
  	});
  }