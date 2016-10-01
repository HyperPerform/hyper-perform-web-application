  angular.module('HyperPerform.pages.detailed.travis').controller('travisCtrl', travisCtrl);

  /** @ngInject */


	var count = 1;
  	// var totalRepo = 0;
  function travisCtrl($scope, $http, $window) 
  {

  	// $('#loadbtn').html("");

  	var travisData;
	  $scope.totalRepo = 0;
	  $scope.travisDataSize = 3;
	  $scope.searchCount = 1;

	  $('#after').hide();
	  $('#loadbtn').hide();
	$scope.loadTravis = function() {

		$('#after').hide();
		$('#loadbtn').hide();
		$('#loading').show();
		$('#tabs').html("");

		var t1 = $('#time1').html();
		var t2 = $('#time2').html();
		var d1 = $('#date1').html().trim();
		var d2 = $('#date2').html().trim();
		// alert(
		// 	JSON.stringify({
		// 		name: n,
		// 		startDate: d1 + t1,
		// 		endDate: d2  + t2,
		// 		type: "travis"
		// 	})
		// );
		var n = document.cookie.split("=")[1].split("#")[0];
		$http({
			url: "https://hyperperform.me:8443/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails",
			method: "POST",
			data: JSON.stringify({
				name: n,
				startDate: d1 + t1,
				endDate: d2 + t2,
				type: "travis"
			}),
			headers: {
				"Content-Type": "application/json",
				"Access-Control-Allow-Origin": "*",
				'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
				'Access-Control-Allow-Headers': 'Content-Type, Authorization, Content-Length, X-Requested-With'

			}
		})
			.then(function (response) {

				travisData = response.data.travisDetails;
				// alert(JSON.stringify(travisData.data[0]));
				$scope.repos = travisData.data;
				$('#loading').fadeOut(1000, function () {
					$(this).hide();
				});
				$('#after').delay(500).fadeIn(1000, function () {
					$('#loadbtn').show();
				});
				if ($scope.repos[0] == null) {
					$('#after').html("<h1>No results found</h1>");
					$scope.openToast('', 'No builds found', 'warning');
				}

				for (var i = 0; i < $scope.repos.length; i++) {

					$scope.tmp = $scope.repos[i][0].repo;
					var el = '"' + $scope.repos[i][0].repo + '"';
					$('#tabs').html($('#tabs').html() + "<a class='btn tabs' onclick='scroll(" + el + ");' >" + $scope.repos[i][0].repo + "</a> &nbsp;");
				}
			}, function (response) {
				$('#loading').fadeOut(1000, function () {
					$(this).hide();
				});
				$('#after').fadeIn(1000, function () {
					$(this).html("<h1>An error occurred</h1>")
				});
				$scope.openToast('From: Travis', 'Unable to connect to the server', 'error');
			});

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
		  	$scope.loadTravis();

		  }, 1000);

  }

  function scroll(el)
  {
  	// alert(el);
	  $('html, body').animate({scrollTop: $("#"+el).offset().top - 135}, 2000);
  }


