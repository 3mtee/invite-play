import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void MessageTest() {
        MessageValue enValue = new MessageValue("en", "Hello");
        MessageValue ruValue = new MessageValue("en", "Привет");
        Message message = new Message();
        message.messageKey = "hello";
        message.addValue(enValue);
        message.addValue(ruValue);

        Message.getTranslation("en", "hello");


    }

}
