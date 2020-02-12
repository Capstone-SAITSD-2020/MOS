/**
 * @author 747136
 * 
 * This script is for loading the Staff from the database and displaying it on the webpage
 * 
 * This script will call a GET request to the REST service class and return objects in json format.
 * 
 * This script then dynamically adds table rows and cells with the information returned and pastes it
 * on the webpage.
 */

	var request = new XMLHttpRequest()

	request.open('GET', 'http://localhost:8080/MOS/resources/staffmanagement/staff')

	
	request.onload = function() {

		var data = JSON.parse(this.response)

		var table = document.getElementById("staffListTable")
		

		for (var i = 0; i < data.length; i++) {

			var rowCount = table.rows.length
			var row = table.insertRow(rowCount)
			
			var tableData0 = row.insertCell(0)
			var tableData1 = row.insertCell(1)
			var tableData2 = row.insertCell(2)
			var tableData3 = row.insertCell(3)
			var tableData4 = row.insertCell(4)
			
			var editButton = document.createElement("input")
			editButton.type = "button"
			editButton.value = "Edit"
			editButton.className = "btn btn-primary"
			editButton.onclick = function() {$('#editModal').modal('toggle')}
			

			var deleteButton = document.createElement("input")
			deleteButton.type = "button"
			deleteButton.value = "Delete"
			deleteButton.className = "btn btn-primary"
			deleteButton.onclick = function() {$('#deleteModal').modal('toggle')}

			var tableData5 = row.insertCell(5)
			var tableData6 = row.insertCell(6)

			tableData0.innerHTML = data[i].sID
			tableData1.innerHTML = data[i].sID
			tableData2.innerHTML = data[i].fName
			tableData3.innerHTML = data[i].lName
			tableData4.innerHTML = data[i].contactNum
			tableData5.appendChild(editButton)
			tableData6.appendChild(deleteButton)
		}
		
	}


	request.send()