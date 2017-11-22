const myApp = angular.module('sgceApp', ['ui.router'])
  .controller('indexController', function($scope, $location) {
    $scope.calculoMensal = 0.00
    $scope.sair = sair
    $scope.usuario = JSON.parse(localStorage.getItem('usuario'))

    if (!$scope.usuario) $location.path('/login')

    function sair () {
      localStorage.setItem('usuario', JSON.stringify({}))
      $location.path('/login')
    }
  })
  .controller('homeController', function($scope, $location) {

  })
  .controller('listController', function($scope, $location, $stateParams, $http) {
    $scope.comodo = setarTitulo($stateParams.comodo)
    $scope.calculos = []
    $scope.submeterFormulario = submeterFormulario

    function listarAparelhos() {
      $http.get("http://localhost:8080/SGCE/rest/aparelhos")
	    .then(function(response) {
	        $scope.aparelhos = response.data;
	    })
    }
    
    function setarTitulo(comodo) {
      switch(comodo) {
        case 'area_de_servico':
          return 'ÁREA DE SERVIÇO'
        default:
          return comodo.toUpperCase()
      }
    }

    function submeterFormulario() {
      if ($scope.formCalculo.$invalid) return

      $scope.calculos.push($scope.calculo)
    }
    
    listarAparelhos()
  })
  .controller('historyController', function($scope, $location) {

  })
  .controller('formController', function($scope, $location) {
    $scope.voltarRota = voltarRota

    function voltarRota() {
      $location.path('/')
    }
  })
  .controller('loginController', function($scope, $location) {
    $scope.cadastrar = cadastrar
    $scope.logar = logar

    $('.btn-pref .btn').click(function () {
      $scope.usuario = {}
      $scope.$apply()
      $('.btn-pref .btn').removeClass('btn-info').addClass('btn-default');
      $(this).removeClass('btn-default').addClass('btn-info');
    });

    function cadastrar () {
      console.log($scope);

    }

    function logar () {
      console.log($scope);
      localStorage.setItem('usuario', JSON.stringify($scope.usuario))
      $location.path('/')
    }
  })
