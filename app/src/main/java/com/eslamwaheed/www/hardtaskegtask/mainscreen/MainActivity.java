package com.eslamwaheed.www.hardtaskegtask.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.eslamwaheed.www.hardtaskegtask.R;
import com.eslamwaheed.www.hardtaskegtask.application.App;
import com.eslamwaheed.www.hardtaskegtask.pojos.Category;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    @Inject
    MainMVP.Presenter presenter;

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        presenter.setView(this);
        recyclerView = findViewById(R.id.main_recyclerView);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(presenter, this);

        recyclerView.setAdapter(adapter);

        presenter.loadCategories(0, 1);
    }

    @Override
    public void onCardListItemClicked() {

    }

    @Override
    public void setResultList(List<Category> resultList) {
        adapter.refreshList(resultList);
    }
}
