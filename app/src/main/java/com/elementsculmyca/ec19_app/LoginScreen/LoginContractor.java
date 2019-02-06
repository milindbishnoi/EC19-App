package com.elementsculmyca.ec19_app.LoginScreen;

public interface LoginContractor {

    void getNextQuote(OnFinishedListener listener);

    void sendLoginData();

    interface OnFinishedListener {
        void onFinished(String string);
    }


}
