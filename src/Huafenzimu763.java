import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * Related Topics 贪心算法 双指针
 *
 * @author Terry
 * @since 2020/9/8 17:51
 */
public class Huafenzimu763 {
//    public List<Integer> partitionLabelsNew(String S) {
//        // 先用HashMap存每个字符对应的最后index;
//        List<Integer> res = new ArrayList<Integer>();
//        HashMap<Character,Integer> map = new HashMap();
//        for(int i=0;i<S.length();i++){
//            map.put(S.charAt(i),i);
//        }
//        int index =0;
//        while(index<S.length()){
//            int temp = map.get(S.charAt(index));
//            int i=index;
//            while(i<temp){
//                if(map.get(S.charAt(i))>temp){
//                    temp = map.get(S.charAt(i));
//                }
//                i++;
//            }
//            res.add(temp-index+1);
//            index = temp+1;
//        }
//        return res;
//    }


    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> chMap = new HashMap<>();
        char[] charArray = S.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            chMap.put(ch, i);
        }
        int index = 0;
        while (index < charArray.length) {
            int num = chMap.get(charArray[index]);
            int i = index;
            while (num > i) {
                if (chMap.get(charArray[i]) > num) {
                    num = chMap.get(charArray[i]);
                }
                i++;
            }
            result.add(num - index + 1);
            index = num + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Huafenzimu763 huafenzimu763 = new Huafenzimu763();
        System.out.println(huafenzimu763.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
