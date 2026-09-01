package seminarie1;

public class Uppgift3 {
    interface Point {

        public double distanceTo(Point other);
    }

    class Point2D implements Point {

        private double x, y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        private Point2D ref(Point other) {
            return (Point2D) other;
        }

        public double distanceTo(Point other) {
            var dx = x - ref(other).x;
            var dy = y - ref(other).y;
            return Math.hypot(dx, dy);
        }
    }

    class Point3D implements Point {

        private double x, y, z;

        public Point3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        private Point3D ref(Point other) {
            return (Point3D) other;
        }

        public double distanceTo(Point other) {
            var dx = x - ref(other).x;
            var dy = y - ref(other).y;
            var dz = z - ref(other).z;
            return Math.hypot(Math.hypot(dx, dy), dz);
        }
    }

    class Segment {

        private Point p0, p1;

        public Segment(Point p0, Point p1) {
            this.p0 = p0;
            this.p1 = p1;
        }

        public double length() {
            return p0.distanceTo(p1);
        }
    }

    interface PointFactory {
        Point create(String s);
    }

    class Point2DFactory implements PointFactory {

        public Point2DFactory() {
        }

        @Override
        public Point create(String s) {
            String[] parts = s.split(",");
            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());
            return new Point2D(x, y);

        }
    }

    class Point3DFactory implements PointFactory {

        public Point3DFactory() {
        }

        @Override
        public Point create(String s) {
            String[] parts = s.split(",");
            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());
            double z = Double.parseDouble(parts[2].trim());
            return new Point3D(x, y, z);

        }
    }

    class DistanceTo {

        public DistanceTo() {
        }

        public double distanceTo(PointFactory pf, String s1, String s2) {
            Point p1 = pf.create(s1);
            Point p2 = pf.create(s2);
            return p1.distanceTo(p2);
        }
    }

}
