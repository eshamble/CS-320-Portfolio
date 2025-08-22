import java.util.HashMap;

public class ContactService {

    private final HashMap<String, Contact> contactList = new HashMap<>();

    //The contact service shall be able to add contacts with a unique ID.
    public void addContact(String id, String firstName, String lastName,
                              String phone, String address){
        if(!contactExists(id)){
            Contact c = new Contact(id, firstName, lastName, phone, address);
            contactList.put(id,c);
        } else{
            throw new IllegalArgumentException("Duplicate id");
        }
    }

    //The contact service shall be able to delete contacts per contact ID.
    public void removeContact(String id){
        contactList.remove(id);
    }

    //Returns true if the contact exists.
    //Returns false if it doesn't.
    public boolean contactExists(String id){
        if(contactList.get(id) == null){
            return false;
        }
        return true;
    }

    //The contact service shall be able to update contact fields per contact ID.
    // The following fields are updatable:
    // firstName
    // lastName
    // Number
    // Address

    public void setFirstName(String id, String firstName){
        contactList.get(id).setFirstName(firstName);
    }

    public void setLastName(String id, String lastName){
        contactList.get(id).setLastName(lastName);
    }

    public void setPhoneNumber(String id, String phone){
        contactList.get(id).setPhoneNumber(phone);
    }

    public void setAddress(String id, String address){
        contactList.get(id).setAddress(address);
    }

    //getters
    public String getFirstName(String id){
        return contactList.get(id).getFirstName();
    }

    public String getLastName(String id){
        return contactList.get(id).getLastName();
    }

    public String getPhoneNumber(String id){
        return contactList.get(id).getPhoneNumber();
    }

    public String getAddress(String id){
        return contactList.get(id).getAddress();
    }

}
