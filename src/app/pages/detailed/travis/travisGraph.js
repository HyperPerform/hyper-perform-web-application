
(function () {
    'use strict';

    angular.module('BlurAdmin.pages.detailed.travis')
        .controller('travisGraph', travisGraph);

    function travisGraph($scope) {

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
            segmentShowStroke: false
        };

    }

})();
