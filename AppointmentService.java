import java.util.Date;
import java.util.HashMap;

public class AppointmentService {

    private final HashMap<String, Appointment> appointmentList = new HashMap<>();

    //The appointment service shall be able to add appointments with a unique appointment ID.
    public void addAppointment(String id, Date date, String description){
        if(!appointmentExists(id)){
            Appointment a = new Appointment(id, date, description);
            appointmentList.put(id,a);
        } else{
            throw new IllegalArgumentException("Duplicate id");
        }
    }

    //The appointment service shall be able to delete appointments per appointment ID.
    public void removeAppointment(String id){
        if(!appointmentExists(id)){
            throw new IllegalArgumentException("No appointment found");
        }
        appointmentList.remove(id);
    }

    //Getters and setters for date and description. Commented out because they're
    // not required, but I think it made sense to have them on standby, as
    // appointments sound like a thing you should be able to edit.

//    public void setDate(String id, Date date){
//        appointmentList.get(id).setDate(date);
//    }
//
//    public void setDescription(String id, String description){
//        appointmentList.get(id).setDescription(description);
//    }
//
//    public Date getDate(String id){
//        return appointmentList.get(id).getDate();
//    }
//
//    public String getDescription(String id){
//        return appointmentList.get(id).getDescription();
//    }

    public boolean appointmentExists(String id){
        if(appointmentList.get(id) == null){
            return false;
        }
        return true;
    }
}
