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
    String name;
    private ArrayList<Product> Goods ;
    private int totalPrice;

    User(String name){
        this.name = name;
        Goods = new ArrayList<>();
        totalPrice = 0;
    }
    public void addGoods(String name,int Quantity,int price){
        System.out.println(name);
        if(Goods.size()==0){
           Product p = new Product(name, Quantity, price);
           Goods.add(p);
           totalPrice+=price*Quantity;
           System.out.println(totalPrice);
           return;
        }
        
        for(int i=0;i<Goods.size();i++){
            Product p = Goods.get(i);
            if(p.name==name){

                p.Quantity+=Quantity;
                totalPrice+=price*Quantity;
                System.out.println(totalPrice);
                return;
                }
        }

        Product p = new Product(name, Quantity, price);
        totalPrice+=price;
        Goods.add(p);
        return;
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
    public void printBill(){

        System.out.println("BILL SYSTEM for "+name);
        System.out.println("FoodItem"+" ---------------->"+"price"+"---------------->"+"Quantity");
        for(int i=0;i<Goods.size();i++){
            Product p = Goods.get(i);
            System.out.println(p.name+"---------------->"+p.price+"-------------->"+p.Quantity);
        }
        System.out.println(totalPrice);




    }
}
class Test {

    

     public static int getUserInput(){
        int option =-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Select a proper input");
        
            option = sc.nextInt();
            if(option==-1){
                System.out.println("No option selected \n Thanks for shopping from us\4");
            } 
            
            // sc.close();
        return option;
    }

    public static void printMenu(){
        System.out.print("1)PannerChilli-100Rs\n2)EGG-200Rs\n3)Aloo-150Rs\n4)Exit and Bill\n");
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        HashMap <Integer,String> foodMenu = new HashMap<>();
        HashMap <String,Integer> priceMenu = new HashMap<>();
        foodMenu.put(1,"PannerChilli");
        foodMenu.put(2,"EGG");
        foodMenu.put(3,"Aloo");

        priceMenu.put("PannerChilli",100);
        priceMenu.put("EGG",200);
        priceMenu.put("Aloo",150);


        System.out.println("-----------Welcome to Cafe---------------------");
        System.out.println("Please Tell Me Your name");
        String name = sc.next();
        System.out.println("Please Tell Me what would you like to have By select the options");
        User p1 = new User(name);
        printMenu();
       while(true){
        try{
            int option =getUserInput();
            if(option==4){
                // printBill(p1);
                p1.printBill();
                break;
            }
            System.out.println("Please Enter the Quantity");
            int Quantity = sc.nextInt();
            p1.addGoods(foodMenu.get(option), Quantity,priceMenu.get(foodMenu.get(option)));
            


        }catch(Exception e){
            printMenu();
        }
       } 
    }
}