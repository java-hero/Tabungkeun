package org.d3ifcool.tabungkeun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PengeluaranAdapter extends RecyclerView.Adapter<PengeluaranAdapter.pengeluaranHolder> {

    private Context mContext;
    private List<PengeluaranData> daftarPengeluaran;

    public PengeluaranAdapter(Context mContext, List<PengeluaranData> daftarPengeluaran) {
        this.mContext = mContext;
        this.daftarPengeluaran = daftarPengeluaran;
    }

    @NonNull
    @Override
    public pengeluaranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_pemasukan, parent, false);

        pengeluaranHolder ph = new pengeluaranHolder(view);
        return  ph;
    }

    @Override
    public void onBindViewHolder(@NonNull pengeluaranHolder holder, int position) {
        PengeluaranData pengeluaranData = daftarPengeluaran.get(position);
    }

    @Override
    public int getItemCount() {
        return daftarPengeluaran.size();
    }

    class pengeluaranHolder extends RecyclerView.ViewHolder{
        final TextView tvKetPemasukan;
        final TextView tvSaldonya;
        final TextView tvTanggalPemasukan;
        final TextView tvKategoriPemasukan;
        public pengeluaranHolder(@NonNull View itemView) {
            super(itemView);
            tvKetPemasukan = (itemView).findViewById(R.id.tv_ketPemasukan);
            tvSaldonya = (itemView).findViewById(R.id.tv_saldonya);
            tvTanggalPemasukan = (itemView).findViewById(R.id.tvTanggalPemasukan);
            tvKategoriPemasukan = (itemView).findViewById(R.id.tvKategoriPemasukan);
        }
    }
}
