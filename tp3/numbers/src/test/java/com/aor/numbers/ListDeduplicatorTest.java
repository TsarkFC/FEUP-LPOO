package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> helper(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        return list;
    }

    @Test
    public void deduplicate() {

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(helper());
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(helper()));

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug8726(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class Stub implements IListSorter{

            @Override
            public List<Integer> sort() {
                List<Integer> sorted = new ArrayList<>();
                sorted.add(1);
                sorted.add(2);
                sorted.add(2);
                sorted.add(4);

                return sorted;
            }
        }

        Stub stub = new Stub();

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(stub);

        assertEquals(expected, distinct);
    }
}