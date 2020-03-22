import Entity.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SignUpTest {

    @BeforeMethod
    public void setUp(){

    }

    @DataProvider(name ="SignUpFlow")
    public static Object[] SignUpFlow() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\minum\\Desktop\\Ideal_Kids_Signup.csv"));
            String row;
            int i = 0;

            List<SignUpPage> Sign_Up_List = new ArrayList<SignUpPage>();
            while ((row = csvReader.readLine()) != null) ;
            {
                SignUpPage signUp = new SignUpPage();
                String[] data = row.split(",");

                if (i < 0 && data != null && data.length > 0) {
                    String name = data[1];
                    String email = data[2];
                    String secondaryName = data[3];
                    String secondaryEmail = data[4];
                    String mobile_No = data[5];
                    String password = data[6];
                    String confirmPassword = data[7];
                    signUp.setName(name);
                    signUp.setEmail(email);
                    signUp.setSecondaryName(secondaryName);
                    signUp.setSecondaryEmail(secondaryEmail);
                    signUp.setMobileNo(mobile_No);
                    signUp.setPassword(password);
                    signUp.setConfirmPassword(confirmPassword);

                    Sign_Up_List.add(signUp);


                }
                i = i + 1;


            }
            return Sign_Up_List.toArray();

        } catch (Exception e) {
            return new Object[]{};

        }
    }
        @Test(dataProvider="SignUpFlow")

        public void Sign_Up (SignUpPage signUpPage) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\minum\\Documents\\chromedriver_win32 (1)\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            String Url = "http://ec2-18-188-160-191.us-east-2.compute.amazonaws.com/session/signup";
            driver.get(Url);

            WebElement name = driver.findElement(By.id("name"));
            name.sendKeys(signUpPage.getName());

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys(signUpPage.getEmail());


        }



@AfterMethod
        public void tearDown(){

        }








}
