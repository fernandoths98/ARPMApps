package com.campdev.arpmapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.campdev.arpmapps.Api.RequestAPI;
import com.campdev.arpmapps.Model.JSONResponse;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ActivityDetail extends AppCompatActivity {

    public static final String Url = "http://arpmpanel.xyz/";

    @BindView(R.id.namaMobilAll) TextView tvnamamobil_all;
    @BindView(R.id.varianMobilAll) TextView tvvarianmobil_all;
    @BindView(R.id.tipebodyMobilAll) TextView tvtipebody_mobil_all;
    @BindView(R.id.bbMobilAll) TextView tvbb_mobil_all;
    @BindView(R.id.transmisiMobilAll) TextView tvtransmisi_mobil_all;
    @BindView(R.id.hargaMobilAll) TextView tvharga_mobil_all;
    @BindView(R.id.decsMobilAll) TextView tvdesc_mobil_all;
    @BindView(R.id.alamatDealerAll) TextView tvdealer_mobil_all;
    @BindView(R.id.no_hp_dealer) TextView tvno_tlp_mobil_all;

    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        img = findViewById(R.id.img_mobil_detail);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestAPI api = retrofit.create(RequestAPI.class);
        Call<JSONResponse> call = api.update();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Response<JSONResponse> response, Retrofit retrofit) {
                String value    =   response.body().getValue();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        Intent intent = getIntent();
        img.setImageResource(getIntent().getIntExtra("link_img_all", 0));
        Glide
                .with(getApplicationContext())
                .load(intent.getStringExtra("link_img_all"))
                .into(img);
        String nama_mobil = intent.getStringExtra("nama_mobil");
        String varian_mobil = intent.getStringExtra("varian_mobil");
        String tipebody_mobil_all = intent.getStringExtra("tipebody_mobil_all");
        String bb_mobil = intent.getStringExtra("bb_mobil");
        String transmisi_mobil = intent.getStringExtra("transmisi_mobil");
        String harga_mobil = intent.getStringExtra("harga_mobil");
        String desc_mobil = intent.getStringExtra("desc_mobil_all");
        String alamat_mobil = intent.getStringExtra("alamat_dealer_mobil_all");
        String tlp_dealer = intent.getStringExtra("no_tlp_mobil_all");

        tvnamamobil_all.setText(nama_mobil);
        tvvarianmobil_all.setText(varian_mobil);
        tvtipebody_mobil_all.setText(tipebody_mobil_all);
        tvbb_mobil_all.setText(bb_mobil);
        tvtransmisi_mobil_all.setText(transmisi_mobil);
        tvharga_mobil_all.setText(harga_mobil);
        tvdesc_mobil_all.setText(desc_mobil);
        tvdealer_mobil_all.setText(alamat_mobil);
        tvno_tlp_mobil_all.setText(tlp_dealer);


        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_navi);
        chipNavigationBar.setItemSelected(R.id.home, true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home:
                        Intent intent = new Intent();
                        startActivity(new Intent(getApplicationContext()
                                ,HomeActivity.class));
                        overridePendingTransition(0,0);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        return;
                    case R.id.maps:
                        startActivity(new Intent(getApplicationContext()
                                ,MapsActivity.class));
                        overridePendingTransition(0,0);
                        return;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                , InfoActivity.class));
                        overridePendingTransition(0,0);
                        return;

                }

            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(ActivityDetail.this, AllBrandActivity.class);
        startActivity(intent);
    }
}