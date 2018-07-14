package com.eslamwaheed.www.hardtaskegtask.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eslamwaheed.www.hardtaskegtask.R;
import com.eslamwaheed.www.hardtaskegtask.application.App;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen.DetailFragment;
import com.eslamwaheed.www.hardtaskegtask.pojos.Category;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    @Inject
    MainMVP.Presenter presenter;

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter.setView(this);
        recyclerView = findViewById(R.id.main_recyclerView);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(presenter, this);

        recyclerView.setAdapter(adapter);

        presenter.loadCategories(0, 1);
    }

    @Override
    public void onCardListItemClicked(Category category) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("category", category);
        detailFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_frame, detailFragment)
                .commit();
    }

    @Override
    public void setResultList(List<Category> categoryList) {
        adapter.refreshList(categoryList);
    }
}
