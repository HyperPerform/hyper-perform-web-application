
(function () {
  'use strict';

  angular.module('BlurAdmin.pages', [
    'ui.router',
    'ngRoute',
    'BlurAdmin.pages.dashboard',
    'BlurAdmin.pages.notifications',
    // 'BlurAdmin.pages.form',
    // 'BlurAdmin.pages.tables',
    // 'BlurAdmin.pages.charts',
    // 'BlurAdmin.pages.profile',
    'BlurAdmin.pages.detailed'
  ]).config(routeConfig);

  /** @ngInject */
  function routeConfig(/*$urlRouterProvider, $routeProvider, $locationProvider*/) {

      if(window.location.pathname == "/user")
          window.location.assign("#/dashboard");
      else if(window.location.pathname == "/")
        window.location.pathname = "/auth.html";

      // $urlRouterProvider
      //      .when("/dashboard", "#/dashboard")
      //       .when("/", window.location.pathname = "/login.html");

      // baSidebarServiceProvider.addStaticItem({
      /*title: 'Pages',
      icon: 'ion-document',
      subMenu: [{
        title: 'Sign In',
        fixedHref: 'login.html',
        blank: true
      }, {
        title: 'Sign Up',
        fixedHref: 'reg.html',
        blank: true
      }, {
        title: 'User Profile',
        stateRef: 'profile'
      }, {
        title: '404 Page',
        fixedHref: '404.html',
        blank: true
      }]*/
    // });

  }

})();
