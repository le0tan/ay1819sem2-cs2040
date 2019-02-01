/*
 * CS1020 (AY2014/5 Sem2)
 * Sit-in Lab 03 A
 * Author      : 
 * Matric no.  : 
 * Lab group   : 
 * Description :
 *      ???
 *      ???
 */

import java.util.*;

/* Class representing a process */
class Process {    
    private String processName;
    private int priority;

    public Process(String processName, int priority) {
        this.processName = processName;
        this.priority = priority;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String toString() { 
		return new String(processName + "," + priority);
	}
}

/* Class representing process scheduling service */
public class ProcessScheduling {

    private ... processList;
    private int maxProcesses;
    


} 
