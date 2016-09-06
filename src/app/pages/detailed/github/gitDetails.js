
(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed.github')
    .controller('gitGraph', gitGraph);

  function gitGraph($scope, $window) {
    
    // $scope.labels =["February", "March", "May", "June", "July", "August"];
    // $scope.data = [
    //   [65, 59, 90, 81, 56, 55, 40],
    //   [28, 48, 40, 19, 88, 27, 45]
    // ];
    // $scope.series = ['Commits', 'Pushes'];
    // $scope.color = ["#ff5252", "#ffffff"];

    // $window.alert($scope.$index);

    $scope.labels = $scope.graphs[$scope.$index].independent;
    $scope.data = [
      $scope.graphs[$scope.$index].dependent
    ];
    $scope.series = ['Commits'];
    $scope.color = ["#ff5252"];

  }



})();