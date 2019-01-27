public class P {
	private int x;
	public void changeSelf() {
		x=1;
	}
	public void changeAnother(P p) {
		p.x=1;
	}
	private void changeAnother(P p) {

	}
}
