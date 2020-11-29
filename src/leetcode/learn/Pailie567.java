package leetcode.learn;

/**
 * 567
 *
 * @author Terry
 * @since 2020/9/15 18:27
 */
public class Pailie567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i) - 'a']++;
            nums2[s2.charAt(i) - 'a']++;
        }
        if (s1.length() == s2.length()) {
            return matches(nums1, nums2);
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(nums1, nums2)) {
                return true;
            }
            nums2[s2.charAt(i + s1.length()) - 'a']++;
            nums2[s2.charAt(i) - 'a']--;
        }
        return false;
    }

    private boolean matches(int[] nums1, int[] nums2) {
        for (int i = 0; i < 26; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusionNew(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }

    public static void main(String[] args) {
        Pailie567 pailie567 = new Pailie567();
        System.out.println(pailie567.checkInclusionNew("ab", "eidbaooo"));
    }
}