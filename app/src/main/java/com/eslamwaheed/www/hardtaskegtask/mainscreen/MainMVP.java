package com.eslamwaheed.www.hardtaskegtask.mainscreen;


import com.eslamwaheed.www.hardtaskegtask.pojos.Category;

import java.util.List;

public interface MainMVP {

    interface View {

        void onCardListItemClicked(Category category);

        void setResultList(List<Category> resultList);
    }

    interface Presenter {
        void setView(View view);

        void goToDetailActivity(Category category);

        void loadCategories(int categoryId, int countryId);

        void register();

        void terminate();
    }

    interface Model {

    }
}
