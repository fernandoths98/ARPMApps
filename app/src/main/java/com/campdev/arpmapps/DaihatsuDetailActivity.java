package com.campdev.arpmapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.campdev.arpmapps.Api.RequestAPI;
import com.campdev.arpmapps.Model.JSONResponse;
import com.developer.kalert.KAlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class DaihatsuDetailActivity extends AppCompatActivity {

    public static final String Url = "http://arpmpanel.xyz/";

    @BindView(R.id.namaMobilDaihatsu) TextView tvnamamobil_daihatsu;
    @BindView(R.id.varianMobilDaihatsu) TextView tvvarianmobil_daihatsu;
    @BindView(R.id.tipebodyMobilDaihatsu) TextView tvtipebody_mobil_daihatsu;
    @BindView(R.id.bbMobilDaihatsu) TextView tvbb_mobil_daihatsu;
    @BindView(R.id.transmisiMobilDaihatsu) TextView tvtransmisi_mobil_daihatsu;
    @BindView(R.id.hargaMobilDaihatsu) TextView tvharga_mobil_daihatsu;
    @BindView(R.id.decsMobilDaihatsu) TextView tvdesc_mobil_daihatsu;
    @BindView(R.id.alamatDealerDaihatsu) TextView tvdealer_mobil_daihatsu;
    @BindView(R.id.no_hp_dealer_daihatsu) TextView tvno_tlp_mobil_daihatsu;

    ImageView img;

    Button btnWa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daihatsu_detail);

        ButterKnife.bind(this);
        img = findViewById(R.id.img_mobil_daihatsu);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestAPI api = retrofit.create(RequestAPI.class);
        Call<JSONResponse> call = api.update_daihatsu();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Response<JSONResponse> response, Retrofit retrofit) {
                String value = response.body().getValue();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        Intent intent = getIntent();
        img.setImageResource(getIntent().getIntExtra("link_img_daihatsu", 0));
        Glide
                .with(getApplicationContext())
                .load(intent.getStringExtra("link_img_daihatsu"))
                .into(img);

        String nama_mobil_daihatsu = intent.getStringExtra("nama_mobil_daihatsu");
        String varian_mobil_daihatsu = intent.getStringExtra("varian_mobil_daihatsu");
        String tipebody_mobil_daihatsu = intent.getStringExtra("tipebody_mobil_daihatsu");
        String bb_mobil_daihatsu = intent.getStringExtra("bb_mobil_daihatsu");
        String transmisi_mobil_daihatsu = intent.getStringExtra("transmisi_mobil_daihatsu");
        String harga_mobil_daihatsu = intent.getStringExtra("harga_mobil_daihatsu");
        String desc_mobil_daihatsu = intent.getStringExtra("desc_mobil_daihatsu");
        String alamat_mobil_daihatsu = intent.getStringExtra("alamat_dealer_mobil_daihatsu");
        String tlp_dealer_daihatsu = intent.getStringExtra("no_tlp_mobil_daihatsu");

        tvnamamobil_daihatsu.setText(nama_mobil_daihatsu);
        tvvarianmobil_daihatsu.setText(varian_mobil_daihatsu);
        tvtipebody_mobil_daihatsu.setText(tipebody_mobil_daihatsu);
        tvbb_mobil_daihatsu.setText(bb_mobil_daihatsu);
        tvtransmisi_mobil_daihatsu.setText(transmisi_mobil_daihatsu);
        tvharga_mobil_daihatsu.setText(harga_mobil_daihatsu);
        tvdesc_mobil_daihatsu.setText(desc_mobil_daihatsu);
        tvdealer_mobil_daihatsu.setText(alamat_mobil_daihatsu);
        tvno_tlp_mobil_daihatsu.setText(tlp_dealer_daihatsu);

        btnWa = findViewById(R.id.btnWaDaihatsu);
        btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_tlp_wa = tvno_tlp_mobil_daihatsu.getText().toString().trim();
                String nm_mobil = tvnamamobil_daihatsu.getText().toString();
                boolean installed = appInstalledOrNot("com.whatsapp");

                if (installed) {

                    KAlertDialog alertDialog = new KAlertDialog(view.getContext(), KAlertDialog.ERROR_TYPE);
                    alertDialog.setTitleText("OPSS....");
                    alertDialog.setContentText("Application not installed");
                    alertDialog.setCancelText("Closes \n");

                    alertDialog.show();

                } else {
                    Intent wa = new Intent(Intent.ACTION_VIEW);
                    wa.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + "+62" +
                            no_tlp_wa + "&text= " + "Hallo Kak, boleh tanya tanya soal mobil " + nm_mobil + " nya kak?"));
                    startActivity(wa);

                }
            }
        });
    }

    private boolean appInstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo( url , PackageManager.GET_ACTIVITIES );
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }

        return app_installed;
    }

    public void back(View view) {
        Intent intent = new Intent(DaihatsuDetailActivity.this, DaihatsuActivity.class);
        startActivity(intent);
    }

}