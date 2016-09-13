package cybodoc.garage.Api;

/**
 * Created by pratheesh on 11-09-2016.
 */


import cybodoc.garage.ModelClass.CarBrands;
import cybodoc.garage.ModelClass.Make;
import cybodoc.garage.ModelClass.Editorial;
import cybodoc.garage.ModelClass.RootObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pratheesh on 28-08-2016.
 */
public interface WebService {
   // https://api.edmunds.com/v1/content/editorreviews?make=honda&model=accord&year=2011&fmt=json&api_key=svddd53q99xzb75uetqf7dbh
    //https://api.edmunds.com/api/vehicle/v2/audi?state=used&view=basic&fmt=json&api_key=svddd53q99xzb75uetqf7dbh
    @GET("/api/vehicle/v2/makes")
    Call<CarBrands> getCarBrands(@Query("state") String state, @Query("view") String view, @Query("fmt") String fmt, @Query("api_key") String key);
    @GET("/api/vehicle/v2/{id}")
    Call<Make> getCarBrandModels(@Path("id") String niceName, @Query("state") String state, @Query("view") String view, @Query("fmt") String fmt, @Query("api_key") String key);
    @GET("/v1/content/editorreviews")
    Call<RootObject> getCarReviews(@Query("make") String make, @Query("model") String model, @Query("year") String year, @Query("fmt") String fmt, @Query("api_key") String key );

}

