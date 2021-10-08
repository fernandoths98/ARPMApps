package com.campdev.arpmapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.campdev.arpmapps.ActivityDetail;
import com.campdev.arpmapps.DaihatsuDetailActivity;
import com.campdev.arpmapps.Model.DataMobil;
import com.campdev.arpmapps.R;
import com.developer.kalert.KAlertDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewAdapterDaihatsu extends RecyclerView.Adapter<RecyclerviewAdapterDaihatsu.ViewHolder>{

    private Context mContext;
    private List<DataMobil> dataMobils;


    public RecyclerviewAdapterDaihatsu(Context mContext, List<DataMobil> dataMobils) {
        this.dataMobils = dataMobils;
    }

    @NonNull
    @Override
    public RecyclerviewAdapterDaihatsu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerviewAdapterDaihatsu.ViewHolder holder = new RecyclerviewAdapterDaihatsu.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapterDaihatsu.ViewHolder holder, int position) {
        DataMobil dataMobil = dataMobils.get(position);
        Glide
                .with(holder.imageView.getContext())
                .load(dataMobil.getLink_img_daihatsu())
                .into(holder.imageView);
        holder.txtNamaMobilAll.setText(dataMobil.getNama_mobil_daihatsu());
        holder.txtVarianMobilAll.setText(dataMobil.getVarian_mobil_daihatsu());
        holder.txtBodyMobilAll.setText(dataMobil.getTipebody_mobil_daihatsu());
        holder.txtbbMobilAll.setText(dataMobil.getBb_mobil_daihatsu());
        holder.txtTransmisiMobilAll.setText(dataMobil.getTransmisi_mobil_daihatsu());
        holder.txtHargaMobilAll.setText(dataMobil.getHarga_mobil_daihatsu());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DaihatsuDetailActivity.class);
                intent.putExtra("link_img_daihatsu", dataMobil.getLink_img_daihatsu());
                intent.putExtra("nama_mobil_daihatsu", dataMobil.getNama_mobil_daihatsu());
                intent.putExtra("varian_mobil_daihatsu", dataMobil.getVarian_mobil_daihatsu());
                intent.putExtra("tipebody_mobil_daihatsu", dataMobil.getTipebody_mobil_daihatsu());
                intent.putExtra("bb_mobil_daihatsu", dataMobil.getBb_mobil_daihatsu());
                intent.putExtra("transmisi_mobil_daihatsu", dataMobil.getTransmisi_mobil_daihatsu());
                intent.putExtra("harga_mobil_daihatsu", dataMobil.getHarga_mobil_daihatsu());
                intent.putExtra("desc_mobil_daihatsu", dataMobil.getDesc_mobil_daihatsu());
                intent.putExtra("alamat_dealer_mobil_daihatsu", dataMobil.getAlamat_dealer_mobil_daihatsu());
                intent.putExtra("no_tlp_mobil_daihatsu", dataMobil.getNo_tlp_mobil_daihatsu());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataMobils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        @BindView(R.id.namaMobilAll)
        TextView txtNamaMobilAll;
        @BindView(R.id.varianMobilAll) TextView txtVarianMobilAll;
        @BindView(R.id.tipebodyMobilAll) TextView txtBodyMobilAll;
        @BindView(R.id.transmisiMobilAll) TextView txtTransmisiMobilAll;
        @BindView(R.id.bbMobilAll) TextView txtbbMobilAll;
        @BindView(R.id.hargaMobilAll) TextView txtHargaMobilAll;


        public ViewHolder(@Nullable View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imageView = itemView.findViewById(R.id.img_mobil_all);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KAlertDialog alertDialog = new KAlertDialog(v.getContext(), KAlertDialog.ERROR_TYPE);
                    alertDialog.setTitleText("OPSS....");
                    alertDialog.setContentText("Please click the image..");
                    alertDialog.setCancelText("Closes \n");

                    alertDialog.show();



                }
            });
        }
    }
}