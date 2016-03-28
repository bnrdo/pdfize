angular.module('MainApp', [])
.controller('TabsCtrl', ['$scope', function ($scope) {
    $scope.tabs = [
        {
			title: 'Split',
            url: 'split.html'
        },{
            title: 'Add/Remove Encryption',
            url: 'crypto.html'
        },{
            title: 'Convert Files to PDF',
            url: 'convert.html'
    	},{
            title: 'Compress',
            url: 'compress.html'
    	}
	];

    $scope.currentTab = $scope.tabs[0].url;

    $scope.onClickTab = function (tab) {
        $scope.currentTab = tab.url;
    }
    
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl == $scope.currentTab;
    }
}]);

//console.log(MainApp);