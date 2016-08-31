angular.module('BlurAdmin.pages.detailed.issues').controller('issuesCtrl', issuesCtrl);

function issuesCtrl($scope, $http) 
{
	$('#after').hide();
  	// $http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails")
  	// .then(function(response){
  	// 	$scope.repos = response.data.gitIssueDetails.data;
  	// });

  	$http({
		url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails", 
		method: "POST",
		data: JSON.stringify({name: "Rohans", startDate: "2016-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "issues"}),
		headers: {
			"Content-Type": "application/json"
		}
	})
	.then(function(response){
  		// travisData = response.data.travisDetails;
  		$scope.repos = response.data.gitIssueDetails.data;

		$('#loading').fadeOut(1000, function(){ $(this).remove();});
		$('#after').delay(500).fadeIn(3000, function(){ });
		if ($scope.repos[0] == null) $('#after').html("<h1>No results found</h1>");

	});
}