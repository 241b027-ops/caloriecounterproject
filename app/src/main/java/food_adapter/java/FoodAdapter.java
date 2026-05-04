package food_adapter.java;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriecounterapp.R;

import java.util.*;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    ArrayList<Food> list;

    public FoodAdapter(ArrayList<Food> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, cal;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tvName);
            cal = view.findViewById(R.id.tvCal);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = list.get(position);
        holder.name.setText(food.getName());
        holder.cal.setText(food.getCalories() + " kcal");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
