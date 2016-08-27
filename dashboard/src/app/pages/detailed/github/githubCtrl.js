(function () {
  'use strict';

  angular.module('BlurAdmin.pages.detailed.github').controller('githubCtrl', githubCtrl);

  function githubCtrl($scope, $http)
  {
    $scope.gitDataSize = 10;
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
            "username": "Wad",
            "repository": "COS332",
            "date": "2016-02-19",
            "commitSize": 2
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