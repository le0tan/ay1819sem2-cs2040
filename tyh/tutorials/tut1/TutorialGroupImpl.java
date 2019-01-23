import java.util.*;

interface TutorialGroup {
   /* get this tutorial group's name e.g. "T05" */
   String getGroupNum();

   /*
    * get Student name at specified sNo, i.e. position in classlist
    */
   String getStudentAt(int sNo);

   /*
    * add Std. name after the last Student (including any dummies)
    */
   void addStudent(String student);

   /*
    * replace Std. name at given sNo if that posn. is within classlist; * otherwise
    * pad dummy Student(s) with name "" (empty String)
    */
   void setStudentAt(int sNo, String newStudent);

   /*
    * truncate classlist to given size without reordering any Student; will not
    * expand the classlist
    */
   void shrinkClassSize(int newSize);

   /*
    * return representation of class list with the format below: e.g.
    * "[1:Ridi, 2:Van, 3:Abdul, 4:Samuel, 5:, 6:Ian, 7:, 8:]"
    */
   String toString();
}

class TutorialGroupImpl implements TutorialGroup {
   private String _groupNum;
   private List<String> _students;

   /*
    * implement c'tor use array-based list to store student names name with sNo 1
    * should physically be at index 0 of the list
    */
   public TutorialGroupImpl(String groupNum) {
      _groupNum = groupNum;
      _students = new ArrayList<String>();
   }

   /* implement the 6 methods */
   public String getGroupNum() {
      return _groupNum;
   }

   public String getStudentAt(int sNo) {
      return _students.get(sNo-1);
   }

   public void addStudent(String student) {
	   _students.add(student);
   }

   public void setStudentAt(int sNo, String newStudent) {
	   if(sNo-1 < _students.size()) {
		   _students.set(sNo-1, newStudent);
	   } else {
		   int t = sNo-1 - _students.size() + 1;
		   for(int i=0;i<t;i++)
			   _students.add("");
		   _students.set(sNo-1, newStudent);
	   }
   }

   public void shrinkClassSize(int newSize) {
	   if(newSize < _students.size()) {
		   for(int i=_students.size()-1; i>=newSize; i--)
			   _students.remove(i);
	   }
   }

   public String toString() {
      String res = "[";
	  for(int i=0;i<_students.size();i++) {
		  res += (Integer.toString(i+1) + ":" + _students.get(i));
		  if(i != _students.size()-1)
			  res += ", ";
		  else
			  res += "]";
	  }
	  return res;
  }
}
