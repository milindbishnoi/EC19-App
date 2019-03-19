package com.elementsculmyca.ec19_app.DataSources;

import com.elementsculmyca.ec19_app.DataSources.DataModels.ClubEventResponse;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.ResponseModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.SponsorModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.TicketModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    public static final String BASE_URL = "https://culmyca19.herokuapp.com/";

    @POST("allevent")
    Call<ArrayList<EventDataModel>> getEventList();

    @POST("eventbyid")
    Call<EventDataModel> getEventById(@Field("id") String id);

    @POST("clubevent")
    Call<ArrayList<ClubEventResponse>> getEventByClub(@Field("club") String club);

    @POST("mytickets")
    Call<ArrayList<TicketModel>> getTickets(@Field("phone") String phone);

    @GET("showtrending")
    Call<ArrayList<EventDataModel>> getTrendingList();

    @GET("sponsors")
    Call<ArrayList<SponsorModel>> getSponsorList();

    @GET("updateTrending")
    Call<ResponseModel> updateTrending(@Query("id") String eventId);

    @POST("register")
    Call<ResponseModel> postregisterEvent(@Field("name") String name,
                                          @Field("phone") String phone,
                                          @Field("email") String email,
                                          @Field("college") String college,
                                          @Field("eventid") String eventid,
                                          @Field("eventname") String eventname,
                                          @Field("team") String team,
                                          @Field("timestamp") String timestamp
    );

}
