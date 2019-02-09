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

    private LinkedList<Process> processList;
    private int maxProcesses;
    private Dictionary<Integer, ListIterator<Process>> priorityLast;

    // private void execute(String name, int priority) {
    //     ListIterator<Process> temp;
    //     if(processList.isEmpty()) {
    //         processList.add(new Process(name, priority));
    //         temp = processList.listIterator();
    //         temp.next();
    //         priorityLast.put(priority, temp);
    //         return;
    //     }

    //     try {
    //         temp = priorityLast.get(priority);
    //     } catch (Exception e) {
    //         //TODO: handle exception
    //         temp = null;
    //     }
    //     if(temp != null) {
    //         temp.add(new Process(name, priority));
    //         temp.next();
    //         priorityLast.put(priority, temp);
    //     } else {
    //         boolean ok = false;
    //         for(int i=priority-1;i>=1;i--) {
    //             try {
    //                 priorityLast.get(i);
    //                 ok = true;
    //                 temp = priorityLast.get(i);
    //                 temp.add(new Process(name, priority));
    //                 temp.next();
    //                 priorityLast.put(priority, temp);
    //                 break;
    //             } catch (Exception e) {
    //                 //TODO: handle exception
    //             }
    //         }
    //         if(!ok) {
    //             temp = processList.listIterator();
    //             temp.add(new Process(name, priority));
    //             temp.next();
    //             priorityLast.put(priority, temp);
    //         }
    //     }
    // }

    ProcessScheduling() {
        processList = new LinkedList<Process>();
    }

    private void execute(String name, int priority) {
        if(processList.size() == maxProcesses) {
            processList.pop();
        }
        ListIterator<Process> iter = processList.listIterator();
        boolean ok = false;
        while(iter.hasNext()) {
            if(iter.next().getPriority() > priority) {
                iter.previous();
                iter.add(new Process(name, priority));
                ok = true;
                break;
            }
        }
        if(!ok) {
            processList.add(new Process(name, priority));
        }
    }

    private void kill(int n) {
        for(int i=0;i<n;i++) {
            processList.pop();
        }
    }

    private void printList() {
        for(Process i: processList) {
            System.out.printf("%s, %d\n", i.getProcessName(), i.getPriority());
        }
        System.out.println();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        maxProcesses = n;
        sc.nextLine();
        while(sc.hasNext()) {
            String cmd = sc.next();
            if(cmd.equals("execute")) {
                String name = sc.next();
                int pri = sc.nextInt();
                execute(name, pri);
            } else if(cmd.equals("kill")) {
                int k = sc.nextInt();
                kill(k);
            }
            printList();
        }

    }
    public static void main(String[] args) {
        ProcessScheduling p = new ProcessScheduling();
        p.run();
    }
} 