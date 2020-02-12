/**
 * 
 */
package rest;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import brokers.StaffBroker;
import model.Staff;

/**
 * @author 747136
 * 
 * This Class is used to manage the REST requests
 * of the Staff management use case. This class
 * can handle GET, POST, DELETE, PUT requests.
 * The paths are all specified as "/"
 * 
 * Please inform @author 747136 of any changes
 * that are suggested to be made.
 *
 */
@Path("staffmanagement")
public class StaffManageRest {
	
	/**
	 * Post method for inserting a new staff member into the database.
	 * @param pin String pin number of the staff
	 * @param isActive String active status of the staff
	 * @param lName String lastname of the staff
	 * @param fName String firstname of the staff
	 * @param jobID String jobID for the staff
	 * @param contactNum String Contact phone number for the staff
	 * @return a response with the obect to be returned to the view
	 */
	@Path("staff")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewStaff(@FormParam("pin") String pin,
								@FormParam("lName") String lName,
								@FormParam("fName") String fName,
								@FormParam("jobID") int jobID,
								@FormParam("contactNum") String contactNum) {
		
		Staff staff = new Staff();
		staff.setPin(pin);
		staff.setJobID(jobID);
		staff.setlName(lName);
		staff.setfName(fName);
		staff.setContactNum(contactNum);
		
		StaffBroker sb = new StaffBroker();
		
		try {
			sb.insert(staff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Response.status(200).entity(staff).build();
	}
	
	/**
	 * This method gets a list of Staff objects using 
	 * GET to return the list. Returns it in the 
	 * format of a json object
	 * @return Response object that contains the list object for the staff
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	@Path("staff")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStaff() throws SQLException {
		StaffBroker sb = new StaffBroker();
		
		
		ArrayList<Staff> staffList = (ArrayList<Staff>) sb.findAll();
		
		
		return Response.status(200).entity(staffList).build();
//		return staffList;
	}
	
	/**
	 * This method is used to get a single staff
	 * object. This method uses the GET request
	 * to return the object. It will be returned 
	 * in the format of a json object.
	 * @param staff Staff object to be retrievedd
	 * @return
	 */
	@Path("/Staff/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getStaff(@PathParam("id") String id) {
		
		StaffBroker sb = new StaffBroker();
		//TODO: Need a method to get a single staff
		return Response.ok().build();
	}
	
	/**
	 * This method removes a staff object.
	 * This method uses the DELETE request
	 * to remove the staff object. 
	 * @param staff Staff object to be deleted
	 * @return A response object containing the
	 * 			response if the staff was deleted.
	 */
	@Path("staff/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeStaff(Staff staff) {
		boolean deleted = false;
		StaffBroker sb = new StaffBroker();
		try {
			deleted = sb.delete(staff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(200).entity(deleted).build();
	}
	
	/**
	 * PUT method for inserting a new staff member into the database.
	 * @param pin String pin number of the staff
	 * @param isActive String active status of the staff
	 * @param lName String lastname of the staff
	 * @param fName String firstname of the staff
	 * @param jobID String jobID for the staff
	 * @param contactNum String Contact phone number for the staff
	 * @return a response with the obect to be returned to the view
	 */
	@Path("staff/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStaff(@FormParam("pin") String pin,
								@FormParam("lName") String lName,
								@FormParam("fName") String fName,
								@FormParam("jobID") String jobID,
								@FormParam("contactNum") String contactNum) {
		
		Staff staff = new Staff();
		staff.setPin(pin);
		staff.setlName(lName);
		staff.setfName(fName);
		staff.setContactNum(contactNum);
		
		StaffBroker sb = new StaffBroker();
		
		try {
			sb.update(staff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Response.status(200).entity(staff).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
