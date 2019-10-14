package com.example.mpping;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ProviderModel> imageModelArrayList;
    private Context ctx;

    public ProviderAdapter(Context ctx, ArrayList<ProviderModel> imageModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.ctx = ctx;
    }

    @Override
    public ProviderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.provide_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProviderAdapter.MyViewHolder holder, int position) {
        final ProviderModel provider =  imageModelArrayList.get(position);
        holder.providePhoto.setImageResource(provider.getImage_drawable());
        holder.providerName.setText(provider.getName());
        holder.providerStatus.setText(provider.getStatus());
        holder.providerJob.setText(provider.getJob());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent providerDetails = new Intent(ctx, ProviderDetails.class);
                providerDetails.putExtra("ProfImage", provider.getImage_drawable());
                providerDetails.putExtra("Name", provider.getName());
                providerDetails.putExtra("Status", provider.getStatus());
                providerDetails.putExtra("Job", provider.getJob());
//                providerDetails.putExtra("Name", provider.getName()); Get rating
                ctx.startActivity(providerDetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView providerName;
        TextView providerStatus;
        TextView providerJob;
        ImageView providePhoto;
        View mView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            providerName = (TextView) itemView.findViewById(R.id.provider_name);
            providerStatus = (TextView) itemView.findViewById(R.id.provider_status);
            providerJob = (TextView) itemView.findViewById(R.id.provider_career);
            providePhoto = (ImageView) itemView.findViewById(R.id.provider_profile_image);
        }

    }
}