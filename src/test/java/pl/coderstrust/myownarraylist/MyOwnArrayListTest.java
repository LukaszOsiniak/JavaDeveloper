package pl.coderstrust.myownarraylist;

import java.util.List;

public class MyOwnArrayListTest extends ListBaseTest {

    @Override
    public List<Long> createList() {
        return new MyOwnArrayList();
    }
}
