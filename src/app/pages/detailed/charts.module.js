/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed', [

      'HyperPerform.pages.detailed.github',
      'HyperPerform.pages.detailed.travis',
      'HyperPerform.pages.detailed.issues',
      'HyperPerform.pages.detailed.entryexit'
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
