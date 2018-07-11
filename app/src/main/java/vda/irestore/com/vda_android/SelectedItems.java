package vda.irestore.com.vda_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.String.valueOf;

public class SelectedItems extends AppCompatActivity {
    private ImageView image1;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> alName;
    ArrayList<Integer> alImage;
    HashMap<Integer,String> imageMapping = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteditems);
        int wireflag = 1;
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            int firstimage = bundle.getInt("wireImage");
            int wireid = bundle.getInt("wireId");
          //  Toast.makeText(SelectedItems.this,valueOf(wireid),Toast.LENGTH_LONG).show();
            int secondimage = bundle.getInt("poletopImage");
            int thirdimage = bundle.getInt("splImage");
            int fourthimage = bundle.getInt("poleImage");
            int fifthimage = bundle.getInt("treeImage");
            int sixthimage = bundle.getInt("otherImage");
            imageMapping.put(firstimage,"Wire");
            imageMapping.put(secondimage,"poletopImage");
            imageMapping.put(thirdimage,"splImage");
            imageMapping.put(fourthimage,"poleImage");
            imageMapping.put(fifthimage,"treeImage");
            imageMapping.put(sixthimage,"otherImage");
            Integer images[] = {firstimage,secondimage,thirdimage,fourthimage,fifthimage,sixthimage};
            LinearLayout imageGallery = (LinearLayout) findViewById(R.id.imageGallery);
            for (Integer image : images) {
                imageGallery.addView(getImageView(image,images));
            }

        }

    }
    private View getImageView(final Integer image, final Integer[] images) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SelectedItems.this,"clicked"+imageMapping.get(image),Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5, 10, 5, 0);
        imageView.setLayoutParams(lp);
        imageView.setImageResource(image);
        return imageView;
    }
}
