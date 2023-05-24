package tests.day18_TestNGReports_ParalelCalistirma;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProviderNegatifLoginTest {
    @DataProvider
    public static Object[][] YanlisKullaniciAdlariListesi() {

        String[][] kullaniciBilgileriArayi = {{"Mutlu","12345"},{"Adil","23456"},{"Ufuk","34567"},{"Cigdem","867453"},
                {"Ahmet","32567"},{"Kemal","87654"},
                {"Melike","65747"},{"Cinar","645353"},
                {"Muleyke","6312"},{"Kadir","19870"}};
        return kullaniciBilgileriArayi;
    }

    // verilen 10 kullanici bilgisi ile
    // sisteme giris yapilamadigini test edin
    @Test(dataProvider = "YanlisKullaniciAdlariListesi")
    public void gecersizIsimSifreTesti(String kullaniciAdi, String password){
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        // gecersiz username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(kullaniciAdi);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        qualitydemyPage.cookieAcceptButonu.click();
        ReusableMethods.bekle(2);

        // login butonuna basin
        qualitydemyPage.loginButonu.click();
        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());
        // sayfayi kapatin
        Driver.closeDriver();
    }
}
