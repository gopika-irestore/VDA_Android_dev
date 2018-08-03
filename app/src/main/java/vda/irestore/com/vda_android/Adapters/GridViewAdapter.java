package vda.irestore.com.vda_android.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.GridItem;
import vda.irestore.com.vda_android.R;


public class GridViewAdapter extends ArrayAdapter<GridItem> {

    //private final ColorMatrixColorFilter grayscaleFilter;
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();
    Typeface typeFace;


    public GridViewAdapter(Context mContext, int layoutResourceId, ArrayList<GridItem> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
        typeFace = Typeface.createFromAsset(mContext.getAssets(), "AvenirLTStd-Book.otf");

    }


    /**
     * Updates grid data and refresh grid items.
     *
     * @param mGridData
     */
    public void setGridData(ArrayList<GridItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final ViewHolder holder;
        typeFace = Typeface.createFromAsset(mContext.getAssets(), "AvenirLTStd-Book.otf");

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.grid_text);
            holder.imageView = (ImageView) row.findViewById(R.id.grid_image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        final GridItem item = mGridData.get(position);
        holder.titleTextView.setText(Html.fromHtml(item.getTitle()));
        holder.titleTextView.setTypeface(typeFace);
      //  imageView.setAlpha(mDim[position] ? 0.5f : 1.0f);

         Log.i("greeshma","inspection done=="+(item.getInspectionDone()));
         Picasso.with(mContext).load(item.getImage()).placeholder(R.mipmap.icn_plus).noFade()
                    .into(holder.imageView);



        return row;
    }
    public static Bitmap loadImageBitmap(Context context, String imageName) {
        Bitmap bitmap = null;
        FileInputStream fiStream;
        try {
            fiStream    = context.openFileInput(imageName);
            bitmap      = BitmapFactory.decodeStream(fiStream);
            fiStream.close();
        } catch (Exception e) {
            Log.d("saveImage", "Exception 3, Something went wrong!");
            e.printStackTrace();
        }
        return bitmap;
    }

    public static void writeBitmapToSD(String aFileName, Bitmap aBitmap) {

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }

        File sdPath = Environment.getExternalStorageDirectory();
        File sdFile = new File(sdPath, aFileName);

      /*  if (sdFile.exists()) {
            sdFile.delete ();
        }
*/
        try {
            FileOutputStream out = new FileOutputStream(sdFile);
            aBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {

        }

    }

    public static Bitmap loadImageFromSD(String aFileName) {
        Bitmap result = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                FileInputStream fis = new FileInputStream(new File(Environment.getExternalStorageDirectory(), aFileName));
                result = BitmapFactory.decodeStream(fis);
                fis.close();
            } catch (FileNotFoundException e) {
                Log.d("vidisha", "loadImageFromSD: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
    }
    public static Bitmap getBitmapFromURL(String imageUrl) {

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection)

                    url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap imageBitmap = BitmapFactory.decodeStream(inputStream);
            return imageBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}