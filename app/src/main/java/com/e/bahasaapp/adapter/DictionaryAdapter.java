package com.e.bahasaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.bahasaapp.R;
import com.e.bahasaapp.model.DictionaryModel;

import java.util.ArrayList;
import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.ViewHolder> implements Filterable {

    private ArrayList<DictionaryModel> dictionaryModels = new ArrayList<>();
    private Context context;
    private Filter mFilter = new ItemFilter();
    private List<DictionaryModel> mData;
    private List<DictionaryModel> mData2;


    public DictionaryAdapter(Context context, ArrayList<DictionaryModel> carsModels) {
        this.dictionaryModels=carsModels;
        this.mData2 = carsModels;
        this.context=context;
    }

    public DictionaryAdapter(Context context, ArrayList<DictionaryModel> carsModels, List<DictionaryModel>  data) {
        this.dictionaryModels=carsModels;
        this.context=context;
        this.mData2 = data;
    }


    @NonNull
    @Override
    public DictionaryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_dictionary,viewGroup,false);
        return new DictionaryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DictionaryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.indo.setText(dictionaryModels.get(i).getIndonesia());
        viewHolder.daerah.setText(dictionaryModels.get(i).getDaerah());

    }

    @Override
    public int getItemCount() {
        return dictionaryModels.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String filterString = charSequence.toString().toLowerCase();
            FilterResults filterResults = new FilterResults();

            if(filterString.length() > 0) {
                final List<DictionaryModel> result = new ArrayList<>();
                for(DictionaryModel w:mData2){
                    if(w.getIndonesia().toLowerCase().contains(filterString) || w.getDaerah().toLowerCase().contains(filterString)){
                        result.add(new DictionaryModel(w.getIndonesia(), w.getDaerah()));
                    }
                }
                if(result.size() == 0){
                    DictionaryModel word = new DictionaryModel("Data tidak ditemukan", "");
                    result.add(word);
                }
                filterResults.values = result;
                filterResults.count = result.size();
            } else {
                filterResults.values = mData2;
                filterResults.count = mData2.size();
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dictionaryModels = (ArrayList<DictionaryModel>) filterResults.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView indo,daerah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            indo= itemView.findViewById(R.id.tv_indo);
            daerah= itemView.findViewById(R.id.tv_daerah);
        }
    }

}
