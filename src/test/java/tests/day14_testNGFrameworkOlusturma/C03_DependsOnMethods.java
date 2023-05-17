package tests.day14_testNGFrameworkOlusturma;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C03_DependsOnMethods {
    @Test(dependsOnMethods= "wiseTesti")
    public void youTubeTesti(){
        System.out.println("Youtube");
        Assert.assertTrue(8==8);
    }
    @Test(priority =3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }
    @Test(dependsOnMethods ="youTubeTesti")
    public void amazonTesti(){
        System.out.println("Amazon");
    }
}
