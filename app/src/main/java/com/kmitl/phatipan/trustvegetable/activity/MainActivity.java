package com.kmitl.phatipan.trustvegetable.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kmitl.phatipan.trustvegetable.R;
import com.kmitl.phatipan.trustvegetable.fragment.CookingFragment;
import com.kmitl.phatipan.trustvegetable.fragment.FarmFragment;
import com.kmitl.phatipan.trustvegetable.fragment.MainFragment;
import com.kmitl.phatipan.trustvegetable.fragment.StandardFragment;
import com.kmitl.phatipan.trustvegetable.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public static final int REQUEST_QR_SCAN = 4;
    private Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabLayout;
    private int pk;
    private int pk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.pager, MainFragment.newInstance())
                    .commit();
        }

    }

    private void init() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(this);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        setupViewPager(pager);
    }

    //รอรับผลการ scan
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents = intent.getStringExtra("SCAN_RESULT");
            String content = contents.substring(8,12);
            String con = contents.substring(0,8);
            pk = Integer.parseInt(content);
            pk1 = pk - 0000;
            // Do behind scan
            if (con.equals("85580111") && pk1 >= 0 && pk1 <= 40) {
                Intent mainToSecon = new Intent(MainActivity.this, SecondActivity.class);
                mainToSecon.putExtra("Primary Key", contents);
                startActivity(mainToSecon);
            }else
                Toast.makeText(getApplication(), "ไม่พบข้อมูลสินค้า", Toast.LENGTH_SHORT).show();

        }
    }


    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment(), "News");
        adapter.addFragment(new CookingFragment(), "Cooking");
        adapter.addFragment(new FarmFragment(), "Farm");
        adapter.addFragment(new StandardFragment(), "Standard");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_scanner) {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            startActivityForResult(Intent.createChooser(intent, "Scan with"), REQUEST_QR_SCAN);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0: toolbar.setTitle(R.string.name_news);
                break;
            case 1: toolbar.setTitle(R.string.name_cooking);
                break;
            case 2: toolbar.setTitle(R.string.name_farm);
                break;
            case 3: toolbar.setTitle(R.string.name_standard);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
