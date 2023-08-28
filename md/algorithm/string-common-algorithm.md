# 字符串通用算法
1.有效的括号给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效,括号必须以正确的顺序关闭，"()" 和 "()[]{}" 是有效的但是 "(]" 和 "([)]" 不是
```java
    public class StringCommonAlgorithm {
    
    
    public static void main(String[] args) {
        String s = "(){](}}}}";
        validBrackets(s);
    }


    public static void validBrackets(String s2) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] chars = s2.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i = i + 2) {
            char target = map.get(chars[i]);
            char source = chars[i + 1];
            if (source != target) {
                flag = false;
                break;
            }
        }
        String flagStr = flag ? "" : "不";
        System.out.println("字符串:" + s2 + flagStr + "是有效的");
    }
}


```