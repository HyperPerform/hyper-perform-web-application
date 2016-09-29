
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
    ////////////////////////////////
	$("#password").keypress(function(event) {
		var p = $("#password").val();
		var pp = $("#rpassword").val();
		if (pp == p)
		{
			$('#check').html("<i class='fa fa-check' style='color: green' aria-hidden='true'></i>");

		}
		else $('#check').html("<i class='fa fa-cross' style='color: red' aria-hidden='true'></i>");
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
		for (var i = 0; i < data.length; i++)
		{
			s+= "<option>" + data[i] + "</option> ";
		}

		$('#rol').html("<select class='form-control' id='roles'>" + s +" </select>");

	});

	function auth()
	{

	}

    
});
