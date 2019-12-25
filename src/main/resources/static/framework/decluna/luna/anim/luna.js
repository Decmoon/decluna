var luna = "lunaCode";

String.prototype.render = function(context) {
	var tokenReg = /(\\)?\{([^\{\}\\]+)(\\)?\}/g;
	return this.replace(tokenReg, function(word, slash1, token, slash2) {
		if(slash1 || slash2) {
			return word.replace('\\', '');
		}
		var variables = token.replace(/\s/g, '').split('.');
		var currentObject = context;
		var i, length, variable;

		for(i = 0, length = variables.length; i < length; ++i) {
			variable = variables[i];
			currentObject = currentObject[variable];
			if(currentObject === undefined || currentObject === null) return '';
		}
		console.log("String render : " + currentObject)
		return currentObject;
	});
};

$(document).on('copy', function() {
	showMessage('What did you copy,meow?', 5000, true);
});

$('#luna_home').click(function() {
	window.location = "/";
});

$("#luna_cosplay").click(function() {
	loadOtherModel();
});

$('#luna_exit').click(function() {
	window.setTimeout(function() {
		$('#luna_div').hide();
	}, 1300);
});

(function() {
	var text;
	var now = (new Date()).getHours();
	if(isError) {
		text = "Mayday!Mayday! Hahahh,you big FOOL !If you want to access a resource you can tell me, I won't tell you~";
	}if(isUndeveloped){
		text = "Stop stop stop! This is the <b>undeveloped</b> area. My master won't let you see it";
	} else if(now > 23 || now <= 5) {
		text = 'Are you a night owl? Hey,go to bed early~';
	} else if(now > 5 && now <= 7) {
		text = 'Good morning! The day is in the morning, and a good day is about to begin~';
	} else if(now > 7 && now <= 11) {
		text = 'Good morning! Work well,don\'t sit long, get up and walk more!';
	} else if(now > 11 && now <= 14) {
		text = 'It\'s noon. it\'s lunchtime!';
	} else if(now > 14 && now <= 17) {
		text = 'It\'s easy to get sleepy in the afternoon. Have you finished today\'s goal?';
	} else if(now > 17 && now <= 19) {
		text = 'Evening! The setting sun outside the window is very beautiful~';
	} else if(now > 19 && now <= 21) {
		text = 'Good evening. How are you today?';
	} else if(now > 21 && now <= 23) {
		text = 'It\'s so late. Have a rest earlier. Nighty night~';
	}
	showMessage(text, 6000);
})();

function initModel(waifuPath) {
	let preset = localStorage.getItem(luna);
	if(preset === undefined || preset === null || preset + "" == null + "") {
		localStorage.setItem(luna, "luna-1-50");
	}
	loadModel(localStorage.getItem(luna));
	$.ajax({
		cache: true,
		type: "post",
		url: waifuPath,
		dataType: "json",
		success: function(result) {
			$.each(result.mouseover, function(index, tips) {
				$(document).on("mouseover", tips.selector, function() {
					var text = tips.text;
					if(Array.isArray(tips.text)) text = tips.text[Math.floor(Math.random() * tips.text.length + 1) - 1];
					text = text.render({
						text: $(this).text()
					});
					showMessage(text, 3000);
				});
			});
			$.each(result.click, function(index, tips) {
				$(document).on("click", tips.selector, function() {
					var text = tips.text;
					if(Array.isArray(tips.text)) text = tips.text[Math.floor(Math.random() * tips.text.length + 1) - 1];
					text = text.render({
						text: $(this).text()
					});
					showMessage(text, 3000, true);
				});
			});
			$.each(result.seasons, function(index, tips) {
				var now = new Date();
				var after = tips.date.split('-')[0];
				var before = tips.date.split('-')[1] || after;
				if((after.split('/')[0] <= now.getMonth() + 1 && now.getMonth() + 1 <= before.split('/')[0]) &&
					(after.split('/')[1] <= now.getDate() && now.getDate() <= before.split('/')[1])) {
					var text = tips.text;
					if(Array.isArray(tips.text)) text = tips.text[Math.floor(Math.random() * tips.text.length + 1) - 1];
					text = text.render({
						year: now.getFullYear()
					});
					showMessage(text, 6000, true);
				}
			});
		}
	});
}

function loadOtherModel() {
	let lunaCode = localStorage.getItem(luna);
	$.ajax({
		cache: false,
		type: "get",
		url: '/elf/change?lunaCode=' + lunaCode,
		dataType: "json",
		success: function(data) {
			loadModel(data.lunaCode);
			showMessage(data.message, 3000, true);
		}
	});
}

function loadModel(newLuna) {
	localStorage.setItem(luna, newLuna);
	loadlive2d('live2d', "/elf/model?lunaCode=" + newLuna, undefined);
}

function showMessage(text, timeout, flag) {
	if(flag || sessionStorage.getItem('waifu-text') === '' || sessionStorage.getItem('waifu-text') === null) {
		if(Array.isArray(text)) text = text[Math.floor(Math.random() * text.length + 1) - 1];
		if(flag) sessionStorage.setItem('waifu-text', text);
		$('#luna_tips').stop();
		$('#luna_tips').html(text).fadeTo(200, 1);
		if(timeout === undefined) timeout = 5000;
		hideMessage(timeout);
	}
}

function hideMessage(timeout) {
	$('#luna_tips').stop().css('opacity', 1);
	if(timeout === undefined) timeout = 5000;
	window.setTimeout(function() {
		sessionStorage.removeItem('waifu-text')
	}, timeout);
	$('#luna_tips').delay(timeout).fadeTo(200, 0);
}