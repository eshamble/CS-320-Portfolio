import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    //1. The contact service shall be able to add contacts with a unique ID.
    @Test
    public void testContactServiceReq1ContactExistsSuccess(){
        //Can the contact service add contacts?
        ContactService c = new ContactService();
        c.addContact("eshamble","Eleanor","Shamble",
                "2158675309","address");
        assertTrue(c.contactExists("eshamble"));

//        assertEquals("Eleanor",c.getFirstName("eshamble"));
//        assertEquals("Shamble",c.getLastName("eshamble"));
//        assertEquals("2158675309",c.getPhoneNumber("eshamble"));
//        assertEquals("address",c.getAddress("eshamble"));
    }

    @Test
    public void testContactServiceReq1FirstNameSuccess() {
        //Can the contact service add contacts accurately?
        ContactService c = new ContactService();
        c.addContact("eshamble","Eleanor","Shamble",
                "2158675309","address");
        assertEquals("Eleanor",c.getFirstName("eshamble"));
    }

    @Test
    public void testContactServiceReq1LastNameSuccess() {
        //Can the contact service add contacts accurately?
        ContactService c = new ContactService();
        c.addContact("eshamble","Eleanor","Shamble",
                "2158675309","address");
        assertEquals("Shamble",c.getLastName("eshamble"));
    }

    @Test
    public void testContactServiceReq1PhoneNumberSuccess() {
        //Can the contact service add contacts accurately?
        ContactService c = new ContactService();
        c.addContact("eshamble","Eleanor","Shamble",
                "2158675309","address");
        assertEquals("2158675309",c.getPhoneNumber("eshamble"));
    }

    @Test
    public void testContactServiceReq1AddressSuccess() {
        //Can the contact service add contacts accurately?
        ContactService c = new ContactService();
        c.addContact("eshamble","Eleanor","Shamble",
                "2158675309","address");
        assertEquals("address",c.getAddress("eshamble"));
    }

    @Test
    public void testContactServiceReq1DuplicateContactFails() {
        //Can the contact service add contacts with a nonunique id?
        ContactService c = new ContactService();
        String expected = "Duplicate id";
        c.addContact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            c.addContact("eshamble", "First", "Last",
                    "2158675300", "Address");
        });
        assertEquals(expected, exception.getMessage());
    }

    //2. The contact service shall be able to delete contacts per contact ID.
    @Test
    public void testContactServiceReq2(){
        ContactService c = new ContactService();
        c.addContact("eshamble","Eleanor","Shamble",
                "2158675309","address");
        c.removeContact("eshamble");
        assertFalse(c.contactExists("eshamble"));
    }

    //3. The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
    //        firstName
    //        lastName
    //        Number
    //        Address

    //There is no function to update an id.

    @Test
    public void testContactServiceReq3FirstNameSuccess() {
        ContactService c = new ContactService();
        c.addContact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        //Can I update the first name?
        c.setFirstName("eshamble", "eleanor");
        assertEquals("eleanor", c.getFirstName("eshamble"));
    }

    @Test
    public void testContactServiceReq3LastNameSuccess() {
        ContactService c = new ContactService();
        c.addContact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        //Can I update the last name?
        c.setLastName("eshamble", "shamble");
        assertEquals("shamble", c.getLastName("eshamble"));
    }

    @Test
    public void testContactServiceReq3PhoneNumberSuccess() {
        ContactService c = new ContactService();
        c.addContact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        //Can I update the phone number?
        c.setPhoneNumber("eshamble", "0000000000");
        assertEquals("0000000000", c.getPhoneNumber("eshamble"));
    }

    @Test
    public void testContactServiceReq3AddressSuccess() {
        ContactService c = new ContactService();
        c.addContact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        //Can I update the phone number?
        c.setAddress("eshamble", "ADDRESS");
        assertEquals("ADDRESS", c.getAddress("eshamble"));
    }

}
