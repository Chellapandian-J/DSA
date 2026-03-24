import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<List<String>> input = Arrays.asList(
                Arrays.asList("bo7","bo8","bo9"),
                Arrays.asList("bo7","bo8"),
                Arrays.asList("bo8","bo9")
        );

        Map<String, Integer> freq = new HashMap<>();

        for (List<String> list : input) {
            Set<String> unique = new HashSet<>(list); // avoid duplicates in same list
            for (String s : unique) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>();
        int n = input.size();

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= n - 1) {
                result.add(entry.getKey());
            }
        }

        System.out.println(result);
    }
}