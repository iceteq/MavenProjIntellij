import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    SomeClass sc = new SomeClass(1);
    @Test
    void getVal() {
        assertEquals(1, sc.getVal());
    }
}