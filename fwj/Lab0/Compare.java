import java.util.Scanner;

public class Compare {
    private static int compare(String a, String b){
        int len=Math.min(a.length(), b.length());
        for(int i=0;i<len;i++){
            if(Character.toLowerCase(a.charAt(i))>Character.toLowerCase(b.charAt(i)))
                return 2;
            else
                if(Character.toLowerCase(a.charAt(i))<Character.toLowerCase(b.charAt(i)))
                return 1;}
        if (a.length()==b.length()) return 0;
        else if(a.length()<b.length()) return 1;
        return 2;
    }
    public static void main(String[] args){
        int re;
        Scanner st = new Scanner(System.in);
        String a = st.nextLine();
        String b = st.nextLine();
        re=compare(a,b);
        System.out.println(re);} 
}
