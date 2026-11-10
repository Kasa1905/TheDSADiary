class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if(s.length() == t1.length()){
                    return s.compareTo(t1);
                }
                return t1.length() - s.length();
            }
        });

        Map<Character, List<Integer>> charMap = new HashMap<>();
        int idx = 0;
        for(char c: s.toCharArray()) {
            List<Integer> indexList = charMap.getOrDefault(c, new ArrayList<>());
            indexList.add(idx++);
            charMap.put(c, indexList);
        }

        for(String word: d) {
            idx = -1;
            Map<Character, Integer> charCount = new HashMap<>();
            boolean isAnswer = true;
            for(char c: word.toCharArray()) {
                if(!charMap.containsKey(c)) {
                    isAnswer = false;
                    break;
                }

                List<Integer> possibleIndexes = charMap.get(c);
                boolean isPossible = false;
                for(int i = charCount.getOrDefault(c, 0); i < possibleIndexes.size(); i++) {
                    if(possibleIndexes.get(i) > idx) {
                        idx = possibleIndexes.get(i);
                        isPossible = true;
                        break;
                    }
                }

                if(!isPossible) {
                    isAnswer = false;
                    break;
                }
            }

            if(isAnswer) {
                return word;
            }
        }
        return "";
    }
}