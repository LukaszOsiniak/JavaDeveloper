package pl.coderstrust.myownarraylist;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends ListBaseTest<Long> {

    @Override
    public List<Long> createList() {
        return new ArrayList<>();
    }

    @Override
    protected Long wrap(Long number) {
        return number;
    }

    @Override
    protected void genericAssertEquals(Object expected, Long actual) {
        assertEquals(expected, actual);
    }
}
