package kedar.matrix;

public class Point {
	
	Integer x;
	Integer y;
	
	Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() { return x; }
	public Integer getY() { return y; }
	
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		Integer sum = x + y;
		result = prime * result + ((x == null || y == null) ? 0 : (sum.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x == null || other.x == null) {
				return false;
		}
		if (y == null || other.y == null) {
				return false;
		}
		if ( x == other.x && y == other.y) {
			return true;
		}
		return false;
	}
	
}
