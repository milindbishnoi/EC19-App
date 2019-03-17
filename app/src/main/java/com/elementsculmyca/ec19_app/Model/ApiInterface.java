package com.elementsculmyca.ec19_app.Model;

import com.elementsculmyca.ec19_app.MainScreen.EventListModel;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    public static final String BASE_URL = "https://culmyca19.herokuapp.com/";
    @POST("allevent")
    Call<ArrayList<EventListModel>> getEventList();


}
