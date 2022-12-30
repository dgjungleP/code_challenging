package com.jungle.algorithms;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.stream.Collectors;

public class Digraph<T> {
    private final List<Point<T>> POINT_LIST = new ArrayList<>();

    public List<T> topologicalSort() {
        if (!checkIsDAG(this)) {
            System.out.println("Can not topological sort if the digraph is not DAG");
            return new ArrayList<>();
        }
        List<Point<T>> starPointList = POINT_LIST.stream().filter(data -> Objects.equals(data.input, 0L))
                .collect(Collectors.toList());
        Stack<T> checkedStack = new Stack<>();
        for (Point<T> point : starPointList) {
            dfs(point, checkedStack);
        }
        return new ArrayList<>(checkedStack);
    }

    private void dfs(Point<T> point, Stack<T> checkedQueue) {
        if (!checkedQueue.contains(point.entity)) {
            checkedQueue.push(point.entity);
            point.route.stream().map(data -> data.target).filter(data -> !data.equals(point.entity)).map(this::getPoint)
                    .forEach(targetPoint -> targetPoint.ifPresent(data -> dfs(data, checkedQueue)));
        }
    }

    private boolean checkIsDAG(Digraph<T> digraph) {
        return true;
    }


    public static class Point<T> {
        private T entity;
        private Long input;
        private Long output;
        private List<Route<T>> route;

        public static <T> Point<T> of(T entity) {
            Point<T> point = new Point<>();
            point.entity = entity;
            point.input = 0L;
            point.output = 0L;
            point.route = new ArrayList<>();
            return point;
        }


        public void merge(Point<T> point) {
            List<Route<T>> mergeRoute = new ArrayList<>();
            mergeRoute.addAll(point.route);
            mergeRoute.addAll(this.route);
            this.route = mergeRoute.stream().distinct().collect(Collectors.toList());
            this.input = route.stream().filter(data -> data.target.equals(entity)).count();
            this.output = route.stream().filter(data -> data.origin.equals(entity)).count();
        }
    }

    public Digraph<T> addRoute(Route<T> route) {
        Point<T> target = Point.of(route.target);
        Point<T> origin = Point.of(route.origin);

        target.route.add(route.copy());
        origin.route.add(route.copy());
        addPoint(target);
        addPoint(origin);


        return this;
    }

    public Digraph<T> addPoint(Point<T> point) {
        getPoint(point.entity).orElseGet(() -> {
            POINT_LIST.add(point);
            return point;
        }).merge(point);
        return this;
    }

    public Optional<Point<T>> getPoint(T entity) {
        return POINT_LIST.stream().filter(data -> data.entity.equals(entity)).findFirst();
    }


    public static class Route<T> {
        public T origin;
        public T target;

        public static <T> Route<T> of(T origin, T target) {
            Route<T> route = new Route<>();
            route.origin = origin;
            route.target = target;
            return route;
        }

        public static <T> Route<T> of(Point<T> origin, Point<T> target) {
            return of(origin.entity, target.entity);
        }

        public Route<T> copy() {
            Route<T> copy = new Route<>();
            copy.origin = this.origin;
            copy.target = this.target;
            return copy;
        }
    }
}
