(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed.entryexit').controller('entryexitCtrl', entryexitCtrl);

  function entryexitCtrl($scope, $http)
  {

    $scope.EntryDataSize = 3;
    $scope.searchCount = 1;


    $('#after').hide();
      var n = document.cookie.split("=")[0];
    $http({
      url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails",
      method: "POST",
      data: JSON.stringify({name: n, startDate: "2006-01-01 00:00:01", endDate: "2016-12-30 23:59:59", type: "entry"}),
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
        'Access-Control-Allow-Headers': 'Content-Type, Authorization, Content-Length, X-Requested-With'

      }
    })
        .then(function(response){

        // alert(JSON.stringify(response.data));

          $scope.aevent = response.data.accessDetails.data;
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

    // openToast();
  }


})();