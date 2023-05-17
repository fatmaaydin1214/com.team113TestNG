package tests.day14_testNGFrameworkOlusturma;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C02_Ignore {
    @Test(priority = 15)
    public void youTubeTesti(){
        System.out.println("Youtube");
    }
    @Test(priority =-1) @Ignore
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }
    @Test
    public void amazonTesti(){
        System.out.println("Amazon");
    }
}
