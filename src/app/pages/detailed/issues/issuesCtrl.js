angular.module('HyperPerform.pages.detailed.issues').controller('issuesCtrl', issuesCtrl);

function issuesCtrl($scope, $http) 
{
	$('#after').hide();
	$scope.issuesDataSize = 3;
	$scope.searchCount = 1;
	$scope.in = 0;
  	// $http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails")
  	// .then(function(response){
  	// 	$scope.repos = response.data.gitIssueDetails.data;
  	// });

	$scope.openIssues = function(el)
	{
		var sum = 0;
		//
		var arr = $scope.repos[$scope.in];
		// alert(JSON.stringify(arr));
		for (var i = 0; i < arr.length; i++) {
			sum += (arr[i].action == "assigned") ? 1 : 0;
		}

		return sum;
	};

	$scope.closedIssues = function(el)
	{
		var sum = 0;
		// alert(JSON.stringify(el));
		var arr = $scope.repos[$scope.in];

		for (var i = 0; i < arr.length; i++) {
			sum += (arr[i].action == "closed") ? 1 : 0;
		}

		$scope.in++;
		return sum;
	};


	$('#after').hide();
	$('#loadbtn').hide();
	$scope.loadIssues = function() {
	$("#cal").hide();
		if (document.cookie != "" ) {
			if (getCookie('hpkey') == "" || getCookie('hpkey') == null)
			{
				window.location.href = "/auth.html";
			}

		}
		else window.location.href = "/auth.html";



		$('#loadbtn').hide();
		$('#after').hide();
		$('#loading').show();
		$('#tabs').html("");

		var t1 = $('#time1').html();
		var t2 = $('#time2').html();
		var d1 = $('#date1').html().trim();
		var d2 = $('#date2').html().trim();
		var n = getCookie('hpkey').split("#")[0];
		$http({
			url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails",
			method: "POST",
			data: JSON.stringify({name: n, startDate: d1 + t1, endDate: d2 + t2, type: "issues"}),
			headers: {
				"Content-Type": "application/json",
				"Access-Control-Allow-Origin": "*"
			}
		})
			.then(function (response) {
				// travisData = response.data.travisDetails;
				$scope.repos = response.data.gitIssueDetails.data;

				for ( i = 0 ;i < $scope.repos.length; i++)
				{
					var op = 0;
					var cl = 0;
					for (var k = 0; k < $scope.repos[i].length; k++) {
						if ($scope.repos[i][k].action == "assigned")
							op += 1;
						if ($scope.repos[i][k].action == "closed")
							cl += 1;
					}
					for (var k = 0; k < $scope.repos[i].length; k++) {
						$scope.repos[i][k].totalOpen = op;
						$scope.repos[i][k].totalClosed = cl;
					}
				}

				$('#loading').fadeOut(1000, function () {
					$(this).hide();
				});
				$('#after').delay(500).fadeIn(1000, function () {
					$('#loadbtn').show();
				});
				if ($scope.repos[0] == null) {
					$('#after').html("<h1>No results found</h1>");
					$scope.openToast('', 'No issues found', 'warning');
				}
				for (var i = 0; i < $scope.repos.length; i++) {

					$scope.tmp = $scope.repos[i][0].repository;
					var el = '"' + $scope.repos[i][0].repository + '"';
					$('#tabs').html($('#tabs').html() + "<a class='btn tabs' onclick='tabScroll(" + el + ");' >" + $scope.repos[i][0].repository + "</a> &nbsp;");
				}
			}, function (response) {
				$('#loading').fadeOut(1000, function () {
					$(this).hide();
				});
				$('#after').fadeIn(1000, function () {
					$(this).html("<h1>An error occurred</h1>")
				});
				$scope.openToast('From: Issues', 'Unable to connect to the server', 'error');
			});

		$('#myModal').modal('hide');
		setTimeout(function(){
			$("#cal").show();
		},2000);

	};
	$scope.showSearch = function (el)
	{
		$scope.searchCount++;
		// alert(el);
		if ( ($scope.searchCount % 2) == 0)
			$('#'+el+'Search').show();
		else $('#'+el+'Search').hide();
	};

	setTimeout(
		function()
		{
			$scope.loadIssues();

		}, 1000);
}