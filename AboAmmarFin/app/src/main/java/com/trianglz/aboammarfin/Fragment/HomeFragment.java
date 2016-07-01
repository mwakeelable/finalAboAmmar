package com.trianglz.aboammarfin.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trianglz.aboammarfin.R;
import com.trianglz.aboammarfin.UI.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    MainActivity activity;
    private static RecyclerView recyclerView;

    public HomeFragment() {

    }

    public class Data_Model {
        private String title;
        private int image;

        public Data_Model(String title, int image) {
            this.title = title;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public int getImage() {
            return image;
        }
    }

    private List<Data_Model> getAllItemList() {
        List<Data_Model> allItems = new ArrayList<Data_Model>();
        allItems.add(new Data_Model(activity.getString(R.string.category1), R.drawable.album1));
        allItems.add(new Data_Model(activity.getString(R.string.category2), R.drawable.album2));
        allItems.add(new Data_Model(activity.getString(R.string.category3), R.drawable.album3));
        allItems.add(new Data_Model(activity.getString(R.string.category4), R.drawable.album4));
        allItems.add(new Data_Model(activity.getString(R.string.category5), R.drawable.album5));
        allItems.add(new Data_Model(activity.getString(R.string.category6), R.drawable.orange));
        return allItems;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        List<Data_Model> rowListItem = getAllItemList();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        llm.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        HomeAdapter adapter = new HomeAdapter(activity, rowListItem);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    class HomeAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<Data_Model> itemList;
        private Context context;

        public HomeAdapter(Context context, List<Data_Model> itemList) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, null);
            ViewHolder rcv = new ViewHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mNameTextView.setTextSize(16);
            holder.mNameTextView.setText(itemList.get(position).getTitle());
            holder.mImageView.setImageResource(itemList.get(position).getImage());
        }

        @Override
        public int getItemCount() {
            return this.itemList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mNameTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mNameTextView = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
