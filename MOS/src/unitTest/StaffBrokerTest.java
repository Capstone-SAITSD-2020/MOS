/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.StaffBroker;
import model.Job;
import model.Staff;

/**
 * @author 730693
 *
 */
class StaffBrokerTest<E> {

	StaffBroker<E> sb ;
	Job job_1 ;
	Job job_2 ;
	Job job_3 ;	
	Staff staff_1;
	Staff staff_2;
	Staff staff_3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sb = new StaffBroker<E>();
		Random random = new Random();
		//int ranIndex = random.nextInt(3);
		String[] jobIDs = {"manager", "Staff-PT", "Staff-FT"}; 
		//job_1 = new Job(String.format("%04d", random.nextInt(10000)), jobIDs[ranIndex]);
		if(sb.dataQty("staff") != 0) {
			sb.deleteAll("staff");
		}
		
		if(sb.dataQty("job") != 0) {
			sb.deleteAll("job");
		}

		job_1 = new Job(1, jobIDs[0]);
		job_2 = new Job(2, jobIDs[1]);
		job_3 = new Job(3, jobIDs[2]);
		staff_1 = new Staff(random.nextInt(10000), "1234", "Y", "Test1", "HI", "4031231234",job_1.getjobID());
		staff_2 = new Staff(random.nextInt(10000), "1234", "N", "Test2", "HI", "4031231234", job_2.getjobID());
		staff_3 = new Staff(random.nextInt(10000), "1234", "Y", "Test1", "HI", "4031231234", job_3.getjobID());
		
	}

	/**
	 * Test method for {@link brokers.StaffBroker#insert(model.Job)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsertJob() throws SQLException {
			assertTrue(sb.insert(job_1));
			assertTrue(sb.insert(job_2));
			assertEquals(sb.dataQty("job"), 2);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#insert(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsertStaff() throws SQLException {
		//staff_1.setJobID(job_1.getjobID());
		sb.insert(job_1);
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.dataQty("staff"), 1);
		staff_2.setJobID(job_1.getjobID());
		assertEquals(sb.insert(staff_2), true);
		assertEquals(sb.dataQty("staff"), 2);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#isExisitng(java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testIsExisitng() throws SQLException {
		sb.insert(job_1);
		sb.insert(staff_1);
		assertTrue(sb.isExisitng("job", job_1.getjobID()));
		assertTrue(sb.isExisitng("staff", staff_1.getsID()));
		assertEquals(sb.isExisitng("job", job_2.getjobID()), false);
		assertEquals(sb.isExisitng("staff", staff_2.getsID()),false);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#finddyIDList(java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testFinddyIDList() throws SQLException {
		sb.insert(job_1);
		sb.insert(staff_1);
		System.out.println(sb.findByIDList("job", job_1.getjobID()));
		System.out.println(sb.findByIDList("staff", staff_1.getsID()));
		//assertEquals(sb.findByIDList("job", job_1.getjobID()).get(0), job_1);
	}


	/**
	 * Test method for {@link brokers.StaffBroker#delete(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteStaff() throws SQLException {
		assertEquals(sb.insert(job_2), true);
		assertEquals(sb.insert(staff_2), true);
		sb.delete(staff_2);
		assertEquals(sb.dataQty("job"), 1);
		assertEquals(sb.dataQty("staff"), 0);
		assertEquals(sb.insert(job_3), true);
		assertEquals(sb.insert(staff_3), true);
		assertEquals(sb.dataQty("job"), 2);
		assertEquals(sb.dataQty("staff"), 1);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#update(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateStaff() throws SQLException {
		assertEquals(sb.insert(job_1), true);
		assertEquals(sb.insert(job_2), true);
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.insert(staff_2), true);
		staff_1.setfName("update test");
		staff_1.setJobID(job_2.getjobID());
		System.out.println("[Staff_before update] " +staff_1.toString());
		System.out.println(sb.update(staff_1));
	
	}

	/**
	 * Test method for {@link brokers.StaffBroker#update(model.Job)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateJob() throws SQLException {
		assertEquals(sb.insert(job_1), true);
		assertEquals(sb.insert(job_2), true);		
		job_2.setJobName("Fucking job position.");
		System.out.println("[job]" + job_2.getJobName());
		assertEquals(sb.update(job_2),true);
		Job updatedJob = (Job) sb.findByIDList("job", job_2.getjobID()).get(0);
		assertEquals(updatedJob.getJobName(), job_2.getJobName());
		
	}

	
	/**
	 * Test method for {@link brokers.StaffBroker#dataQty(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testDataQty() throws SQLException {
		assertEquals(sb.insert(job_1), true);
		assertEquals(sb.insert(job_2), true);
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.dataQty("staff"), 1);
		staff_2.setJobID(job_1.getjobID());
		assertEquals(sb.insert(staff_2), true);
		assertEquals(sb.dataQty("staff"), 2);
	}

}
