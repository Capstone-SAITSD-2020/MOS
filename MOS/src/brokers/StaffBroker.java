/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Job;
import model.Staff;
import server.Connect2Server;

/**
 * @author 730693
 * StaffBroker:	
 * 	Communicating DB and Model
 *
 */
public class StaffBroker {
	Connect2Server c2s;
	Connection con = null;
	Job job;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	public StaffBroker() {
		
	}
	
	/**
	 * insert data into database
	 * @param object Staff staff
	 * @return boolean  true if insert is success, otherwise the return is false
	 * @throws SQLException  Exception if SQL has any problem.
	 */
	
	public boolean insert(Staff staff) throws SQLException {
		//connect;
		boolean result = false;
		con = c2s.connect();
		if(con != null) {
			try {			
					// MYSQL insert statement
					String stmt = " insert into staff (sID, pin, isActive, fName, lName, contactNum, jobID)"
							+ " values (?, ?, ?, ?, ?, ?,?)";
					//create MySQL insert preparedstatement
					preparedStmt = con.prepareStatement(stmt);
					preparedStmt.setString (1, staff.getsID());
					preparedStmt.setString (2, staff.getPin());
					preparedStmt.setString (3, staff.getIsActive());	
					preparedStmt.setString (4, staff.getfName());
					preparedStmt.setString (5, staff.getlName());
					preparedStmt.setString (6, staff.getContactNum());
					preparedStmt.setString (7, staff.getJobID());
		
			      // execute the preparedstatement
			     
					result = preparedStmt.execute();	     
			} catch (SQLException e) {
				con.close();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Connecting fail, please check settings.");
		}
		preparedStmt.close();
		con.close();
		return result;		
	}	
	
	/**
	 * isIDexisitng
	 * 	check ID is existing or not.
	 * @param ID 4 characters ID
	 * @return boolean indicating the staff ID is existing in DB, or not
	 * @throws SQLException
	 */
	public boolean isIDexisitng(String sID) throws SQLException {
		//connect
		int result= -1;
		con = c2s.connect();
		if(con != null) {
			String stmt = "select count(*) from staff where sID = " + sID;
			preparedStmt = con.prepareStatement(stmt);
			 rs = preparedStmt.executeQuery(stmt);
			 rs.next();
			 result = rs.getInt(1);
		}else {
			System.out.println("Connecting server fail.");
		}
		preparedStmt.close();
		rs.close();
		con.close();	
		
		return result > 0 ? true : false;		
	}
	
	/**
	 * findByID2
	 * @param ID 4 characters ID
	 * @return list of searching result.
	 * @throws SQLException
	 */
	public List<Staff> findByID2List(String sID) throws SQLException {
		//connect
		con = c2s.connect();
		if(con != null) {
			String stmt = "select count(*) from staff where sID = " + sID;
			preparedStmt = con.prepareStatement(stmt);
			rs = preparedStmt.executeQuery(stmt);			
		}else {
			System.out.println("Connecting server fail.");
		}
		preparedStmt.close();
		rs.close();
		con.close();		
		return listing(rs); 
		
	}
	
	
	/**
	 * delete 
	 * 	delete data by staffID
	 * @param staffID
	 * @return boolean true, the data has been deleted. False, deleting fail.
	 * @throws SQLException
	 */
	public boolean delete(String staffID) throws SQLException {
		if(isIDexisitng(staffID)) {		
			//connect
			con = c2s.connect();
			if(con != null) {
				String stmt = "delete from staff where sID = "+ staffID;
				preparedStmt = con.prepareStatement(stmt);
				if( preparedStmt.executeUpdate() ==1) {
					return true;				
				}					
			}else {
				System.out.println("Connecting fail, please check settings.");
			}
			preparedStmt.close();
			con.close();
		}else {
			System.out.println("Staff is not existing in staff DB.");
		}
		return false;
	}
	
	/**
	 * delete
	 * 	delete data by Staff object.
	 * @param staff Staff object, the staffID cannot be null(mandatory).
	 * @return boolean true, the data has been deleted. False, deleting fail.
	 * @throws SQLException
	 */
		public boolean delete(Staff staff) throws SQLException  {
			if(isIDexisitng(staff.getsID())) {		
				//connect
				con = c2s.connect();
				if(con != null) {
					String stmt = "delete from staff where sID = "+ staff.getsID();
					preparedStmt = con.prepareStatement(stmt);
					if( preparedStmt.executeUpdate() ==1) {
						return true;				
					}
						
				}else {
					System.out.println("Connecting fail, please check settings.");
				}
				preparedStmt.close();
				con.close();
			}else {
				System.out.println("Staff is not existing in staff DB.");
			}
			return false;
		}
	
		
		/**
		 * update
		 * 	update staff data
		 * @param staff Staff object, staff ID, sID cannot be empty and changed
		 * @return boolean update 
		 * @throws SQLException
		 */
		public Staff update(Staff staff) throws SQLException{
			Staff updatedStaff = null;
			//connect
			con = c2s.connect();
			if(con != null) {
				if(isIDexisitng(staff.getsID())) {
					try {			
						// MYSQL insert statement
						String stmt = " update staff "
								+ "set (pin = ?, isActive = ?, fName =?, lName =?, contactNum = ?, jobID= ?)"
								+ "where sID =" +staff.getsID();
						//create MySQL insert preparedstatement
						preparedStmt = con.prepareStatement(stmt);
						preparedStmt.setString (1, staff.getPin());
						preparedStmt.setString (2, staff.getIsActive());	
						preparedStmt.setString (3, staff.getfName());
						preparedStmt.setString (4, staff.getlName());
						preparedStmt.setString (5, staff.getContactNum());
						preparedStmt.setString (6, staff.getJobID());
			
				      // execute the preparedstatement
				     
						if(preparedStmt.execute()) {
							updatedStaff = findByID2List(staff.getsID()).get(0);
						}	     
				} catch (SQLException e) {
					con.close();
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					System.out.println("Staff ID not existing.");
				}
			}else {
				System.out.println("connectting to database fail.");
			}
			con.close();
			preparedStmt.close();
			return updatedStaff;
			
		}
		
	/**
	 * listing function:
	 * 	covert the data from ResultSet into object list
	 * @param rs ResultSet from database
	 * @return list  staff data
	 * @throws SQLException
	 */
	private List<Staff> listing(ResultSet rs) throws SQLException {
		List<Staff> staffs = new ArrayList<Staff>();
		while(rs.next()) {
			Staff staff = new Staff();
			staff.setsID(rs.getString("sID"));
			staff.setfName(rs.getString("fName"));
			staff.setlName(rs.getString("lName"));
			staff.setPin(rs.getString("pin"));
			staff.setContactNum(rs.getString("contactNum"));
			staff.setJobID(rs.getString("jobID"));
			staff.setIsActive(rs.getString("isActive"));
			staffs.add(staff);
		}
		
		return staffs;
	}	
		
	//[2020.01.21] for testing
	/*
	public static void main(String[] args) {
		StaffBorker sb = new StaffBorker();		
	
	}
	*/
	
	
}
