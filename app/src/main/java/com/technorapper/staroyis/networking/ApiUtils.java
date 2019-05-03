package com.technorapper.staroyis.networking;

/**
 * Created by romit on 18/01/19.
 */

public class ApiUtils {

  public static String API_BASE_URL = "https://demo-project.live";

  public static StaroyisApi getBaseUrl() {
    return RetrofitClient.getClient(API_BASE_URL).create(StaroyisApi.class);
  }
}
