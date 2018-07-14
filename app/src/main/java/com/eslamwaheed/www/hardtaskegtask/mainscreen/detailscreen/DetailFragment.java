package com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eslamwaheed.www.hardtaskegtask.R;
import com.eslamwaheed.www.hardtaskegtask.application.App;
import com.eslamwaheed.www.hardtaskegtask.pojos.Category;
import com.eslamwaheed.www.hardtaskegtask.pojos.SubCategory;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class DetailFragment extends Fragment implements DetailMVP.View {

    private static String TAG = "DetailFragment";
    @Inject
    DetailMVP.Presenter presenter;

    @Inject
    Context context;

    private RecyclerView recyclerView;
    private DetailAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<SubCategory> subCategories;
    Toolbar toolbar;
    TextView toolbar_text;

    static private Typeface typefaceArabic;
    static private Typeface typefaceEnglish;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);
        ((App) getActivity().getApplication()).getComponent().inject(this);

        toolbar = fragmentView.findViewById(R.id.toolbar);
        toolbar_text = fragmentView.findViewById(R.id.toolbar_text);

        typefaceArabic = Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/ge_dinar_one_medium.ttf");
        typefaceEnglish = Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/montserrat_regular.ttf");

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle bundle = this.getArguments();

        try {
            Category category = (Category) bundle.getSerializable("category");
            subCategories = category.getSubCategories();

            // for language
            if (Locale.getDefault().getLanguage().equals("en")) {
                toolbar_text.setTypeface(typefaceEnglish);
                toolbar_text.setText(category.getTitleEN());
            } else {
                toolbar_text.setTypeface(typefaceArabic);
                toolbar_text.setText(category.getTitleAR());
            }

        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
        }


        presenter.setView(this);
        recyclerView = fragmentView.findViewById(R.id.detail_recyclerView);

        layoutManager = new GridLayoutManager(context, 2);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new DetailAdapter(presenter, context);

        recyclerView.setAdapter(adapter);

        this.setResultList();

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.register();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.terminate();
    }

    @Override
    public void onCardListItemClicked() {

    }

    @Override
    public void setResultList() {
        adapter.refreshList(subCategories);
    }
}
