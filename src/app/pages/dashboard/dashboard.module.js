/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {


    var dashboard = angular.module('BlurAdmin.pages.dashboard', ['ui.bootstrap', 'highcharts-ng', 'angular-svg-round-progressbar'])
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

   function loadPa($scope, $http) {
       // alert("wowowowoowwo");
       $http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getSummary")
           .then(function(response) {
               $scope.summary = response.data;
            // alert(response.data);
           });



    }

})();
