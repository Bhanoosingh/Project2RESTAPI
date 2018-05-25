var myApp=angular.module("myApp",['ngRoute',,'ngCookies']);

myApp.config(function($routeProvider)
{
	console.log('I am in templateUrl');
	$routeProvider
	.when("/",{templateUrl:"home.html"})
	.when("/contact",{templateUrl:"contactus.html"})
	.when("/login",{templateUrl:"c_user/login.html"})
	.when("/register",{templateUrl:"c_user/register.html"})
	.when("/blog",{templateUrl:"c_blog/blog.html"})
	.when("/addBlog",{templateUrl:"c_blog/addBlog.html"})
	.when("/updateBlog",{templateUrl:"c_blog/updateBlog.html"})
	.when("/forum",{templateUrl:"c_forum/forum.html",})
	.when("/addForum",{templateUrl:"c_forum/addForum.html",})
	.when("/updateForum",{templateUrl:"c_forum/updateForum.html",})
	.when("/job",{templateUrl:"c_job/job.html"})
	.when("/about",{templateUrl:"aboutus.html"})
	.when("/displayProfile",{templateUrl:"c_user/viewProfile.html"})
	.when("/updateProfile",{templateUrl:"c_user/updateProfile.html"})
	.when("/uploadProfilePicture",{templateUrl:"c_user/updateProfilePic.html"})
	.when("/chat",{templateUrl:"c_chat/chat.html"})
	.when("/friend",{templateUrl:"c_friend/showAllFriends.html"})
	.when("/suggestedFriend",{templateUrl:"c_friend/suggestedFriend.html"})
	.when("/pendingFriend",{templateUrl:"c_friend/pendingFriend.html"})
});


myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.userName);
				console.log($rootScope.currentUser.role);
				}
});