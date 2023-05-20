package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassSonHali {
    //3 tane test meth olusturalim
    //1.meth amazon'a gidip URL'nin amazon icerdigini test edin

    @Test
    public void amazonTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        String expectedIcerik ="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        Driver.closeDriver();
    }

    //2. meth WiseQuarter anasayfaya gidip title'in Wise Quarter icerdigini test edin
    @Test
    public void wiseTest(){

        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));

        String expectedIcerik ="Wise Quarter";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();

    }

    //3.meth Facebook anasayfaya gidip title'in Facebook icerdigini test edin
    @Test
    public void facebookTest(){
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));

        String expectedIcerik ="Facebook";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();

    }
    // her methodda yeni yeni driver olusturup methsonunda driver'i kapatin

}
