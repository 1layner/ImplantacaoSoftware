var BASE_URL = 'http://localhost:8081';

angular.module('app', ['ngRoute', 'ngQuill', 'ngResource', 'ngSanitize', 'naif.base64', 'checklist-model', 'ngNotify', 'ngCookies', 'ngStorage'])


    .config(function($routeProvider){
       $routeProvider.
            when('/cadUsuario', {
                templateUrl : 'src/usuario/usuario.html',
                controller : 'usuarioCtrl'
            })

    });