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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PastriesAdapter extends RecyclerView.Adapter<PastriesAdapter.ViewHolder>{
    private ArrayList<Pastries> pastriesData;
    private Context mContext;

    PastriesAdapter(ArrayList<Pastries> mPastriesData,Context context){
        this.mContext=context;
        this.pastriesData=mPastriesData;
    }
    @NonNull
    @Override
    public PastriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.pastries_list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull PastriesAdapter.ViewHolder holder, int position) {
        Pastries currentPastries=pastriesData.get(position);
        holder.bindTo(currentPastries);

    }

    @Override
    public int getItemCount() {

        return pastriesData.size();
    }

    private ImageView myPastriesImage;
    private TextView myPastriesTitle;
    private TextView myPastriesDescription;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myPastriesImage=itemView.findViewById(R.id.pastries_image);
            myPastriesTitle=itemView.findViewById(R.id.pastries_title);
            myPastriesDescription=itemView.findViewById(R.id.pastries_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pastriesPosition= getAdapterPosition();
                    Pastries currentPastries = pastriesData.get(pastriesPosition);
                    if(pastriesPosition==0){
                        Intent croissantIntent = new Intent(mContext,CroissantActivity.class);
                        croissantIntent.putExtra("crTitle",currentPastries.getPastriesTitle());
                        croissantIntent.putExtra("crImage",currentPastries.getPastriesImage());
                        croissantIntent.putExtra("crDescription",currentPastries.getPastriesDescription());
                        mContext.startActivity(croissantIntent);

                    }else if(pastriesPosition==1){
                        Intent pretzelIntent = new Intent(mContext,PretzelActivity.class);
                        pretzelIntent.putExtra("pTitle",currentPastries.getPastriesTitle());
                        pretzelIntent.putExtra("pImage",currentPastries.getPastriesImage());
                        pretzelIntent.putExtra("pDescription",currentPastries.getPastriesDescription());
                        mContext.startActivity(pretzelIntent);

                    }else if(pastriesPosition==2){
                        Intent strudelIntent = new Intent(mContext,StrudelActivity.class);
                        strudelIntent.putExtra("stTitle",currentPastries.getPastriesTitle());
                        strudelIntent.putExtra("stImage",currentPastries.getPastriesImage());
                        strudelIntent.putExtra("stDescription",currentPastries.getPastriesDescription());
                        mContext.startActivity(strudelIntent);
                    }
                    else if(pastriesPosition==3){
                        Intent croissantIntent = new Intent(mContext,CroissantActivity.class);
                        croissantIntent.putExtra("crTitle",currentPastries.getPastriesTitle());
                        croissantIntent.putExtra("crImage",currentPastries.getPastriesImage());
                        croissantIntent.putExtra("crDescription",currentPastries.getPastriesDescription());
                        mContext.startActivity(croissantIntent);

                    }else if(pastriesPosition==4){
                        Intent pretzelIntent = new Intent(mContext,PretzelActivity.class);
                        pretzelIntent.putExtra("pTitle",currentPastries.getPastriesTitle());
                        pretzelIntent.putExtra("pImage",currentPastries.getPastriesImage());
                        pretzelIntent.putExtra("pDescription",currentPastries.getPastriesDescription());
                        mContext.startActivity(pretzelIntent);

                    }else if(pastriesPosition==5){
                        Intent strudelIntent = new Intent(mContext,StrudelActivity.class);
                        strudelIntent.putExtra("stTitle",currentPastries.getPastriesTitle());
                        strudelIntent.putExtra("stImage",currentPastries.getPastriesImage());
                        strudelIntent.putExtra("stDescription",currentPastries.getPastriesDescription());
                        mContext.startActivity(strudelIntent);
                    }
                    else{
                        Toast.makeText(mContext,"create an activity for the pastries",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        public void bindTo(Pastries currentPastries) {
            Glide.with(mContext).load(currentPastries.getPastriesImage()).into(myPastriesImage);
            myPastriesTitle.setText(currentPastries.getPastriesTitle());
            myPastriesDescription.setText(currentPastries.getPastriesDescription());
        }
    }
}
