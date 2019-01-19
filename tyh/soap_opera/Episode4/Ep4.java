import java.util.*;

/**
 * Ep4
 */
public class Ep4 {
    private static class Permutation {
        int SIZE;
        boolean[] vis;
        // int cnt = 0;
        List<int[]> ans;
        int[] res;
        int[] num;

        private void dfs(int n) {
            if(n == SIZE) {
                ans.add(res.clone());
                // for(int i=0;i<SIZE;i++) System.out.print(res[i]);
                // System.out.println();
                return;
            } else {
                for(int i=0;i<SIZE;i++) {
                    if(!vis[i]) {
                        res[n] = num[i];
                        vis[i] = true;
                        dfs(n+1);
                        vis[i] = false;
                    }
                }
            }
            return;
        }

        public List<int[]> get() {
            dfs(0);
            return ans;
        }

        Permutation(int size) {
            SIZE = size;
            vis = new boolean[SIZE];
            ans = new ArrayList<int[]>();
            res = new int[SIZE];
            num = new int[SIZE];
            for(int i=1;i<=SIZE;i++) {
                num[i-1] = i;
                vis[i-1] = false;
            }
        }
    }

    private static class Number implements Cloneable{
        int[] nums = new int[7];
        int digits = 0;

        public boolean isAround() {
            boolean[] vis = new boolean[7];
            boolean[] used = new boolean[10];
            int cur = 0;
            for(int i=0;i<digits;i++) {
                if(nums[i] == 0 || used[nums[i]]) {
                    return false;
                } else {
                    used[nums[i]] = true;
                }
            }
            if(digits==0) return false;
            else {
                while(!vis[cur]) {
                    vis[cur] = true;
                    cur = (cur + nums[cur]) % digits;
                }
                if(cur == 0) {
                    for(int i=0;i<digits;i++) {
                        if(!vis[i]) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }

        public int toInt() {
            int ans = 0;
            for(int i=0;i<digits;i++) {
                ans *= 10;
                ans += nums[i];
            }
            return ans;
        }

        public boolean greaterThan(Number n) {
            if(digits != n.digits) {
                return digits > n.digits;
            } else {
                for(int i=0;i<digits;i++) {
                    if(nums[i] != n.nums[i]) {
                        return nums[i] > n.nums[i];
                    }
                }
                return false;
            }
        }

        public void print() {
            for(int i=0;i<digits;i++) {
                System.out.print(nums[i]);
            }
            System.out.println();
        }

        public Number plusOne() {
            int a = this.toInt() + 1;
            Number ans = new Number();
            ans.digits = digits;
            for(int i=digits-1;i>=0;i--) {
                ans.nums[i] = a%10;
                a/=10;
            }
            return ans;
        }

        public Number genAns() {
            Number current = new Number();
            current.digits = digits;
            for(int i=0;i<digits;i++) {
                current.nums[i] = nums[i];
            }
            while(!current.isAround()) {
                current = current.plusOne();
                // System.out.print("h");
            }
            return current;
        }
    }
    public static void main(String[] args) {
        Number n = new Number();
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        while(true) {
            String t = sc.next();
            if(t.equals("0")) break;
            else {
                n.digits = t.length();
                for(int i=0;i<n.digits;i++) {
                    n.nums[i] = Character.getNumericValue(t.charAt(i));
                }
                n.genAns().print();
            }
        }
    }
}