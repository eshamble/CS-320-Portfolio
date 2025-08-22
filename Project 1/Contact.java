public class Contact {
    //id cannot be reassigned.
    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String id, String firstName, String lastName,
                   String phone, String address){
        //id can't be longer than 10 characters, and can't be null.
        checkString(id, "id", 10, 0);

        //firstName can't be longer than 10 characters, and can't be null.
        checkString(firstName, "first name", 10, 0);

        //lastName can't be longer than 10 characters, and can't be null.
        checkString(lastName, "last name", 10, 0);

        //phone must be 10 characters, and can't be null.
        checkString(phone, "phone number", 10, 10);

        //address can't be longer than 30 characters, and can't be null.
        checkString(address, "address", 30, 0);

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public void setFirstName(String firstName){
        //firstName can't be longer than 10 characters, and can't be null.
        checkString(firstName, "first name", 10, 0);
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        //lastName can't be longer than 10 characters, and can't be null.
        checkString(lastName, "last name", 10, 0);
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phone){
        //phone must be 10 characters, and can't be null.
        checkString(phone, "phone number", 10, 10);
        this.phone = phone;
    }

    public void setAddress(String address){
        //address can't be longer than 30 characters, and can't be null.
        checkString(address, "address", 30, 0);
        this.address = address;
    }

    public String getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhoneNumber(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    //This function validates a string by checking if it's null, and checking it against
    // the upper and lower boundary for its length.
    //If the string is invalid, it throws an exception that contains the name of
    // the variable it was meant for.
    private void checkString(String string, String varName, int upperBound, int lowerBound){
        if(string == null || string.length() > upperBound || string.length() < lowerBound){
            throw new IllegalArgumentException("Invalid " + varName);
        }
        if(varName.equals("phone number") && !string.matches("\\d{10}")){
            throw new IllegalArgumentException("Invalid " + varName);
        }
    }
}
