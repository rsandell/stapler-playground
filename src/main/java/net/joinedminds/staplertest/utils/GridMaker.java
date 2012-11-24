package net.joinedminds.staplertest.utils;

import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-24
 * Time: 00:12
 * To change this template use File | Settings | File Templates.
 */
public class GridMaker<T> {

    private Collection<T> source;
    private int columns;
    private List<List<T>> rows;

    public GridMaker(Collection<T> source, int columns) {
        this.source = source;
        this.columns = columns;

        int realCols = Math.max(columns, 1);
        rows = new ArrayList<List<T>>(source.size() / realCols + 1);
        List<T> currentRow = new ArrayList<T>(realCols);
        rows.add(currentRow);
        for (T s : source) {
            if (currentRow.size() >= realCols) {
                currentRow = new ArrayList<T>(realCols);
                rows.add(currentRow);
            }
            currentRow.add(s);
        }
    }

    public GridMaker(Collection<T> source) {
        this(source, 12);
    }

    public List<List<T>> getRows() {
        return rows;
    }
}
