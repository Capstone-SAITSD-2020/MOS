/**
 * 
 */

var request = new XMLHttpRequest()
	request.open('GET', 'http://localhost:8080/MOS/resources/staffmanagement/staff/all')

	request.onload = function() {
	
	var data = JSON.parse(this.response)
	var table = document.getElementById("staffTable")
	
		
	for (var i = 0, len = data.length; i < len; i++) {
		
		var insertRow = table.insertRow(1)
		var cell0 = insertRow.insertCell(0)
		var cell1 = insertRow.insertCell(1)
		var cell2 = insertRow.insertCell(2)
		var cell3 = insertRow.insertCell(3)
		
		cell0.innerHTML = data[i].sID
		cell1.innerHTML = data[i].fName
		cell2.innerHTML = data[i].lName
		cell3.innerHTML = data[i].contactNum
//		document.getElementById("lname").innerHTML = data[i].lName
//		document.getElementById("contactnumber").innerHTML = data[i].contactNum
//		document.getElementById("fname").innerHTML = data[i].fName
//		document.getElementById("id").innerHTML = data[i].sID
	}
		
		
		

	
	
}

request.send()