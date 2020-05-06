package pl.coderstrust.myownarraylist;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyOwnArrayListTest extends ListBaseTest<Long> {

    @Override
    public List<Long> createList() {
        return new MyOwnArrayList<>();
    }

    @Override
    protected Long wrap(Long number) {
        return number;
    }

    @Override
    protected void genericAssertEquals(Object expected, Object actual) {
        assertEquals(expected, (Long) actual);
    }
}
