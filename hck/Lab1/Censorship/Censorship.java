import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Censorship {
	
	private void run() {
		Scanner scan1=new Scanner(System.in);
		int NumOfCensoredWords=scan1.nextInt();
		List<String> CensoredWords=new ArrayList<>();
		List<String> Result=new ArrayList<>();
		
		for(int i=0;i<NumOfCensoredWords-1;i++)
			CensoredWords.add(scan1.next().toUpperCase());
		
		while(scan1.hasNext()){
			String the_word=scan1.next();
			if (CensoredWords.contains(the_word.toUpperCase())){
				String the_alter_word=" ";
				for(int j=0;j<the_word.length()-1;j++)
					the_alter_word+="*";
				Result.add(the_alter_word);
			}
			else Result.add(the_word);
		}
		for(int k = 0;k<Result.size()-1;k++)
			System.out.print(Result.get(k));
		scan1.close();
		
	}
	
	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}

}
