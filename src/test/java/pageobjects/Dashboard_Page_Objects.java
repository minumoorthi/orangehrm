package pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class Dashboard_Page_Objects {
    @FindBy(xpath = "//*[@id=\"task-list-group-panel-menu_holder\"]")
    public static WebElement pendingLeaveRequests;
}
