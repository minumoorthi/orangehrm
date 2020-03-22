import java.util.concurrent.TimeUnit;

public class Video_File {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\minum\\Documents\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Open the page containing video component.
        driver.get("https://www.kaftan.tv/session/category/5d4156f6642e012886771184?title=KAFTAN%20News");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//If video is placed in embed tag or iframe, navigate to the source.
//However, we can even switch to frame. [Else, skip this step]
        WebElement elm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ss-category-home/div[1]/ss-channel-player/button/div/img"));
        String urlStr = elm.getAttribute("src");
        System.out.println("Video Url : " + urlStr);
        driver.navigate().to(urlStr);
        cdrv.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
//Click on play button
        jse.executeScript("jwplayer().play();");
        Thread.sleep(2000);
//Pause
        jse.executeScript("jwplayer().pause()");
        Thread.sleep(2000);
//Play
        jse.executeScript("jwplayer().play();");
        Thread.sleep(2000);
// Set Volume
        Thread.sleep(2000);
        jse.executeScript("jwplayer().setVolume(50);");
        Thread.sleep(2000);
//Mute Player
        jse.executeScript("jwplayer().setMute(true);");
        Thread.sleep(2000);
//UnMute Player
        jse.executeScript("jwplayer().setMute(false);");
        Thread.sleep(2000);
//Stop the player
        jse.executeScript("jwplayer().stop()");
        Thread.sleep(2000);

        driver.quit();




    }


}
