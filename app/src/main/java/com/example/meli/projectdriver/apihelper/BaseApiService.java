package com.example.meli.projectdriver.apihelper;

import com.example.meli.projectdriver.model.GetDriver;
import com.example.meli.projectdriver.model.GetHistory;
import com.example.meli.projectdriver.model.GetRequest;
import com.example.meli.projectdriver.model.GetTransaksi;
import com.example.meli.projectdriver.model.GetUser;
import com.example.meli.projectdriver.model.PostRating;
import com.example.meli.projectdriver.model.PostRegister;
import com.example.meli.projectdriver.model.PostRequest;
import com.example.meli.projectdriver.model.PostSaldo;
import com.example.meli.projectdriver.model.PostTransaksi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("Register")
    Call<PostRegister>              postRegister(@Field("nik") String nik,
                                                 @Field("nama") String nama,
                                                 @Field("noHp") String noHp,
                                                 @Field("level") String level,
                                                 @Field("email") String email,
                                                 @Field("username") String username,
                                                 @Field("password") String password);

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody>              getLogin(@Field("username") String username,
                                             @Field("password") String password);


    @GET("DriverLihat")
    Call<GetDriver> getDriver();

    @FormUrlEncoded
    @POST("RequestOrder")
    Call<PostRequest>               postRequest(@Field("id_driver") int id_driver,
                                               @Field("id_user") int id_user,
                                               @Field("tujuan") String tujuan,
                                               @Field("lat") double lat,
                                               @Field("longs") double longs,
                                               @Field("status") String status);

    @GET("RequestOrder")
    Call<GetRequest>                getRequest(@Query("id_driver") String id_driver);

    @FormUrlEncoded
    @PUT("RequestOrder")
    Call<PostRequest>               putRequest(@Field("idReq") String idReq,@Field("id_driver") String id_driver);

    @GET("Request")
    Call<GetRequest>                getRequestDone(@Query("id_driver") String id_driver,
                                                   @Query("id_user") String id_user);

    @FormUrlEncoded
    @PUT("Request")
    Call<PostRequest>               putRequestReject(@Field("idReq") String idReq);


    @GET("DriverAndro")
    Call<GetTransaksi>                getTransaksi(@Query("id_driver") String id_driver, @Query("id_user") String id_user);

    @FormUrlEncoded
    @PUT("DriverAndro")
    Call<PostTransaksi>               putTransaksi(@Field("id_driver") String id_driver,@Field("id_transaksi") String id_transaksi, @Field("endTime") String endTime);

    @FormUrlEncoded
    @POST("Rating")
    Call<PostRating>                  postRating(@Field("rating") float rating,
                                                 @Field("transaksi_id") int transaksi_id);

    @GET("Rating")
    Call<PostRating>                getRating(@Query("id_transaksi") String id_transaksi);

    @GET("History")
    Call<GetHistory>                getHistory(@Query("id_driver") String id_driver);

    @GET("HistoryUser")
    Call<GetHistory>                getHistoryUser(@Query("id_user") String id_user);

    @FormUrlEncoded
    @POST("TransaksiAndro")
    Call<PostTransaksi>             postTransaksi(@Field("id_user") int id_user,
                                                  @Field("id_driver") int id_driver,
                                                  @Field("startTime") String startTime,
                                                  @Field("endTime") String endTime,
                                                  @Field("totalHarga") double totalHarga,
                                                  @Field("latJem") double latJem,
                                                  @Field("longJem") double longJem,
                                                  @Field("lokasi_jemput") String lokasi_jemput,
                                                  @Field("latTuj") double latTuj,
                                                  @Field("longTuj") double longTuj,
                                                  @Field("tujuan") String tujuan,
                                                  @Field("status") String status);

    @GET("SaldoAndro")
    Call<GetUser>                getUser(@Query("id") int id);

    @FormUrlEncoded
    @POST("SaldoAndro")
    Call<PostSaldo>                 postSaldo(@Field("id_user") int id_user,
                                              @Field("saldoEpay") double saldoEpay,
                                              @Field("rekening") String rekening,
                                              @Field("status") String status);

    @FormUrlEncoded
    @PUT("SaldoUpdate")
    Call<GetUser>                 updateSaldo(@Field("id") int id,
                                              @Field("saldoEpay") double saldoEpay);

    @FormUrlEncoded
    @PUT("Register")
    Call<GetUser>                 updateProfile(@Field("id") int id,
                                                @Field("nama") String nama,
                                                @Field("noHp") String noHp,
                                                @Field("email") String email);

}
