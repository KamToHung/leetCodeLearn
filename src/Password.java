import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * TODO
 *
 * @author Terry
 * @since 2020/8/24 15:58
 */
public class Password {

    String addNumber(String password, int num) {
        char[] chars = password.toCharArray();
        if (chars[num] == '9') {
            chars[num] = '0';
        } else {
            chars[num] += 1;
        }
        return new String(chars);
    }

    String subNumber(String password, int num) {
        char[] chars = password.toCharArray();
        if (chars[num] == '0') {
            chars[num] = '9';
        } else {
            chars[num] -= 1;
        }
        return new String(chars);
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                boolean flag = false;
                for (String deadend : deadends) {
                    if (deadend.equals(poll)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                if (target.equals(poll)) {
                    return result;
                }
                for (int j = 0; j < 4; j++) {
                    String add = addNumber(poll, j);
                    if (!visited.contains(add)) {
                        queue.offer(add);
                        visited.add(add);
                    }
                    String sub = subNumber(poll, j);
                    if (!visited.contains(sub)) {
                        queue.offer(sub);
                        visited.add(sub);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
