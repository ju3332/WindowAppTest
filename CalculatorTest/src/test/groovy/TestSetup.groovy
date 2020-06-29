import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import java.util.concurrent.TimeUnit

class TestSetup{

    static WindowsDriver CalculatorSession = null
    static WebElement CalculatorResult = null

    static void setup() {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \" cd C:\\Program Files (x86)\\Windows Application Driver\\ && WinAppDriver.exe\"")
            DesiredCapabilities capabilities = new DesiredCapabilities()
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App")
            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities)
            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)

            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults")
            Assert.assertNotNull(CalculatorResult)

        }catch(Exception e){
            e.printStackTrace()
        } finally {
        }
    }

    static void TearDown() throws IOException {
        CalculatorResult = null
        if (CalculatorSession != null) {
            CalculatorSession.quit()
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \" taskkill /F /IM WinAppDriver.exe \"")
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe")
            sleep(2000)
        }
        CalculatorSession = null;

    }
}