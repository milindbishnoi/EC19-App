package com.elementsculmyca.ec19_app.Model;

import com.google.gson.JsonElement;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("activity/list/")
    Call<JsonElement> getEventList(@Body RequestBody body);

    @GET("activity/{activityId}")
    Call<JsonElement> getEventDetail(@Path("activityId") String id);

    @GET("/mytickets")
    Call<List<MyTickets>> getTickets();
}
