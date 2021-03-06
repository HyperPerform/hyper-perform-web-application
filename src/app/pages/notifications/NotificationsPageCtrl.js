/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('HyperPerform.pages.notifications')
      .controller('NotificationsPageCtrl', NotificationsPageCtrl);

  /** @ngInject */
  function NotificationsPageCtrl($scope, toastr, toastrConfig) {
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

    if (document.cookie != "" ) {
      if (getCookie('hpkey') == "" || getCookie('hpkey') == null)
      {
        window.location.href = "/auth.html";
      }

    }
    else window.location.href = "/auth.html";


    var defaultConfig = angular.copy(toastrConfig);
    $scope.types = ['success', 'error', 'info', 'warning'];

    $scope.quotes = [
      {
        title: 'Come to Freenode',
        message: 'We rock at <em>#angularjs</em>',
        options: {
          allowHtml: true
        }
      },
      {
        title: 'Looking for bootstrap?',
        message: 'Try ui-bootstrap out!'
      },
      {
        title: 'Wants a better router?',
        message: 'We have you covered with ui-router'
      },
      {
        title: 'Angular 2',
        message: 'Is gonna rock the world'
      },
      {
        title: null,
        message: 'Titles are not always needed'
      },
      {
        title: null,
        message: 'Toastr rock!'
      },
      {
        title: 'What about nice html?',
        message: '<strong>Sure you <em>can!</em></strong>',
        options: {
          allowHtml: true
        }
      },
      {
        title: 'Ionic is <em>cool</em>',
        message: 'Best mobile framework ever',
        options: {
          allowHtml: true
        }
      }
    ];

    var openedToasts = [];
    $scope.options = {
      autoDismiss: false,
      positionClass: 'toast-top-right',
      type: 'info',
      timeOut: '5000',
      extendedTimeOut: '2000',
      allowHtml: false,
      closeButton: true,
      tapToDismiss: true,
      progressBar: false,
      newestOnTop: true,
      maxOpened: 0,
      preventDuplicates: false,
      preventOpenDuplicates: false,
      title: "Some title here",
      msg: "Type your message here"
    };


    $scope.clearLastToast = function () {
      var toast = openedToasts.pop();
      toastr.clear(toast);
    };

    $scope.clearToasts = function () {
      toastr.clear();
    };

    $scope.openRandomToast = function () {
      var type = Math.floor(Math.random() * $scope.types.length);
      var quote = Math.floor(Math.random() * $scope.quotes.length);
      var toastType = $scope.types[type];
      var toastQuote = $scope.quotes[quote];
      openedToasts.push(toastr[toastType](toastQuote.message, toastQuote.title, toastQuote.options));
      $scope.optionsStr = "toastr." + toastType + "(\'" + toastQuote.message + "\', \'" + toastQuote.title + "', " + JSON.stringify(toastQuote.options || {}, null, 2) + ")";
    };

    $scope.openToast = function ( msg,  title, type) {
      $scope.notify.push(
          {
            'id': $scope.id++,
            'title': title,
            'message': msg,
            'timestamp': new Date(),
            'type': type

          });

      angular.extend(toastrConfig, $scope.options);
      openedToasts.push(toastr[type](msg, title));
      var strOptions = {};
      for (var o in  $scope.options) if (o != 'msg' && o != 'title')strOptions[o] = $scope.options[o];
      $scope.optionsStr = "toastr." + $scope.options.type + "(\'" + $scope.options.msg + "\', \'" + $scope.options.title + "\', " + JSON.stringify(strOptions, null, 2) + ")";


    };

    $scope.$on('$destroy', function iVeBeenDismissed() {
      angular.extend(toastrConfig, defaultConfig);
    });

    $scope.size = 5;
    $scope.id = 0;
    $scope.notify = [
      {
        'id': 1,
        'title': 'Git',
        'message': 'No internet connection',
        'timestamp': '2016-02-02',
        'type': 'Error'
      }
    ];
  }



})();
