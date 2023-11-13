class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(char ch : arr){
            int chr = ch;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                pq.add(chr);
            }
            else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                pq.add(chr);
            }
        }
        
        for(int i=0; i<arr.length; i++){
            char ch = arr[i];
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                int rem = pq.remove();
                arr[i] = (char)rem;
            }
            else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                int rem = pq.remove();
                arr[i] = (char)rem;
            }
        }
        
        return new String(arr);
    }
}