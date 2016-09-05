(function () {
  'use strict';

  angular.module('BlurAdmin.pages.detailed.github').controller('githubCtrl', githubCtrl);

  function githubCtrl($scope, $http) {
      $scope.gitDataSize = 5;
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
          data: JSON.stringify({
              name: "Avinash",
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
              $scope.gitDataSize = 5;
              $scope.repos = git;
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
          }, function (response) {
              $('#loading').fadeOut(1000, function () {
                  $(this).remove();
              });
              $('#after').fadeIn(1000, function () {
                  $(this).html("<h1>An error occurred</h1>")
              });
              $scope.openToast('From: GitHub','Unable to connect to the server','error');
          });
      }

  })();