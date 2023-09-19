public class Loop {
    public static boolean isTure(int arr[]){
        if(arr==null||arr.length==0){
            return false;
        }
        int maxDepth =arr[0];
        for(int  i=1;i<maxDepth;i++){
            if(arr[i]+i>maxDepth){
                maxDepth=arr[1]+1;
            }
        }
        return maxDepth>=arr.length-1;
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,1,4};
        System.out.println(isTure(arr));
    }
}
