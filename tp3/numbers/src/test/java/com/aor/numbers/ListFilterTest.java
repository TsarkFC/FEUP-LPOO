package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFilterTest {
    private List<Integer> list = new ArrayList<>();

    public void initializer() {
        list.add(1);
        list.add(0);
        list.add(-1);
        list.add(5);
    }


    @Test
    public void positiveFilterTest() {
        initializer();
        ListFilterer listFilterer = new ListFilterer(list);
        PositiveFilter positiveFilter = new PositiveFilter();

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);
        expected.add(5);

        List<Integer> result = listFilterer.filter(positiveFilter);

        assertEquals(expected, result);
    }

    @Test
    public void divisibleByFilterTest(){
        initializer();
        ListFilterer listFilterer = new ListFilterer(list);
        DivisibleByFilter divisibleFilter = new DivisibleByFilter(5);

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);

        List<Integer> result = listFilterer.filter(divisibleFilter);

        assertEquals(expected, result);
    }
}
