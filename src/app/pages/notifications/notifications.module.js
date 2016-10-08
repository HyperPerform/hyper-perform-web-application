/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('HyperPerform.pages.notifications', []);
      // .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('notifications', {
          url: '/notifications',
          templateUrl: 'app/pages/notifications/notifications.html',
          controller: 'NotificationsPageCtrl',
          title: 'Notifications',
          // abstract: true,
          sidebarMeta: {
            icon: 'fa fa fa-bell',
            order: 150
          }
        });
  }

})();
