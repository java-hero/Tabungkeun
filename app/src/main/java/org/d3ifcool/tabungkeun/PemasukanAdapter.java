package org.d3ifcool.tabungkeun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PemasukanAdapter extends RecyclerView.Adapter<PemasukanAdapter.pemasukanHolder> {

    private Context mContext;
    private List<PemasukanData> daftarPemasukan;

    public PemasukanAdapter(Context mContext, List<PemasukanData> daftarPemasukan) {
        this.mContext = mContext;
        this.daftarPemasukan = daftarPemasukan;
    }

    @NonNull
    @Override
    public pemasukanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_pemasukan, parent, false);

        pemasukanHolder ph = new pemasukanHolder(view);
        return ph;
    }

    @Override
    public void onBindViewHolder(@NonNull pemasukanHolder holder, int position) {
        final PemasukanData pemasukanData = daftarPemasukan.get(position);
        holder.tvKetPemasukan.setText(pemasukanData.getNama());
        String saldo = Integer.toString(pemasukanData.getSaldo());
        holder.tvSaldonya.setText(saldo);
        holder.tvTanggalPemasukan.setText(pemasukanData.getTanggal());
    }

    @Override
    public int getItemCount() {
        return daftarPemasukan.size();
    }

    class pemasukanHolder extends RecyclerView.ViewHolder{
        final TextView tvKetPemasukan;
        final TextView tvSaldonya;
        final TextView tvTanggalPemasukan;
        public pemasukanHolder(@NonNull View itemView) {
            super(itemView);
            tvKetPemasukan = (itemView).findViewById(R.id.tv_ketPemasukan);
            tvSaldonya = (itemView).findViewById(R.id.tv_saldonya);
            tvTanggalPemasukan = (itemView).findViewById(R.id.tvTanggalPemasukan);
        }
    }
}
