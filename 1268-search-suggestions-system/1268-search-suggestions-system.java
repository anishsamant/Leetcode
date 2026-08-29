class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(products);
        int l = 0, r = products.length - 1;
        int i = 0;
        for (char c: searchWord.toCharArray()) {
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) l++;

            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) r--;

            List<String> prod = new ArrayList<>();
            for(int j = 0; j < 3 && l + j <= r; j++) {
                prod.add(products[l + j]);
            }

            res.add(prod);
            i++;
        }

        return res;
    }
}