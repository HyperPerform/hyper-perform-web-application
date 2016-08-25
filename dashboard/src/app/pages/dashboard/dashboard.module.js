/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {


 var dashboard = angular.module('BlurAdmin.pages.dashboard', ['ui.bootstrap', 'highcharts-ng'])
      .config(routeConfig).controller('pacrtl', loadPa);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('dashboard', {
          url: '/dashboard',
          templateUrl: 'app/pages/dashboard/dashboard.html',
          title: 'Dashboard',
          sidebarMeta: {
            icon: 'ion-android-home',
            order: 0
          }
        });
  }

   function loadPa($scope) {

       $scope.chart = {
           options: {
               chart: {
                   type: 'bar'
               }
           },
           series: [{
               data: [10, 15, 12, 8, 7]
           }],
           title: {
               text: 'Hello'
           }
       };
        // $scope.addPoints = function () {
        //
        //     var seriesArray = $scope.chart.series;
        //     var rndIdx = Math.floor(Math.random() * seriesArray.length);
        //     seriesArray[rndIdx].data = seriesArray[rndIdx].data.concat([1, 10, 20])
        // };
        //
        // $scope.addSeries = function () {
        //     var rnd = [];
        //
        //     for (var i = 0; i < 10; i++) {
        //         rnd.push(Math.floor(Math.random() * 20) + 1)
        //     }
        //     $scope.chart.series.push({
        //         data: rnd
        //     })
        // };
        //
        // $scope.removeRandomSeries = function () {
        //     var seriesArray = $scope.chart.series;
        //     var rndIdx = Math.floor(Math.random() * seriesArray.length);
        //     seriesArray.splice(rndIdx, 1)
        // };
        //
        // $scope.options = {
        //     type: 'line'
        // };
        //
        // $scope.swapChartType = function () {
        //     if (this.chart.options.chart.type === 'line') {
        //         this.chart.options.chart.type = 'bar'
        //     } else {
        //         this.chart.options.chart.type = 'line'
        //     }
        // };
        //


    }

})();
