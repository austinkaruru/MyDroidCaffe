package com.example.mydroidcaffe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
private ArrayList<Store> storeData;
private Context sContext;

        StoreAdapter(ArrayList<Store> mStoreData, Context context){
        this.sContext=context;
        this.storeData=mStoreData;
        }
@NonNull
@Override
public StoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(sContext).inflate(R.layout.store_list_item,parent,false));

        }

    @NonNull
    @Override
public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder holder, int position) {
        Store currentStore=storeData.get(position);
        holder.bindTo(currentStore);

        }

@Override
public int getItemCount() {

        return storeData.size();
        }

private ImageView myStoreImage;
private TextView myStoreTitle;
private TextView myStoreDescription;
public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        myStoreImage=itemView.findViewById(R.id.store_image);
        myStoreTitle=itemView.findViewById(R.id.store_title);
        myStoreDescription=itemView.findViewById(R.id.store_description);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int storePosition= getAdapterPosition();
                Store currentStore = storeData.get(storePosition);
                if(storePosition==0){
                    Intent thehubIntent = new Intent(sContext,TheHubActivity.class);
                    thehubIntent.putExtra("thTitle",currentStore.getStoreTitle());
                    thehubIntent.putExtra("thImage",currentStore.getStoreImage());
                    thehubIntent.putExtra("thDescription",currentStore.getStoreDescription());
                    sContext.startActivity(thehubIntent);

                }else if(storePosition==1){
                    Intent galleriaIntent = new Intent(sContext,GalleriaActivity.class);
                    galleriaIntent.putExtra("gTitle",currentStore.getStoreTitle());
                    galleriaIntent.putExtra("gImage",currentStore.getStoreImage());
                    galleriaIntent.putExtra("gDescription",currentStore.getStoreDescription());
                    sContext.startActivity(galleriaIntent);

                }else if(storePosition==2){
                    Intent trmIntent = new Intent(sContext,TRMActivity.class);
                    trmIntent.putExtra("trTitle",currentStore.getStoreTitle());
                    trmIntent.putExtra("trImage",currentStore.getStoreImage());
                    trmIntent.putExtra("trDescription",currentStore.getStoreDescription());
                    sContext.startActivity(trmIntent);
                }
                else if(storePosition==3){
                    Intent westgateIntent = new Intent(sContext,WestgateActivity.class);
                    westgateIntent.putExtra("wTitle",currentStore.getStoreTitle());
                    westgateIntent.putExtra("wImage",currentStore.getStoreImage());
                    westgateIntent.putExtra("wDescription",currentStore.getStoreDescription());
                    sContext.startActivity(westgateIntent);

                }else if(storePosition==4){
                    Intent tworiversIntent = new Intent(sContext,TwoRiversActivity.class);
                    tworiversIntent.putExtra("twTitle",currentStore.getStoreTitle());
                    tworiversIntent.putExtra("twImage",currentStore.getStoreImage());
                    tworiversIntent.putExtra("twDescription",currentStore.getStoreDescription());
                    sContext.startActivity(tworiversIntent);

                }else if(storePosition==5){
                    Intent villageIntent = new Intent(sContext,VillageActivity.class);
                    villageIntent.putExtra("vTitle",currentStore.getStoreTitle());
                    villageIntent.putExtra("vImage",currentStore.getStoreImage());
                    villageIntent.putExtra("vDescription",currentStore.getStoreDescription());
                    sContext.startActivity(villageIntent);
                }
                else{
                    Toast.makeText(sContext,"create an activity for the Store",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void bindTo(Store currentStore) {
        Glide.with(sContext).load(currentStore.getStoreImage()).into(myStoreImage);
        myStoreTitle.setText(currentStore.getStoreTitle());
        myStoreDescription.setText(currentStore.getStoreDescription());
    }
}
}
