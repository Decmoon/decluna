$().ready(function() {
	$.ajax({
		url: decluna_wrod+"/check/check",
		type: "get",
		dataType: "json",
		success: function(data) {
			if(!equals("okay", data.data)) {
				//do somethings
			} else {
				var table = "";
				$.each(data, function(word, info) {
					if(!equals(word, "data")) {
							$("#display").get(0).style.padding = "10px";
						if(equals(table, "")){
							$("#check thead").html("<tr><th>WORD</th><th>PART OF SPEECH</th><th>TRANSLATE</th></tr>");
						} 
						var arr = info.split("*");
						table += "<tr><td>" + word + "</td><td>" + arr[0] + "</td><td>" + arr[1] + "</td></tr>";
					}
				});
				$("#check tbody").html(table);
			}
		}
	})

})