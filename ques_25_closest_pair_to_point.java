import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ques_25_closest_pair_to_point {
  static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static double distance(Point p1, Point p2) {
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }

    static double closestUtil(Point[] Px, Point[] Py, int n) {
        if (n <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = 0; i < n; ++i)
                for (int j = i + 1; j < n; ++j)
                    min = Math.min(min, distance(Px[i], Px[j]));
            return min;
        }

        int mid = n / 2;
        Point midPoint = Px[mid];

        Point[] Pyl = new Point[mid];
        Point[] Pyr = new Point[n - mid];
        int li = 0, ri = 0;
        for (int i = 0; i < n; i++) {
            if (Py[i].x <= midPoint.x && li < mid)
                Pyl[li++] = Py[i];
            else
                Pyr[ri++] = Py[i];
        }

        double dl = closestUtil(Arrays.copyOfRange(Px, 0, mid), Pyl, mid);
        double dr = closestUtil(Arrays.copyOfRange(Px, mid, n), Pyr, n - mid);

        double d = Math.min(dl, dr);

        List<Point> strip = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (Math.abs(Py[i].x - midPoint.x) < d)
                strip.add(Py[i]);

        return Math.min(d, stripClosest(strip, d));
    }

    static double stripClosest(List<Point> strip, double d) {
        double min = d;
        int size = strip.size();
        for (int i = 0; i < size; ++i)
            for (int j = i + 1; j < size && (strip.get(j).y - strip.get(i).y) < min; ++j)
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
        return min;
    }

    static double closest(Point[] points) {
        int n = points.length;
        Point[] Px = points.clone();
        Point[] Py = points.clone();

        Arrays.sort(Px, Comparator.comparingInt(p -> p.x));
        Arrays.sort(Py, Comparator.comparingInt(p -> p.y));

        return closestUtil(Px, Py, n);
    }

    public static void main(String[] args) {
        Point[] points = {
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };

        double minDist = closest(points);
        System.out.printf("Minimum Distance: %.4f\n", minDist);
    }
}
