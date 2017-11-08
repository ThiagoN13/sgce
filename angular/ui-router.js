myApp.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('index', { url: '/', template: 'Inicio' })

	$urlRouterProvider.otherwise('/')    
})