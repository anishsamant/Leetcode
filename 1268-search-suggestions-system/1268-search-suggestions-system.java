class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> res = new ArrayList<>();
        int left = 0;
        int right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);

            while (left <= right &&
                    (products[left].length() <= i ||
                            products[left].charAt(i) != ch)) {
                left++;
            }

            while (left <= right &&
                    (products[right].length() <= i ||
                            products[right].charAt(i) != ch)) {
                right--;
            }

            List<String> list = new ArrayList<>();

            for (int j = 0; j < 3 && left + j <= right; j++) {
                list.add(products[left + j]);
            }

            res.add(list);
        }

        return res;
    }
}