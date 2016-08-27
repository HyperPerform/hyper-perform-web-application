
(function () {
    'use strict';

    angular.module('BlurAdmin.pages.detailed.travis')
        .controller('travisGraph', travisGraph);

    function travisGraph($scope) {

        $scope.labels = ["Success", "Failed"];
        $scope.data = [10,2];
        $scope.options = {
            segmentShowStroke: false
        };

        $scope.polarOptions = {
            scaleShowLabelBackdrop: false,
            segmentShowStroke: false
        };
    }

})();
