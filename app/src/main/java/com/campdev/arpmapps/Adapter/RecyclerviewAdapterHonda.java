package com.campdev.arpmapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.campdev.arpmapps.ActivityDetail;
import com.campdev.arpmapps.HondaDetailActivity;
import com.campdev.arpmapps.Model.DataMobil;
import com.campdev.arpmapps.R;
import com.developer.kalert.KAlertDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewAdapterHonda extends RecyclerView.Adapter<RecyclerviewAdapterHonda.ViewHolder>{

    private Context mContext;
    private List<DataMobil> dataMobils;


    public RecyclerviewAdapterHonda(Context mContext, List<DataMobil> dataMobils) {
        this.dataMobils = dataMobils;
    }

    @NonNull
    @Override
    public RecyclerviewAdapterHonda.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerviewAdapterHonda.ViewHolder holder = new RecyclerviewAdapterHonda.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapterHonda.ViewHolder holder, int position) {
        DataMobil dataMobil = dataMobils.get(position);
        Glide
                .with(holder.imageView.getContext())
                .load(dataMobil.getLink_img_honda())
                .into(holder.imageView);
        holder.txtNamaMobilAll.setText(dataMobil.getNama_mobil_honda());
        holder.txtVarianMobilAll.setText(dataMobil.getVarian_mobil_honda());
        holder.txtBodyMobilAll.setText(dataMobil.getTipebody_mobil_honda());
        holder.txtbbMobilAll.setText(dataMobil.getBb_mobil_honda());
        holder.txtTransmisiMobilAll.setText(dataMobil.getTransmisi_mobil_honda());
        holder.txtHargaMobilAll.setText(dataMobil.getHarga_mobil_honda());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HondaDetailActivity.class);
                intent.putExtra("link_img_honda", dataMobil.getLink_img_honda());
                intent.putExtra("nama_mobil_honda", dataMobil.getNama_mobil_honda());
                intent.putExtra("varian_mobil_honda", dataMobil.getVarian_mobil_honda());
                intent.putExtra("tipebody_mobil_honda", dataMobil.getTipebody_mobil_honda());
                intent.putExtra("bb_mobil_honda", dataMobil.getBb_mobil_honda());
                intent.putExtra("transmisi_mobil_honda", dataMobil.getTransmisi_mobil_honda());
                intent.putExtra("harga_mobil_honda", dataMobil.getHarga_mobil_honda());
                intent.putExtra("desc_mobil_honda", dataMobil.getDesc_mobil_honda());
                intent.putExtra("alamat_dealer_mobil_honda", dataMobil.getAlamat_dealer_mobil_honda());
                intent.putExtra("no_tlp_mobil_honda", dataMobil.getNo_tlp_mobil_honda());
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

                    /*
                    String nama_mobil = txtNamaMobilAll.getText().toString();
                    String varian_mobil = txtVarianMobilAll.getText().toString();
                    String tipebody_mobil_all = txtBodyMobilAll.getText().toString();
                    String bb_mobil = txtbbMobilAll.getText().toString();
                    String transmisi_mobil = txtTransmisiMobilAll.getText().toString();
                    String harga_mobil = txtHargaMobilAll.getText().toString();

                    Intent intent = new Intent(v.getContext(), ActivityDetail.class);
                    intent.putExtra("nama_mobil", nama_mobil);
                    intent.putExtra("varian_mobil", varian_mobil);
                    intent.putExtra("tipebody_mobil_all", tipebody_mobil_all);
                    intent.putExtra("bb_mobil", bb_mobil);
                    intent.putExtra("transmisi_mobil", transmisi_mobil);
                    intent.putExtra("harga_mobil", harga_mobil);
                    v.getContext().startActivity(intent);

                     */


                }
            });
        }
    }
}