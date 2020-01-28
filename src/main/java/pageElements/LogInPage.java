package pageElements;

import com.wiley.elements.TeasyElement;
import com.wiley.page.AbstractBlock;
import org.openqa.selenium.By;

import static com.wiley.wat.selenium.WASBy.*;

public class LogInPage extends AbstractBlock {

    private static By LOGIN_FORM_LOCATOR = By.xpath("*//div[child::form[@id='login-form']]");

    private LogInPage(TeasyElement element, boolean isNullElementAllowed) {
        super(element, isNullElementAllowed);
    }

    public LogInPage getLoginForm() {
        return new LogInPage(element(LOGIN_FORM_LOCATOR), false);
    }

    public TeasyElement getEmailField() {
        return element(seleniumId("model-ctx"));
    }

    public TeasyElement getPasswordField(){
        return element(seleniumId("model-password"));
    }

    public TeasyElement getButtonLogIn(){
        return element(By.xpath("//button[@type='submit']"));
    }


}
