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
import com.kmitl.phatipan.trustvegetable.adapter.NewsListAdapter;
import com.kmitl.phatipan.trustvegetable.dao.NewsItemCollectionDao;
import com.kmitl.phatipan.trustvegetable.dao.NewsItemDao;
import com.kmitl.phatipan.trustvegetable.manager.Contextor;
import com.kmitl.phatipan.trustvegetable.manager.NewsListManager;
import com.kmitl.phatipan.trustvegetable.manager.http.HttpManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment {

    private ListView listViewMain;
    NewsListAdapter listAdapter;

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here

        listViewMain = rootView.findViewById(R.id.listViewMain);
        listAdapter = new NewsListAdapter();
        listViewMain.setAdapter(listAdapter);
        listViewMain.setOnItemClickListener(listViewItemClickListener);

        Call<NewsItemCollectionDao> call = HttpManager.getInstance().getNewsService().loadPhotoList();
        call.enqueue(new Callback<NewsItemCollectionDao>() {
            @Override
            public void onResponse(Call<NewsItemCollectionDao> call, Response<NewsItemCollectionDao> response) {
                if (response.isSuccessful()){
                    NewsItemCollectionDao dao = response.body();
                    NewsListManager.getInstance().setDao(dao);
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
            public void onFailure(Call<NewsItemCollectionDao> call, Throwable t) {
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
            NewsItemDao dao = (NewsItemDao) NewsListManager.getInstance().getDao().getItem().get(position);
            Toast.makeText(Contextor.getInstance().getContext(),"Open Browser",Toast.LENGTH_SHORT).show();

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dao.getLink()));
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
