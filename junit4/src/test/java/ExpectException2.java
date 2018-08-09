import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by mtumilowicz on 2018-08-09.
 */
public class ExpectException2 {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void expect_exception() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("test");
        
        throw new RuntimeException("test");
    }
}
