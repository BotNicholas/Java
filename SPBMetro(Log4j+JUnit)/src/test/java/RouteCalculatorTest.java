import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;

    List<Station> connections;
    StationIndex testIndex;
    RouteCalculator calculator;

    @Override
    protected void setUp() throws Exception {
        //super.setUp();
        route = new ArrayList<Station>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");

        route.add(new Station("Петровская", line1));
        route.add(new Station("Арбузная", line1));
        route.add(new Station("Морковная", line2));
        route.add(new Station("Яблочная", line2));

        testIndex = new StationIndex();

        Line testLine1 = new Line(1, "Первая линия");
        Line testLine2 = new Line(2, "Вторая линия");
        Line testLine3 = new Line(3, "Третья линия");

        testLine1.addStation(new Station("Первая", testLine1));
        testLine1.addStation(new Station("Вторая", testLine1));
        testLine1.addStation(new Station("Третья", testLine1));
        testLine2.addStation(new Station("Четвертая", testLine2));
        testLine2.addStation(new Station("Пятая", testLine2));
        testLine2.addStation(new Station("Шестая", testLine2));
        testLine3.addStation(new Station("Седьмая", testLine3));
        testLine3.addStation(new Station("Восьмая", testLine3));
        testLine3.addStation(new Station("Девятая", testLine3));


        testIndex.addStation(new Station("Первая", testLine1));
        testIndex.addStation(new Station("Вторая", testLine1));
        testIndex.addStation(new Station("Третья", testLine1));
        testIndex.addStation(new Station("Четвертая", testLine2));
        testIndex.addStation(new Station("Пятая", testLine2));
        testIndex.addStation(new Station("Шестая", testLine2));
        testIndex.addStation(new Station("Седьмая", testLine3));
        testIndex.addStation(new Station("Восьмая", testLine3));
        testIndex.addStation(new Station("Девятая", testLine3));


        testIndex.addLine(testLine1);
        testIndex.addLine(testLine2);
        testIndex.addLine(testLine3);

        connections = new ArrayList<Station>();

        connections.add(new Station("Третья", testLine1));
        connections.add(new Station("Четвертая", testLine2));

        testIndex.addConnection(connections);

        connections = new ArrayList<Station>();

        connections.add(new Station("Шестая", testLine2));
        connections.add(new Station("Седьмая", testLine3));

        testIndex.addConnection(connections);

        calculator = new RouteCalculator(testIndex);
    }

    public void testCalculateDuration(){
        double expected = 8.5;
        double actual = RouteCalculator.calculateDuration(route);

        assertEquals(expected, actual);

    }

    public void testGetRouteOnTheLine(){
        List<Station> expected = new ArrayList<Station>();
        expected.add(testIndex.getStation("Первая"));
        expected.add(testIndex.getStation("Вторая"));
        List<Station> actual = calculator.getShortestRoute(testIndex.getStation("Первая"), testIndex.getStation("Вторая"));

        assertEquals(expected, actual);

    }

    /*public void testGetRouteOnTheLine1(){
        List<Station> expected = new ArrayList<Station>();
        expected.add(testIndex.getStation("Первая"));
        List<Station> actual = calculator.getShortestRoute(testIndex.getStation("Первая"), testIndex.getStation("Первая"));
        assertEquals(expected, actual);
    }*/

    public void testGetRouteWithOneConnection(){
        List<Station> expected = new ArrayList<Station>();
        expected.add(testIndex.getStation("Первая"));
        expected.add(testIndex.getStation("Вторая"));
        expected.add(testIndex.getStation("Третья"));
        expected.add(testIndex.getStation("Четвертая"));
        expected.add(testIndex.getStation("Пятая"));

        List<Station> actual = calculator.getShortestRoute(testIndex.getStation("Первая"), testIndex.getStation("Пятая"));

        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections(){
        List<Station> expected = new ArrayList<Station>();
        expected.add(testIndex.getStation("Первая"));
        expected.add(testIndex.getStation("Вторая"));
        expected.add(testIndex.getStation("Третья"));
        expected.add(testIndex.getStation("Четвертая"));
        expected.add(testIndex.getStation("Пятая"));
        expected.add(testIndex.getStation("Шестая"));
        expected.add(testIndex.getStation("Седьмая"));
        expected.add(testIndex.getStation("Восьмая"));

        List<Station> actual = calculator.getShortestRoute(testIndex.getStation("Первая"), testIndex.getStation("Восьмая"));

        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        //super.tearDown();
    }
}
