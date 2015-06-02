package fob_solution.com.xmlparsertwo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    ArrayList<Food> foodsList = new ArrayList<Food>();

    public List<Food> getFoods() {
        return  foodsList;
    }

    private String name;
    private String price;
    private String calories;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            XmlPullParser foodsParser = getResources().getXml(R.xml.foods);
            int eventType = foodsParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) {
                    if (foodsParser.getName().equals("name")) {
                        foodsParser.next();
                        name = foodsParser.getText();
                    } else if (foodsParser.getName().equals("price")) {
                        foodsParser.next();
                        price = foodsParser.getText();
                    } else if (foodsParser.getName().equals("calories")) {
                        foodsParser.next();
                        calories = foodsParser.getText();
                    } else if (foodsParser.getName().equals("descrition")) {
                        foodsParser.next();
                        desc = foodsParser.getText();
                    }
                }
                if (eventType == XmlPullParser.END_TAG && foodsParser.getName().equals("food")) {
                    foodsList.add(new Food(name, price, calories, desc));
                }

                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Toast.makeText(this, "Error XML-file loading: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }


        String[] from = new String[]{Food.name, Food.price, Food.calories};
        int[] to = new int[]{R.id.nameView, R.id.priceView, R.id.calorView};

        ListAdapter adapter = new SimpleAdapter(this, foodsList, R.layout.food_list_item, from, to);
        setListAdapter(adapter);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
            Food food = (Food) parent.getItemAtPosition(pos);
            Toast.makeText(getApplicationContext(), food.getDescrition(), Toast.LENGTH_LONG).show();
        }
    };
}