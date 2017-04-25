package yuzhentao.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * PhoneService
 *
 * @author yuzhentao
 */
public interface PhoneService {

    @GET("/apistore/mobilenumber/mobilenumber")
    Call<PhoneResult> getResult(@Header("apikey") String apikey, @Query("phone") String phone);

}