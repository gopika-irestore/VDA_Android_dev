package vda.irestore.com.vda_android.localDB;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vda.irestore.com.vda_android.R;


/**
 * Created by dell on 04-01-2018.
 */

public class MyreportAdapter extends ArrayAdapter {
    private ArrayList<MyReportData> dataSet;
    Context mContext;

    public MyreportAdapter(Context context, @LayoutRes int resource, ArrayList<MyReportData> data) {
        super(context, resource);
        this.dataSet = data;
        this.mContext = context;
    }

    // View lookup cache
    private static class ViewHolder {
        //        LinearLayout damageLayout, noteLayout, sizeLaayout, checkLayout;
        TextView address, poleID, poleHeight, date;
        ImageView inspectionImage1, inspectionImage2, inspectionImage3, inspectionImage4;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        final MyreportAdapter.ViewHolder viewHolder; // view lookup cache stored in tag
        Typeface typeFace = Typeface.createFromAsset(mContext.getAssets(), "AvenirLTStd-Book.otf");
        final View result;
        final int pos = position;
       // if (convertView == null) {
            viewHolder = new MyreportAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_view, parent, false);

            viewHolder.address = (TextView) convertView.findViewById(R.id.address);
            viewHolder.poleID = (TextView) convertView.findViewById(R.id.pole_id);
            viewHolder.poleHeight = (TextView) convertView.findViewById(R.id.pole_height);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);

            viewHolder.inspectionImage1 = (ImageView) convertView.findViewById(R.id.icon);
            viewHolder.inspectionImage2 = (ImageView) convertView.findViewById(R.id.icon_1);
            viewHolder.inspectionImage3 = (ImageView) convertView.findViewById(R.id.icon_2);
            viewHolder.inspectionImage4 = (ImageView) convertView.findViewById(R.id.icon_3);
            viewHolder.address.setTypeface(typeFace);
            convertView.setTag(viewHolder);
       /* } else {
            viewHolder = (MyreportAdapter.ViewHolder) convertView.getTag();
        }*/

        MyReportData myReportData = (MyReportData) getItem(position);


        viewHolder.address.setText(myReportData.ADDRESS);
        viewHolder.poleID.setText(myReportData.POLE_ID);
        viewHolder.poleHeight.setText(myReportData.POLE_HEIGHT);
        viewHolder.date.setText(myReportData.DATE);

        String isPoleTop = myReportData.POLETOP;
        String isPole = myReportData.POLE;
        String isUnderground = myReportData.UNDERGROUND;
        String isOthers = myReportData.OTHER;

        Log.i("vidisha","isPoleTop=="+isPoleTop);
        if (isPoleTop.equalsIgnoreCase("false"))
            viewHolder.inspectionImage1.setImageResource(R.drawable.poletop_sub);
        else
            viewHolder.inspectionImage1.setVisibility(View.GONE);//ImageResource(R.mipmap.home_poletop_disabled);
        if (isPole.equalsIgnoreCase("false"))
            viewHolder.inspectionImage2.setImageResource(R.drawable.pole_sub);
        else
            viewHolder.inspectionImage2.setVisibility(View.GONE);//.setImageResource(R.mipmap.home_poledamage_disabled);
        if (isUnderground.equalsIgnoreCase("false"))
            viewHolder.inspectionImage3.setImageResource(R.drawable.spl_sub1);
        else
            viewHolder.inspectionImage3.setVisibility(View.GONE);//setImageResource(R.mipmap.underground_header_disabled);
        if (isOthers.equalsIgnoreCase("false"))
            viewHolder.inspectionImage4.setImageResource(R.drawable.other_sub);
        else
            viewHolder.inspectionImage4.setVisibility(View.GONE);//.setImageResource(R.mipmap.other_header_disabled);
        return convertView;
    }
}
