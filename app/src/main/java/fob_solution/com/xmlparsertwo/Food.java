package fob_solution.com.xmlparsertwo;

/*public class Food extends HashMap<String, String> {

    static String NAME = "name";
    static String PRICE = "price";
    static String CALOR = "calories";
    static String DESC = "descrition";


    public Food(String name, String price, String calor, String desc) {
        super();
        super.put(NAME, name);
        super.put(PRICE, price);
        super.put(CALOR, calor);
        super.put(DESC, desc);
    }

    public String getDetails(String desc) {
        String result = desc;
        return result;
    }
*/

public class Food {
    public Food(String name, String price, String calories, String desc) {
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected static String name;
    protected int id;
    protected static String price;
    protected static String calories;
    protected static String descrition;
}