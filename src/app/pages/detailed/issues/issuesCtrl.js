angular.module('HyperPerform.pages.detailed.issues').controller('issuesCtrl', issuesCtrl);

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
		data: JSON.stringify({name: "Rohan", startDate: "2016-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "issues"}),
		headers: {
			"Content-Type": "application/json",
			"Access-Control-Allow-Origin": "*"
		}
	})
	.then(function(response){
  		// travisData = response.data.travisDetails;
  		$scope.repos = response.data.gitIssueDetails.data;

		$('#loading').fadeOut(1000, function(){ $(this).remove();});
		$('#after').delay(500).fadeIn(3000, function(){ });
		if ($scope.repos[0] == null)
		{
			$('#after').html("<h1>No results found</h1>");
			$scope.openToast('','No issues found','warning');
		}
		for (var i = 0; i < $scope.repos.length; i++)
		{

			$scope.tmp =  $scope.repos[i][0].repository;
			var el = '"' +$scope.repos[i][0].repository + '"';
			$('#tabs').html($('#tabs').html() + "<a class='btn tabs' onclick='scroll("+el+");' href='#"+$scope.tmp+"' >"+$scope.repos[i][0].repository+"</a> &nbsp;");
		}
	}, function(response){
		$('#loading').fadeOut(1000, function(){ $(this).remove();});
		$('#after').fadeIn(1000, function(){$(this).html("<h1>An error occurred</h1>") });
		$scope.openToast('From: Issues','Unable to connect to the server','error');
	});
}