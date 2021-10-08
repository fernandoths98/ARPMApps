package com.campdev.arpmapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
import com.developer.kalert.KAlertDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>{

    private Context mContext;
    private List<DataMobil> dataMobils;


    public RecyclerviewAdapter(Context mContext, List<DataMobil> dataMobils) {
        this.dataMobils = dataMobils;
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.ViewHolder holder, int position) {
        DataMobil dataMobil = dataMobils.get(position);
        Glide
                .with(holder.imageView.getContext())
                .load(dataMobil.getLink_img_all())
                .into(holder.imageView);
        holder.txtNamaMobilAll.setText(dataMobil.getNama_mobil());
        holder.txtVarianMobilAll.setText(dataMobil.getVarian_mobil());
        holder.txtBodyMobilAll.setText(dataMobil.getTipebody_mobil_all());
        holder.txtbbMobilAll.setText(dataMobil.getBb_mobil());
        holder.txtTransmisiMobilAll.setText(dataMobil.getTransmisi_mobil());
        holder.txtHargaMobilAll.setText(dataMobil.getHarga_mobil());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityDetail.class);
                intent.putExtra("link_img_all", dataMobil.getLink_img_all());
                intent.putExtra("nama_mobil", dataMobil.getNama_mobil());
                intent.putExtra("varian_mobil", dataMobil.getVarian_mobil());
                intent.putExtra("tipebody_mobil_all", dataMobil.getTipebody_mobil_all());
                intent.putExtra("bb_mobil", dataMobil.getBb_mobil());
                intent.putExtra("transmisi_mobil", dataMobil.getTransmisi_mobil());
                intent.putExtra("harga_mobil", dataMobil.getHarga_mobil());
                intent.putExtra("desc_mobil_all", dataMobil.getDesc_mobil_all());
                intent.putExtra("alamat_dealer_mobil_all", dataMobil.getAlamat_dealer_mobil_all());
                intent.putExtra("no_tlp_mobil_all", dataMobil.getNo_tlp_mobil_all());
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
        @BindView(R.id.namaMobilAll) TextView txtNamaMobilAll;
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
