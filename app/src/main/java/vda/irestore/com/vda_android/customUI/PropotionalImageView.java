package vda.irestore.com.vda_android.customUI;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PropotionalImageView extends android.support.v7.widget.AppCompatImageView {

    public PropotionalImageView(Context context) {
        super(context);
    }

    public PropotionalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PropotionalImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getDrawable();
        if (d != null) {
            int w = MeasureSpec.getSize(widthMeasureSpec);
            int h = w * d.getIntrinsicHeight() / d.getIntrinsicWidth();
            setMeasuredDimension(w, h);
        }
        else super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
