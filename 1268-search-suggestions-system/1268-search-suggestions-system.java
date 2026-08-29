class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(products);
        for (char c: searchWord.toCharArray()) {
            sb.append(c);
            List<String> prods = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(sb.toString())) {
                    prods.add(product);
                }
                if (prods.size() == 3) break;
            }
            res.add(prods);
        }

        return res;
    }
}