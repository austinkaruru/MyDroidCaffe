package com.example.mydroidcaffe;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;


public class StoresFragment extends Fragment {


    private RecyclerView storesRecyclerview;
    private ArrayList<Store> storeData;
    private StoreAdapter storeAdapter;


    public StoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stores, container, false);
        storesRecyclerview=rootView.findViewById(R.id.recycler_stores);
        storesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        storeData= new ArrayList<>();
        storeAdapter= new StoreAdapter(storeData,getContext());
        storesRecyclerview.setAdapter((storeAdapter));
        initializeData();
        ItemTouchHelper helper= new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to =viewHolder.getAdapterPosition();
                Collections.swap(storeData, from, to);
                storeAdapter.notifyItemMoved(from, to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                storeData.remove(viewHolder.getAdapterPosition());
                storeAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });
        helper.attachToRecyclerView(storesRecyclerview);


        return rootView;
    }

    private void initializeData() {
        String[] storeTitles = getResources().getStringArray(R.array.store_title);
        String[] storeDescription= getResources().getStringArray(R.array.store_description);
        TypedArray storeImages=getResources().obtainTypedArray(R.array.store_images);
        storeData.clear();
        for(int i=0;i<storeTitles.length;i++){
            storeData.add(new Store(storeImages.getResourceId(i,0),storeTitles[i],storeDescription[i]));
        }
        storeImages.recycle();
        storeAdapter.notifyDataSetChanged();


    }
}