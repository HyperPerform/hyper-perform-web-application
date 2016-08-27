(function () {
  'use strict';

  angular.module('BlurAdmin.pages.detailed.travis', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('detailed.travis', {
          url: '/travis',
          templateUrl: 'app/pages/detailed/travis/travis.html',
          title: 'Travis',
          sidebarMeta: {
            order: 200,
          },
        });
  }

})();