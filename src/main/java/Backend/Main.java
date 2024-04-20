package Backend;


public class Main {
    public static void main (String [] args){
        System.out.println("Hello World");
        
        Dogs dog = new Dogs("Negrita", "Street Dog", 10, 90, 10, "black", "Nigga Katia");
        //System.out.println(dog);
        
        DogsDAO dogDAO = new DogsDAO();
        int resultDog = dogDAO.insertDog(dog);
        if(resultDog == 1){
            System.out.println("Dog has been inserted");
        }else{
            System.out.println("Unable to insert dog");
        }
        
        Cats cat = new Cats("Michi", "street cat", 5, 50, 3, "orange", "Katia nigga");
        //System.out.println(cat);
        
        CatsDAO catDAO = new CatsDAO();
        int resultCat = catDAO.addCat(cat);
        if(resultCat == 1){
            System.out.println("Cat has been inserted");
        }else{
            System.out.println("Unable to insert cat");
        }
        
       
        
       
        
        
        
    
    
    
    } 

}
