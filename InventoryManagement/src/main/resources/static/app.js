/**
 * Created by sumi on 2/8/16.
 */

var app1= angular.module('app', ['ui.router']);
app1.config(function($stateProvider, $urlRouterProvider)
{
    $urlRouterProvider.otherwise("/");
    $stateProvider
        .state('welcome',
            {
                url:"/welcome",
                templateUrl: 'welcome.html'
            })
        .state('indetails',
            {
                url:"/indetails",
                templateUrl:'indetails.html'
            })
        .state('purdetails',
            {
                url:"/purdetails",
                templateUrl:'purdetails.html'
            })
        .state('prodetails',
            {
                url:"/prodetails",
                templateUrl:'prodetails.html'
            })
});
