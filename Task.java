public class Task {
    private final String id;
    private String name;
    private String description;

    public Task(String id, String name, String description){
        //The task object shall have a required unique task ID String that
        // cannot be longer than 10 characters. The task ID shall not be null
        // and shall not be updatable.
        checkString(id,"id",10);

        //The task object shall have a required name String field that cannot
        // be longer than 20 characters. The name field shall not be null.
        checkString(name,"name",20);

        //The task object shall have a required description String field that
        // cannot be longer than 50 characters. The description field shall
        // not be null.
        checkString(description,"description",50);

        this.id = id;
        this.name = name;
        this.description = description;
    }

    //This function validates a string by checking if it's null, and checking it against
    // the upper and lower boundary for its length.
    //If the string is invalid, it throws an exception that contains the name of
    // the variable it was meant for.
    private void checkString(String string, String varName, int upperBound){
        if(string == null || string.length() > upperBound){
            throw new IllegalArgumentException("Invalid " + varName);
        }
    }

    public void setName(String name){
        checkString(name,"name",20);
        this.name = name;
    }

    public void setDescription(String description){
        checkString(description,"description",20);
        this.description = description;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
}
