public class WaitingQueue {
    private String[] waitingHere;
    private int front; // "Leave a gap" when array is full
    private int back; // back is the index AFTER last element
    private static final int ARR_LENGTH = 10;

    public WaitingQueue() {
        waitingHere = new String[ARR_LENGTH];
    }

    public boolean isEmpty() {
        return back <= front;
    }

    // Returns true if Person is successfully added
    public boolean addAPerson(String newPerson) {
        if(back >= ARR_LENGTH) {
            return false;
        } else {
            waitingHere[back] = newPerson;
            back++;
            return true;
        }
    }

    public String serveNextPerson() {
        String t = waitingHere[front];
        for(int i=front; i<back-1; i++) {
            waitingHere[i] = waitingHere[i+1];
        }
        return t;
    }

    // Returns true if someone is removed from the queue
    public boolean leave(String personName) {
        boolean ok = false;
        for(int i=front; i<back; i++) {
            if(waitingHere[i] == personName) {
                ok = true;
                for(int j=i;j<back-1;j++) {
                    waitingHere[j] = waitingHere[j+1];
                }
                break;
            }
        }
        if(ok) {
            return true;
        } else {
            return false;
        }
    }

}