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

    private Stack<Email> inbox;

}
