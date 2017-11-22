myApp.config(function($stateProvider, $urlRouterProvider) {
  // For any unmatched url, redirect to /state1
  $urlRouterProvider.otherwise("/");
  // Now set up the states
  $stateProvider
    .state('index', {
      url: "/",
      templateUrl: "partials/home.html",
      controller: "homeController"
    })
    .state('login', {
      url: "/login",
      templateUrl: "partials/login.html",
      controller: "loginController"
    })
    .state('form', {
      url: "/form",
      templateUrl: "partials/form.html",
      controller: "formController"
    })
    .state('list', {
      url: "/list/:comodo",
      templateUrl: "partials/list.html",
      controller: "listController"
    })
    .state('history', {
      url: "/history/",
      templateUrl: "partials/history.html",
      controller: "historyController"
    })
});
