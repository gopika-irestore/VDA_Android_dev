package vda.irestore.com.vda_android.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;
import vda.irestore.com.vda_android.R;
import vda.irestore.com.vda_android.SelectedItems;

/**
 * Created by MALBEL on 07-08-2017.
 */

public class InspectionMetaDataAdapter extends ArrayAdapter<InspectionMetaData> implements View.OnClickListener {

    private ArrayList<InspectionMetaData> dataSet;
    Context mContext;
    ListView listView;
    public static HashMap<Integer, String> myList = new HashMap<Integer, String>();

    // View lookup cache
    private static class ViewHolder {
        TextView inspectionName;
        ImageView inspectionImage;
    }

    public InspectionMetaDataAdapter(ArrayList<InspectionMetaData> data, Context context, ListView listView) {
        super(context, R.layout.inspection_data_item, data);
        this.dataSet = data;
        this.mContext = context;
//        this.listView = listView;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void add(@Nullable InspectionMetaData object) {
        int index = -1;
        if(mContext instanceof SelectedItems)
            index = ((SelectedItems)mContext).verticalItemSelectedPosition;

        if(index == -1)
            dataSet.add(object);
        else
            dataSet.add(index, object);
    }

    @Override
    public void remove(@Nullable InspectionMetaData object) {
        dataSet.remove(object);
    }

    /*  @Override
                  public boolean isEnabled(int position) {
                      return false;
                  }*/
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        Typeface typeFace = Typeface.createFromAsset(mContext.getAssets(), "AvenirLTStd-Book.otf");

        //  if (convertView == null) {
        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.inspection_data_item, parent, false);
        viewHolder.inspectionName = (TextView) convertView.findViewById(R.id.pendingInspectionHeading1);
        viewHolder.inspectionImage = (ImageView) convertView.findViewById(R.id.pendingImage1);

        convertView.setTag(viewHolder);
       /* } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
*/
        InspectionMetaData inspectionMetaData = (InspectionMetaData) getItem(position);
//        dataSet.get(position).getDisplayName()
        viewHolder.inspectionName.setText(inspectionMetaData.getDisplayName());
        viewHolder.inspectionName.setTypeface(typeFace);
//        dataSet.get(position).getImageUrl()
        if(inspectionMetaData.getIsSelected() != null && inspectionMetaData.getDisplayName() != null && !inspectionMetaData.getDisplayName().isEmpty()) {
            viewHolder.inspectionImage.setVisibility(View.VISIBLE);
            viewHolder.inspectionName.setVisibility(View.VISIBLE);
            if(!inspectionMetaData.getIsSelected()) {
                Log.d("dinesh111", "displaying unselected/ default item");
                Picasso.with(mContext).load(inspectionMetaData.getImageUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(viewHolder.inspectionImage);
            }else {
                Picasso.with(mContext).load("https://s3.amazonaws.com/restore-build-artefacts/InspectionIcons/damage_tick.png")
                        .into(viewHolder.inspectionImage);
                Log.d("dinesh111", "displaying selected item");
            }
        } else {
            viewHolder.inspectionName.setVisibility(View.GONE);
            viewHolder.inspectionImage.setVisibility(View.GONE);
        }
        notifyDataSetChanged();
        return convertView;
    }
}
