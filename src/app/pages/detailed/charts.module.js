/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.detailed', [

      'BlurAdmin.pages.detailed.github',
      'BlurAdmin.pages.detailed.travis',
      'BlurAdmin.pages.detailed.issues',
      'BlurAdmin.pages.detailed.entryexit'
  ])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('detailed', {
          url: '/detailed',
          abstract: true,
          template: '<div ui-view></div>',
          title: 'Detailed',
          sidebarMeta: {
            icon: 'ion-stats-bars',
            order: 150
          }
        });
  }

})();
