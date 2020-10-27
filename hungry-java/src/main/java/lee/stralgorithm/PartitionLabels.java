package lee.stralgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description: 字符串集合最大分割
 *
 * @author JunchaoYao
 * @date 2020-10-22 10:53
 **/
public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        Character nowC = S.charAt(0);
        List<Integer> result = new ArrayList<>();
        Set<Character> set = S.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());
        Map<Character, List<Integer>> charMap = new HashMap<>();
        Map<Integer, Character> intMap = new HashMap<>();
        for (Character c : set) {
            int firstIndex = S.indexOf(c);
            int lastIndex = S.lastIndexOf(c);
            charMap.put(c, Arrays.asList(firstIndex, lastIndex));
            intMap.put(firstIndex, c);
        }
        int startIndex = charMap.get(nowC).get(0);
        int endIndex = charMap.get(nowC).get(1);
        while (!charMap.isEmpty()) {
            while (intMap.keySet().stream().min(Comparator.comparing(Integer::valueOf)).get() < endIndex) {
                nowC = S.charAt(intMap.keySet().stream().min(Comparator.comparing(Integer::valueOf)).get());
                List<Integer> list = charMap.get(nowC);
                startIndex = Math.min(startIndex, list.get(0));
                endIndex = Math.max(endIndex, list.get(1));
                charMap.remove(nowC);
                intMap.remove(list.get(0));
            }
            result.add(endIndex - startIndex + 1);
        }



        return result;

    }
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));

    }
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] last = new int[26];
            int length = S.length();
            for (int i = 0; i < length; i++) {
                last[S.charAt(i) - 'a'] = i;
            }
            List<Integer> partition = new ArrayList<Integer>();
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                end = Math.max(end, last[S.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return partition;
        }
    }
}
