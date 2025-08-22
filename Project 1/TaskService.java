import java.util.HashMap;

public class TaskService {

    private final HashMap<String, Task> taskList = new HashMap<>();

    //The task service shall be able to add tasks with a unique ID.
    public void addTask(String id, String name, String description){
        if(!taskExists(id)){
            Task t = new Task(id, name, description);
            taskList.put(id,t);
        } else{
            throw new IllegalArgumentException("Duplicate id");
        }
    }

    //The task service shall be able to delete tasks per task ID.
    public void removeTask(String id){
            taskList.remove(id);
    }


    //The task service shall be able to update task fields per task ID.
    // The following fields are updatable:
            //Name
            //Description
    public void setName(String id, String name){
        taskList.get(id).setName(name);
    }

    public void setDescription(String id, String description){
        taskList.get(id).setDescription(description);
    }

    public String getName(String id){
        return taskList.get(id).getName();
    }

    public String getDescription(String id){
        return taskList.get(id).getDescription();
    }

    //Returns true if the task exists.
    //Returns false if it doesn't.
    public boolean taskExists(String id){
        if(taskList.get(id) == null){
            return false;
        }
        return true;
    }

}
