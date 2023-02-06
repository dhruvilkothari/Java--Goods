import java.util.*;

class FF {
   private int id;
   private int quantity;

   public FF(int id,int quantity){
      this.id  = id;
      this.quantity = quantity;
   } 

   public void updateDetails() {

   }




}

class User {
   private ArrayList<Integer> food;
   private int price;
   

  public User(){
      System.out.println("User Updated");
      food = new ArrayList<>();
      price=0;
   }

   public void updateUserDetails (int priceValue , int id){
      price+=priceValue;
      food.add(id);
   }


   public  void showDetails (HashMap <Integer,String> foodMap,HashMap<String,Integer> priceMap) {
      System.out.println("FOOD ITEM -----------------------------> PRICE");
      for(int i=0;i<food.size();i++){
         int option = food.get(i);
         System.out.println(foodMap.get(option)+"----------------------------->"+priceMap.get(foodMap.get(option)));
      }
      System.out.println("Total Price------------------------------------------------->"+price);
   }
}




class Test {

   public static int confirmation(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Please Confirm Your Order");
      int ans= sc.nextInt();      
      return ans;
   }
   


  public static void printLogo(){
      System.out.println("----------------------Cloud Kitchen-------------------");
   }

   public static void printoption () {
      System.out.print("1)Nachos ----- 175\n2)paneerchili ----- 200\n3)Egg -------- 150\n");
   }

   public static int getUserInput(){
      int option=-1;
      System.out.println("Please Select a required option");
      Scanner sc = new Scanner(System.in);
      option = sc.nextInt();
      // sc.close();
      if(option <1 || option >3)return -1;
      return option;
   }

   public static void main(String args[]){
      int option = 99;
      Scanner sc = new Scanner(System.in);
      HashMap <Integer,String> foodMap = new HashMap<>();
      foodMap.put(1,"Nachos");
      foodMap.put(2, "paneerchili");
      foodMap.put(3, "Egg");
      HashMap<String,Integer> priceMap = new HashMap<>();
      priceMap.put("Nachos", 175);
      priceMap.put("paneerchili", 200);
      priceMap.put("Egg", 150);
      printLogo();
      printoption();
      User p1 =new User();
      while(option!=-1){
         try{
            option = getUserInput();
            if(option ==-1){
               try{
                  // break;
                  System.out.println("Please Select a Valid Option");
                  option = getUserInput();
                  if(option==-1){
                     break;
                  }
               }catch(Exception e){
                  break;
               }
            }
         }catch(Exception e){
            System.out.println("Wrong Input.Please Select Valid option or Exit with Key -1");
            continue;
         }

         int confirm = confirmation();
         if(confirm==0){
            System.out.println("NOT Ordered");
            continue;
         }

         int priceValue = priceMap.get(foodMap.get(option));

         // System.out.println(priceValue);
         p1.updateUserDetails(priceValue, option);
      }
      p1.showDetails(foodMap, priceMap);
      sc.close();
      

   }
}