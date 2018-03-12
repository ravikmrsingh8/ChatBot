var synth = window.speechSynthesis;


function speak(inputTxt){
  if(inputTxt !== ''){
    var utterThis = new SpeechSynthesisUtterance(inputTxt);
	utterThis.voice = synth.getVoices()[0];
    utterThis.pitch = 1;
    utterThis.rate = 1;
    synth.speak(utterThis);
  }
}


function appendUserChat(chatText) {
	var html = "<li><div class='left-chat'><img src='image/1499345471_boy.png'><p>"+chatText+"</p></div></li>";
	$(".chat-section").find("ul").append(html);
	//Clear input text value
	$("#text-input").val(" ")
} 

function appendBotResponse(botResponseText) {
	
	var html = "<li><div class='right-chat'><img src='image/bot.png'><p>"+botResponseText+"</p></div></li>";
	$(".chat-section").find("ul").append(html);
	speak(botResponseText);
}

$("#text-input").keydown(function(event) {
    if (event.keyCode === 13) {
        processChat();
    }
});

$(document).ready(function(){
	$(".chat-section").animate({scrollTop: $(".chat-section").find("ul").height()});
    $(".left-first-section").click(function(){
        $('.main-section').toggleClass("open-more");
    });
});
$(document).ready(function(){
	$(".fa-minus").click(function(){
        $('.main-section').toggleClass("open-more");
    });
});
	
$(document).ready(function(){
    $("#paper-plane").click(function(){
		processChat();
    });
});


var processChat = function (){
	if (recognizing) {
        recognition.stop();
    }
	var text = $("#text-input").val();
	appendUserChat(text)
			
	var height = $(".chat-section").find("ul").height()	
	$(".chat-section").animate({scrollTop: height});
		
	var url = "http://52CQYX1J:8080/api/infer";
	var successFun = function(result) {
		console.log(result);
		var answer = result.text;
		appendBotResponse(answer);
	};
	console.log({'text':text});
	$.ajax({
		type: "POST",
		url: url,
		data: JSON.stringify({'text': text}),
		success: successFun,
		dataType: "json",
		contentType: "application/json"
	}).fail(function(error) {
		console.log(JSON.stringify(error,null,4))
		appendBotResponse("Request Failed");
	}).always(function(){
		var height = $(".chat-section").find("ul").height()	
		$(".chat-section").animate({scrollTop: height});
		$("#text-input").val(" ")
	});
};


	