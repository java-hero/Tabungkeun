package org.d3ifcool.tabungkeun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.wishlistHolder> {

    private Context context;
    private List<WishlistData> daftarKeinginan;

    public WishlistAdapter(Context context, List<WishlistData> daftarKeinginan) {
        this.context = context;
        this.daftarKeinginan = daftarKeinginan;
    }

    @NonNull
    @Override
    public wishlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_wishlist, parent, false);

        wishlistHolder wishlistHolder = new wishlistHolder(view);
        return wishlistHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull wishlistHolder holder, int position) {
        final WishlistData wd = daftarKeinginan.get(position);
        holder.tvJudul.setText(wd.getNamaBarang());
        holder.tvDesc.setText(wd.getDesc());

//        String saldoB = Integer.toString(wd.getHargaBarang());
//        String saldoA = Integer.toString(wd.getJumlahNabung());
        holder.saldoAwal.setText(wd.getHargaBarang());
        holder.saldoBarang.setText(wd.getJumlahNabung());
    }

    @Override
    public int getItemCount() {
        return daftarKeinginan.size();
    }


    class wishlistHolder extends RecyclerView.ViewHolder{
        final TextView tvJudul, tvDesc, saldoAwal, saldoBarang;
        final ImageView ivWishlist, ivNabung, ivHapus;

        public wishlistHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = (itemView).findViewById(R.id.namaBarang);
            tvDesc = (itemView).findViewById(R.id.tv_deskripsi_wishlist);
            saldoAwal = (itemView).findViewById(R.id.saldoAwal);
            saldoBarang = (itemView).findViewById(R.id.saldoBarang);
            ivWishlist = (itemView).findViewById(R.id.iv_wishlist);
            ivNabung = (itemView).findViewById(R.id.iv_button_nabung);
            ivHapus = (itemView).findViewById(R.id.iv_button_hapus);
        }
    }
}
