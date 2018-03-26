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
public class FarmListItem extends BaseCustomViewGroup {

    private TextView tvName;
    private TextView tvDescription;
    private ImageView ivImg;

    private String[] n = {
            "บริษัท นอร์ธเทอร์น ฟู้ด คอมเพล็กซ์ จำกัด",
            "บริษัท คิวพลัส คอนเซพท์ จำกัด",
            "บริษัท ชิตา ออร์แกนิค ฟู้ด จำกัด",
            "บริษัท ซองเดอร์ไทยออร์กานิคฟูด จำกัด",
            "บริษัท ซานาบิล ฮาลาล ฟู้ด จำกัด",
            "บริษัท ซี.เค.อินดัสทรี่ (2000) จำกัด",
            "บริษัท ทรอปิคานา ออยล์ จำกัด",
            "บริษัท ทีพีไอ โพลีน ชีวะอินทรีย์ จำกัด",
            "บริษัท ท็อปออร์กานิกโปรดักส์แอนด์ซัพพลายส์ จำกัด"
    };
    private String[] l = {
            "ที่อยู่:  333/14 อาคารสำนักงานยูไนเต็ดทาวเวอร์ ชั้นที่ 8 ซ.สุขุมวิท 55(ทองหล่อ) ถ.สุขุมวิท แขวงคลองตันเหนือ เขตวัฒนา กทม. 10110",
            "ที่อยู่:  139 หมู่ 8 ต.บัวปากท่า อ.บางเลน จ.นครปฐม 73130",
            "ที่อยู่:  299 หมู่ที่ 7 ต.นครเจดีย์ อ.ป่าซาง จ.ลำพูน 51120",
            "ที่อยู่:  129 ม.1 ต.หนองโอ่ง อ.อู่ทอง จ.สุพรรณบุรี 72160 , ที่ติดต่อ: 48/55 ซ.รัตนาธิเบศร์ ต.บางกระสอ อ.เมืองนนทบุรี จ.นนทบุรี 11000",
            "ที่อยู่: 242/4 ชั้น 3 ถนนราษร์อุทิศ แขวงแสนแสบ เขตมีนบุรี กรุงเทพฯ 10510",
            "ที่อยู่: 83 หมู่ 7 ต. เกาะสำโรง อ.เมือง จังหวัดกาญจนบุรี 71000",
            "ที่อยู่: 35/9 หมู่ 4 ตำบลขุนแก้ว อำเภอนครชัยศรี จังหวัดนครปฐม 73120",
            "ที่อยู่:  26/56 TPI Tower ถ.จันทน์ตัดใหม่ แขวงทุ่งมหาเมฆ เขตสาทร กทม. 10120",
            "ที่อยู่:  126/83 ถนนกรุงธนบุรี แขวงบางลำภูล่าง เขตคลองสาน กรุงเทพฯ 10600"
    };
    private String[] url = {
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/sutharos_1.jpg",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/unnamed.png",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/logo_400x249_0.jpg",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/xongdur.jpg",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/sanabil_logo-3_01.jpg",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/ck.png",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/tropicana_oil_logo.jpg",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/tpipl-logo.jpg",
            "http://www.thaiorganictrade.com/sites/default/files/imagecache/member-scale-image/member/1299799441toporganic.jpg"
    };

    public FarmListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public FarmListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public FarmListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public FarmListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_farm, this);
    }

    private void initInstances() {
        // findViewById here

        tvName = findViewById(R.id.person_name);
        tvDescription = findViewById(R.id.person_age);
        ivImg = findViewById(R.id.person_photo);
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

    public void setNameText(int name){
        tvName.setText(n[name]);
    }
    public void setDescriptionText(int de){
        tvDescription.setText(l[de]);
    }

    public void setImage(int position){
        Glide.with(getContext())
                .load(url[position])
                .into(ivImg);
    }

}
