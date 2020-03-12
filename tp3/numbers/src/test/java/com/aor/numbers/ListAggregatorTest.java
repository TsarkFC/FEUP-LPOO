package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
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
    public void sum() {

        ListAggregator aggregator = new ListAggregator(helper());

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(helper());

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void max_bug7263(){
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(helper());

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator(helper());

        int distinct = aggregator.distinct(new ListDeduplicator(helper()), new ListSorter(helper()));

        assertEquals(4, distinct);
    }

    @Test
    public void distintc_bug8726(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        class Stub implements IListDeduplicator, IListSorter{
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                List<Integer> stublist = new ArrayList<>();
                stublist.add(1);
                stublist.add(2);
                stublist.add(4);

                return stublist;
            }

            @Override
            public List<Integer> sort() {
                List<Integer> stubList = new ArrayList<>();
                stubList.add(1);
                stubList.add(2);
                stubList.add(4);

                return stubList;
            }
        }

        Stub stub = new Stub();

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(stub, stub);

        assertEquals(3, distinct);
    }
}