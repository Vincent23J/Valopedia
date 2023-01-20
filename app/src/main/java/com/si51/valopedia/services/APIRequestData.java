package com.si51.valopedia.services;

import android.hardware.lights.LightState;

import com.si51.valopedia.models.ValorantData;
import com.si51.valopedia.models.ValorantDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("agent")
    Call<ValorantData> VALORANT_DATA_CALL(
            @Query("offset") int offset,
            @Query("limit") int limit
    );

    @GET("agent/{uuid}")
    Call<ValorantDetail>  VALORANT_DETAIL_CALL(
            @Path("uuid") String uuid
    );

}
