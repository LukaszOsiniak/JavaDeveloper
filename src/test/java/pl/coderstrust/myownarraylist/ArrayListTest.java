package pl.coderstrust.myownarraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends ListBaseTest {

    @Override
    public List<Long> createList() {
        return new ArrayList<Long>();
    }
}
