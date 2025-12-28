class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;
        Map<String, List<String>> parents = new HashMap<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);
        boolean found = false;
        Set<String> visited = new HashSet<>();
        while (!level.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            visited.addAll(level);
            for (String word : level) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[i] = c;
                        String nei = new String(arr);
                        if (!wordSet.contains(nei)) continue;
                        if (visited.contains(nei)) continue;
                        parents.computeIfAbsent(nei, k -> new ArrayList<>()).add(word);
                        if (nei.equals(endWord)) {
                            found = true;
                        }
                        nextLevel.add(nei);
                    }
                    arr[i] = original;
                }
            }

            level = nextLevel;
        }

        if (!found) return result;

        // DFS backtracking from endWord to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, parents, path, result);

        return result;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> parents,
                     List<String> path, List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            result.add(copy);
            return;
        }  

        if (!parents.containsKey(word)) return;

        for (String p : parents.get(word)) {
            path.add(p);
            dfs(p, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}
