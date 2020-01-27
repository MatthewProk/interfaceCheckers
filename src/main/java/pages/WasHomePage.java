package pages;

import com.wiley.page.BasePage;
import interfaceCheckers.LogIn;
import interfaceCheckers.LogOut;
import org.springframework.stereotype.Component;

import static com.wiley.page.PageProvider.get;

@Component
public class WasHomePage extends BasePage
        implements
        LogIn<WasHomePage>,
        LogOut<WasHomePage> {

    protected WasHomePage getWASAdminPage() {
        return get(WasHomePage.class, "https://was-qa.api.wiley.com/was/v1/admin");
    }
}