package com.kmitl.phatipan.trustvegetable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.kmitl.phatipan.trustvegetable.R;

import static com.kmitl.phatipan.trustvegetable.R.mipmap.mat;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CookingListItem extends BaseCustomViewGroup {

    private TextView tvName;
    private TextView tvDescription;
    private ImageView ivImg;


    public CookingListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CookingListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public CookingListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public CookingListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_photo, this);
    }

    private void initInstances() {
        // findViewById here
        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvDescription);
        ivImg = findViewById(R.id.ivImg);
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
    public void setImage(String position){
        switch(position)
        {
            case "9db1a1695afaefd6e122d657703843e6": ivImg.setImageResource(R.mipmap.mat);
                break;
            case "b9eeea793b9185cbbdbc67bbeef25a9b": ivImg.setImageResource(R.mipmap.mat1);
                break;
            case "03a2b85d69b9dac9577b94f3aab06e92": ivImg.setImageResource(R.mipmap.mat2);
                break;
            case "08150dc3d927d9e7fcb9c74a62b14418": ivImg.setImageResource(R.mipmap.mat3);
                break;
            case "7a9bacf99434651ffbf3a6c8fd71604b": ivImg.setImageResource(R.mipmap.mat4);
                break;
            case "afb2b6b18d217de52e936db7f67c74c5": ivImg.setImageResource(R.mipmap.mat5);
                break;
            case "8f17ff44f274e0af217a87ae56039655": ivImg.setImageResource(R.mipmap.mat6);
                break;
            case "032bc40a18a3ac3758764d80033e9f29": ivImg.setImageResource(R.mipmap.mat7);
                break;
            case "e836cdc8dc8c41475440a79245338c2b": ivImg.setImageResource(R.mipmap.mat8);
                break;
            case "f5a56a39e2fe65dd2cef5995b6626a24": ivImg.setImageResource(R.mipmap.mat9);
                break;

        }
    }
}
