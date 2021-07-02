package com.royalcars.jd.dealershipapp;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.royalcars.jd.dealershipapp.JavaBean.Credits;
;
import java.util.ArrayList;

public class CreditsRecycleViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Credits> credits;

    public CreditsRecycleViewAdapter(ArrayList<Credits> credits) {
        this.credits = credits;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credits_card, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final Credits credit = credits.get(position);

        ((CustomViewHolder) holder).title.setText(credit.getCreditsTitle());
        ((CustomViewHolder) holder).author.setText(credit.getCreditsAuthor());
        ((CustomViewHolder) holder).desc.setText(credit.getCreditsDesc());

        ((CustomViewHolder) holder).card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(credit.getCreditsLink()));
                if(intent.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivity(intent);
                } else {
                    Toast.makeText(activity.getApplicationContext(),
                            "You do not have the correct software", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return (credits != null ? credits.size() : 0);
    }

    /**
     * @author Chris Dias
     * @date November 16th, 2018
     * @version 1.0
     *
     * CustomViewHolder Constructor
     *
     */
    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected CardView card;
        protected TextView title;
        protected TextView author;
        protected TextView desc;
        protected View view;


        public CustomViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
            this.card = view.findViewById(R.id.credits_cardview);
            this.title = view.findViewById(R.id.creditsTitle);
            this.author = view.findViewById(R.id.creditsAuthor);
            this.desc = view.findViewById(R.id.creditsDesc);
        }
    }

}
