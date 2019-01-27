class Circle{
	//private Point centre; 
	private double radius = 2.0; 
	//private double area = bla2; //area = pi * r^2
	//private double perimeter = bla2; //perimeter = pi * r *2 

	Circle(double r) {
		radius = r;
	}
	
	@Override
	public boolean equals(Object o){
		System.out.println("equals(Object) called");
		if(o == this){
			return true;
		}
		else if(o instanceof Circle){
			return ((Circle) o).radius == this.radius; 
		}
		else{
			return false;
		}
	}

	public boolean equals(Circle circle) {
		System.out.println("equals(Circle) called");
		return circle.radius == radius;
	}

	public static void main(String[] args) {
		Circle c1= new Circle(10);
		Circle c2 = new Circle(10);
		Object o1 = c1;
		Object o2 = c2;
		System.out.println((Circle) o2);
		System.out.println((Object) c1);
	}
}
