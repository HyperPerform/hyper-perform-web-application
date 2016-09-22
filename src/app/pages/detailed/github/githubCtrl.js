(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed.github').controller('githubCtrl', githubCtrl);

  function githubCtrl($scope, $http, $window) {
      $scope.gitDataSize = 5;
      $scope.searchCount = 1;
      $scope.changeCount = 1;
      $scope.IconCount = 1;

      var git = [
          {
              "id": 1,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 50
          },
          {
              "id": 2,
              "username": "Rohan",
              "repository": "COS332",
              "date": "2016-03-10",
              "commitSize": 2
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS284",
              "date": "2016-03-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-05-10",
              "commitSize": 13
          },
          {
              "id": 5,
              "username": "Rohan",
              "repository": "COS332",
              "date": "2016-06-12",
              "commitSize": 20
          }
          , {
              "id": 6,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 7,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          },
          {
              "id": 3,
              "username": "Brad",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 20
          }
          , {
              "id": 4,
              "username": "Avinash",
              "repository": "COS332",
              "date": "2016-02-19",
              "commitSize": 500
          }
      ];

      $http({
          url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails",
          method: "POST",
          // method: "GET",
          data: JSON.stringify({
              name: "Rohan",
              startDate: "2016-01-01 00:00:01",
              endDate: "2016-12-30 23:59:59",
              type: "git"
          }),
          headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin": "*"
          }
      })
          .then(function (response) {

              git = response.data.gitDetails.data;
              $scope.gitDataSize = 3;
              $scope.repos = git;

              $scope.gitData = response.data.gitDetails.data[0];
              $scope.graphs = response.data.gitDetails.graphData;

              $('#loading').fadeOut(1000, function () {
                  $(this).remove();
              });
              $('#after').delay(500).fadeIn(3000, function () {
              });
              if ($scope.repos[0] == null)
              {
                  $('#after').html("<h1>No results found</h1>");
                  $scope.openToast('From: GitHub','No results found','warning');
              }

              for (var i = 0; i < $scope.repos.length; i++)
              {

                  $scope.tmp =  $scope.repos[i][0].repository;
                  var el = '"' +$scope.repos[i][0].repository + '"';
                  $('#tabs').html($('#tabs').html() + "<a class='btn tabs' onclick='scroll("+el+");' href='#"+$scope.tmp+"' >"+$scope.repos[i][0].repository+"</a> &nbsp;");
              }

          }, function (response) {
              $('#loading').fadeOut(1000, function () {
                  $(this).remove();
              });
              $('#after').fadeIn(1000, function () {
                  $(this).html("<h1>An error occurred</h1>")
              });
              $scope.openToast('From: GitHub','Unable to connect to the server','error');
          });


          $scope.showSearch = function (el)
          {
              $scope.searchCount++;
              // alert(el);
              if ( ($scope.searchCount % 2) == 0)
                  $('#'+el+'Search').show();
              else $('#'+el+'Search').hide();
          };

          $scope.changeIcon = function (el)
          {
              $scope.IconCount++;
              // alert(el);
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
  }


    function scroll(el)
    {
        // alert(el);

        $('html, body').animate({scrollTop: $("#"+el).offset().top - 135}, 2000);
    }

  })();