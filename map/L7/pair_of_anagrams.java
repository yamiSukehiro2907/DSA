import java.util.*;

public class pair_of_anagrams {
    public static void main(String[] args) {
        String[] arr = { "ate", "tea", "tan", "ate", "nat", "bat" };
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String sort = sort(s);
            if (!map.containsKey(sort))
                map.put(sort, new ArrayList<>());
            map.get(sort).add(i + 1);
        }
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        for(int i = 0 ; i < list.size() ; i++){
            for(int j = 0 ; j < list.get(i).size() ; j++){
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static String sort(String s) {
        StringBuilder sb = new StringBuilder();
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        int i = 0;
        while (i < 26) {
            if (freq[i] > 0) {
                sb.append(i + 'a');
                freq[i]--;
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}