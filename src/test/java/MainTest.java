import pages.WasHomePage;
import org.testng.annotations.Test;

public class MainTest extends WasHomePage {

    public static final String main = "main";

    @Test(groups = {main})
    public void firstTest(){
        getWASAdminPage()
                .logIn()
                .logOut()
                .logIn()
                .logOut()
                .logIn()
                .logOut()
                .logIn()
                .logIn();
    }
}
