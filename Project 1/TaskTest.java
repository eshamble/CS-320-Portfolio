import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    String expectedId = "Invalid id";
    String expectedName = "Invalid name";
    String expectedDescription = "Invalid description";


    //id

    //Is id required?
    // There is no constructor that does not contain id.

    //Is id unique?
    // This is addressed in the taskServiceTest class.

    @Test
    public void req1ContainsIdSuccess(){
        //Does task contain an id?
        Task task = new Task("task","name","description");
        assertEquals("task",task.getId());
    }

    @Test
    public void req1IdOver10CharactersCreateFails(){
        //Does task's id need to be under 10 characters?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("over 10 characters","name","description");
        });

        assertEquals(expectedId, exception.getMessage());
    }

    @Test
    public void req1IdNullCreateFails(){
        //Does task's id need to be not null?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(null,"name","description");
        });

        assertEquals(expectedId, exception.getMessage());
    }

    //Can id be updated?
    //No, there is no setter for id.


    //name

    //Is name required?
    //There is no constructor without a name.

    @Test
    public void req2ContainsNameSuccess(){
        //Does task contain a name?
        Task task = new Task("task","name","description");
        assertEquals("name",task.getName());
    }

    //Can name be longer than 20 characters?
    @Test
    public void req2NameOver20CharactersCreateFails(){
        //Does task's name need to be under 20 characters?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("task",
                    "over 20 characters over 20 characters","description");
        });

        assertEquals(expectedName, exception.getMessage());
    }

    @Test
    public void req2Over20CharactersModifyFails(){
        //Does task's name need to be under 20 characters?
        Task task = new Task("task","name","description");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setName("over 20 characters over 20 characters");
        });

        assertEquals(expectedName, exception.getMessage());
    }

    //Can name be null?
    @Test
    public void req2NameNullCreateFails(){
        //Does task's name need to be not null?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("task",
                    null,"description");
        });

        assertEquals(expectedName, exception.getMessage());
    }

    @Test
    public void req2NameNullModifyFails(){
        //Does task's name need to be not null?
        Task task = new Task("task","name","description");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });

        assertEquals(expectedName, exception.getMessage());
    }


    //description

    //Is description required?
    //There is no constructor without a description.

    @Test
    public void req3ContainsNameSuccess(){
        //Does task contain a name?
        Task task = new Task("task","name","description");
        assertEquals("description",task.getDescription());
    }

    //Can name be longer than 50 characters?
    @Test
    public void req3DescriptionOver50CharactersCreateFails(){
        //Does task's name need to be under 20 characters?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("task",
                    "name","Lorem ipsum dolor sit amet, consectetur " +
                    "adipiscing elit. Ut luctus metus at scelerisque fermentum. " +
                    "Curabitur felis ante, molestie at blandit. ");
        });

        assertEquals(expectedDescription, exception.getMessage());
    }

    @Test
    public void req3DescriptionOver50CharactersModifyFails(){
        //Does task's name need to be under 20 characters?
        Task task = new Task("task","name","description");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing " +
                    "elit. Ut luctus metus at scelerisque fermentum. Curabitur felis " +
                    "ante, molestie at blandit. ");
        });

        assertEquals(expectedDescription, exception.getMessage());
    }

    //Can description be null?
    @Test
    public void req3DescriptionNullCreateFails(){
        //Does task's name need to be not null?
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("task",
                    "name",null);
        });

        assertEquals(expectedDescription, exception.getMessage());
    }

    @Test
    public void req3DescriptionNullModifyFails(){
        //Does task's name need to be not null?
        Task task = new Task("task","name","description");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });

        assertEquals(expectedDescription, exception.getMessage());
    }
}
