import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    //REQUIREMENTS:

    //1. The contact object shall have a required unique contact ID string that cannot
    // be longer than 10 characters. The contact ID shall not be null and shall not
    // be updatable.

    //Is id required?
    // There is no constructor that does not contain id.

    //Is id unique?
    // This is addressed in the ContactServiceTest class.

    @Test
    public void testContactReq1ContainsIdSuccess() {
        String expected = "Invalid id";

        //Is id required?
        // There is no constructor that does not contain id.

        //Is id unique?
        // This is addressed in the ContactServiceTest class.

        //Does Contact contain an id?
        Contact c = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        assertEquals("eshamble", c.getId());

    }

    @Test
    public void testContactReq1TooLongIdFails() {
        String expected = "Invalid id";
        //Does the id need to be under 10 characters?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("over ten characters", "Eleanor", "Shamble",
                    "2158675309", "address");
        });

        assertEquals(expected, exception.getMessage());

    }

    @Test
    public void testContactReq1NullIdFails() {
        String expected = "Invalid id";
        //Does the id need to not be null?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact(null, "Eleanor", "Shamble",
                    "2158675309", "address");
        });
        assertEquals(expected, exception.getMessage());

    }

    //Is the id not updatable?
    // There is no existing function to update the ID with.


    //2. The contact object shall have a required firstName String field that cannot
    // be longer than 10 characters. The firstName field shall not be null.

    //Is firstName required?
    // There is no constructor that does not contain firstName.

    @Test
    public void testContactReq2ContainsFirstNameSuccess() {
        String expected = "Invalid first name";

        //Does Contact contain a firstName?
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        assertEquals("Eleanor", cOne.getFirstName());

    }

    @Test
    public void testContactReq2FirstNameTooLongAddFails() {
        //Does the firstName need to be under 10 characters?
        String expected = "Invalid first name";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cTwo = new Contact("eshamble",
                    "over ten characters", "Shamble",
                    "2158675309", "address");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq2FirstNameTooLongChangeFails() {
        //Does the firstName need to be under 10 characters?
        String expected = "Invalid first name";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cOne.setFirstName("over ten characters");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq2FirstNameNullAddFails() {
        //Does the firstName need to not be null?
        String expected = "Invalid first name";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cThree = new Contact("eshamble",
                    null, "Shamble",
                    "2158675309", "address");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq2FirstNameNullChangeFails() {
        //Does the firstName need to not be null?
        String expected = "Invalid first name";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cOne.setFirstName(null);
        });
        assertEquals(expected, exception.getMessage());
    }

    //3. The contact object shall have a required lastName String field that cannot
    // be longer than 10 characters. The lastName field shall not be null.

    //Is lastName required?
    // There is no constructor that does not contain lastName.

    @Test
    public void testContactReq3ContainsLastNameSuccess() {
        //Does Contact contain a lastName?
        String expected = "Invalid last name";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        assertEquals("Shamble", cOne.getLastName());
    }

    @Test
    public void testContactReq3LastNameTooLongAddFails() {
        //Does the lastName need to be under 10 characters?
        String expected = "Invalid last name";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cTwo = new Contact("eshamble", "Eleanor",
                    "over ten characters",
                    "2158675309", "address");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq3LastNameTooLongChangeFails() {
        //Does the lastName need to be under 10 characters?
        String expected = "Invalid last name";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cOne.setLastName("over ten characters");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq3LastNameNullAddFails() {
        //Does the lastName need to not be null?
        String expected = "Invalid last name";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cThree = new Contact("eshamble", "Eleanor",
                    null,
                    "2158675309", "address");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq3LastNameNullChangeFails() {
        //Does the lastName need to not be null?
        String expected = "Invalid last name";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cOne.setLastName(null);
        });
        assertEquals(expected, exception.getMessage());
    }

    //4. The contact object shall have a required phone String field that must be
    // exactly 10 digits. The phone field shall not be null.

    //Is phone required?
    // There is no constructor that does not contain phone.

    @Test
    public void testContactReq4ContainsPhoneNumberSuccess() {
        //Does Contact contain a phone number?
        Contact c = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        assertEquals("2158675309", c.getPhoneNumber());
    }

    @Test
    public void testContactReq4InvalidPhoneNumberHighAddFails() {
        //Does the phone number need to be exactly 10 characters?
        String expected = "Invalid phone number";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cTwo = new Contact("eshamble", "Eleanor", "Shamble",
                    "over ten characters",
                    "address");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq4InvalidPhoneNumberHighChangeFails() {
        //Does the phone number need to be exactly 10 characters?
        String expected = "Invalid phone number";
        Contact c = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            c.setPhoneNumber("over ten characters");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq4InvalidPhoneNumberLowAddFails() {
        //Does the phone number need to be exactly 10 characters?
        String expected = "Invalid phone number";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cThree = new Contact("eshamble", "Eleanor", "Shamble",
                    "< ten",
                    "address");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq4InvalidPhoneNumberLowChangeFails() {
        //Does the phone number need to be exactly 10 characters?
        String expected = "Invalid phone number";
        Contact c = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            c.setPhoneNumber("< ten");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq4InvalidPhoneNumberNullAddFails() {
        //Can the phone number be null?
        String expected = "Invalid phone number";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cFour = new Contact("eshamble", "Eleanor", "Shamble",
                    null,
                    "address");
        });
        assertEquals(expected, exception.getMessage());
    }
    @Test
    public void testContactReq4InvalidPhoneNumberNullChangeFails() {
        //Can the phone number be null?
        String expected = "Invalid phone number";
        Contact c = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            c.setPhoneNumber(null);
        });
        assertEquals(expected, exception.getMessage());

    }

    @Test
    public void testContactReq4InvalidPhoneNumberNonIntegerAddFails() {
        //Can the phone number be a non integer?
        String expected = "Invalid phone number";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cFour = new Contact("eshamble", "Eleanor", "Shamble",
                    "abcdefghij",
                    "address");
        });
        assertEquals(expected, exception.getMessage());
    }
    @Test
    public void testContactReq4InvalidPhoneNumberNonIntegerChangeFails() {
        //Can the phone number be a non integer?
        String expected = "Invalid phone number";
        Contact c = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            c.setPhoneNumber("abcdefghij");
        });
        assertEquals(expected, exception.getMessage());

    }

    //5. The contact object shall have a required address field that must be no
    // longer than 30 characters. The address field shall not be null.

    //Is address required?
    // There is no constructor that does not contain address.

    @Test
    public void testContactReq5ContainsAddressSuccess() {
        //Does Contact contain an address?
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        assertEquals("address", cOne.getAddress());
    }

    @Test
    public void testContactReq5AddressTooLongAddFails() {
        //Does the address need to be under 30 characters?
        String expected = "Invalid address";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cTwo = new Contact("eshamble", "Eleanor", "Shamble",
                    "2158675309",
                    "over thirty characters over thirty characters");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq5AddressTooLongChangeFails() {
        //Does the address need to be under 30 characters?
        String expected = "Invalid address";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cOne.setAddress("over thirty characters over thirty characters");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq5AddressNullAddFails() {
        //Does the address need to not be null?
        String expected = "Invalid address";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Contact cThree = new Contact("eshamble", "Eleanor",
                    "Shamble", "2158675309", null);
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContactReq5AddressNullChangeFails() {
        //Does the address need to not be null?
        String expected = "Invalid address";
        Contact cOne = new Contact("eshamble", "Eleanor", "Shamble",
                "2158675309", "address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cOne.setAddress(null);
        });
        assertEquals(expected, exception.getMessage());
    }

}
