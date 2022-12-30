import com.jungle.algorithms.Digraph;
import org.junit.jupiter.api.Test;

public class TestDigraph {

    @Test
    public void test() {
        Digraph<Integer> digraph = new Digraph<>();

        Digraph.Point<Integer> point1 = Digraph.Point.of(1);
        Digraph.Point<Integer> point2 = Digraph.Point.of(2);
        Digraph.Point<Integer> point3 = Digraph.Point.of(3);
        Digraph.Point<Integer> point4 = Digraph.Point.of(4);
        Digraph.Point<Integer> point5 = Digraph.Point.of(5);
        digraph.addPoint(point1);
        digraph.addPoint(point2);
        digraph.addPoint(point3);
        digraph.addPoint(point4);
        digraph.addPoint(point5);
        digraph.addRoute(Digraph.Route.of(point1, point2));
        digraph.addRoute(Digraph.Route.of(point2, point3));
        digraph.addRoute(Digraph.Route.of(7,8));
        digraph.addRoute(Digraph.Route.of(6,4));
        System.out.println(digraph);
    }
}
