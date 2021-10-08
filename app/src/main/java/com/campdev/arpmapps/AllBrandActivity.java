package com.campdev.arpmapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.campdev.arpmapps.Adapter.RecyclerviewAdapter;
import com.campdev.arpmapps.Api.RequestAPI;
import com.campdev.arpmapps.Model.DataMobil;
import com.campdev.arpmapps.Model.JSONResponse;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class AllBrandActivity extends AppCompatActivity {

    public static final String url = "http://arpmpanel.xyz/admin/";
    private List<DataMobil> dataMobils = new ArrayList<>();
    private RecyclerviewAdapter viewAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    EditText edPriceAll;
    Button btnSearchAll;
    Spinner harga,varian,tipebd,trsmsi,bbakar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_brand);

        ButterKnife.bind(this);
        viewAdapter = new RecyclerviewAdapter(this, dataMobils);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataMobilAll();
        
        edPriceAll = findViewById(R.id.etPrice);
        btnSearchAll = findViewById(R.id.btnMobil_all);
        edPriceAll.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });




    }

    private void filter(String toString) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        Call<JSONResponse> call = requestAPI.search(toString);

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Response<JSONResponse> response, Retrofit retrofit) {
                String value = response.body().getValue();
                if (value.equals("1")) {
                    //Log.d(value, "hasil");
                    dataMobils = response.body().getResult();
                    viewAdapter = new RecyclerviewAdapter(AllBrandActivity.this, dataMobils);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

        });

    }

    private void loadDataMobilAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( url )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        Call<JSONResponse> call = requestAPI.view();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Response<JSONResponse> response, Retrofit retrofit) {
                String value = response.body().getValue();
                if (value.equals("1")) {
                    dataMobils = response.body().getResult();
                    viewAdapter = new RecyclerviewAdapter(AllBrandActivity.this, dataMobils);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadDataMobilAll();
    }
    

    public void back(View view) {
        Intent back = new Intent(AllBrandActivity.this, HomeActivity.class);
        startActivity(back);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();

    }

}