/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Job;
import model.Staff;
import server.*;

/**
 * @author 730693
 *
 */
public class StaffBroker {
	StmtsMySQL stmts ; 
	Connect2Server c2s;
	Connection con = null;
	Job job;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	public StaffBroker() {
		
	}
	
	public boolean insert(Staff staff) throws SQLException {
		//connect;
		boolean result = false;
		con = c2s.connect();
		if(con != null) {
			try {			
					// MYSQL insert statement
					String stmt = " insert into staff (sID, fName, lName, contactNum, jobID, pin)"
							+ " values (?, ?, ?, ?, ?, ?)";
					//create MySQL insert preparedstatement
					preparedStmt = con.prepareStatement(stmt);
					preparedStmt.setString (1, staff.getsID());
					preparedStmt.setString (2, staff.getfName());
					preparedStmt.setString (3, staff.getlName());
					preparedStmt.setString (4, staff.getContactNum());
					preparedStmt.setString (5, staff.getJobID());
					preparedStmt.setString (6, staff.getPin());			
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
	
	//search staff
	public int findByID(String ID) throws SQLException {
		//connect
		int result= -1;
		con = c2s.connect();
		if(con != null) {
			String stmt = "select count(*) from staff where sID = " + ID;
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
		return result;
		
	}
	
	
	//delete
	public boolean delete(String staffID) throws SQLException {
		int verifyID = findByID(staffID) ;
		if(verifyID > 1) {
			System.out.println("duplicate staffID, please check input data or database.");
		}else if(verifyID < 1) {
			System.out.println("StaffID doesn't exist.");
		}else {
			//connect
			con = c2s.connect();
			if(con != null) {
				String stmt = "delete from staff where sID = "+ staffID;
				preparedStmt = con.prepareStatement(stmt);
				if( preparedStmt.executeUpdate() ==1) {
					return true;				}
					
			}else {
				System.out.println("Connecting fail, please check settings.");
			}
			preparedStmt.close();
			con.close();
			return false;
		}
		return false;
	}
	
	//delete
		public boolean delete(Staff staff) throws SQLException  {
			int verifyID = findByID(staff.getsID()) ;
			if(verifyID > 1) {
				System.out.println("duplicate staffID, please check input data or database.");
			}else if(verifyID < 1) {
				System.out.println("StaffID doesn't exist.");
			}else {
				//connect
				con = c2s.connect();
				if(con != null) {
					String stmt = "delete from staff where sID = "+ staff.getsID();
					preparedStmt = con.prepareStatement(stmt);
					if( preparedStmt.executeUpdate() ==1) {
						return true;				}
						
				}else {
					System.out.println("Connecting fail, please check settings.");
				}
				preparedStmt.close();
				con.close();
				return false;
			}
			return false;
		}
	
		//update
		
		public int update(Staff staff) throws SQLException{
			
			return 0;
			
		}
		
	
	//[2020.01.21] for testing
	/*
	public static void main(String[] args) {
		StaffBorker sb = new StaffBorker();		
	
	}
	*/
	
	
}
