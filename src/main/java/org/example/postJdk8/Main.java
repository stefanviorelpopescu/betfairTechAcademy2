package org.example.postJdk8;

import org.example.postJdk8.shapes.Rectangle;

import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var citiesByCountry = new HashMap<String, List<City>>();
        for (var entry : citiesByCountry.entrySet()) {
            var key = entry.getKey();
            var cities = entry.getValue();
        }

        DayOfWeek day = DayOfWeek.TUESDAY;
        int productivityFromDay = getProductivityFromDay(day);
        int productivity = switch (day) {
            case TUESDAY -> 60;
            case WEDNESDAY -> 50;
            case JOI -> 30;
            case FRIDAY -> 10;
            case MONDAY, WEEKEND -> 0;
        };

        String value = switch (day) {
            case MONDAY -> "5";
            case TUESDAY -> "6";
            case WEDNESDAY -> "4";
            case JOI, FRIDAY -> "3";
            case WEEKEND -> "1";
        };

        var rectangle = new Rectangle(5, 4);
        System.out.println(rectangle.length());
        System.out.println(rectangle);

        String s = "<div class=\"ind\">\n" +
                "            <div>\n" +
                "               <p></p>\n" +
                "               <p>See <a href=\"../text-blocks/index.html\" target=\"_blank\">Programmer's Guide to Text\n" +
                "                                                Blocks</a> for more information about this\n" +
                "                                    language feature. For background information about text blocks,\n" +
                "                                    see <a href=\"https://openjdk.java.net/jeps/378\" target=\"_blank\">JEP 378</a>.\n" +
                "               </p>\n" +
                "            </div>\n" +
                "         </div>";

        String s2 = """
                <div class="ind">
                    <div>
                       <p></p>
                       <p>See <a href="../text-blocks/index.html" target="_blank">Programmer's Guide to Text
                                                        Blocks</a> for more information about this
                                            language feature. For background information about text blocks,
                                            see <a href="https://openjdk.java.net/jeps/378" target="_blank">JEP 378</a>.
                       </p>
                    </div>
                </div>
                
                """;
    }

    private static int getProductivityFromDay(DayOfWeek day) {
        switch (day) {
            case TUESDAY:
                return 60;
            case WEDNESDAY:
                return 50;
            case JOI:
                return 30;
            case FRIDAY:
                return 10;
            case MONDAY:
            case WEEKEND:
                return 0;
            default:
                return -1;
        }
    }
    private static int getProductivityFromDayExpression(DayOfWeek day) {
        return switch (day) {
            case TUESDAY -> 60;
            case WEDNESDAY -> 50;
            case JOI -> 30;
            case FRIDAY -> 10;
            case MONDAY, WEEKEND -> 0;
        };
    }

    record Point(double x, double y) {}

    static void printAngleFromXAxis(Object obj) {
        if (obj instanceof Point(double a, double b)) {
            System.out.println(Math.toDegrees(Math.atan2(a, b)));
        }
    }

    static void printAngleFromXAxis2(Object obj) {
        if (obj instanceof Point point) {
            System.out.println(Math.toDegrees(Math.atan2(point.x(), point.y())));
        }
    }

    interface Polygon { }
    class Triangle { }

    public void work(Triangle t) {
        Polygon p = (Polygon) t;
    }
}
