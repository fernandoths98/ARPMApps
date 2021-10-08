package com.campdev.arpmapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
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

public class ToyotaDetailActivity extends AppCompatActivity {

    public static final String Url = "http://arpmpanel.xyz/";

    @BindView(R.id.namaMobilToyota) TextView tvnamamobil_toyota;
    @BindView(R.id.varianMobilToyota) TextView tvvarianmobil_toyota;
    @BindView(R.id.tipebodyMobilToyota) TextView tvtipebody_mobil_toyota;
    @BindView(R.id.bbMobilToyota) TextView tvbb_mobil_toyota;
    @BindView(R.id.transmisiMobilToyota) TextView tvtransmisi_mobil_toyota;
    @BindView(R.id.hargaMobilToyota) TextView tvharga_mobil_toyota;
    @BindView(R.id.decsMobilToyota) TextView tvdesc_mobil_toyota;
    @BindView(R.id.alamatDealerToyota) TextView tvdealer_mobil_toyota;
    @BindView(R.id.no_hp_dealer_toyota) TextView tvno_tlp_mobil_toyota;

    Button btnWa;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota_detail);

        ButterKnife.bind(this);
        img = findViewById(R.id.img_mobil_toyota);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestAPI api = retrofit.create(RequestAPI.class);
        Call<JSONResponse> call = api.update_toyota();

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
        img.setImageResource(getIntent().getIntExtra("link_img_toyota", 0));
        Glide
                .with(getApplicationContext())
                .load(intent.getStringExtra("link_img_toyota"))
                .into(img);

        String nama_mobil_toyota = intent.getStringExtra("nama_mobil_toyota");
        String varian_mobil_toyota = intent.getStringExtra("varian_mobil_toyota");
        String tipebody_mobil_toyota = intent.getStringExtra("tipebody_mobil_toyota");
        String bb_mobil_toyota = intent.getStringExtra("bb_mobil_toyota");
        String transmisi_mobil_toyota = intent.getStringExtra("transmisi_mobil_toyota");
        String harga_mobil_toyota = intent.getStringExtra("harga_mobil_toyota");
        String desc_mobil_toyota = intent.getStringExtra("desc_mobil_toyota");
        String alamat_mobil_toyota = intent.getStringExtra("alamat_dealer_mobil_toyota");
        String tlp_dealer_toyota = intent.getStringExtra("no_tlp_mobil_toyota");

        tvnamamobil_toyota.setText(nama_mobil_toyota);
        tvvarianmobil_toyota.setText(varian_mobil_toyota);
        tvtipebody_mobil_toyota.setText(tipebody_mobil_toyota);
        tvbb_mobil_toyota.setText(bb_mobil_toyota);
        tvtransmisi_mobil_toyota.setText(transmisi_mobil_toyota);
        tvharga_mobil_toyota.setText(harga_mobil_toyota);
        tvdesc_mobil_toyota.setText(desc_mobil_toyota);
        tvdealer_mobil_toyota.setText(alamat_mobil_toyota);
        tvno_tlp_mobil_toyota.setText(tlp_dealer_toyota);

        btnWa = findViewById(R.id.btnWaToyota);
        btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_tlp_wa = tvno_tlp_mobil_toyota.getText().toString().trim();
                String nm_mobil = tvnamamobil_toyota.getText().toString();
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
        Intent intent = new Intent(ToyotaDetailActivity.this, ToyotaActivity.class);
        startActivity(intent);
    }
}