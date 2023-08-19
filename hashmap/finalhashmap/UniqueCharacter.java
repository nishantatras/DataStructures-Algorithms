import java.util.HashMap;

public class UniqueCharacter {
    public static void main(String[] args) {
        String str = "ababacdeff";
        System.out.println(uniqueChar(str));
    }

    public static String uniqueChar(String str) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                res += ch;
                map.remove(ch);
            }
        }
        return res;
    }
}