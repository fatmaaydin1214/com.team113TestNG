package tests.day14_testNGFrameworkOlusturma;

import org.testng.annotations.Test;

public class C01_Priority {

    //TestNG'de testler normalde alfabetik siraya gore calisir
    // Ayrica priority degeri girerek testleri istedigimiz sira ile de calistirabiliriz
    // (KONTROL EDILEBILIR SIRALAMA)
    // priority sayisal olarak kucukten buyuge dogru testleri calistirir
    // eger priority degeri ayni olan birden fazla test varsa, yine harf sirasina bakar

    @Test(priority = 15)
    public void youTubeTesti(){
        System.out.println("Youtube");
    }
    @Test(priority =-1)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }
    @Test
    public void amazonTesti(){ //priority yazilmazsa 0 degeri alir
        System.out.println("Amazon");
    }
}
