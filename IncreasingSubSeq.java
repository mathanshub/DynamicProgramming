package com.dynamicProgramming;

public class IncreasingSubSeq {

	
	
	public static void main(String[] args) {
		int [] seq={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		//System.out.println(increasingSubsequence(seq));;
		System.out.println(increasingSeq(seq,0,seq.length-1));;
	}
	public static int increasingSubsequence(int[]seq){
	    int[]L=new int[seq.length];
	    L[0]=1;
	    for(int i=1;i<L.length;i++){
	      int maxn=0;
	      for(int j=0;j<i;j++){
	        if(seq[j]<seq[i]&&L[j]>maxn){
	          maxn=L[j];
	        }
	      }
	      L[i]=maxn+1;
	    }
	   /* for ( i = 0; i < n; i++ )
	        lis[i] = 1;
	      
	      Compute optimized LIS values in bottom up manner 
	     for ( i = 1; i < n; i++ )
	        for ( j = 0; j < i; j++ )
	           if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
	              lis[i] = lis[j] + 1;
	      */
	    
	    int maxi=0;
	    for(int i=0;i<L.length;i++){
	      if(L[i]>maxi){
	        maxi=L[i];
	      }
	    }
	    return(maxi);
	  }
	
	public static int increasingSeq(int[] seq,int i,int j){
		
		if(j>seq.length)
			return 0;
		if(seq[i]>seq[j])
			return increasingSeq(seq, i, j+1);
		else{
			return max(increasingSeq(seq, i, j+1),1+increasingSeq(seq, j, j+1));
		}
		
		
	}
	
	
	int _lis( int arr[], int n, int max_ref)
	{
	    /* Base case */
	    if(n == 1)
	        return 1;
	 
	    int res, max_ending_here = 1; // length of LIS ending with arr[n-1]
	 
	    /* Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If 
	       arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
	       to be updated, then update it */
	    for(int i = 1; i < n; i++)
	    {
	        res = _lis(arr, i, max_ref);
	        if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
	            max_ending_here = res + 1;
	    }
	 
	    // Compare max_ending_here with the overall max. And update the
	    // overall max if needed
	    if (max_ref < max_ending_here)
	       max_ref = max_ending_here;
	 
	    // Return length of LIS ending with arr[n-1]
	    return max_ending_here;
	}
	public static int max(int a,int b){
		
		return( a>b?a:b);
		
	}
	

}
