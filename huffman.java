import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node{
    int freq;
    Node left,right;
    String symbol;
    String huff=" ";

    public Node(int freq,String symbol,Node left,Node right){
        this.freq=freq;
        this.symbol=symbol;
        this.right=right;
        this.left=left;
    }
}
    public class huffman{
        public static void printNode(Node node,String val){
            String newVal= val+node.huff;
            if(node.left!=null){
                printNode(node.left,newVal);
                
            }if(node.right!=null){
                printNode(node.right,newVal);
            } 
            if(node.left==null && node.right==null){
                System.out.println(node.symbol+"->"+newVal);
            }
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);

            System.out.println("enter the number of symbols");
            int numsymbol=sc.nextInt();
            List<Node>nodes=new ArrayList<>();

            for(int i=0;i<numsymbol;i++){
                System.out.println("enter the symbol"+(i+1)+" : ");
                String symbol=sc.next();
                System.out.println("enter the frequency of symbol"+symbol+" : ");
                int freq=sc.nextInt();

                nodes.add(new Node(freq,symbol,null,null));
            }

            while(nodes.size()>1){
                Collections.sort(nodes,Comparator.comparingInt(n->n.freq));

                Node left=nodes.remove(0);
                Node right=nodes.remove(0);

                left.huff="0";
                right.huff="1";

                Node newNode=new Node(left.freq+right.freq,left.symbol+right.symbol, left, right);
                nodes.add(newNode);
            }
            System.out.println("huffan codes");
            printNode(nodes.get(0)," ");

        }
        

    }
