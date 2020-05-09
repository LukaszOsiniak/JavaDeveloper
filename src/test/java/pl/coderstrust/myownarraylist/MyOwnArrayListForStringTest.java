package pl.coderstrust.myownarraylist;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyOwnArrayListForStringTest extends ListBaseTest<String> {

    @Override
    public List<String> createList() {
        return new MyOwnArrayList<>();
    }

    @Override
    protected String wrap(Long number) {
        return number.toString();
    }

    @Override
    protected void genericAssertEquals(Object expected, Object actual) {
        assertEquals(expected.toString(), (String) actual);
    }
}
