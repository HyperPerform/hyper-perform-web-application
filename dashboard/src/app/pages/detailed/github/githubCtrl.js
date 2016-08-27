(function () {
  'use strict';

  angular.module('BlurAdmin.pages.detailed.github').controller('githubCtrl', githubCtrl);

  function githubCtrl($scope, $http)
  {
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
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
        ,{
            "id": 4,
            "username": "Avinash",
            "repository": "COS332",
            "date": "2016-02-19",
            "commitSize": 500
        }
    ];

    $http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getDetails")
        .then(function(response){
            $scope.gitData = response.data.gitDetails.data[0];
              // alert(response.data.gitDetails.data[0][0].repository);


        });
        git.push($scope.gitData);

      $scope.gitData = git;
      //   alert($scope.gitData );
      //

      // alert($scope.gitData );alert(github );
  }

})();