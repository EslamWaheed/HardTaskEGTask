package com.eslamwaheed.www.hardtaskegtask.mainscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eslamwaheed.www.hardtaskegtask.R;
import com.eslamwaheed.www.hardtaskegtask.application.App;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen.DetailFragment;
import com.eslamwaheed.www.hardtaskegtask.pojos.Category;

import java.util.List;

import javax.inject.Inject;

public class MainFragment extends Fragment implements MainMVP.View {

    @Inject
    MainMVP.Presenter presenter;

    @Inject
    Context context;

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);
        ((App) getActivity().getApplication()).getComponent().inject(this);

        toolbar = fragmentView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        presenter.setView(this);
        recyclerView = fragmentView.findViewById(R.id.main_recyclerView);

        layoutManager = new GridLayoutManager(context, 2);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(presenter, context);

        recyclerView.setAdapter(adapter);

        presenter.loadCategories(0, 1);
        return fragmentView;
    }

    @Override
    public void onCardListItemClicked(Category category) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("category", category);
        detailFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, detailFragment)
                .commit();
    }

    @Override
    public void setResultList(List<Category> categoryList) {
        adapter.refreshList(categoryList);
    }
}
