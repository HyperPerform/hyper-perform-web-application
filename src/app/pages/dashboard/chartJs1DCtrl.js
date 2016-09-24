
(function () {
  'use strict';

  angular.module('HyperPerform.pages.dashboard').config(chartJsConfig)
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
  // @ngInject
  // function chartJs1DCtrl($scope) {
  //
  //   $scope.labels =["PA Score"];
  //   $scope.data = [4.23];
  //   $scope.options = {
  //     segmentShowStroke : false
  //   };
  //
  //   $scope.polarOptions = {
  //     scaleShowLabelBackdrop : false,
  //     segmentShowStroke : false
  //   };
  //
  // }
  angular.module('demo', ['angular-svg-round-progressbar']).controller('chartJs1DCtrl', chartJs1DCtrl);

  function chartJs1DCtrl($scope, $interval, $timeout, $window, roundProgressService, $http){


    $http({
      method: "POST",
      url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getScore",
      data: JSON.stringify({name: "Rohan", startDate: "2006-01-01 00:00:01", endDate: "2016-12-30 23:59:59"}),
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*"
      }
    })    .then(function(response) {

          $scope.current = response.data.score;

          // $scope.current = 3;
          if ($scope.current < 2.5)
            $scope.performance = "<h4 align='center' style='color: red;'>Non Performer</h4>";

          if ($scope.current >= 2.5 && $scope.current < 4.0)
            $scope.performance = "<h4 align='center' style='color: #0EA5A5;'>Average Performer</h4>";

          if ($scope.current >= 4.0)
            $scope.performance = "<h4 align='center' style='color: lawngreen;'>High Performer</h4>";

      // alert(response.data.score);
          $('#pascore').html($scope.performance);

        }, function(response){

          $scope.openToast('From: Dashboard','Failed to load PA Score','error');
        });




    // $scope.current =        1.5;
    $scope.max =            5;
    $scope.offset =         0;
    $scope.timerCurrent =   0;
    $scope.uploadCurrent =  0;
    $scope.stroke =         55;
    $scope.radius =         150;
    $scope.isSemi =         true;
    $scope.rounded =        false;
    $scope.responsive =     false;
    $scope.clockwise =      true;
    $scope.gradient =       true;
    $scope.currentColor =   '#0EA5A5';
    $scope.bgColor =        '#eaeaea';
    $scope.duration =       800;
    $scope.currentAnimation = 'easeOutCubic';
    $scope.animationDelay = 0;

    $scope.animations = [];

    angular.forEach(roundProgressService.animations, function(value, key){
      $scope.animations.push(key);
    });

    $scope.getStyle = function(){
      var transform = ($scope.isSemi ? '' : 'translateY(-50%) ') + 'translateX(-50%)';

      return {
        'top': $scope.isSemi ? 'auto' : '50%',
        'bottom': $scope.isSemi ? '-15%' : 'auto',
        'left': '50%',
        'background-color': 'white',
        'height': '20%',
        'transform': transform,
        '-moz-transform': transform,
        '-webkit-transform': transform,
        'font-size': '22pt'
      };
    };

    $scope.getColor = function(){
      return $scope.gradient ? 'url(#gradient)' : $scope.currentColor;
    };

    $scope.showPreciseCurrent = function(amount){
      $timeout(function(){
        if(amount <= 0){
          $scope.preciseCurrent = $scope.current;
        }else{
          var math = $window.Math;
          $scope.preciseCurrent = math.min(amount, $scope.max).toFixed(2);
        }
      });
    };

    var getPadded = function(val){
      return val < 10 ? ('0' + val) : val;
    };

    $interval(function(){
      var date = new Date();
      var hours = date.getHours();
      var minutes = date.getMinutes();
      var seconds = date.getSeconds();

      $scope.hours = hours;
      $scope.minutes = minutes;
      $scope.seconds = seconds;
      $scope.time = getPadded(hours) + ':' + getPadded(minutes) + ':' + getPadded(seconds);
    }, 1000);
  }

})();