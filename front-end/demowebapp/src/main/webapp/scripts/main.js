

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
                            destroy();
                            displayTable();
                            
                        } else {
                            alert("Unsuccessful login");
                        }
		}
	});
     
}

function destroy() {

    var content = document.getElementById("content");
    while (content.firstChild) {
        content.removeChild(content.firstChild);
    }
}
function displayTable(){
	$.ajax({
		method: 'GET',
		url: rootURL+'/displayTable',
               
		dataType: "json", // data type of response
		success : function(result) {   
                    console.log(result);
    
        

            // Retrieve column headers
            var columnHeaders;
            columnHeaders = $.map(result[0], function (val, key) { return key })
            console.log(columnHeaders);

            // Start writing html table code
            var tableBody = '<table id="dataTable" class="row-border hover order-column" style="width:100%">';
            tableBody += '<thead> <tr>';

            // Print column headers
            for (cH in columnHeaders) {
                tableBody += '<th>' + columnHeaders[cH] + '</th>';
            }
            tableBody += '</tr> </thead>';

            // Print table values
            for (row = 0; row < result.length; row++) {
                tableBody += '<tr>';
                for (column in columnHeaders) {
                    tableBody += '<td>' + result[row][columnHeaders[column]] + '</td>';
                }
                tableBody += '</tr>';
            }

            tableBody += '</tbody> </table>';
            $('#dataBaseTable').html(tableBody);
            
            $(document).ready(function () {
            $('#dataTable').DataTable();

        });

                }})}

