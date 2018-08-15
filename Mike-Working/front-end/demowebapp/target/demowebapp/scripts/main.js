var rootURL = "rws/services";


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


function validat() {
        var name = $('form');
        var fdata = name.serialize();
	$.ajax({
		method: 'POST',
		url: rootURL+'/validate1',
                data: fdata,
		dataType: "text", // data type of response
		success : function(result) {

                        if (result === "true") {
                            // TODO: Destroy, display table
                            
                            alert("Successful login");
                            
                        } else {
                            alert("Unsuccessful login");
                        }
		}
	});
     
}

function destroy(){
    
}

function displayTable(){
    
}