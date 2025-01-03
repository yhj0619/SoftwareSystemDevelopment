function postXml() {
	var today = new Date().toISOString();
	var xmlData = `<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<message-list>
			<message>
				<id>1</id>
				<content>메시지1</content>
				<crTime>${today}</crTime>
			</message>
			<message>
				<id>2</id>
				<content>메시지2</content>
				<crTime>${today}</crTime>
			</message>
		</message-list>`;
	alert("request: " + xmlData);

	/*
	$.ajax({		// Ajax 호출을 위해 JQuery 이용 
		type: "POST",
		url: "message/post-in-xml",
		contentType: "text/xml",
		data: xmlData,
		dataType: "xml"
	}).done(function(responseXml){ 	// XML Document node
		...	
	}).fail(function(jqXHR) {
		alert("ERROR: "+ JSON.stringify(jqXHR));
	});	
	*/
		
	// Ajax 호출을 위해 Axios library 이용 
	axios.post("message/post-in-xml",
			xmlData,
			{ headers: {'Content-Type': 'text/xml', 'Accept': 'application/xml'},
			  responseType: "document" })	// XML				
		.then(response => {			
			var responseXml = response.data;	// XML Document node
			
			var responseStr = (new XMLSerializer()).serializeToString(responseXml);
			$("#result").html("Response Body:<div id='div1'><div>");		
			$("#div1").text(responseStr);			
			
		   	// XML 데이터 사용
		   	var content = `
		   			<br>응답 데이터 이용:<br>
		   			<table border='1'>
		   			<tr><th>ID</th><th>내용</th><th>생성시각</th></tr>`;
		   	var messageList = $(responseXml).find("message"); 	// find a list of <message> elements
		   	$(messageList).each(function(){
		   		content += `
					<tr>
						<td>${$(this).find("id").text()}</td>
						<td>${$(this).find("content").text()}</td>  
						<td>${new Date($(this).find("crTime").text())}</td>
					</tr>`;
            });
		   	content += "</table><br>";
		   	$("#result").append(content);
		})
		.catch(error => { 
			alert("ERROR", error); console.error(error);
		});
}
	
function postJson() {
	var message1 = {id: 1, content: "메시지1", creationTime: new Date()}, 
		message2 = {id: 2, content: "메시지2", creationTime: new Date()};
	var messages = [message1, message2];	
	alert("request: " + JSON.stringify(messages));
	
	/*
 	$.ajax({			// Ajax 호출을 위해  JQuery 이용
		type: "POST",
		url: "message/post-in-json",
		contentType: "application/json",
		data: JSON.stringify(messages)
	}).done(function(responseJson) {	// responseJson: JS object parsed from JSON text
		...	
	}).fail(function(jqXHR) {
		alert("ERROR: "+ JSON.stringify(jqXHR));
	});	
	*/				
	
	// Ajax 호출을 위해 Axios library 이용
	axios.post("message/post-in-json", 
				messages)
		.then(response => {
			var responseJson = response.data;	// JS object parsed from response body
			
			$("#result").html("Response Body: <div><div>");
			$("#result > div").text(JSON.stringify(responseJson));
			
	        // JSON 데이터 사용
		   	var content = `
		   			<br>응답 데이터 이용:<br>
		   			<table border='1'>
		   			<tr><th>ID</th><th>내용</th><th>생성시각</th></tr>`;
		   	$(responseJson).each(function(){				
		   		content += `
					<tr>
						<td>${this.id}</td>
						<td>${this.content}</td>  
						<td>${new Date(this.creationTime)}</td>
					</tr>`;
            });
		   	content += "</table><br>";
			$("#result").append(content);		
	   	})
		.catch(error => { 
				alert("ERROR", error); console.error(error);
		});	
}
