import org.junit.Test;

/**
 * Created by mtumilowicz on 2018-08-09.
 */
public class ExpectException1Test {
    
    @Test(expected = RuntimeException.class)
    public void expect_exception() {
        throw new RuntimeException();
    }
}
