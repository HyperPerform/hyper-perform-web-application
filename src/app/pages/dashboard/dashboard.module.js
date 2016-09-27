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
    function login($scope, $cookieStore){

        // alert($cookieStore.get('email'));



    }

   function loadPa($scope, $http) {

       if (document.cookie == "" || document.cookie == null)
           window.location.href = '/';

       var name = document.cookie.split("=");
        name = name[1];
        name = name.split("#")[0];
        // alert(name);
        if (name == "" || name == null)
            window.location.href = '/';
       //
       // alert(document.cookie);
       var n = document.cookie.split("=")[1].split("#")[0];
       // alert(n);
       $scope.p  = "";
       $http({
          method: "POST",
          url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getSummary",
          data: JSON.stringify({name: n, startDate: "2006-01-01 00:00:01", endDate: "2016-12-30 23:59:59"}),
           headers: {
               "Content-Type": "application/json",
               "Access-Control-Allow-Origin": "*"
           }
       })
           .then(function(response) {
               $('.fa-spinner, .fa-spin').fadeOut(500, function(){ $(this).remove();});
               $scope.summary = response.data;
               // alert(JSON.stringify($scope.summary));
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
