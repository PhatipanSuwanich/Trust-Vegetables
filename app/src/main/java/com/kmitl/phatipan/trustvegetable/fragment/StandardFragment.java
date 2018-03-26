package com.kmitl.phatipan.trustvegetable.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.kmitl.phatipan.trustvegetable.R;
import com.kmitl.phatipan.trustvegetable.adapter.StardardGridAdapter;
import com.kmitl.phatipan.trustvegetable.manager.Contextor;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class StandardFragment extends Fragment {

    private GridView gridview;
    private StardardGridAdapter listAdapter;
    private String url;

    public StandardFragment() {
        super();
    }

    public static StandardFragment newInstance() {
        StandardFragment fragment = new StandardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_standard, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here

        gridview = (GridView) rootView.findViewById(R.id.gridview);
        listAdapter = new StardardGridAdapter();
        gridview.setAdapter(listAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Contextor.getInstance().getContext(),"Open Browser",Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        url = "https://www.thaibio.com/อย.%20คือ%20อะไร";
                        break;
                    case 1:
                        url = "http://www.onep.go.th/library/index.php?option=com_content&view=article&id=86:gmp-good-manufacturing-practice&catid=22:2012-03-12-02-54-55&Itemid=31";
                        break;
                    case 2:
                        url = "http://masci.or.th/service/มาตรฐานระบบการวิเคราะห/";
                        break;
                    case 3:
                        url = "http://www.oae.go.th/infoservice/GAP.html";
                        break;
                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
                }
        });
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();
    }

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
