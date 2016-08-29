angular.module('BlurAdmin.pages.detailed.issues').controller('issuesCtrl', issuesCtrl);

function issuesCtrl($scope, $http) 
{
  	$http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails")
  	.then(function(response){
  		$scope.repos = response.data.gitIssueDetails.data;
  	});
}