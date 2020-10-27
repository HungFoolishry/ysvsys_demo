package lee.other;

/**
 * description: 是否长按名字
 *
 * @author JunchaoYao
 * @date 2020-10-21 10:24
 **/
public class IsLongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        char[] namesC = name.toCharArray();
        char[] typedC = typed.toCharArray();
        int i = 0;
        int j = 0;
        char lastChar = namesC[0];
        StringBuilder result = new StringBuilder();
        for (char c: namesC) {
            if (j < typedC.length) {
                if (c == typedC[j]) {
                    i++;
                    j++;
                    result.append(c);
                    lastChar = c;
                } else {
                    while ( j < typedC.length && lastChar == typedC[j] ) {
                        j++;
                    }
                    if (j < typedC.length) {
                        if (c == typedC[j]) {
                            i++;
                            j++;
                            result.append(c);
                            lastChar = c;
                        }
                    }

                }
            }
        }
        while (j < typedC.length && lastChar == typedC[j] ) {
            j++;
        }
        return j == typedC.length && name.contentEquals(result);
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("vtkgn"
                ,"vttkgnn"));
    }

    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int i = 0, j = 0;
            while (j < typed.length()) {
                if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                    i++;
                    j++;
                } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                } else {
                    return false;
                }
            }
            return i == name.length();
        }
    }


}
