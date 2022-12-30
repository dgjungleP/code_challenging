import com.jungle.algorithms.Digraph;

import javax.xml.transform.Source;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Digraph<Integer> digraph = new Digraph<>();
        digraph.addRoute(Digraph.Route.of(0, 1));
        digraph.addRoute(Digraph.Route.of(1, 3));
        digraph.addRoute(Digraph.Route.of(1, 6));
        digraph.addRoute(Digraph.Route.of(4, 6));
        digraph.addPoint(Digraph.Point.of(2));
        digraph.addPoint(Digraph.Point.of(5));
        digraph.addPoint(Digraph.Point.of(7));
        List<Integer> sorted = digraph.topologicalSort();
        System.out.println(sorted);


        Digraph<Integer> digraph2 = new Digraph<>();
        digraph2.addRoute(Digraph.Route.of(0, 3));
        digraph2.addRoute(Digraph.Route.of(1, 2));
        digraph2.addRoute(Digraph.Route.of(1, 5));
        digraph2.addRoute(Digraph.Route.of(5, 6));
        digraph2.addRoute(Digraph.Route.of(4, 6));
        digraph2.addPoint(Digraph.Point.of(7));
        List<Integer> sorted2 = digraph2.topologicalSort();
        System.out.println(sorted2);
    }


}
