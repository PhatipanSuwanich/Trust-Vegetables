package com.kmitl.phatipan.trustvegetable.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kmitl.phatipan.trustvegetable.R;
import com.kmitl.phatipan.trustvegetable.adapter.FarmListAdapter;
import com.kmitl.phatipan.trustvegetable.manager.Contextor;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FarmFragment extends Fragment {

    private ListView listViewMain;
    private FarmListAdapter listAdapter;
    private String url;

    public FarmFragment() {
        super();
    }

    public static FarmFragment newInstance() {
        FarmFragment fragment = new FarmFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_farm, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here

        listViewMain = rootView.findViewById(R.id.listViewFarm);
        listAdapter = new FarmListAdapter();
        listViewMain.setAdapter(listAdapter);
        listViewMain.setOnItemClickListener(listViewItemClickListener);

    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();
    }

    final AdapterView.OnItemClickListener listViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Contextor.getInstance().getContext(), "Open Browser", Toast.LENGTH_SHORT).show();
            switch (position) {
                case 0:
                    url = "http://www.northernfoodcomplex.com";
                    break;
                case 1:
                    url = "http://www.qplusfood.com";
                    break;
                case 2:
                    url = "https://www.chitaorganicfood.co.th";
                    break;
                case 3:
                    url = "http://www.xongdur.com";
                    break;
                case 4:
                    url = "http://www.greenektar.com";
                    break;
                case 5:
                    url = "http://www.ckindustry.co.th";
                    break;
                case 6:
                    url = "http://www.tropicanaoil.com";
                    break;
                case 7:
                    url = "http://www.tpipolene.co.th/Thai/fertilizer.html";
                    break;
                case 8:
                    url = "http://www.toporganicproduct.com";
                    break;
            }
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    };

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
