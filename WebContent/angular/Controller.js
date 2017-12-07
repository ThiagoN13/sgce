const myApp = angular.module('sgceApp', ['ui.router'])
  .service('usuarioService', function() {
    return {
      getSession: function () {
          return JSON.parse(localStorage.getItem('usuario'));
      },
      setSession: function(usuario) {
    	  localStorage.setItem('usuario', JSON.stringify(usuario))
      }
    }
  })
  .controller('indexController', function($scope, $location, usuarioService) {
    $scope.calculoMensal = 0.00
    $scope.sair = sair
    $scope.usuario = usuarioService.getSession()

    if (!$scope.usuario) $location.path('/login')

    function sair () {
      usuarioService.setSession({})
      $location.path('/login')
    }
  })
  .controller('homeController', function($scope, $location, usuarioService) {
	  console.log(usuarioService.getSession())
  })
  .controller('listController', function($scope, $location, $stateParams, $http, usuarioService) {
	const comodo = $stateParams.comodo
    $scope.comodo = setarTitulo(comodo)
    $scope.calculos = []
    $scope.submeterFormulario = submeterFormulario
    const usuario = usuarioService.getSession()

    function listarAparelhos() {
      $http.get("http://localhost:8080/SGCE/rest/aparelhos?id_usuario=" + usuario.id_usuario + "&comodo=" + comodo)
	    .then(function(response) {
	        $scope.aparelhos = response.data;
	    })
    }
    
    function setarTitulo(comodo) {
      if(comodo === 'area_de_servico') return 'ÁREA DE SERVIÇO'
      
      return comodo.toUpperCase()
    }

    function submeterFormulario() {
      if ($scope.formCalculo.$invalid) return

      $scope.calculos.push($scope.calculo)
    }
    
    listarAparelhos()
  })
  .controller('historyController', function($scope, $location, $http) {
	  $http.get('http://localhost:8080/SGCE/rest/consumos')
	    .then(function(response) {
	        $scope.consumos = response.data;
	    })
  })
  .controller('formController', function($scope, $location, usuarioService) {
    $scope.voltarRota = voltarRota
    $scope.cadastrarAparelho = cadastrarAparelho
    
    function cadastrarAparelho() {
    	$scope.aparelho.usuario = usuarioService.getSession()
    	$http.post('http://localhost:8080/SGCE/rest/aparelhos', $scope.aparelho)
    	  .then(function() {
    		  alert("Cadastrado com sucesso")
    	  })
    }

    function voltarRota() {
      $location.path('/')
    }
  })
  .controller('loginController', function($scope, $location, usuarioService) {
    $scope.cadastrar = cadastrar
    $scope.logar = logar

    $('.btn-pref .btn').click(() => {
      $scope.usuario = {}
      $scope.$apply()
      $('.btn-pref .btn').removeClass('btn-info').addClass('btn-default');
      $(this).removeClass('btn-default').addClass('btn-info');
    });

    function cadastrar () {
      $http.post('http://localhost:8080/SGCE/rest/usuario/cadastro', $scope.usuario)
	    .then(function() {
		  alert("Cadastrado com sucesso")
	    })
    }

    function logar () {
      $http.post('http://localhost:8080/SGCE/rest/usuario/login', $scope.usuario)
  	    .then(function() {
  		  alert("Cadastrado com sucesso")
  		  usuarioService.setSession($scope.usuario)
  		  $location.path('/')
  	    })
    }
  })
