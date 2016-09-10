(function () {


    var dashboard = angular.module('HyperPerform.pages.dashboard', ['ui.bootstrap', 'highcharts-ng', 'angular-svg-round-progressbar'])
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
    function login($http){




    }

   function loadPa($scope, $http) {
       //
       $scope.p  = "";
       $http.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getSummary")
           .then(function(response) {
               $('.fa-spinner, .fa-spin').fadeOut(500, function(){ $(this).remove();});
               $scope.summary = response.data;
               $scope.p  = "%";
           }, function(response){
               $('.fa-spinner, .fa-spin').toggleClass().html("<i class='fa fa-exclamation-triangle' style='color: #F0AD4E'></i>");
               $scope.openToast('From: Summary','Unable to connect to the server','error');
           });

       // $http({
       //     url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/login/verifyDetails",
       //     method: "POST",
       //     data: JSON.stringify({userEmail: "admin@hyperperform.me", userPassword: "hashedPass"}),
       //     headers: {
       //         "Content-Type": "application/json",
       //         "Access-Control-Allow-Origin": "*",
       //         'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
       //         'Access-Control-Allow-Headers': 'Content-Type, Authorization, Content-Length, X-Requested-With'
       //
       //     }
       // })
       //     .then(function (response) {
       //         // alert(JSON.stringify(response.data));
       //         alert(response.data.loggedin);
       //         // window.location.href='/user';
       //     });


    }

})();
