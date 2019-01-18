import java.util.*;

public class Ep1 {
	static class Date {
		int year;
		int month;
		int day;
		static int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		boolean leap = false;

		Date(int a, int b, int c) {
			year = a;
			month = b;
			day = c;
			if(isLeap(year))
				leap = true;
		}

		static boolean isLeap(int year) {
			return year % 4 == 0 && year % 100 != 0;
		}
		
		static int daysBetweenYear(int a, int b) {
			// the start and the end is excluded
			int ans = 0;
			a++;
			while(a < b){
				if(isLeap(a)) {
					ans += 366;
				} else {
					ans += 365;
				}
				a++;
			}
			return ans;
		}

		static int daysBetweenMonth(int a, int b, boolean l) {
			// the start and the end is excluded
			int ans = 0;
			for(int i=a;i<=b-2;i++) {
				if(l && i==1) ans++;
				ans += daysOfMonth[i];
			}
			return ans;
		}

		static int daysUntilEndOfMonth(int y, int m, int d) {
			int ans = daysOfMonth[m-1] - d;
			if(isLeap(y) && m==2) ans++;
			return ans;
		}

		static int daysBetweenDate(Date a, Date b) {
			int ans = 0;
			if(a.year == b.year) {
				if(a.month == b.month) {
					return b.day - a.day;
				} else {
					ans += daysBetweenMonth(a.month, b.month, isLeap(a.year));
					ans += daysUntilEndOfMonth(a.year, a.month, a.day);
					ans += b.day;
					return ans;
				}
			} else {
				ans += daysUntilEndOfMonth(a.year, a.month, a.day);
				ans += (daysBetweenMonth(a.month, 12, isLeap(a.year)) + 31);
				ans += daysBetweenYear(a.year, b.year);
				ans += (31 + daysBetweenMonth(1, b.month, isLeap(b.year)) + b.day);
				return ans;
			}
		}

	}

	public static void main(String[] args) {
		Date a = new Date(2007,8,8);
		Date b = new Date(2012,10,31);
		System.out.println(Date.daysBetweenDate(a, b));
	}
}
