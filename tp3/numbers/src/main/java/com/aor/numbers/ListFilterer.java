package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private List<Integer> list = new ArrayList<>();

    public ListFilterer(List<Integer> list){
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter){
        List<Integer> ret = new ArrayList<>();

        for (Integer number : list){
            if (filter.accept(number)) ret.add(number);
        }

        return ret;
    }
}
