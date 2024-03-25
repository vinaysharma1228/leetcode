
/*
class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int countA = countOnes(a);
                int countB = countOnes(b);
                if (countA == countB) {
                    return a.compareTo(b); // Sort by value if count of 1's is the same
                }
                return countA - countB; // Sort by count of 1's
            }

            private int countOnes(int num) {
                int count = 0;
                while (num != 0) {
                    if ((num & 1) == 1) {
                        count++;
                    }
                    num = num >>> 1; // Unsigned right shift
                }
                return count;
            }
        });

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
*/

class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            arr[i] += Integer.bitCount(arr[i])*10001;
        }

        Arrays.sort(arr);

        for(int i = 0; i<arr.length; i++){
            arr[i] = arr[i]%10001;
        }
        return arr;
    }
}