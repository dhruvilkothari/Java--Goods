import java.util.*;

class Product {
    public String name;
    public int Quantity;
    public int price;

    Product(String name,int Quantity,int Price){
        this.name = name;
        this.Quantity = Quantity;
        this.price = Price;
    }
}

class User{ 
    
    private ArrayList<Product> Goods ;
    private int totalPrice;

    User(){
        Goods = new ArrayList<>();
        totalPrice = 0;
    }
    public void addGoods(String name,int Quantity,int price){
        if(Goods.size()==0){
           Product p = new Product(name, Quantity, price);
           Goods.add(p);
           return;
        }
        else{
            for(int i=0;i<Goods.size();i++){
                Product p = Goods.get(i);
                if(p.name==name){
                    p.Quantity+=Quantity;
                    return;
                }
            }
            System.out.println("No Name Found With this name");
        }

    }

    public void removeGoods (String name,int Quantity){
        if(Goods.size()==0)return;
        for(int i=0;i<Goods.size();i++){
            Product p = Goods.get(i);
            if(p.name==name){
                p.Quantity-=Quantity;
                if(p.Quantity==0){
                    Goods.remove(p);
                    return;
                }
                return;
            }
        }
    }
}
class Test {

     public static int getUserInput(){
        int option =-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Select a proper input\n");
        
            option = sc.nextInt();
            if(option==-1){
                System.out.println("No option selected \n Thanks for shopping from us\4");
            } 
        
        return option;
    }

    public static void printMenu(){
        System.out.print("1)PannerChilli-100Rs\n2)Egg-200Rs\n3)Aloo-150Rs\n");
    }


    public static void main(String args[]){

        HashMap <Integer,String> foodMenu = new HashMap<>();
        HashMap <String,Integer> priceMenu = new HashMap<>();
        foodMenu.put(1,"PannerChilli");
        foodMenu.put(2,"EGG");
        foodMenu.put(3,"Aloo");

        priceMenu.put("PannerChilli",100);
        priceMenu.put("EGG",200);
        priceMenu.put("Aloo",150);




        printMenu();
        getUserInput();
    }
}