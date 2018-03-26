package com.kmitl.phatipan.trustvegetable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kmitl.phatipan.trustvegetable.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class NewsListItem extends BaseCustomViewGroup {

    private TextView tvName;
    private TextView tvDescription;
    private ImageView ivImg;


    public NewsListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public NewsListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public NewsListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public NewsListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_news, this);
    }

    private void initInstances() {
        // findViewById here
        tvName = findViewById(R.id.tvNameNews);
        tvDescription = findViewById(R.id.tvDescriptionNews);
        ivImg = findViewById(R.id.ivImgNews);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec); // width in px
        int height = width * 2 / 3;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                height,
                MeasureSpec.EXACTLY
        );
        //Child view
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
        //Self
        setMeasuredDimension(width,height);
    }

    public void setNameText(String text){
        tvName.setText(text);
    }
    public void setDescriptionText(String text){
        tvDescription.setText(text);
    }

    public void setImage(int position){
        String url = "0 99ii";
        switch(position)
        {
            case 0 : url = "http://www.pandinthong.com/data/otop/pic/s/600200000002.jpg";
                break;
            case 1 : url = "http://www.pandinthong.com/data/otop/pic/s/600200000001.jpg";
                break;
            case 2 : url = "http://www.pandinthong.com/data/otop/pic/s/600100000001.jpg";
                break;
            case 3 : url = "http://www.pandinthong.com/data/otop/pic/s/591200000004.jpg";
                break;
            case 4 : url = "http://www.pandinthong.com/data/otop/pic/s/591200000003.jpg";
                break;
            case 5 : url = "http://www.pandinthong.com/data/otop/pic/s/591200000002.jpg";
                break;
            case 6 : url = "http://www.pandinthong.com/data/otop/pic/s/591200000001.jpg";
                break;
            case 7 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000007.jpg";
                break;
            case 8 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000006.jpg";
                break;
            case 9 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000005.jpg";
                break;
            case 10 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000004.jpg";
                break;
            case 11 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000003.jpg";
                break;
            case 12 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000002.jpg";
                break;
            case 13 : url = "http://www.pandinthong.com/data/otop/pic/s/591100000001.jpg";
                break;
            case 14 : url = "http://www.pandinthong.com/data/otop/pic/s/591000000005.jpg";
                break;
            case 15 : url = "http://www.pandinthong.com/data/otop/pic/s/591000000004.jpg";
                break;
            case 16 : url = "http://www.pandinthong.com/data/otop/pic/s/591000000003.jpg";
                break;
            case 17 : url = "http://www.pandinthong.com/data/otop/pic/s/591000000002.jpg";
                break;
            case 18 : url = "http://www.pandinthong.com/data/otop/pic/s/591000000001.jpg";
                break;
            case 19 : url = "http://www.pandinthong.com/data/otop/pic/s/590900000001.jpg";
                break;
        }
        Glide.with(getContext())
                .load(url)
                .into(ivImg);
    }
}
