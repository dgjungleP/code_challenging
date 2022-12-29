package com.jungle.algorithms;

import java.lang.annotation.Target;
import java.util.List;

public class Digraph<T> {
    private List<Point<T>> pointList;


    public static class Point<T> {
        private T entity;
        private Integer input;
        private Integer output;
        private List<Route<T>> route;
    }

    public Digraph<T> addRoute(Route<T> route) {


        return this;
    }

    public Digraph<T> addPoint(Point<T> point) {

        return this;
    }

    public static class Route<T> {
        public T origin;
        public T target;
    }
}
