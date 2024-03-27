package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.EDGE;

public class EdgeDriverManager extends  DriverManager{
    @Override
    protected WebDriver createDriver() {
        if (!super.is64bits()) {
            WebDriverManager.getInstance(EDGE).arch32().setup();
        } else {
            WebDriverManager.getInstance(EDGE).setup();
        }

        return new EdgeDriver();
    }

}
