
(function () {
    'use strict';

    angular.module('BlurAdmin.pages.detailed.travis').config(chartJsConfig)
        .controller('travisGraph', travisGraph);

    function chartJsConfig(ChartJsProvider, baConfigProvider) {
        // var layoutColors = baConfigProvider.colors;
        // Configure all charts
        ChartJsProvider.setOptions({
            colours: [ "#ff5252"],//, layoutColors.primary, layoutColors.danger, layoutColors.warning, layoutColors.success, layoutColors.info, layoutColors.default, layoutColors.primaryDark, layoutColors.successDark, layoutColors.warningLight, layoutColors.successLight, layoutColors.primaryLight],
            responsive: true,
           // scaleFontColor: layoutColors.defaultText,
            //scaleLineColor: layoutColors.border,
            //pointLabelFontColor: layoutColors.defaultText
        });
        // Configure all line charts
        ChartJsProvider.setOptions('Pie', {
            datasetFill: true
        });
    }

    function travisGraph($scope) {
        $scope.colors = ["#8bc34a","#ff5252" ];

        $scope.labels = ["Success", "Failed"];
        $scope.data = [0,0];
        for (var k = 0; k < $scope.repo.length; k++)
        {
           if ($scope.repo[k].status == 'Passed')
              $scope.data[0]++;
           else
              $scope.data[1]++;
        }

        $scope.options = {
            segmentShowStroke: false
        };

        $scope.polarOptions = {
            scaleShowLabelBackdrop: false,
            segmentShowStroke: false,

        };



    }

})();
