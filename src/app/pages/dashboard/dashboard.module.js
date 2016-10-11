(function () {


    var dashboard = angular.module('HyperPerform.pages.dashboard', ['ui.bootstrap', 'highcharts-ng', 'angular-svg-round-progressbar'])
      .config(routeConfig).controller('pacrtl', loadPa).controller('modal', ModalsPageCtrl);

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


   function loadPa($scope, $http, $rootScope) {
       $(document).on('manUpdate', function(){
           if (getCookie("hpkey") == "")
               window.location.reload();
       });

       $(document).trigger('manUpdate');

       function getCookie(cname) {
           var name = cname + "=";
           var ca = document.cookie.split(';');
           for(var i = 0; i <ca.length; i++) {
               var c = ca[i];
               while (c.charAt(0)==' ') {
                   c = c.substring(1);
               }
               if (c.indexOf(name) == 0) {
                   return c.substring(name.length,c.length);
               }
           }
           return "";
       }

       $scope.loadDashboard = function() {

           if (document.cookie != "" ) {
               if (getCookie('hpkey') == "" || getCookie('hpkey') == null)
               {
                   window.location.href = "/auth.html";
               }

           }
           else window.location.href = "/auth.html";



           var t1 = $('#time1').html();
           var t2 = $('#time2').html();
           var d1 = $('#date1').html().trim();
           var d2 = $('#date2').html().trim();
           var n = getCookie('hpkey').split("#")[0];
            // alert(JSON.stringify({name: n, startDate: d1 + t1, endDate: d2 + t2}));
           $scope.p = "";
           $scope.h = " H";
           $http({
               method: "POST",
               url: "https://hyperperform.me:8443/hyperperform-system-1.0-SNAPSHOT/rs/report/getSummary",
               data: JSON.stringify({name: n, startDate: d1 + t1, endDate: d2 + t2}),
               headers: {
                   "Content-Type": "application/json",
                   "Access-Control-Allow-Origin": "*"
               }
           })
               .then(function (response) {
                   $('.fa-spinner, .fa-spin').fadeOut(500, function () {
                       $(this).remove();
                   });
                   $scope.summary = response.data;

                   // $scope.summary.github = parseFloat($scope.summary.github).toFixed(2);
                   $scope.summary.travis = parseFloat($scope.summary.travis).toFixed(2);
                   $scope.summary.issues = parseFloat($scope.summary.issues).toFixed(2);
                   // $scope.summary.entryExit = parseFloat($scope.summary.entryExit).toFixed(2);

                   // alert(JSON.stringify($scope.summary));
                   $scope.p = "%";
               }, function (response) {
                   $('.fa-spinner, .fa-spin').toggleClass().html("<i class='fa fa-exclamation-triangle' style='color: #F0AD4E'></i>");
                   $scope.openToast('From: Summary', 'Unable to connect to the server', 'error');
               });

           $('#myModal').modal('hide');
           $rootScope.$emit("pa", {});

       };

       setTimeout(
           function()
           {

               $scope.loadDashboard();
           }, 1000);

    }

    function ModalsPageCtrl($scope, $uibModal) {
        $scope.open = function (page, size) {
            $uibModal.open({
                animation: true,
                templateUrl: page,
                size: size,
                resolve: {
                    items: function () {
                        return $scope.items;
                    }
                }
            });
        };
    }

})();
