package com.beyondthehorizon.marapap;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyViewHolder>
        implements Filterable {

    private LayoutInflater inflater;
    private ArrayList<ProviderModel> providerModelArrayList;
    private Context ctx;
    private int layoutItem;
    private ArrayList<ProviderModel> providersListFiltered;

    public ProviderAdapter(Context ctx, ArrayList<ProviderModel> providerModelArrayList, int layoutItem) {

        inflater = LayoutInflater.from(ctx);
        this.providerModelArrayList = providerModelArrayList;
        this.providersListFiltered = providerModelArrayList;
        this.ctx = ctx;
        this.layoutItem = layoutItem;
    }

    @Override
    public ProviderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(layoutItem, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProviderAdapter.MyViewHolder holder, int position) {
        final ProviderModel provider = providerModelArrayList.get(position);
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
        return providerModelArrayList.size();
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

    @Override
    public Filter getFilter() {
        return filteredProvidersList;
    }

    private Filter filteredProvidersList = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<ProviderModel> filteredList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(providersListFiltered);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (ProviderModel item : providerModelArrayList) {
                    if (item.getJob().toLowerCase().contains(filterPattern) || item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            providerModelArrayList = (ArrayList<ProviderModel>) filterResults.values;
            notifyDataSetChanged();
        }
    };
}