package tests.day14_testNGFrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DriverIlkTest {
    /*
    POM'de driver olusturmak icin inheritance ile kullandigimiz TestBase class'i yerine
    static yollarla ulasabileceegimiz bir method kullanilmasi tercih edilmistir.

    Driver bizim icin cok önemli old Driver icin bagimsiz bir class olusturacagiz
     */
    @Test
    public void test01(){
        //Amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com/");

        // Nutella icin arama yapin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // Arama sonuclarinin Nutella kelimesi icerdigini test edin

        WebElement sonucElementi=Driver.getDriver().findElement(By.xpath("(//div[@class='sg-col-inner'])[1]" ));

        String expectedIcerik="Nutella";
        String actualSonuc=sonucElementi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }
}
