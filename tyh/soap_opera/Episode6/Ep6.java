public class Ep6 {
	public static boolean canBalance(int[] nums) {
		int[] part = new int[nums.length];
		part[0] = nums[0];
		for(int i=1;i<nums.length;i++) {
			part[i] = part[i-1] + nums[i];
		}
		if(part[nums.length-1]%2 != 0)
			return false;
		else {
			for(int i=0;i<nums.length;i++) {
				if(part[i] == part[nums.length-1] / 2) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = {1,1,1,2,1};
		int[] b = {2,1,1,2,1};
		System.out.println(canBalance(a));
		System.out.println(canBalance(b));
	}
}
