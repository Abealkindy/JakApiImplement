package com.rosinante24.exploremuseum.network;

import com.rosinante24.exploremuseum.response.MuseumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Rosinante24 on 21/11/17.
 */

public interface ApiService {
    @Headers({"Authorization: " + "wfc2X6K0P9OVUTJkRE3DIYdrqMRSPCeCtFn8JnhpXbapVgL0bnyupIct23Ii6hw5"})
    @GET("museum")
    Call<MuseumResponse> getMuseumData();
}
