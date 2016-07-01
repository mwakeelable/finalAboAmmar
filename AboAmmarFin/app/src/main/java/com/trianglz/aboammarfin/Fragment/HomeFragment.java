package com.trianglz.aboammarfin.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.trianglz.aboammarfin.model.Data_Model;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    MainActivity activity;
    private static RecyclerView recyclerView;
    public static final String[] TITLES = {"Hood", "Full Sleeve Shirt", "Shirt", "Jean Jacket", "Jacket"};
    public static final Integer[] IMAGES = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,};

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Data_Model> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new Data_Model(TITLES[i],IMAGES[i]));
        }
        RecyclerView_Adapter  adapter = new RecyclerView_Adapter(activity, arrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private ArrayList<Data_Model> arrayList;
        private Context context;

        public RecyclerView_Adapter(Context context, ArrayList<Data_Model> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public int getItemCount() {
            return (null != arrayList ? arrayList.size() : 0);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            final Data_Model model = arrayList.get(position);
            RecyclerViewHolder mainHolder = (RecyclerViewHolder) holder;
            Bitmap image = BitmapFactory.decodeResource(context.getResources(),
                    model.getImage());
            mainHolder.title.setText(model.getTitle());
            mainHolder.imageview.setImageBitmap(image);
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
            ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                    R.layout.item_row, viewGroup, false);
            RecyclerViewHolder listHolder = new RecyclerViewHolder(mainGroup);
            return listHolder;
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView imageview;

        public RecyclerViewHolder(View view) {
            super(view);
            this.title = (TextView) view
                    .findViewById(R.id.title);
            this.imageview = (ImageView) view
                    .findViewById(R.id.image);
        }
    }
}
