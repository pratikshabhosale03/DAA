import java.util.Scanner;
public class fibo{
    public static int fibonacci(int n){
        int a=0,b=1;
        if(n==0){
            return a;
        }else if(n==1){
            return b;
        }
        else{
            for(int i=2;i<=n;i++){
                int c=a+b;
                a=b;
                b=c;
            }return b;
        }
    }
    public static int fiborec(int n){
        if(n==0){
            return 0;
        }else if (n==1){
            return 1;
        }else{
            return fiborec(n-1)+fiborec(n-2);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter position : ");
        int n=sc.nextInt();

        System.out.println("fibonacci" +n+"th number without recursion : ");
        System.out.println(fibonacci(n));

        System.out.println("fibonacci"+n+"th position with recursion : ");
        System.out.println(fiborec(n));
    }
} 
