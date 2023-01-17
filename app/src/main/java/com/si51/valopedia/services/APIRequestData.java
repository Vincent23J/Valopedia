package com.si51.valopedia.services;

import com.si51.valopedia.models.ValorantData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("agent")
    Call <ValorantData> VALORANT_DATA_CALL(
            @Query("offset") int offset,
            @Query("limit") int limit
    );

}
