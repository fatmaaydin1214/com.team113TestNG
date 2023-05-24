package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    /*
    DataProvider TestNG'nin test methodu disindan
     teste data saglaamak icin olusturdugu bir yapidir

     Bu yapi iki katli bir array dondurur
     */
    @DataProvider
    public static Object[][] aranacaklarListesi() {
        String[][] aranacaklarArrayi = {{"Apple"},{"Java"},{"Samsung"},{"Faker"},{"Cracker"}};

        return aranacaklarArrayi;
    }

    @Test(dataProvider = "aranacaklarListesi")
    public void test01(String aranacakKelime){
        //Amazona anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //bize list olarak verilen uunlerin hepsi icin
        // arama kutusuna yazip arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        // ve sonuc yazisinin arattiginiz elementin adini icerdigini test edin
        String actualAramaSonucuYazisi = amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik= aranacakKelime;

        Assert.assertTrue(actualAramaSonucuYazisi.contains(expectedIcerik));

        Driver.closeDriver();

    }
}
