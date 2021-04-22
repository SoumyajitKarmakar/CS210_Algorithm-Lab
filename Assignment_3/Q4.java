//package Assignment3;

public class Q4 {
	
	public static class Point implements Comparable<Point> {
		int x;
		int y;
		
		Point(int X, int Y){
			this.x = X;
			this.y = Y;
		}
		
		public int compareTo(Point p) {
			return this.x - p.x;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
