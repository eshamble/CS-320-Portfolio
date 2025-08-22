import java.util.Date;

public class Appointment {

    private final String id;
    private Date date;
    private String description;

    public Appointment(String id, Date date, String description){
        //The appointment object shall have a required unique appointment ID
        // string that cannot be longer than 10 characters. The appointment ID
        // shall not be null and shall not be updatable.
        checkString(id,"id",10);

        //The appointment object shall have a required appointment Date field.
        // The appointment Date field cannot be in the past. The appointment Date
        // field shall not be null.
        checkDate(date);

        //The appointment object shall have a required description String field that
        // cannot be longer than 50 characters. The description field shall not be null.
        checkString(description,"description",50);

        this.id = id;
        this.date = date;
        this.description = description;
    }

    public String getId(){
        return id;
    }

    //Not necessary per assignment requirements,
    // but would make sense in a full program.
    public void setDate(Date date){
        checkDate(date);
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    //Not necessary per assignment requirements,
    // but would make sense in a full program.
    public void setDescription(String description){
        checkString(description,"description",50);
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    private void checkString(String string, String varName, int upperBound){
        if(string == null || string.length() > upperBound){
            throw new IllegalArgumentException("Invalid " + varName);
        }
    }

    private void checkDate(Date date){
        //The appointment object shall have a required appointment Date field.
        // The appointment Date field cannot be in the past. The appointment Date
        // field shall not be null.
        Date currentDate = new Date(System.currentTimeMillis());
        if(date == null || date.compareTo(currentDate) < 0){
            throw new IllegalArgumentException("Invalid date");
        }
    }
}
