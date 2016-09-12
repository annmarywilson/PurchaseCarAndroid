package cybodoc.garage.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cybodoc.carpurchase.R;
import cybodoc.garage.Adapter.CarBrandModelsAdapter;
import cybodoc.garage.Adapter.CarBrandsAdapter;
import cybodoc.garage.ModelClass.CarBrands;
import cybodoc.garage.ModelClass.Make;
import cybodoc.garage.Utils.Constants;
import cybodoc.garage.Utils.utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pratheesh on 11-09-2016.
 */
public class UserApi extends BaseApi {
    public Context context;
public String key= Constants.API_KEY;
    public UserApi(Context context) {
        super(Constants.BASE_URL);
        this.context = context;

    }
    public void ListCarBrands(final RecyclerView recyclerView, final int resId, final View view) {
        final ProgressDialog progressDialog= utils.showProgressDialog(context);
        progressDialog.show();
        Call<CarBrands> call = webservice.getCarBrands("new","basic","json",key);
        call.enqueue(new Callback<CarBrands>() {
            @Override
            public void onResponse(Call<CarBrands> call, Response<CarBrands> response) {
                if (response.body()==null) {
                    progressDialog.cancel();
                    //EventBus.getDefault().postSticky(response.body());
                    recyclerView.setVisibility(View.INVISIBLE);
                    TextView emptyView=(TextView)view.findViewById(R.id.empty_view);
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    if(response.body().getMakesCount()==0)
                    {
                        progressDialog.cancel();
                        //EventBus.getDefault().postSticky(response.body());
                        recyclerView.setVisibility(View.INVISIBLE);
                        TextView emptyView=(TextView)view.findViewById(R.id.empty_view);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressDialog.cancel();
                        TextView emptyView = (TextView) view.findViewById(R.id.empty_view);
                        emptyView.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        //EventBus.getDefault().postSticky(response.body().getResult());
                        recyclerView.setAdapter(new CarBrandsAdapter(response.body().getMakes(), resId, context));
                    }
                }

            }

            @Override
            public void onFailure(Call<CarBrands> call, Throwable t) {
                progressDialog.cancel();
            }
        });

    }
    public void ListCarBrandModels(String niceName,final RecyclerView recyclerView, final int resId, final View view) {
        final ProgressDialog progressDialog= utils.showProgressDialog(context);
        progressDialog.show();
        Call<Make> call = webservice.getCarBrandModels(niceName,"new", "basic", "json", key);
        call.enqueue(new Callback<Make>() {
            @Override
            public void onResponse(Call<Make> call, Response<Make> response) {
                if (response.body()==null) {
                    progressDialog.cancel();
                    //EventBus.getDefault().postSticky(response.body());
                    recyclerView.setVisibility(View.INVISIBLE);
                    TextView emptyView=(TextView)view.findViewById(R.id.empty_view);
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    if(response.body().getModels().size()==0)
                    {
                        progressDialog.cancel();
                        //EventBus.getDefault().postSticky(response.body());
                        recyclerView.setVisibility(View.INVISIBLE);
                        TextView emptyView=(TextView)view.findViewById(R.id.empty_view);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressDialog.cancel();
                        TextView emptyView = (TextView) view.findViewById(R.id.empty_view);
                        emptyView.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        //EventBus.getDefault().postSticky(response.body().getResult());
                        recyclerView.setAdapter(new CarBrandModelsAdapter(response.body().getModels(), resId, context));
                    }
                }

            }

            @Override
            public void onFailure(Call<Make> call, Throwable t) {
                progressDialog.cancel();
            }
        });

    }
}