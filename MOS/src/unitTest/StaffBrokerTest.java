/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.StaffBroker;
import model.Staff;

/**
 * @author 730693
 *
 */
class StaffBrokerTest<E> {

	StaffBroker sb ;
	Staff staff_1;
	Staff staff_2;
	Staff staff_3;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sb = new StaffBroker();
		Random random = new Random();
		//int ranIndex = random.nextInt(3);
		String[] jobIDs = {"manager", "Staff-PT", "Staff-FT"}; 
		//job_1 = new Job(String.format("%04d", random.nextInt(10000)), jobIDs[ranIndex]);
		if(sb.dataQty() != 0) {
			sb.deleteAll();
		}		

		staff_1 = new Staff(random.nextInt(10000), "1234", "Y", "Test1", "HI", "4031231234",jobIDs[0]);
		staff_2 = new Staff(random.nextInt(10000), "1234", "N", "Test2", "HI", "4031231234", jobIDs[1]);
		staff_3 = new Staff(random.nextInt(10000), "1234", "Y", "Test1", "HI", "4031231234", jobIDs[2]);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#insert(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsert() throws SQLException {
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.dataQty(), 1);
		assertEquals(sb.insert(staff_2), true);
		assertEquals(sb.dataQty(), 2);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#isExisitng(int)}.
	 * @throws SQLException 
	 */
	@Test
	void testIsExisitng() throws SQLException {
		sb.insert(staff_1);
		assertTrue(sb.isExisitng(staff_1.getsID()));
		assertEquals(sb.isExisitng(staff_2.getsID()),false);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#findByIDList(int)}.
	 */
	@Test
	void testFindByIDList() throws SQLException{
		sb.insert(staff_1);
		System.out.println(sb.findByIDList( staff_1.getsID()));
		//assertEquals(sb.findByIDList("job", job_1.getjobID()).get(0), job_1);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#delete(int)}.
	 */
	@Test
	void testDeleteByID()throws SQLException {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link brokers.StaffBroker#delete(model.Staff)}.
	 */
	@Test
	void testDeleteStaff()throws SQLException {
		assertEquals(sb.insert(staff_2), true);
		sb.delete(staff_2.getsID());
		assertEquals(sb.dataQty(), 1);
		assertEquals(sb.dataQty(), 0);
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.dataQty(), 1);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#update(model.Staff)}.
	 */
	@Test
	void testUpdate()throws SQLException {
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.insert(staff_2), true);
		staff_1.setfName("update test");
		staff_1.setJobName("Staff-FTTTT");
		System.out.println("[Staff_before update] " +staff_1.toString());
		System.out.println(sb.update(staff_1));
	}

	

	/**
	 * Test method for {@link brokers.StaffBroker#findAll()}.
	 */
	@Test
	void testFindAll()throws SQLException {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link brokers.StaffBroker#dataQty()}.
	 */
	@Test
	void testDataQty()throws SQLException {
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.dataQty(), 1);
		assertEquals(sb.insert(staff_2), true);
		assertEquals(sb.dataQty(), 2);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#deleteAll()}.
	 */
	@Test
	void testDeleteAll()throws SQLException {
		fail("Not yet implemented");
	}

}
