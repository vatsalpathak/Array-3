// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int [] buckets = new int[n+1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        int sum = 0; 
        for(int i = n; i >=0; i--){
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}

/*
//Nlogn 
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < n; i++){
            int diff = n - i;
            if(citations[i] >= diff){
                return diff;
            }
        }
        return 0;
    }
}
*/