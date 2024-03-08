class Solution {
    public int maxFrequencyElements(int[] nums) {
        final byte[]ct=new byte[101];
        int maxFrq=0;
        int result = 0;
        for (int n:nums){
            final int x = ++ct[n];
            if (x<maxFrq)
                continue;
            else if (x>maxFrq)
                result = 0;
            result +=ct[n];
            maxFrq = x;
        }
        return result;
    }
}