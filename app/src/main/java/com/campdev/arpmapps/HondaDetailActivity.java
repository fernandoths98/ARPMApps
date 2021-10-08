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

public class HondaDetailActivity extends AppCompatActivity {

    public static final String Url = "http://arpmpanel.xyz/";

    @BindView(R.id.namaMobilHonda) TextView tvnamamobil_honda;
    @BindView(R.id.varianMobilHonda) TextView tvvarianmobil_honda;
    @BindView(R.id.tipebodyMobilHonda) TextView tvtipebody_mobil_honda;
    @BindView(R.id.bbMobilHonda) TextView tvbb_mobil_honda;
    @BindView(R.id.transmisiMobilHonda) TextView tvtransmisi_mobil_honda;
    @BindView(R.id.hargaMobilHonda) TextView tvharga_mobil_honda;
    @BindView(R.id.decsMobilHonda) TextView tvdesc_mobil_honda;
    @BindView(R.id.alamatDealerHonda) TextView tvdealer_mobil_honda;
    @BindView(R.id.no_hp_dealer_honda) TextView tvno_tlp_mobil_honda;

    Button btnWa;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honda_detail);

        ButterKnife.bind(this);
        img = findViewById(R.id.img_mobil_honda);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestAPI api = retrofit.create(RequestAPI.class);
        Call<JSONResponse> call = api.update_honda();

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
        img.setImageResource(getIntent().getIntExtra("link_img_honda", 0));
        Glide
                .with(getApplicationContext())
                .load(intent.getStringExtra("link_img_honda"))
                .into(img);

        String nama_mobil_honda = intent.getStringExtra("nama_mobil_honda");
        String varian_mobil_honda = intent.getStringExtra("varian_mobil_honda");
        String tipebody_mobil_honda = intent.getStringExtra("tipebody_mobil_honda");
        String bb_mobil_honda = intent.getStringExtra("bb_mobil_honda");
        String transmisi_mobil_honda = intent.getStringExtra("transmisi_mobil_honda");
        String harga_mobil_honda = intent.getStringExtra("harga_mobil_honda");
        String desc_mobil_honda = intent.getStringExtra("desc_mobil_honda");
        String alamat_mobil_honda = intent.getStringExtra("alamat_dealer_mobil_honda");
        String tlp_dealer_honda = intent.getStringExtra("no_tlp_mobil_honda");

        tvnamamobil_honda.setText(nama_mobil_honda);
        tvvarianmobil_honda.setText(varian_mobil_honda);
        tvtipebody_mobil_honda.setText(tipebody_mobil_honda);
        tvbb_mobil_honda.setText(bb_mobil_honda);
        tvtransmisi_mobil_honda.setText(transmisi_mobil_honda);
        tvharga_mobil_honda.setText(harga_mobil_honda);
        tvdesc_mobil_honda.setText(desc_mobil_honda);
        tvdealer_mobil_honda.setText(alamat_mobil_honda);
        tvno_tlp_mobil_honda.setText(tlp_dealer_honda);

        btnWa = findViewById(R.id.btnWaHonda);
        btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_tlp_wa = tvno_tlp_mobil_honda.getText().toString().trim();
                String nm_mobil = tvnamamobil_honda.getText().toString();
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
        Intent intent = new Intent(HondaDetailActivity.this, HondaActivity.class);
        startActivity(intent);
    }
}