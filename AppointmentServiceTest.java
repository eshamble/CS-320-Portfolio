import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    //The appointment service shall be able to add appointments with a unique
    // appointment ID.
    @Test
    public void testReq1AddAppointmentSuccess(){
        AppointmentService a = new AppointmentService();
        Date currentDate = new Date(System.currentTimeMillis());
        a.addAppointment("appoint",new Date(currentDate.getTime() + 10),"description");
        assertTrue(a.appointmentExists("appoint"));
    }
    @Test
    public void testReq1NonUniqueIdAddAppointmentFails(){
        //Can I create two appointments with the same id?
        AppointmentService a = new AppointmentService();
        Date currentDate = new Date(System.currentTimeMillis());
        a.addAppointment("appoint",new Date(currentDate.getTime() + 10),"description");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            a.addAppointment("appoint",new Date(currentDate.getTime() + 100),"description1");
        });
        assertEquals("Duplicate id", exception.getMessage());
    }

    //The appointment service shall be able to delete appointments per appointment ID.

    @Test
    public void testReq2DeleteAppointmentSuccess(){
        AppointmentService a = new AppointmentService();
        Date currentDate = new Date(System.currentTimeMillis());
        a.addAppointment("appoint",new Date(currentDate.getTime() + 10),"description");
        a.removeAppointment("appoint");
        assertFalse(a.appointmentExists("appoint"));
    }

    @Test
    public void testReq2DeleteAppointmentFails(){
        //Can I delete a nonexistent appointment?
        AppointmentService a = new AppointmentService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            a.removeAppointment("appoint");
        });
        assertEquals("No appointment found", exception.getMessage());
    }

}