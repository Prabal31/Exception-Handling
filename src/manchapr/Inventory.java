package manchapr;

/**
 *
 * @author manch
 */
//hello
class Inventory {       //Creating class name "Inventory"
    
    //creating private variable of int,String and double
    private String id;
    private String name;
    private int qoh;
    private int rop;
    private double SellPrice;
    
    
    //The default constructor initialize the data members to their default values,
    Inventory() {
        id="ABC-1234";
        name="New item";
        qoh=0;
        rop=25;
        SellPrice=0.0;
    }
    
    //overloading construction
    Inventory(String id, String name, double sellPrice) {
    
    }
    
    //The multi-param constructors set the values of the appropriate data members to the param values
    Inventory(String id, String name, int qoh, int rop, double SellPrice) {
        this.id=id;
        this.name=name;
        this.qoh=qoh;
        this.rop=rop;
        this.SellPrice=SellPrice;
    }
    
    //get method to get the value of Id
    public String getId() {
        return id;
    }
    
    //set method to set the value of Id
    public void setId(String id) {
        this.id=id;
    }
    
    //get method to get the value of Name
    public String getName() {
        return name;
    }
    
    //set method to set the value of Name
    public void setName(String name) {
        this.name=name;
    }
    
    //get method to get the value of Qoh
    public int getQoh() {
        return qoh;
    }
    
    //set method to set the value of Qoh
    public void setQoh(int qoh) {
        this.qoh=qoh;
    }
    
    //get method to get the value of Rop
    public int getRop() {
        return rop;
    }
    
    //set method to set the value of Rop
    public void setRop(int rop) {
        this.rop=rop;
    }
    
    //get method to get the value of SellPrice
    public double getSellPrice() {
        return SellPrice;
    }
    
    //set method to set the value of SellPrice
    public void setSellPrice(double Sellprice) {
        this.SellPrice=Sellprice;
    }
    @Override
    
    //ToString method to return the string
    public String toString() {
        return id+" ("+name+"), "+"QOH: "+qoh+" Price: "+SellPrice;
    }
}    //end of class Inventory