angular.module('BlurAdmin.pages.detailed.issues').controller('issuesCtrl', issuesCtrl);

function issuesCtrl($scope, $http) 
{
  	// $http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails")
  	// .then(function(response){
  	// 	$scope.repos = response.data.gitIssueDetails.data;
  	// });

  	$http({
		url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails", 
		method: "POST",
		data: JSON.stringify({name: "Rohan", startDate: "2016-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "issues"}),
		headers: {
			"Content-Type": "application/json"
		}
	})
	.then(function(response){
  		// travisData = response.data.travisDetails;
  		$scope.repos = response.data.gitIssueDetails.data;
  	});
}