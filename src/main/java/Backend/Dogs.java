package Backend;


public class Dogs {
    
    // Attributes
    
    private int idDog;
    private String dogsName;
    private String kind;
    private int age;
    private double height;
    private double weight;
    private String color;
    private String ownersname;
    
    // Constructor
    
    public Dogs(){
    }

    public Dogs(String dogsName, String kind, int age, double height, double weight, String color, String ownersname) {
        this.dogsName = dogsName;
        this.kind = kind;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.ownersname = ownersname;
    }
    
    // Getters & Setters            

    public int getIdDog() {
        return idDog;
    }

    public void setIdDog(int idDog) {
        this.idDog = idDog;
    }

    public String getDogsName() {
        return dogsName;
    }

    public void setDogsName(String dogsName) {
        this.dogsName = dogsName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnersname() {
        return ownersname;
    }

    public void setOwnersname(String ownersname) {
        this.ownersname = ownersname;
    }
    
    //toString

    @Override
    public String toString() {
        return "Dogs{" + "idDog=" + idDog + ", dogsName=" + dogsName + ", kind=" + kind + ", age=" + age + ", height=" + height + ", weight=" + weight + ", color=" + color + ", ownersname=" + ownersname + '}';
    }
    
    

}
