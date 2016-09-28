(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed.entryexit').controller('entryexitCtrl', entryexitCtrl);

  function entryexitCtrl($scope, $http, $window)
  {
    var events =[];
    $scope.entryDataSize = 3;
    $scope.searchCount = 1;
    $scope.changeCount = 1;
    $scope.IconCount = 1;
      $scope.aevent = [];

    $('#after').hide();
      var n = document.cookie.split("=")[1].split("#")[0];
    $http({
      url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails",
      method: "POST",
      data: JSON.stringify({name: n, startDate: "2016-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "entry"}),
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
        'Access-Control-Allow-Headers': 'Content-Type, Authorization, Content-Length, X-Requested-With'

      }
    })
        .then(function(response){

        // alert(JSON.stringify(response.data));
            events = response.data.accessDetails.data;
          $scope.aevent = events;
          $scope.srcevent = events;
          $scope.labels = response.data.accessDetails.graphData.independent;
          $scope.data = [
            response.data.accessDetails.graphData.dependent
          ];
            // $scope.entryDataSize = 3;
          // alert($scope.data);

          // alert(JSON.stringify($scope.aevent));
          $('#loading').fadeOut(1000  , function(){ $(this).remove();});
          $('#after').delay(500).fadeIn(3000, function(){ });
          if ($scope.aevent[0] == null  )
          {
            $('#after').html("<h1>No results found</h1>");
            $scope.openToast('','No logs found','warning');
          }


        }, function(response){
          $('#loading').fadeOut(1000, function(){ $(this).remove();});
          $('#after').fadeIn(1000, function(){$(this).html("<h1>An error occurred</h1>") });
          $scope.openToast('From: Entry/Exit','Unable to connect to the server','error');
        });

    $scope.showSearch = function ( )
    {
      $scope.searchCount++;
      // alert(el);
      if ( ($scope.searchCount % 2) == 0)
        $('#Search').show();
      else $('#Search').hide();
    };

    $scope.changeIcon = function (el)
    {
        $scope.IconCount++;
        // alert(el);
        // alert($("#" + el + "icon").html());
        if ( ($scope.IconCount % 2) == 0) {
            $('#' + el + 'icon').html("<i class='fa fa-caret-down'></i>");
            $('#' + el ).hide();


        }
        else
        {
            $('#'+el+'icon').html("<i class='fa fa-caret-up'></i>");
            $('#' + el ).show();

        }
    };

    $scope.changeView = function (el)
    {
        $scope.changeCount++;

        if ( ($scope.changeCount % 2) == 0) {
            $('#' + el + 'switch').html("<i class='fa fa-table white' aria-hidden='true'></i>");
            $('#'+el+'table').hide();
            $('#'+el+'graph').show();
            // alert("Hide table");
        }
        else
        {
            $('#'+el+'switch').html("<i class='fa fa-line-chart white' aria-hidden='true'></i>");
            $('#'+el+'graph').hide();
            $('#'+el+'table').show();
            // alert("Hide graph");
        }
    };

    // openToast();
  }


})();