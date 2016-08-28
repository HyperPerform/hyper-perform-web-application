
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.detailed.github')
    .controller('gitGraph', gitGraph);

  function gitGraph($scope) {
    $scope.labels =["February", "March", "May", "June", "July", "August"];
    $scope.data = [
      [65, 59, 90, 81, 56, 55, 40],
      [28, 48, 40, 19, 88, 27, 45]
    ];
    $scope.series = ['Commits', 'Pushes'];


  }



})();