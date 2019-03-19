/*
 * CS1020 (AY2014/5 Sem2)
 * Sit-in Lab 03 B
 * Author      : 
 * Matric no.  : 
 * Lab group   : 
 * Description :
 *      ???
 *      ???
 */

import java.util.*;

/* Class representing an Email */
class Email {

    String sender;
    String subject;
    String content;

    public Email(String sender, String subject, String content) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSameThread(Email mail1) {
        return (this.sender.equals(mail1.sender) && this.subject.equals(mail1.subject));
    }

    public String toString() {
        return new String(sender + "," + subject + "," + content);
    }
}

/* Class representing Email service scheduling */

public class EmailService {

    // private Stack<Email> inbox;

    private LinkedList<Email> inbox;

    EmailService() {
        inbox = new LinkedList<Email>();
    }

    private void receive(String sender, String subject, String content) {
        Email mail = new Email(sender, subject, content);
        inbox.push(mail);
    }

    private void read(int n) {
        for(int i=0;i<n;i++)
            inbox.pop();
    }

    private void mark(String sender, String subject) {
        ListIterator<Email> iter = inbox.listIterator(inbox.size());
        while(iter.hasPrevious()) {
            Email temp = iter.previous();
            if(temp.getSender().equals(sender) && temp.getSubject().equals(subject)) {
                // iter.previous();
                // iter.next();
                iter.remove();
                inbox.push(temp);
            }
        }
    }

    private void printBox() {
        for(int i=0;i<inbox.size();i++) {
            Email e = inbox.get(i);
            System.out.printf("%s,%s,%s\n", e.getSender(), e.getSubject(), e.getContent());
        }
        System.out.println();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++) {
            String cmd = sc.next();
            if(cmd.equals("receive")) {
                String sender = sc.next();
                String subject = sc.next();
                String content = sc.next();
                receive(sender, subject, content);
            } else if(cmd.equals("read")){
                read(sc.nextInt());
            } else {
                mark(sc.next(), sc.next());
            }
            printBox();
        }
    }

    public static void main(String[] args) {
        EmailService es = new EmailService();
        es.run();
    }
}
