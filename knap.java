import java.util.*;

class Item{
    double profit,weight;

    public Item(double profit,double weight){
        this.profit=profit;
        this.weight=weight;
    }
}

public class knapsack{

    public static double knapbyratio(double limit,List<Item>items){
        items.sort((a,b)->Double.compare(b.profit/b.weight,a.profit/a.weight));
        return calculateKnapsack(limit,items);
    }

    public static double knapbyprofit(double limit,List<Item>items){
        items.sort((a,b)->Double.compare(b.profit , a.profit));
        return calculateKnapsack(limit,items);
    }
    public static double knapsackbyweight(double limit,List<Item>items){
        items.sort(Comparator.comparingDouble(a->a.weight));
        return calculateKnapsack(limit,items);
    }
    
    public static double calculateKnapsack(double limit,List<Item>items){
        double totalprofit=0.0;

        for(Item item:items){
            if(item.weight<=limit){
                totalprofit+=item.profit;
                limit-=item.weight;
            }else{
                totalprofit+=(item.profit*limit)/item.weight;
                break;
            }
        }
        return totalprofit;
    }
    
    public static void main(String[] args){
    
        Scanner sc=new Scanner(System.in);

        System.out.println("enter knapsack limit");
        double limit=sc.nextDouble();

        System.out.println("enter no of items");
        int numitems=sc.nextInt();

        List<Item>items=new ArrayList<>();
        for(int i=0;i<numitems;i++){
            System.out.println("enter the profit for item "+(i+1)+" : ");
            double profit=sc.nextDouble();

            System.out.println("enter the weight for item "+ (i+1)+" : ");
            double weight=sc.nextDouble();

            items.add(new Item(profit,weight));
        }
        System.out.println("max profit/weight ratio : "+knapbyratio(limit,items));
        System.out.println("max profit : "+ knapbyprofit(limit,items));
        System.out.println("min weight "+knapsackbyweight(limit,items));
    }



} 
