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

import com.mysql.cj.xdevapi.Table;

import model.Job;
import model.Staff;
import server.Connect2Server;
import sun.security.action.GetIntegerAction;

/**
 * @author 730693
 * StaffBroker:	
 * 	Communicating DB and Model
 *  Including job database and staff database
 *
 */
public class StaffBroker<E> {
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	Job job;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	boolean executedResult = false;
	String stmtString="";
	/**
	 * insert
	 * 	insert the jobID and job description 
	 * @param job object JOB
	 * @return boolean , true is success. false is fail.
	 * @throws SQLException
	 */
	public boolean insert(Job job) throws SQLException{		
			//connect;			
		con = c2s.connect();
		if(con != null) {
			try {			
					// MYSQL insert statement
					stmtString = " insert into job (jobID, jobName)"
							+ " values (?, ?)";
					//create MySQL insert preparedstatement
					preparedStmt = con.prepareStatement(stmtString);
					preparedStmt.setInt(1, job.getjobID());
					preparedStmt.setString (2, job.getJobName());
			      // execute the preparedstatement			     
					executedResult = preparedStmt.execute();	     
			} catch (SQLException e) {
				con.close();
				System.out.println("Insert data is wrong. Caused reason: duplication id or data.");
				e.printStackTrace();
			}
		}else {
			System.out.println("Connecting fail, please check settings.");
		}
		preparedStmt.close();
		con.close();
		return executedResult;	
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
					stmtString = " insert into staff (sID, pin, isActive, fName, lName, contactNum, jobID)"
							+ " values (?, ?, ?, ?, ?, ?,?)";
					//create MySQL insert preparedstatement
					preparedStmt = con.prepareStatement(stmtString);
					preparedStmt.setInt(1, staff.getsID());
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
	 * isExisitng
	 * 	check id is existing or not.
	 * @param tableName String 
	 * @param id Sting 4 characters ID
	 * @return boolean indicating the ID is existing in DB, or not
	 * @throws SQLException
	 */
	public boolean isExisitng(String tableName, int id) throws SQLException {
		//connect
		int result= -1;
		con = c2s.connect();
		if(con != null) {
			if(tableName == "staff") {
				stmtString = "select count(*) from staff where sID = " + id;
			}else {
				stmtString = "select count(*) from job where jobID = " + id;
			}
			preparedStmt = con.prepareStatement(stmtString);
			 rs = preparedStmt.executeQuery(stmtString);
			 rs.next();
			 result = rs.getInt(1);
		}else {
			System.out.println("Connecting server fail.");
		}
		preparedStmt.close();
		rs.close();
		con.close();	
		
		return result > 0 ?  true: false;		
	}
	
	/**
	 * findByID
	 * @param ID 4 characters ID
	 * @param tableName String table name
	 * @return list of searching result.
	 * @throws SQLException
	 */
	//public List<Staff> findByIDList( String id) throws SQLException {
	public List<E> findByIDList(String tableName, int id) throws SQLException {
		//connect
		con = c2s.connect();	
		if(con != null) {			
			ArrayList<Staff> resultArrayList = new ArrayList<Staff> (); 
			stmtString = "select count(*) from staff where sID = " + id;	
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery(stmtString);	
		}else {
			System.out.println("Connecting server fail.");
		}
		preparedStmt.close();
		rs.close();
		con.close();		
		return  (List<E>) listing(tableName, rs);
		
	}
	
	
	/**
	 * delete 
	 * 	delete data by staffID
	 * @param tableName String table name
	 * @param id String, size == 4
	 * @return boolean true, the data has been deleted. False, deleting fail.
	 * @throws SQLException
	 */
	public boolean delete(String tableName, int id) throws SQLException {
		if(isExisitng(tableName, id)) {		
			//connect
			con = c2s.connect();
			if(con != null) {
				if(tableName == "staff") {
					stmtString = "delete from staff where sID = "+ id;
				}else {
					stmtString = "delete from job where jobID = "+ id;
				}
				preparedStmt = con.prepareStatement(stmtString);
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
			if(isExisitng("staff", staff.getsID())) {		
				//connect
				con = c2s.connect();
				if(con != null) {
					stmtString = "delete from staff where sID = "+ staff.getsID();
					preparedStmt = con.prepareStatement(stmtString);
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
				if(isExisitng("staff", staff.getsID())) {
					try {			
						// MYSQL insert statement
						stmtString = " update staff "
								+ "set (pin = ?, isActive = ?, fName =?, lName =?, contactNum = ?, jobID= ?)"
								+ "where sID =" +staff.getsID();
						//create MySQL insert preparedstatement
						preparedStmt = con.prepareStatement(stmtString);
						preparedStmt.setString (1, staff.getPin());
						preparedStmt.setString (2, staff.getIsActive());	
						preparedStmt.setString (3, staff.getfName());
						preparedStmt.setString (4, staff.getlName());
						preparedStmt.setString (5, staff.getContactNum());
						preparedStmt.setString (6, staff.getJobID());
			
				      // execute the preparedstatement
				     
						if(preparedStmt.execute()) {
							updatedStaff = (Staff) findByIDList("staff", staff.getsID()).get(0);
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
		 * update
		 * 	update staff data
		 * @param staff Staff object, staff ID, sID cannot be empty and changed
		 * @return boolean update 
		 * @throws SQLException
		 */
		public Job update(Job job) throws SQLException{
			Job updatedJob = null;
			//connect
			con = c2s.connect();
			if(con != null) {
				if(isExisitng("Job", job.getjobID())) {
					try {			
						// MYSQL insert statement
						String stmt = " update job "
								+ "set (jobName = ?)"
								+ "where jobID =" +job.getjobID();
						//create MySQL insert preparedstatement
						preparedStmt = con.prepareStatement(stmt);
						preparedStmt.setString (1, job.getJobName());					
			 	       // execute the preparedstatement
				     
						if(preparedStmt.execute()) {
							updatedJob = (Job) findByIDList("job", job.getjobID()).get(0);
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
			return updatedJob;
			
		}	
		
	/**
	 * listing function:
	 * 	covert the data from ResultSet into object list
	 * @param rs ResultSet from database
	 * @return list  staff data
	 * @throws SQLException
	 */
	public List<E> listing(String tableName, ResultSet rs) throws SQLException {
		if(rs != null) {
			if(tableName =="job") {
				List<Job> jobs = new ArrayList<Job>();
				while(rs.next()) {
					Job job = new Job();
					job.setjobID(rs.getInt("jobID"));
					job.setJobName(rs.getString("jobName"));
				}
				
				return (List<E>) jobs;
			}else {
				List<Staff> staffs = new ArrayList<Staff>();
				while(rs.next()) {
					Staff staff = new Staff();
					staff.setsID(rs.getInt("sID"));
					staff.setfName(rs.getString("fName"));
					staff.setlName(rs.getString("lName"));
					staff.setPin(rs.getString("pin"));
					staff.setContactNum(rs.getString("contactNum"));
					staff.setJobID(rs.getString("jobID"));
					staff.setIsActive(rs.getString("isActive"));
					staffs.add(staff);
				}
				return (List<E>) staffs;
			}
		}
		return null;

	}	
	/**
	 * dataQty 
	 * 	total number of database
	 * @param tableName  the retrieving  data name
	 * @return int the qty of data
	 * @throws SQLException
	 */
	
	public int dataQty(String tableName) throws SQLException {
		//connect
		con = c2s.connect();
		int qty = -1;
		if(con != null) {
			stmtString = "select count(*) from " + tableName;
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery(stmtString);
			rs.next();
			qty = rs.getInt("count(*)");
		}
		System.out.println("total number of data in "+tableName + " is "+ qty);
		rs.close();
		preparedStmt.close();
		con.close();
		return qty;
	}
	
	public boolean deleteAll(String tableName) throws SQLException {
		//connect
		con = c2s.connect();
		boolean executedResult = false;
		System.out.println("cleaning data.....");
		if(con != null) {
			stmtString ="delete from "+ tableName;
			preparedStmt = con.prepareStatement(stmtString);
			executedResult = preparedStmt.execute(stmtString);
		}
		preparedStmt.close();
		con.close();
		return executedResult;
	}
		
	//[2020.01.21] for testing

	public static void main(String[] args) {
		System.out.println("running");
		StaffBroker sb = new StaffBroker();		
	
	}

	
	
}
