/*
  You do not have to conform to the skeleton. You are free to design your own classes and methods.
*/

import java.util.ArrayList;

class Group{

    private int id; // assign a unique id to each group.
    private String name;
    private ArrayList<Person> members;

    public Group(){
    	
    }
    public Group(int id, String name){
    	
    }
    
    public int getId(){
    	return -1;
    }
    
    public String getName(){
    	return null;
    }
    
    public void addMember(Person p){
    	
    }
    
    public void delMember(String name){
    	
    }
    
    public int getNumOfMembers(){
    	return 0;
    }
    /*
    	more
    */ 
}

class Person{
    private String name;
    private ArrayList<Integer> groups; //contain the group id's of the person's groups.

    public Person(){
    	
    }
    public Person(String name){
    	
    }
    
    public String getName(){
    	return null;
    }
    public void joinGroup(int grp){
    	
    }
    public void quitGroup(int grp){
    	
    }
    public int getNumOfGroups(){
    	return 0;
    }
    /*
    more
    */ 
}

class SocialNetwork{
    private ArrayList<Group> groups;
    private ArrayList<Person> persons;

    public SocialNetwork(){
    	
    }
    
    public Person addPerson(String name){
    	return null;
    }
    
    public Group addGroup (String name){
    	return null;
    }
    
    public String answerQuery1(){
    	return null;
    }
    
    public String answerQuery2(){
    	return null;
    }
    /*
    more
    */          
};

public class Main {

	public static void main(String[] args) {
		// your main program here

	}

}
