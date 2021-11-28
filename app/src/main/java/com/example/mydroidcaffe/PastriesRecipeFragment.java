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
import java.util.Collection;
import java.util.Collections;


public class PastriesRecipeFragment extends Fragment {
    private RecyclerView pastriesRecyclerview;
    private ArrayList<Pastries> pastriesRecipeData;
    private PastriesAdapter pastriesAdapter;


    public PastriesRecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pastries_recipe, container, false);
        pastriesRecyclerview=rootView.findViewById(R.id.recycler_pastries);
        pastriesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        pastriesRecipeData= new ArrayList<>();
        pastriesAdapter= new PastriesAdapter(pastriesRecipeData,getContext());
        pastriesRecyclerview.setAdapter((pastriesAdapter));
        initializeData();
        ItemTouchHelper helper= new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to =viewHolder.getAdapterPosition();
                Collections.swap(pastriesRecipeData, from, to);
                pastriesAdapter.notifyItemMoved(from, to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                pastriesRecipeData.remove(viewHolder.getAdapterPosition());
                pastriesAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });
        helper.attachToRecyclerView(pastriesRecyclerview);


        return rootView;
    }

    private void initializeData() {
        String[] pastriesTitles = getResources().getStringArray(R.array.pastries_title);
        String[] pastriesDescription= getResources().getStringArray(R.array.pastries_description);
        TypedArray pastriesImages=getResources().obtainTypedArray(R.array.pastries_images);
        pastriesRecipeData.clear();
        for(int i=0;i<pastriesTitles.length;i++){
            pastriesRecipeData.add(new Pastries(pastriesImages.getResourceId(i,0),pastriesTitles[i],pastriesDescription[i]));
        }
        pastriesImages.recycle();
        pastriesAdapter.notifyDataSetChanged();


    }
}