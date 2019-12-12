window.onload = function() {
	


	let star = '<div class="star-1"></div><div class="star-2"></div>';
    for(i = 0 ; i < 10 ; i++){
    	star+=star;
    }
	$("#stars").html(star);


	let bird = '<div class="bird bird-anim"> <div class="bird-container"> <div class="wing wing-left"> <div class="wing-left-top"></div> </div> <div class="wing wing-right"> <div class="wing-right-top"></div> </div> </div> </div>';
	 for(i = 0 ; i < 5; i++){
    	bird+=bird;
    }
	
	$("#birds").html(bird);
	$.luna();
}	
isError=true;