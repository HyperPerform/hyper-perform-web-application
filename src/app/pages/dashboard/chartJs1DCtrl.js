
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

  function chartJs1DCtrl($scope, $interval, $timeout, $window, roundProgressService){

    $scope.current =        3.76;
    $scope.max =            5;
    $scope.offset =         0;
    $scope.timerCurrent =   0;
    $scope.uploadCurrent =  0;
    $scope.stroke =         45;
    $scope.radius =         130;
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
        'font-size': '25pt'
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