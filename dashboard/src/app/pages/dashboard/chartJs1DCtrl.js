/**
 * @author a.demeshko
 * created on 12/16/15
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.dashboard').config(chartJsConfig)
    .controller('chartJs1DCtrl', chartJs1DCtrl);

  function chartJsConfig(ChartJsProvider, baConfigProvider) {
    var layoutColors = baConfigProvider.colors;
    // Configure all charts
    ChartJsProvider.setOptions({
      colours: [ layoutColors.primary, layoutColors.danger, layoutColors.warning, layoutColors.success, layoutColors.info, layoutColors.default, layoutColors.primaryDark, layoutColors.successDark, layoutColors.warningLight, layoutColors.successLight, layoutColors.primaryLight],
      responsive: true,
      scaleFontColor: layoutColors.defaultText,
      scaleLineColor: layoutColors.border,
      pointLabelFontColor: layoutColors.defaultText
    });
    // Configure all line charts
    ChartJsProvider.setOptions('Line', {
      datasetFill: false
    });
  }
  /** @ngInject */
  function chartJs1DCtrl($scope) {

    $scope.labels =["PA Score"];
    $scope.data = [2.1];
    $scope.options = {
      segmentShowStroke : false
    };

    $scope.polarOptions = {
      scaleShowLabelBackdrop : false,
      segmentShowStroke : false
    };

  }

})();