import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void messageTest() {
        MessageValue enValue = new MessageValue("en", "Hello");
        MessageValue ruValue = new MessageValue("en", "Привет");
        Message message = new Message();
        message.messageKey = "hello";
        message.addValue(enValue);
        message.addValue(ruValue);

        final String translation = Message.getTranslation("en", "hello");
        assertEquals(translation, "Hello");



    }

    @Test
    public void contactTest() {
        Contact contact = new Contact("emtee@gmail.com", "emtee");
        contact.addInvitation();

        assertEquals(contact.invitations.size(), 1);
    }


}
