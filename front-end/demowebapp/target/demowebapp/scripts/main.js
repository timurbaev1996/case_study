var rootURL = "rws/services";

function validateUserId()
{
    loginFromForm();
}

function testConnection() {
	console.log('testConnection');
	$.ajax({
		method: 'GET',
		url: rootURL+'/testConnection',
		dataType: "text", // data type of response
		success : function(result) {
                        //alert(result);
                        if (result === "true") {
//                            alert("Successful connection");

                            document.querySelector('#connectiontext').innerText = "Successful connection";
                            document.querySelector('#connectiontext').disabled = "disabled";
                            
                        } else {
//                            alert("Unsuccessful  connection");
                            document.querySelector('#connectiontext').innerText = "Unsuccessful connection";
                            document.querySelector('#connectiontext').setEnabled = "false";


                        }
			
			}
	});
  
     
       
        
}
