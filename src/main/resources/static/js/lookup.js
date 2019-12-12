function lookup() {
	createLookArea();
	$.ajax({
		url: decluna_wrod+"/lookup/search",
		type: "post",
		data: {
			wordName: $("#word").val()
		},
		dataType: "json",
		success: function(data) {
			decodeJson_word(data.data,data.info)
			decodeJson_translate(data.data, data.info)

			$("#test").click();
		},
		error: function() {
			console.log("i can't")
		}
	})
}

// private 
function createLookArea() {
	$("#look").html("");
	$("#look").get(0).style.padding = "10px";
	let a = " <div id=\"displayArea\" class=\"collapse\"><h5></h5><hr /><span></span></div>";
	$("#look").html(a);
}

function decodeJson_word(data,string) {
	string = string+"";
	if(data == "okay") {
		$("#look h5").get(0).innerHTML = string.split(":")[0];
	}else if(data == "no"){
		$("#look h5").html("Uh-oh,luna didn't find the word in the dictionary");
	}
}

function decodeJson_translate(data, string) {
	string = string+"";
	if(data == "okay") {
		let html = "";
		let translates = string.split(":")[1].split("^");
		for(let a = 0; a < translates.length; a++) {
			let arr = translates[a].split("*");
			html += arr[0] + "&nbsp;" + arr[1].replace(/;/g, "；") + "<br/><br/>";
		}
		$("#look span").html(html);
	} else if(data == "no") {
		$("#look span").html(string);
	}

}