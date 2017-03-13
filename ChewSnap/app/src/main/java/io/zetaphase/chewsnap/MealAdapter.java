package io.zetaphase.chewsnap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave Ho on 3/7/2017.
 */

public class MealAdapter extends ArrayAdapter<Meal>{
    private Context context;
    private List<Meal> mealList;


    public MealAdapter(Context context, int resource, ArrayList<Meal> meals){
        super(context, resource, meals);
        this.context = context;
        this.mealList = meals;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Meal meal = mealList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.meal_row, null);

        TextView title = (TextView) view.findViewById(R.id.mealTitle);
        TextView description = (TextView) view.findViewById(R.id.mealDescription);
        RatingBar rating = (RatingBar) view.findViewById(R.id.mealRating);

        title.setText(meal.getTitle());
        description.setText(meal.getDescription());
        rating.setRating(meal.getNumStars());

        return view;
    }

    public List<Meal> getMealList(){
        return mealList;
    }

    public void updateMealList(ArrayList<Meal> mealList){
        this.mealList = mealList;
    }
}
