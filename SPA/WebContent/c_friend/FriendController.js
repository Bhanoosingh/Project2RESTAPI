	myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
	{
		$scope.friend = {"friendId":0,"loginname":'',"friendloginname":'',"status":''};
		$scope.acceptfrienddata;
		$scope.pendingFriendRequest;
		$scope.suggestedFriends;
		
		function friendData(){	
			console.log('Friend Data');
			$http.get("http://localhost:8081/FriendsAddaMiddleware/showAllFriends")
					.then(function(response)
							{
								$scope.acceptfrienddata=response.data;
								console.log($scope.acceptfrienddata);
							});
		}
		
		function suggestedFriends(){
			console.log('Suggested Friend');
			$http.get("http://localhost:8081/FriendsAddaMiddleware/showSuggestedFriends")
					.then(function(response)
							{
								$scope.suggestedFriends=response.data;
								console.log($scope.suggestedFriends);
							});
		}
		
		function pendingFriendRequest(){
			console.log('Pending Friend Request');
			$http.get("http://localhost:8081/FriendsAddaMiddleware/showPendingRequests")
					.then(function(response)
							{
								$scope.pendingFriendRequest=response.data;
								console.log($scope.pendingFriendRequest);
							});
		}
		
		$scope.acceptFriendRequest = function(friendId){
			console.log('Accept Friend Request');
			$http.get("http://localhost:8081/FriendsAddaMiddleware/acceptFriendRequest/"+friendId)
					.then(function(response)
							{
						
							});
		}
		
		$scope.deleteFriendRequest = function(friendId){
			console.log('Delete Friend Request');
			$http.get("http://localhost:8081/FriendsAddaMiddleware/deleteFriendRequest/"+friendId)
					.then(function(response)
							{
						
							});
		}
		
		$scope.sendFriendRequest=function(friendloginname){
			$scope.friend.loginname = rootScope.currentUser.email;
			$scope.friend.friendloginname = friendloginname;
			
			$http.post('http://localhost:8081/FriendsAddaMiddleware/sendFriendRequest',$scope.friend)
					.then(function(response)
							{
						
							});
		}
		friendData();
		suggestedFriends();
	});	