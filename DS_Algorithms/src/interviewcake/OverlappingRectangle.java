package interviewcake;
/**
 * Given 2 rectangles, find the overlapping rectangle
 * https://www.interviewcake.com/question/java/rectangular-love?
 * 
 * ALGO: Draw and see how it looks
 * 1. Find the overlapping x range - for the overlapping rectangle the startingX will be the max X of those 2 rectangles, 
 * ending x is the min X of those 2 rectangles.
 * 2. Find the overlapping y range - Similarly the startingY will be the max Y of those 2 rectangles, 
 * ending y is the min Y of those 2 rectangles.
 * 3. Merge them to get the overlapping rectangle
 * @author suni
 *
 */
public class OverlappingRectangle {

	public static Rectangle findRectangleOverlap(Rectangle r1, Rectangle r2){
	
		   RangeOverlap xRange = findRangeOverlap(r1.x, r2.x, r1.x+r1.width, r2.x+r2.width);
		   RangeOverlap yRange = findRangeOverlap(r1.y, r2.y, r1.y+r1.height, r2.y+r2.height);
           
		   Rectangle overlapRec = new Rectangle(xRange.startingPoint, yRange.startingPoint, xRange.length, yRange.length);
		   return overlapRec;
		
	}
	
	private static RangeOverlap  findRangeOverlap(int recAstart, int recBstart, int recAEnd, int recBEnd){
		int overlapStart = Math.max(recAstart, recBstart);
		int overlapEnd = Math.min(recAEnd, recBEnd);
		return new RangeOverlap(overlapStart, overlapEnd-overlapStart);
	}
	
	private static class Rectangle{
		public int x;
		public int y;
		public int width;
		public int height;
		public Rectangle(int x, int y, int w, int h){
			this.x = x;
			this.y = y;
			width = w;
			height = h;
		}		
	}
	
	private static class RangeOverlap{
		public int startingPoint;
		public int length;
		public RangeOverlap(int start, int l){ 
			startingPoint = start;
			length = l;
		}
	}
}
