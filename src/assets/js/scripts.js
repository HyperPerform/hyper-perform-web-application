
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    // $.backstretch("assets/img/blue-blur-background.jpg");
    //
    // $('#top-navbar-1').on('shown.bs.collapse', function(){
    // 	$.backstretch("resize");
    // });
    // $('#top-navbar-1').on('hidden.bs.collapse', function(){
    // 	$.backstretch("resize");
    // });
    
    /*
        Form
    */
    $('.registration-form fieldset:first-child').fadeIn('slow');
    
    $('.registration-form input[type="text"], .registration-form input[type="password"], .registration-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });


    // next step
    $('.registration-form .btn-next').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		parent_fieldset.find('input[type="email"]').each(function() {
			if ( filter.test($(this).val()) == false)
			{
				$(this).addClass('input-error');
				next_step = false;
				$('#error').html("Error: Email is not valid<br/><br/>");
				$('#email').focus();
			}
		});
    	parent_fieldset.find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');

    		}
			if ($("#rpassword").val() != "" ) {
				if ($("#rpassword").val() != $("#password").val()) {
					next_step = false;
					$("#error1").html("Error: Passwords do not match");
				}
				if($("#password").val().length < 6) {
					next_step = false;
					$("#error1").html("Error: Password must be at least 6 characters");
				}
			}
    	});

    	if( next_step ) {
    		parent_fieldset.fadeOut(400, function() {
	    		$(this).next().fadeIn();
	    	});
    	}
    	
    });
    
    // previous step
    $('.registration-form .btn-previous').on('click', function() {
    	$(this).parents('fieldset').fadeOut(400, function() {
    		$(this).prev().fadeIn();
			$('#error').html("");
			$('#email').removeClass('input-error');
    	});
    });
    
    // submit
    $('.registration-form').on('submit', function(e) {

    	$(this).find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });


	$.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/users/getPositions", function(res) {

		var data = res;
           // alert(JSON.stringify(data));
		var s = "";
		for (var i = 0; i < data.length; i++)
		{
			s+= "<option>" + data[i] + "</option> ";
		}

		$('#pos').html("<select class='form-control' id='position'>" + s +" </select>");

	});

	$.get("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/users/getRoles", function(res) {

		var data = res;
		// alert(JSON.stringify(data));
		var s = "";
		for (var i = data.length-1; i >= 0; i--)
		{

			s+= "<option>" + data[i] + "</option> ";
		}

		$('#rol').html("<select class='form-control' id='role'>" + s +" </select>");

	});

	$(document).keyup(function(event) {
		var p = $("#password").val();
		var pp = $("#rpassword").val();
		if (pp == p && pp.length > 5)
		{
			$('#check').html("<i class='fa fa-check' style='color: green' aria-hidden='true'></i>");
		}
		else $('#check').html("<i class='fa fa-times' style='color: red' aria-hidden='true'></i>");

		if (p.length < 6)
			$('#error1').html("Error: Password must be at least 6 characters");
		else $('#error1').html("");
	});



    
});

function auth()
{
	// "{\"userName\":\"rohan\", \"userSurname\":\"chhipa\", \"userEmail\":\"rohanchhipa@live.com\", \"userPassword\":\"1234\", \"role\":\"Employee\", \"position\":\"SoftwareDeveloper\"}";
	// var n = document.cookie.split("=")[1].split("#")[0];
	// alert(n);

	var s = "{ ";
	s += "\"managerEmail\": \"admin@hyperperform.me";
	s += "\", \"userName\": \"" + $('#name').val();
	s += "\", \"userSurname\": \"" + $('#surname').val();
	s += "\", \"userEmail\": \"" + $('#email').val();
	s += "\", \"userPassword\": \"" + $('#password').val();
	s += "\", \"role\": \"" + $('#role').val();
	s += "\", \"position\": \"" + $('#position').val().split(" ").join('');
	s += "\", \"gitUserName\": \"" + $('#git').val();
	s += "\" }";
	var b = JSON.parse(s);
	// alert(JSON.stringify(b));
	
	// $.post("http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/users/verifySignUp", {data: s}, function(data, status){
	// 	alert("Data: " + data + "\nStatus: " + status);
	// });

	$.ajax({
		type: "POST",
		url: "http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/users/verifySignUp",
		data: JSON.stringify(b),
		// success: function(res, status){alert(res + " " + status)},
		// failure: function(res, status){alert(res + " " + status)},
		// always:  function(res, status){alert(res + " " + status)},
		// dataType: "json",
		headers: {"Content-Type": "application/json"}
	}).always(function(data) {
		// alert(data.responseText);
		$('#msg').html("<h2> <i style='color: #1F968B'>"+ data.responseText + "</i></h2>");

		modal.style.display = 'block';
		if (data.responseText == "Success")
		{
			setTimeout(
				function()
				{
					location.reload();

				}, 1000);
		}


	});


}

// Get the modal
var modal = document.getElementById('myModal');


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];


// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
};