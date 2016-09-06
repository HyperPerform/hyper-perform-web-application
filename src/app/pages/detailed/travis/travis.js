(function () {
  'use strict';

  angular.module('HyperPerform.pages.detailed.travis', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('detailed.travis', {
          url: '/travis',
          templateUrl: 'app/pages/detailed/travis/travis.html',
          title: 'Travis',
          sidebarMeta: {
            icon: 'fa-gears',
            order: 200
          }
        });
  }

})();