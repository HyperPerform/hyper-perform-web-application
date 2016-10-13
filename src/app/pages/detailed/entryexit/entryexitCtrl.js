(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed.entryexit').controller('entryexitCtrl', entryexitCtrl);

  function entryexitCtrl($scope, $http, $window)
  {
    var events =[];
    $scope.entryDataSize = 3;
    $scope.searchCount = 1;
    $scope.changeCount = 0;
    $scope.IconCount = 1;
      $scope.aevent = [];

      $('#after').hide();
      $('#loadbtn').hide();
      $scope.loadEntry = function() {
          $("#cal").hide();
          if (document.cookie != "" ) {
              if (getCookie('hpkey') == "" || getCookie('hpkey') == null)
              {
                  window.location.href = "/auth.html";
              }

          }
          else window.location.href = "/auth.html";


          $('#after').hide();
          $('#loading').show();
          $('#loadbtn').hide();
          var t1 = $('#time1').html();
          var t2 = $('#time2').html();
          var d1 = $('#date1').html().trim();
          var d2 = $('#date2').html().trim();
          var n = getCookie('hpkey').split("#")[0];
          $http({
              url: "https://hyperperform.me:8443/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails",
              method: "POST",
              data: JSON.stringify(
                  {
                      name: n,
                      startDate: d1 + t1,
                      endDate: d2 + t2,
                      type: "entry"
                  }),
              headers: {
                  "Content-Type": "application/json",
                  "Access-Control-Allow-Origin": "*",
                  'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
                  'Access-Control-Allow-Headers': 'Content-Type, Authorization, Content-Length, X-Requested-With'

              }
          })
              .then(function (response) {

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
                  // for ( i = 0 ;i < $scope.aevent.length; i++)
                  // {
                      var ho = 0;

                      for (var k = 0; k < $scope.data[0].length; k++) {
                         ho += $scope.data[0][k];
                        // alert(JSON.stringify($scope.data[0]));
                      }
                      for (var k = 0; k < $scope.aevent.length; k++) {
                          $scope.aevent[k].totalHours = ho;

                  }
                  // alert(JSON.stringify($scope.aevent));
                  $('#loading').fadeOut(1000, function () {
                      $(this).hide();
                  });
                  $('#after').delay(500).fadeIn(1000, function () {
                      $('#loadbtn').show();
                  });
                  if ($scope.aevent[0] == null) {
                      $('#after').html("<h1>No results found</h1>");
                      $scope.openToast('', 'No logs found', 'warning');
                  }


              }, function (response) {
                  $('#loading').fadeOut(1000, function () {
                      $(this).hide();
                  });
                  $('#after').fadeIn(1000, function () {
                      $(this).html("<h1>An error occurred</h1>")
                  });
                  $scope.openToast('From: Entry/Exit', 'Unable to connect to the server', 'error');
              });
          $('#myModal').modal('hide');

          setTimeout(function(){
              $("#cal").show();
          },2000);

      };

    $scope.totalHours = function()
    {
        var sum = 0;
        // alert(JSON.stringify($scope.data));
        if ($scope.data[0] != null) {
            for (var k = 0; k < $scope.data.length; k++) {
                for (var i = 0; i < $scope.data[k].length; i++) {
                    sum += $scope.data[k][i];
                }
            }
            return sum;
        }
        return null;
    };


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

      setTimeout(
          function()
          {
              $scope.loadEntry();

          }, 1000);

  }


})();