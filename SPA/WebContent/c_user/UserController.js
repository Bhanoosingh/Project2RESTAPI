/**
 * 
 */
myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore){
	
	$scope.user={"name":'',"password":'',"email":'',"address":'',"phone":'',"role":'',"isOnline":''};
		
		$scope.register = function(){
			console.log("Registration function");
			$http.post('http://localhost:8081/FriendsAddaMiddleware/registerUser',$scope.user)
			.then(function(response)
				{
				console.log('Status text:' + response.statusText);
				alert('Registered successfully..!!');
				});
		};
	
		$rootScope.login=function(){
			console.log("Logging function");
			
			$http.post("http://localhost:8081/FriendsAddaMiddleware/login",$scope.user)
			.then(function(response){
				console.log(response.status);
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetails',response.data);
				console.log($rootScope.currentUser.role);
				
				if($rootScope.currentUser.role=='Admin'){
					console.log("Admin");
				}
				if($rootScope.currentUser.role=='USER'){
					console.log("User");
				}
				$location.path("/");
			});
		};
		
		
		$rootScope.displayDetails=function(){
			
			console.log("Display Details function called : ");
		};
		
		$scope.update = function(email) {
			console.log('Entered into the Update  User method '+email);
			$http.post("http://localhost:8081/FriendsAddaMiddleware/update/"+email,
					$scope.user).then(function(response) {
				console.log('Status text:' + response.statusText);
				alert('updated details successfully..!!');
				$location.path("/viewProfile");
			});

	};

	$rootScope.logout=function(){
		console.log('LogOut function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("/");
	}	
});