
(function () {
  'use strict';

  angular.module('HyperPerform.pages', [
    'ui.router',
    'ngRoute',
    'HyperPerform.pages.dashboard',
    'HyperPerform.pages.notifications',
    // 'HyperPerform.pages.form',
    // 'HyperPerform.pages.tables',
    // 'HyperPerform.pages.charts',
    // 'HyperPerform.pages.profile',
    'HyperPerform.pages.detailed'
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
