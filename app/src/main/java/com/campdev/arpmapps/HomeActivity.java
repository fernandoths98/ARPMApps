package com.campdev.arpmapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    TextView ucapan, tanggal;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageView = findViewById(R.id.cuaca);
        ucapan = findViewById(R.id.ucpn);
        tanggal = findViewById(R.id.waktu);
        Date date = new Date();
        String dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(date);
        tanggal.setText(dateFormat);
        gretting();

        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://www.promohondacars.com/wp-content/uploads/2017/10/slider2-promohondacars.png","Promo Honda"));
        slideModels.add(new SlideModel("https://tsoimageprod.azureedge.net/sys-master-hybrismedia/hc7/h94/8826239942686/Desktop%20(1).png","Promo Toyota"));
        slideModels.add(new SlideModel("https://www.daihatsusoloraya.id/ss/pm/daihatsusoloraya_09uyMR1985im101005g813c06a.png?v=223201520","Promo Daihatsu"));
        imageSlider.setImageList(slideModels, false);


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

    private void gretting() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String gretting = null;


        if (hour >= 0 && hour < 12) {
            gretting = "Good Morning, Sir";
            imageView.setImageResource(R.drawable.matahari);
        } else if (hour >= 12 && hour < 15) {
            gretting = "Good Afternoon, Sir";
            imageView.setImageResource(R.drawable.matahari);
        } else if (hour >= 15 && hour < 18) {
            gretting = "Good Afternoon, Sir";
            imageView.setImageResource(R.drawable.bulan_prev_ui);
        } else if (hour >= 18 && hour < 24) {
            gretting = "Good evening, Sir";
            imageView.setImageResource(R.drawable.bulan_prev_ui);
        }
        ucapan.setText(gretting + "!");

    }

    public void layout_honda(View view) {
        Intent honda = new Intent(HomeActivity.this, HondaActivity.class);
        startActivity(honda);

    }

    public void layout_toyota(View view) {
        Intent toyota = new Intent(HomeActivity.this, ToyotaActivity.class);
        startActivity(toyota);
    }

    public void layout_daihatsu(View view) {
        Intent daihatsu = new Intent(HomeActivity.this, DaihatsuActivity.class);
        startActivity(daihatsu);
    }

    public void layout_all(View view) {
        Intent all = new Intent(HomeActivity.this, AllBrandActivity.class);
        startActivity(all);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();

    }
}