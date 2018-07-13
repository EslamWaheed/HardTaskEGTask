package com.eslamwaheed.www.hardtaskegtask.mainscreen;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eslamwaheed.www.hardtaskegtask.R;
import com.eslamwaheed.www.hardtaskegtask.pojos.Category;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private MainMVP.Presenter presenter;
    private Context context;
    private List<Category> categories;
    static private Typeface typefaceArabic;
    static private Typeface typefaceEnglish;

    public MainAdapter(MainMVP.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        typefaceArabic = Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/ge_dinar_one_medium.ttf");
        typefaceEnglish = Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/montserrat_regular.ttf");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Category category = categories.get(position);

        Picasso.with(context).load(category.getPhoto()).into(holder.Photo);

        // for language
        if (Locale.getDefault().getLanguage().equals("en")) {
            holder.title.setText(category.getTitleEN());
        } else {
            holder.title.setText(category.getTitleAR());
        }
        holder.ProductCount.setText("(" + category.getProductCount() + ")");
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToDetailActivity();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (categories != null)
            return categories.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView Photo;
        public TextView title;
        public TextView ProductCount;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            this.Photo = itemView.findViewById(R.id.Photo);
            this.title = itemView.findViewById(R.id.title);
            this.ProductCount = itemView.findViewById(R.id.ProductCount);

            // for language
            if (Locale.getDefault().getLanguage().equals("en")) {
                this.title.setTypeface(typefaceEnglish);
                this.ProductCount.setTypeface(typefaceEnglish);
            } else {
                this.title.setTypeface(typefaceArabic);
                this.ProductCount.setTypeface(typefaceArabic);
            }
        }
    }

    public void refreshList(List<Category> categoryList) {
        this.categories = categoryList;
        notifyDataSetChanged();
    }
}
