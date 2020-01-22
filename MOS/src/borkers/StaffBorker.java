/**
 * 
 */
package borkers;

import java.sql.Connection;

import server.Connect2Server;

/**
 * @author 730693
 *
 */
public class StaffBorker {
	Connection con = null;
	
	public StaffBorker() {
		if(con == null) {
			con = Connect2Server.Connect();
		}
			System.out.println("[DB connecting]");
		
	}
	//[2020.01.21] for testing
	/*
	public static void main(String[] args) {
		StaffBorker sb = new StaffBorker();		
	
	}
	*/
	
	
}
