public class Tutorials {
	public static void main(String[] args) {
		Tutorials ts = new Tutorials();
		ts.runTest();
	}
	public void runTest() {
		TutorialGroupImpl tut = new TutorialGroupImpl("T05");
		tut.addStudent("Ridi");
		tut.addStudent("Van");
		tut.addStudent("Abdul");
		tut.addStudent("Samuel");
		tut.setStudentAt(6, "Ian");
		tut.setStudentAt(8, "");
		System.out.println(tut);
	}
}
