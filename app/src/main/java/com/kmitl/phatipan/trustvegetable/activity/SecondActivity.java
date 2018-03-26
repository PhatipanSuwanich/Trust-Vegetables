package com.kmitl.phatipan.trustvegetable.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kmitl.phatipan.trustvegetable.R;

public class SecondActivity extends AppCompatActivity {

    private DatabaseReference mRootRef;
    private ValueEventListener mValueEventListener;
    private String pk;
    private TextView data1;
    private TextView data2;
    private TextView data3;
    private TextView data4;
    private TextView data5;
    private TextView data6;
    private TextView data7;
    private TextView data8;
    private TextView data9;
    private TextView data10;
    private TextView data11;
    private TextView data12;
    private TextView data13;
    private TextView data14;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();

        Intent intent = getIntent();
        pk = intent.getStringExtra("Primary Key");
    }

    private void init() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRootRef = FirebaseDatabase.getInstance().getReference();

        iv = findViewById(R.id.TvSE);
        data1 = findViewById(R.id.data1);
        data2 = findViewById(R.id.data2);
        data3 = findViewById(R.id.data3);
        data4 = findViewById(R.id.data4);
        data5 = findViewById(R.id.data5);
        data6 = findViewById(R.id.data6);
        data7 = findViewById(R.id.data7);
        data8 = findViewById(R.id.data8);
        data9 = findViewById(R.id.data9);
        data10 = findViewById(R.id.data10);
        data11 = findViewById(R.id.data11);
        data12 = findViewById(R.id.data12);
        data13 = findViewById(R.id.data13);
        data14 = findViewById(R.id.data14);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = (dataSnapshot.child(pk).child("ชื่อสินค้า").getValue(String.class));
                data1.setText("ชื่อสินค้า : " + data);
                data = (dataSnapshot.child(pk).child("ลำดับสินค้า").getValue(String.class));
                data2.setText("ลำดับสินค้า : " + data);
                data = (dataSnapshot.child(pk).child("ขนาดบรรจุ").getValue(String.class));
                data3.setText("ขนาดบรรจุ : " + data);
                data = (dataSnapshot.child(pk).child("ราคา").getValue(String.class));
                data4.setText("ราคา : " + data);
                data = (dataSnapshot.child(pk).child("รหัสผู้ผลิต").getValue(String.class));
                data5.setText("รหัสผู้ผลิต : " + data);
                data = (dataSnapshot.child(pk).child("ชื่อผู้ผลิต").getValue(String.class));
                data6.setText("ชื่อผู้ผลิต : " + data);
                data = (dataSnapshot.child(pk).child("ชนิดผัก").getValue(String.class));
                data7.setText("ชนิดผัก : " + data);
                data = (dataSnapshot.child(pk).child("GAP").getValue(String.class));
                data8.setText("มาตรฐาน GAP : " + data);
                data = (dataSnapshot.child(pk).child("GMP").getValue(String.class));
                data9.setText("มาตรฐาน GMP : " + data);
                data = (dataSnapshot.child(pk).child("HACCP").getValue(String.class));
                data10.setText("มาตรฐาน HACCP : " + data);
                data = (dataSnapshot.child(pk).child("Q").getValue(String.class));
                data11.setText("มาตรฐาน Q : " + data);
                data = (dataSnapshot.child(pk).child("รหัสโรงงานคัดบรรจุ").getValue(String.class));
                data12.setText("รหัสโรงงานคัดบรรจุ : " + data);
                data = (dataSnapshot.child(pk).child("ชื่อโรงงานคัดบรรจุ").getValue(String.class));
                data13.setText("ชื่อโรงงานคัดบรรจุ : " + data);
                data = (dataSnapshot.child(pk).child("ล็อตวัตถุดิบ").getValue(String.class));
                data14.setText("ล็อตวัตถุดิบ : " + data);
                String url = (dataSnapshot.child(pk).child("รูป").getValue(String.class));
                Glide.with(getApplication()).load(url).into(iv);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplication(), "Failed: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mRootRef.addValueEventListener(mValueEventListener);


    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mValueEventListener != null) {
            mRootRef.removeEventListener(mValueEventListener);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
