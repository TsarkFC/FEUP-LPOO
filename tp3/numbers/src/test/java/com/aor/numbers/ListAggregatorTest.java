package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.manipulation.Sorter;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyObject;

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

    private List<Integer> list;
    private IListDeduplicator deduplicator;
    private IListSorter sorter;

    @Before
    public void setup(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);

        deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(anyObject())).thenReturn(deduplicated);


        List<Integer> sorted = new ArrayList<>();
        sorted.add(1);
        sorted.add(2);
        sorted.add(4);

        sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(sorted);


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

    @Test
    public void distinct_mockito(){
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(deduplicator, sorter);

        assertEquals(3, distinct);
    }
}