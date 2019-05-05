package com.technorapper.staroyis.networking;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.technorapper.staroyis.ui.order.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by romit on 19/01/19.
 * Updated by Haneet
 */

public interface StaroyisApi {

    @GET("/petrol/api/products.php")
    Call<JsonObject> GetAllProduct(@Query("token") String token);

    @GET("/petrol/api/view_address.php")
    Call<JsonObject> GetAllAddresst(@Query("token") String token, @Query("user_id") int id);

    @GET("/petrol/api/otp.php")
    Call<JsonObject> otp(@Query("token") String token, @Query("mobile_number") String mobile_number);

    @GET("/petrol/api/login.php")
    Call<JsonObject> login(@Query("token") String toke, @Query("mobile_number") String mobile_number, @Query("password") String password);

    @GET("/petrol/api/register.php")
    Call<JsonObject> register(@Query("token") String toke, @Query("mobile_number") String mobile_number, @Query("name") String name, @Query("otp") String otp, @Query("password") String password);

    @GET("/petrol/api/add_address.php")
    Call<JsonObject> AddAddress(@Query("token") String toke, @Query("user_id") int id, @Query("address_one") String address_one, @Query("address_two") String address_two, @Query("city") String city, @Query("state") String state, @Query("pincode") String pincode, @Query("contact_person") String contact_person, @Query("contact_person_number") String contact_person_number);

    @GET("/petrol/api/view_address.php")
    Call<JsonObject> ViewAddress(@Query("token") String toke, @Query("mobile_number") String mobile_number, @Query("name") String name, @Query("otp") String otp, @Query("password") String password);

    @POST("/petrol/api/order.php")
    Call<JsonObject> Order(@Body JsonObject body);

    @GET("/petrol/api/order.php")
    Call<JsonObject> OrderJSON(@Query("token") String toke, @Query("user_id") String user_id, @Query("address_id") String address_id, @Query("subtotal") String subtotal, @Query("tax") String tax, @Query("total") String total, @Query("items") List<Item> items);

}

