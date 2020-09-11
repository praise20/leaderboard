package com.example.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterSkill extends RecyclerView.Adapter<MyAdapterSkill.CustomViewHolder> {

    private List<SkillModel> dataList;


    public MyAdapterSkill(List<SkillModel> dataList) {

        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

//Get a reference to the Views in our layout//

        public final View myView;

        TextView textView;
        TextView textView2;
        ImageView imageView2;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            textView = myView.findViewById(R.id.textView);
            textView2 = myView.findViewById(R.id.textView2);
            imageView2 = myView.findViewById(R.id.imageView2);

        }
    }

    @Override

//Construct a RecyclerView.ViewHolder//

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override

//Set the data//

    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position).getName());
        holder.textView2.setText(new StringBuilder().append(dataList.get(position).getScore()).append(" skill IQ score ").append(dataList.get(position).getCountry()).toString());
        holder.imageView2.setImageResource(R.drawable.skill );




    }

//Calculate the item count for the RecylerView//

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


