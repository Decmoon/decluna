var classTypes;
var classSize;

parametersLoad();

function parametersLoad() {
	classSize = 1;
	classTypes = ["Nouns(n.)", "Pronouns(pron.)", "Adjectives(adj.)",
		"Numerals(num.)", "Verb (v.)", "Adverbs(adv.)",
		"Articles (art.)", "Prepositions(prep.)", "Conjunctions (conj.)", "Interjections (int.)"
	];
}

var attribute = "<div class=\"translate_wordclass\"><div class=\"input-group mb-3\"><div class=\"input-group-prepend\">" +
	"<span class=\"input-group-text  transparentElement elementFade\">Part of speech</span></div><select class=\"form-control options elementFade transparentElement\" onmouseenter=\"selectOnmouseenter()\">" +
	"</select></div></div> <div class=\"translate\"><div class=\"input-group mb-3\"><div class=\"input-group-prepend\">" +
	"<span class=\"input-group-text elementFade transparentElement \">Means</span></div><input type=\"text\" class=\"form-control cursor_input elementFade transparentElement textColor\" " +
	"placeholder=\"The word meaning,multiple translations are separated by Spaces\" title=\"The word meaning,multiple translations are separated by Spaces\">" +
	"</div></div>";

function addAttribute() {
	if(classSize >= 1 && classSize <= 10) {
		classSize++;
		$("#class" + classSize).html(attribute);
		addOptions();
	}

}

function delAttribute() {
	if(classSize >= 2 && classSize <= 10) {
		$("#class" + classSize).html("");
		classSize--;
		addOptions();
	}

}

function recordWord() {
	let _word = $("#wordName").val();
	let _means = turnJson();
	$.ajax({
		url: decluna_wrod+"/record/add",
		type: "post",
		data: {
			wordName: _word,
			translate: _means
		},
		dataType: "json",
		success: function(data) {
			if(equals("okay", data.data)) {
				$("#alert_title").removeClass("alert-danger");
				$("#alert_title").addClass("alert-success");
				$("#alert_title strong").get(0).innerHTML = "The word has been successfully added to your exclusive dictionary";
				$("#alert_body strong").get(0).innerHTML = (data.pretty + "").replace("^", "<br/>");
				reset();
			}else if(equals("no", data.data)) {
				$("#alert_title").removeClass("alert-success");
				$("#alert_title").addClass("alert-danger");
				$("#alert_title strong").get(0).innerHTML = "Failed to add words please check if there are missing items and try again";
				$("#alert_body strong").get(0).innerHTML = "Books are the ladder of human progress" + "<br/>" + "---Maxim Gorky";
			}
		},
		error: function() {
			$("#alert_title").removeClass("alert-success");
			$("#alert_title").addClass("alert-danger");
			$("#alert_title strong").get(0).innerHTML = "Network connection failed please check your network and try again";
			$("#alert_body strong").get(0).innerHTML = "Books are the ladder of human progress" + "<br/>" + "---Maxim Gorky";
		}
	})

}

function selectOnmouseenter(oldvalue, a) {
	addOptions();
}

// private 
function addOptions() {
	$(".options").each(function(i, o) {
		if(($(this).attr("id") + "") == "undefined")
			$(this).attr("id", "wordClass" + classSize);
		$(this).html(addOption($(this)));
	});
}

function addOption(object) {
	let optionsString = selectOptions();
	let value = $(object).val();
	let c = value == null ? "" : "<option>" + $(object).val() + "</option>";
	for(let s = 0; s < classTypes.length; s++) {
		if(optionsString.indexOf(classTypes[s]) != -1) continue;
		c += "<option>" + classTypes[s] + "</option>";
	}
	return c;
}

function selectOptions() {
	let str = "";
	$(".options").each(function(i, o) {
		str += $(this).val();
	});
	return str;
}

function turnJson() {
	let jsonValue = "";
	for(let i = 1; i <= 10; i++) {
		let type = $(("#class" + i) + " select");
		let means = $(("#class" + i) + " input");
		let key = type.val();
		let value = means.val();
		if((key + "") == "undefined" || (value + "") == "undefined") break;
		jsonValue += key + "*" + value;
		jsonValue += "^";
	}
	return jsonValue.substr(0, jsonValue.length - 1);
}

function reset() {
	parametersLoad();
	for(let i = 2; i <= 10; i++) {
		$(("#class" + i)).html("");
	}
	$("#wordName").get(0).value = "";
	$("#class1 input").get(0).value = "";
}


