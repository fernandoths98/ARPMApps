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
import com.campdev.arpmapps.Model.DataMobil;
import com.campdev.arpmapps.R;
import com.campdev.arpmapps.ToyotaDetailActivity;
import com.developer.kalert.KAlertDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewAdapterToyota extends RecyclerView.Adapter<RecyclerviewAdapterToyota.ViewHolder>{

    private Context mContext;
    private List<DataMobil> dataMobils;


    public RecyclerviewAdapterToyota(Context mContext, List<DataMobil> dataMobils) {
        this.dataMobils = dataMobils;
    }

    @NonNull
    @Override
    public RecyclerviewAdapterToyota.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerviewAdapterToyota.ViewHolder holder = new RecyclerviewAdapterToyota.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapterToyota.ViewHolder holder, int position) {
        DataMobil dataMobil = dataMobils.get(position);
        Glide
                .with(holder.imageView.getContext())
                .load(dataMobil.getLink_img_toyota())
                .into(holder.imageView);
        holder.txtNamaMobilAll.setText(dataMobil.getNama_mobil_toyota());
        holder.txtVarianMobilAll.setText(dataMobil.getVarian_mobil_toyota());
        holder.txtBodyMobilAll.setText(dataMobil.getTipebody_mobil_toyota());
        holder.txtbbMobilAll.setText(dataMobil.getBb_mobil_toyota());
        holder.txtTransmisiMobilAll.setText(dataMobil.getTransmisi_mobil_toyota());
        holder.txtHargaMobilAll.setText(dataMobil.getHarga_mobil_toyota());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ToyotaDetailActivity.class);
                intent.putExtra("link_img_toyota", dataMobil.getLink_img_toyota());
                intent.putExtra("nama_mobil_toyota", dataMobil.getNama_mobil_toyota());
                intent.putExtra("varian_mobil_toyota", dataMobil.getVarian_mobil_toyota());
                intent.putExtra("tipebody_mobil_toyota", dataMobil.getTipebody_mobil_toyota());
                intent.putExtra("bb_mobil_toyota", dataMobil.getBb_mobil_toyota());
                intent.putExtra("transmisi_mobil_toyota", dataMobil.getTransmisi_mobil_toyota());
                intent.putExtra("harga_mobil_toyota", dataMobil.getHarga_mobil_toyota());
                intent.putExtra("desc_mobil_toyota", dataMobil.getDesc_mobil_toyota());
                intent.putExtra("alamat_dealer_mobil_toyota", dataMobil.getAlamat_dealer_mobil_toyota());
                intent.putExtra("no_tlp_mobil_toyota", dataMobil.getNo_tlp_mobil_toyota());
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