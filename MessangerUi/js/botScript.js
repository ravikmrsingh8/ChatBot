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
    var html=   "<div class='intercom-conversation-part intercom-conversation-part-user'> \
                    <div class='intercom-comment-container intercom-comment-container-user'> \
                        <div class='intercom-comment'> \
                            <div class='intercom-blocks'> \
                                <div class='intercom-block intercom-block-paragraph'>" + chatText + "</div> \
                            </div>\
                        </div>\
                    </div>\
                </div>"
        
               
    $(".intercom-conversation-parts").append(html);
    $("textarea#message").val(" ")
} 

function appendBotResponse(botResponseText) {
	var html=  "<div class='intercom-conversation-part intercom-conversation-part-admin intercom-conversation-part-last'> \
                        <div class='intercom-comment-container intercom-comment-container-admin'> \
                            <div class='intercom-comment-container-admin-avatar'> \
                                <div class='intercom-avatar'> \
                                    <img src='image/operator.png'> \
                                </div> \
                            </div> \
	                   <div class='intercom-comment'>\
                               <div class='intercom-blocks'> \
                                   <div class='intercom-block intercom-block-paragraph'> \
                                        <p>" + botResponseText + "</p> \
                                   </div> \
                                </div> \
                            </div> \
                        </div> \
                    </div>";
    
        html += "<div class='intercom-conversation-part-metadata'> \
                    <div class='intercom-conversation-part-metadata-save-state'></div> \
                </div>";
        
	$(".intercom-conversation-parts").append(html);
	speak(botResponseText);
}

$("textarea#message").keydown(function(event) {
    
    if (event.keyCode === 13) {
        processChat();
        event.preventDefault();
    }
    
});




var processChat = function (){

	if (recognizing) {
            recognition.stop();
        }
	var text = $("textarea#message").val();
	appendUserChat(text)
			
	//var height = $(".intercom-conversation-body-parts").height()	
        //$(".intercom-conversation-body-parts").animate({scrollTop: height});
	$(".intercom-conversation-body-parts").stop().animate({ scrollTop: $(".intercom-conversation-body-parts")[0].scrollHeight}, 1000);	
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
                $(".intercom-conversation-body-parts").stop().animate({ scrollTop: $(".intercom-conversation-body-parts")[0].scrollHeight}, 1000);
		//var height = $(".intercom-conversation-body-parts").height()	
		//$(".intercom-conversation-body-parts").animate({scrollTop: height});
		//$("textarea#message").val(" ");
	});
};


	