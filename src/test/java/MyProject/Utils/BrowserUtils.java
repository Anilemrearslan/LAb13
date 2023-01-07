package MyProject.Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    public static void wait(int second){
        try{
            Thread.sleep(1000*second);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
