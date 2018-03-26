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
import com.kmitl.phatipan.trustvegetable.adapter.CookingListAdapter;
import com.kmitl.phatipan.trustvegetable.dao.CookingItemCollectionDao;
import com.kmitl.phatipan.trustvegetable.dao.CookingItemDao;
import com.kmitl.phatipan.trustvegetable.manager.Contextor;
import com.kmitl.phatipan.trustvegetable.manager.CookingListManager;
import com.kmitl.phatipan.trustvegetable.manager.http.HttpManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CookingFragment extends Fragment {

    private ListView listView;
    CookingListAdapter listAdapter;
    CookingItemDao dao;
    String url;

    public CookingFragment() {
        super();
    }

    public static CookingFragment newInstance() {
        CookingFragment fragment = new CookingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cooking, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here


        listView = rootView.findViewById(R.id.listViewCooking);
        listAdapter = new CookingListAdapter();
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listViewItemClickListener);


        Call<CookingItemCollectionDao> call = HttpManager.getInstance().getCookingService().loadPhotoList();
        call.enqueue(new Callback<CookingItemCollectionDao>() {
            @Override
            public void onResponse(Call<CookingItemCollectionDao> call, Response<CookingItemCollectionDao> response) {
                if (response.isSuccessful()){
                    CookingItemCollectionDao dao = response.body();
                    CookingListManager.getInstance().setDao(dao);
                    listAdapter.notifyDataSetChanged();
                }else {
                    // fail
                    try {
                        Toast.makeText(Contextor.getInstance().getContext(),
                                response.errorBody().string(),
                                Toast.LENGTH_LONG)
                                .show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<CookingItemCollectionDao> call, Throwable t) {
                //unconnect server
                Toast.makeText(Contextor.getInstance().getContext(),
                        t.toString(),
                        Toast.LENGTH_SHORT)
                        .show();
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

    final AdapterView.OnItemClickListener listViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(Contextor.getInstance().getContext(),"Open Browser",Toast.LENGTH_SHORT).show();

            switch (position) {
                case 0:
                    url = "https://www.bloggang.com/viewdiary.php?id=cheftoon&group=3";
                    break;
                case 1:
                    url = "http://mat.bkk96.com/#post44";
                    break;
                case 2:
                    url = "http://mat.bkk96.com/#post43";
                    break;
                case 3:
                    url = "http://mat.bkk96.com/#post42";
                    break;
                case 4:
                    url = "http://mat.bkk96.com/#post41";
                    break;
                case 5:
                    url = "http://mat.bkk96.com/#post40";
                    break;
                case 6:
                    url = "http://mat.bkk96.com/#post39";
                    break;
                case 7:
                    url = "https://www.youtube.com/watch?v=9WWQIYs7e7s";
                    break;
                case 8:
                    url = "http://mat.bkk96.com/#post37";
                    break;
                case 9:
                    url = "http://mat.bkk96.com/#post36";
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
