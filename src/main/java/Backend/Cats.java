package Backend;


public class Cats {
    
    // Attributes
    
    // Attributes
    
    private int idCat;
    private String catsName;
    private String kind;
    private int age;
    private double height;
    private double weight;
    private String color;
    private String ownersname;
    
    // Constructur
    
    public Cats(){
    }

    public Cats(String catsName, String kind, int age, double height, double weight, String color, String ownersname) {
        this.catsName = catsName;
        this.kind = kind;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.ownersname = ownersname;
    }
    
    // Getters & Setters

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getCatsName() {
        return catsName;
    }

    public void setCatsName(String catsName) {
        this.catsName = catsName;
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
    
    // toString

    @Override
    public String toString() {
        return "Cats{" + "idCat=" + idCat + ", catsName=" + catsName + ", kind=" + kind + ", age=" + age + ", height=" + height + ", weight=" + weight + ", color=" + color + ", ownersname=" + ownersname + '}';
    }
    
    

}
