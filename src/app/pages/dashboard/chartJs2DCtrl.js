/**
 * @author a.demeshko
 * created on 12/16/15
 */
(function () {
  'use strict';

  angular.module('HyperPerform.pages.dashboard')
    .controller('chartJs2DCtrl', chartJs2DCtrl);

  /** @ngInject */
  function chartJs2DCtrl($scope) {
    $scope.labels =["January", "February", "March", "April", "May", "June", "July"];
    $scope.data = [
      [65, 59, 90, 81, 56, 55, 40],
      [28, 48, 40, 19, 88, 27, 45],
      [25, 41, 22, 60, 50, 31, 55],
      [30, 20, 33, 40, 62, 53, 42]
    ];
    $scope.series = ["Github", "Travis", "Issues", "Entry/Exit" ];
    $scope.color = ["#40AFEF","#8bc34a","#FF7043","#7D9EAF"];


  }






})();