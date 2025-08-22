import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    //The task service shall be able to add tasks with a unique ID.
    @Test
    public void testReq1AddTaskSuccess(){
        //Can it add tasks?
        TaskService t = new TaskService();
        t.addTask("task","name","description");
        assertTrue(t.taskExists("task"));
    }

    @Test
    public void testReq1NonUniqueFails(){
        //Do tasks need to have a unique id?
        TaskService t = new TaskService();
        t.addTask("task","name","description");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            t.addTask("task","name1","description1");
        });
        assertEquals("Duplicate id", exception.getMessage());
    }

    //The task service shall be able to delete tasks per task ID.
    @Test
    public void testReq2DeleteTaskSuccess(){
        TaskService t = new TaskService();
        t.addTask("task","name","description");
        t.removeTask("task");
        assertFalse(t.taskExists("task"));
    }

    //The task service shall be able to update task fields per task ID. The following fields are updatable:
            //Name
            //Description
    @Test
    public void testReq3ChangeNameSuccess(){
        TaskService t = new TaskService();
        t.addTask("task","name","description");

        t.setName("task","Name");
        assertEquals("Name",t.getName("task"));
    }

    @Test
    public void testReq3ChangeDescriptionSuccess(){
        TaskService t = new TaskService();
        t.addTask("task","name","description");

        t.setDescription("task","Description");
        assertEquals("Description",t.getDescription("task"));
    }

}
