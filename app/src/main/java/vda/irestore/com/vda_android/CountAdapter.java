package vda.irestore.com.vda_android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * Created by MalbelTechnologies on 13-11-2017.
 */

public class CountAdapter extends RecyclerView.Adapter<CountAdapter.MyViewHolder> {

    public ArrayList defectCount = new ArrayList<String>();
    Context context = null;
    public CountAdapter(Context mActivty, ArrayList<String> numberOfDefect) {
        context = mActivty;
        defectCount = numberOfDefect;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button number;

        public MyViewHolder(View itemView) {
            super(itemView);
            number = (Button) itemView.findViewById(R.id.button_count);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
                holder.number.setText(defectCount.get(position).toString());

            if(((SelectedItems)context).horizontalItemSelectedPosition == position){
                holder.number.setBackgroundColor(context.getResources().getColor(R.color.green));
            } else {
                holder.number.setBackgroundColor(context.getResources().getColor(R.color.lightGray));
            }

    }

    @Override
    public int getItemCount() {
        return defectCount.size();
    }
}
