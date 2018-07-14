package com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen;

public class DetailMVP {
    interface View {

        void onCardListItemClicked();

        void setResultList();
    }

    public interface Presenter {

        void setView(View view);

        void register();

        void terminate();
    }

    interface Model {

    }
}
