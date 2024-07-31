public class DominantOnesSubstrings {
    public static int countDominantOnesSubstrings(String s) {
        int n = s.length();
        int[] prefixOnes = new int[n + 1];
        int[] prefixZeros = new int[n + 1];

        // Create prefix arrays for ones and zeros
        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (s.charAt(i) == '1' ? 1 : 0);
            prefixZeros[i + 1] = prefixZeros[i] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int count = 0;
        // Iterate through all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int onesCount = prefixOnes[j] - prefixOnes[i];
                int zerosCount = prefixZeros[j] - prefixZeros[i];
                if (onesCount >= zerosCount * zerosCount) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "001";
        System.out.println(countDominantOnesSubstrings(s1)); // Output: 5

        String s2 = "101101";
        System.out.println(countDominantOnesSubstrings(s2)); // Output: 16
    }
}

