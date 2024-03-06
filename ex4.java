import java.util.HashMap;

public class ex4 {

        public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(Integer.valueOf(nums[i]), map.getOrDefault(Integer.valueOf(nums[i]), 0)+1);
        }
        int[] resultFreq = new int[k];
        int[] resultValue = new int[k];
        int size = 0;
        for (int i = 0; i < k; i++) {
            resultFreq[i] = 0;
        }
        for (Integer i : map.keySet()) {
            Integer frequency = map.get(i);
            if(resultFreq[k-1]==0) {
                for (int j = 0; j < k; j++) {
                    if(resultFreq[j]==0) {
                        resultFreq[j] = frequency.intValue();
                        resultValue[j] = i.intValue();
                        break;
                    }
                }
                size++;
                for (int m = 0; m < size; m++) {
                    for (int n = 0; n < size-m-1; n++) {
                        if (resultFreq[n] > resultFreq[n+1]) {
                            int tempFreq = resultFreq[n];
                            resultFreq[n] = resultFreq[n+1];
                            resultFreq[n+1] = tempFreq;
                            int tempValue= resultValue[n];
                            resultValue[n] = resultValue[n+1];
                            resultValue[n+1] = tempValue;
                        }
                    }
                }
                
            }
            else if(resultFreq[k-1] < frequency.intValue()) {
                int minFreqIndex = 0;
                for (int j = 0; j < k; j++) {
                    if (resultFreq[j] < frequency.intValue()) {
                        minFreqIndex = j;
                        break;
                    }
                }
                for (int j = k-1; j > minFreqIndex; j--) {
                    resultFreq[j] = resultFreq[j-1];
                    resultValue[j] = resultValue[j-1];
                }
                resultFreq[minFreqIndex] = frequency.intValue();
                resultValue[minFreqIndex] = i.intValue();
            }
           
        }
        int[] result = new int[size];
        for (int j = 0; j < size; j++) {
            result[j] = resultValue[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {1,1,1,2,2,3};
        int[] ans = topKFrequent(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        
    }
}