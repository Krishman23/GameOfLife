jQuery(document).ready(function($) {
	var myVar;
	// since page is redirecting, to control over the stateless request, added
	// sessionStorage
	if (sessionStorage.getItem("itrAuto") == "true") {
		// use user define delay to call controller 
		myVar = setTimeout(myItr, $("input#itrSpeed").val());
	}
	// on load update the array color 
	$('div.common').each(function() {

		if ($(this)[0].innerText == "0") {
			$(this).removeClass('alive').addClass('dead');
		} else {
			$(this).removeClass('dead').addClass('alive');
		}

	});
	//toggle array on click 
	$("div.common").click(function(event) {
		if (event.target.innerText == "1") {

			event.target.innerText = "0";
			$(this).prev().val("0");
			$(this).removeClass('alive').addClass('dead');
		} else {
			event.target.innerText = "1";
			$(this).prev("input").val("1");
			$(this).removeClass('dead').addClass('alive');
		}

	});
	//on submit update session storage
	$("div.submit").click(function(event) {
		sessionStorage.setItem("itrAuto", "true");
	});
	//loop till the user defined value of iteration 
	function myItr() {
		if ($("input#itr").val() > "0") {
			document.getElementById("submit").click();
		} else {
			console.log("End of Loop");
			sessionStorage.clear();
		}
	}
	//on stop clear time out and sessionstorage
	$("input#stop").click(function(event) {
		clearTimeout(myVar);
		sessionStorage.clear();
	});

});
