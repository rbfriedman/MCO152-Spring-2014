package friedman.triangle;

public class Triangle {

	private int height;

	private int base;
	public Triangle(int height){
		this.height = height;
		this.base =height*2 -1;
	}
	public int getBase(){
		return this.base;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		return drawLine(this.height,builder);
		
	}
	private String drawLine(int height,StringBuilder builder){
		int place =0;
		
		
		if(this.height ==height){
			while(place<height-1){
				builder.append(" ");
				place++;
			}
			builder.append('*');
			builder.append("\n");
			return drawLine(height-1,builder);
		}
		else if(height<this.height && height!=1){
			int padding = builder.length();
			while(place<this.base -height){
				builder.append(" ");
				place++;
			}
			builder.setCharAt(height-1 +  padding, '*');
			builder.append('*');
			builder.append("\n");
			return drawLine(height-1,builder);
		}
		else{
			while(place <this.base){
				builder.append('*');
				place++;
			}
			return builder.toString();
		}
	
		
	}
}

