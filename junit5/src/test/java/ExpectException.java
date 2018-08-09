import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by mtumilowicz on 2018-08-09.
 */
class ExpectException {
    
    @Test
    void expect_exception() {
        Executable executable = () -> new TestedObject().testedMethod("test");

        assertThrows(RuntimeException.class, executable, "test");
    }

    class TestedObject {
        void testedMethod(String param) {
            throw new RuntimeException(param);
        }
    }
}
