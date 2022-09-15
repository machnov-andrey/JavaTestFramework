import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBase {

    @Test
    public void Test1(){
        Assert.assertEquals(1, 2);
    }

    @Test(description = "test description")
    public void Test2(){
    }
}
