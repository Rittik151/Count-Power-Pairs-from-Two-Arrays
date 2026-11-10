import java.util.*;

class Count_Power_Pairs_from_Two_Arrays {
    int generateIndex(int[] y,int n,int x){
        int l=0;
        int h=n-1;
        int a=-1;
        while(l<=h){
            int mid=(h+l)/2;
            if(x<y[mid]){
                a=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return a;
    }
    public int countPairs(int[] X, int[] Y) {
        // code here
        int z=0,o=0,f=0,th=0,t=0,n = Y.length,m = X.length;
        Arrays.sort(X);
        Arrays.sort(Y);
        for(int i=0;i<n;i++){
            if(Y[i]==0)z++;
            if(Y[i]==1)o++;
            if(Y[i]==4)f++;
            if(Y[i]==3)th++;
            if(Y[i]==2)t++;
        }
        long ans=0;
        for(int i=0;i<m;i++){
            if(X[i]==0)continue;
            else if(X[i]==1)ans+=z;
            else if(X[i]==2){

                int p=generateIndex(Y,n,2);
                if(p!=-1){
                ans+=n-p;
            }
            ans-=th;
            ans-=f;
            ans+=o;
            ans+=z;

            }
            else{
                int p=generateIndex(Y,n,X[i]);
                if(p!=-1){
                ans+=n-p;
            }
            if(X[i]==3)ans+=t;
            ans+=o;
            ans+=z;
            }
        }
        return (int)ans;
    }
}
