import org.testng.annotations.*;

public class FirstTest {

    @BeforeSuite
    public void setup()
    {
        System.out.println("Setup");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before Method");
    }

    @Test
    public void myTest()
    {
        System.out.println("My Test 1");
    }

    @Test
    public void myTest2()
    {
        System.out.println("My Test 2");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After Suite");
    }


}
