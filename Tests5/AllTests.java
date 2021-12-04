import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestsRegistEdge.class, TestsLoginEdge.class, TestsEdge.class,
	TestsRegistFirefox.class, TestsLoginFirefox.class, TestsFirefox.class,
	TestsRegistChrome.class, TestsLoginChrome.class, TestsChrome.class})
public class AllTests
{
    @BeforeClass
    public static void setUp()
    {
        System.out.println("Runs before all tests in the annotation above.");
    }

    @AfterClass
    public static void tearDown()
    {
        System.out.println("Runs after all tests in the annotation above.");
    }
}