class Box
{
	double width;
	double height;
	double depth;

double volume()
{
	return width*height*depth;
}

void setdim(double w, double h, double d)
{
	width=w;
	height=h;
	depth=d;
}
}

class Boxdemo
{
	public static void main(String[] args){
	Box box1=new Box();
	Box box2=new Box();

	double vol1,vol2;

	box1.setdim(1.0,2.0,3.0);
	box2.setdim(10.0,20.0,30.0);

	vol1=box1.volume();
	vol2=box2.volume();
	System.out.println("volume 1 "+vol1);
	System.out.println("volume 2 "+vol2);
}
}








