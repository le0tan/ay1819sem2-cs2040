import java.security.Permission;
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

    private static class Number {
        int[] nums = new int[7];
        int digits = 0;

        public boolean isAround() {
            boolean[] vis = new boolean[7];
            int cur = 0;
            if(digits==0) return false;
            else {
                while(!vis[cur]) {
                    vis[cur] = true;
                    cur = (cur + nums[cur]) % digits;
                }
                return cur == 0;
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

        public Number genAns() {
            Permutation pm = new Permutation(digits);
            List<int[]> perm = pm.get();
            Number ans = new Number();
            ans.digits = digits;
            for(int i=0;i<digits;i++) {
                ans.nums[i] = 9;
            }
            for(int[] elem: perm) {
                Number current = new Number();
                current.digits = digits;
                for(int i=0;i<digits;i++) {
                    current.nums[i] = nums[elem[i]-1];
                }
                if(current.isAround() && ans.greaterThan(current)) {
                    ans = current;
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Number n = new Number();
        n.digits = 5;
        n.nums = new int[] {8,1,3,6,2};
        // System.out.print(n.genAns().toInt());
        // Permutation pr = new Permutation(5);
        // List<int[]> t = pr.get();
        // System.out.println(t.size());
        // for(int i=0;i<t.size();i++) {
        //     int[] current = t.get(i);
        //     for(int j=0;j<5;j++) {
        //         System.out.print(current[j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println(t.get(2)[4]);
        int[] ans = n.genAns().nums;
        for(int i=0;i<ans.length;i++) {
            System.out.print(ans[i]);
        }
    }
}