package com.technorapper.staroyis.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by romit on 19/01/19.
 */

public class RetrofitClient {

  private static Retrofit retrofit = null;

  public static Retrofit getClient(String baseUrl){
    if(retrofit==null){
      retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit;
  }
}
