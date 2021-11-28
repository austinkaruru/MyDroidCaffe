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

/*STep 1
Create a Recipe adapter that extends the RecyclerView.Adapter amd uses the Recyclerview.ViewHolder class
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    //Step3.0 Declare the private member variables Recipe Data and the context
    private ArrayList<Recipe> recipeData;
    private Context myContext;
    /*
    Step 3.1 Create a Constructor to pass in the recipe data and the context
     */
    RecipeAdapter(ArrayList<Recipe>mRecipeData,Context context ){
        //initialize the objects
        this.myContext=context;
        this.recipeData=mRecipeData;
    }
    @NonNull
    @Override
    /*Step 1.1 Required
    implement the method onCreateViewHolder for creating viewHolder objects
    @param parent. The view group of which the view object will be added after it is bound to the adapter position
    @param viewType viewType of the new view
    @return the newly created viewHolder
     */
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Step 4.1 Create a new view holder
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item,parent,false));

    }
    /*Step 1.1 Required for binding the view to the data
    @holder viewHolder which the data should be put
    @position the adapter position
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        //Step 5 Get the current view object using its position and populate it with data
        Recipe currentRecipe= recipeData.get(position);
        //Step 5.1 Populate the current view with data
        holder.bindTo(currentRecipe);

    }
    /*Step 1.1 Required for getting the size of the data set
    @return the size of the dataset

     */

    @Override
    public int getItemCount() {
        //Step 4.0
        return recipeData.size();
    }
    /*Step 2 Create the ViewHolder class that represents each and every row in the recycler view

     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        /*Step 2.1
        Create a constructor for the ViewHolder used in onCreateViewHolder() method
        @param itemView rootView of the recipe_list_item layout
        */
        //Step 2.2 Declare the private member variables that the viewHolder will hold
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecipeImage=itemView.findViewById(R.id.recipe_image);
            myRecipeTitle=itemView.findViewById(R.id.recipe_title);
            myRecipeDescription=itemView.findViewById(R.id.recipe_description);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int dessertPosition= getAdapterPosition();
                    Recipe currentDessert = recipeData.get(dessertPosition);
                    if(dessertPosition==0){
                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);

                    }else if(dessertPosition==1){
                        Intent cakeIntent = new Intent(myContext,CakeActivity.class);
                        cakeIntent.putExtra("cTitle",currentDessert.getRecipeTitle());
                        cakeIntent.putExtra("cImage",currentDessert.getRecipeImage());
                        cakeIntent.putExtra("cDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(cakeIntent);

                    }else if(dessertPosition==2){
                        Intent sandIntent = new Intent(myContext,SandActivity.class);
                        sandIntent.putExtra("sTitle",currentDessert.getRecipeTitle());
                        sandIntent.putExtra("sImage",currentDessert.getRecipeImage());
                        sandIntent.putExtra("sDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(sandIntent);
                    }
                    else if(dessertPosition==3){
                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);

                    }else if(dessertPosition==4){
                        Intent cakeIntent = new Intent(myContext,CakeActivity.class);
                        cakeIntent.putExtra("cTitle",currentDessert.getRecipeTitle());
                        cakeIntent.putExtra("cImage",currentDessert.getRecipeImage());
                        cakeIntent.putExtra("cDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(cakeIntent);

                    }else if(dessertPosition==5){
                        Intent sandIntent = new Intent(myContext,SandActivity.class);
                        sandIntent.putExtra("sTitle",currentDessert.getRecipeTitle());
                        sandIntent.putExtra("sImage",currentDessert.getRecipeImage());
                        sandIntent.putExtra("sDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(sandIntent);
                    }
                    else{
                        Toast.makeText(myContext,"create an activity for the dessert",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
/*Step 6 Create a method to bind the current view with data(Image, title and description

 */
        public void bindTo(Recipe currentRecipe) {
            /*Step 6.1 Populate the view with the data
            for loading the image use the Glide library so as to prevent problems of app crashing as a result of loading many images of different resolutions
            Implement the Glide library first in your Gradle Module(App) Level

             */
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());

        }
    }
}
