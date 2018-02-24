package years.year2018.months02;

public class Day24 {
	public static void main(String[]args){
		Day24 d = new Day24();
		javaProblem_drawRound d1 =d.new javaProblem_drawRound();
		d1.drawRound(5);
	}
	
	class javaProblem_drawRound{

		/**
		 * 根据传入半径打印不同大小的圆
		 * @param radii
		 */
		public void drawRound(int radii){
			int x=0;
			int y=0;
			int c=0;
			int z=2;
			for(int i=0,l=radii*2;i<l;i+=z){
				x = getX(radii, y);
				System.out.print(getSpace(x)+"*");
				c = 2*(radii-x);
				System.out.println(getSpace(c)+"*");
				y+=z;
			}
		}
		public int getX(int r,int y){
			return (int)Math.round((r-Math.sqrt(Math.pow(r, 2)-Math.pow((y-r),2))));
		}
		/**
		 * 返回需要打印的空格数量
		 * @param s
		 * @return
		 */
		public String getSpace(int s){
			StringBuilder space = new StringBuilder();
			for(int i=0;i<s;i++){
				space.append("  ");
			}
			return space.toString();
		}
	}
}
