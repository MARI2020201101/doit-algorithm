package geometry.intersectline;

class IntersectLine {
    static boolean isIntersect(Line l1, Line l2){
        return false;
    }

}
class Line{
    Point p1;
    Point p2;
    double slope;
    double beta;
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.slope = (p2.y-p1.y)/(p2.x-p1.x);
        this.beta = p1.y - (slope*p1.x);
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}