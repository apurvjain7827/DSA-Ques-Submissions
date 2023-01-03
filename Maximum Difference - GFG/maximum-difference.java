//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findMaxDiff(int a[], int n)
    {
	// Your code here	
	Stack<Integer> st = new Stack<>();
	int[] ngr = new int[n];
	int[] ngl = new int[n];
	st.push(0);
	for(int i=1; i<n; i++){
	    while(st.size() != 0 && a[st.peek()] > a[i]){
	        ngr[st.pop()] = a[i];
	    }
	    st.push(i);
	}
	while(st.size() != 0){
	    st.pop();
	}
	
	st.push(n-1);
	for(int i=n-2; i>=0; i--){
	    while(st.size() != 0 && a[st.peek()] > a[i]){
	        ngl[st.pop()] = a[i];
	    }
	    st.push(i);
	}
	int max = 0;
	for(int i=0; i<n; i++){
	    max = Math.max(max, Math.abs(ngr[i] - ngl[i]));
	}
	
	return max;
	
	
    }
}