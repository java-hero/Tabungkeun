package org.d3ifcool.tabungkeun;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PengeluaranFragment extends Fragment {
    private ImageView ic_tambah_pengeluaran;
    private RecyclerView mRecyclerView;
    private PengeluaranAdapter mAdapter;
    private DatabaseReference reference;
    private ArrayList<PengeluaranData> mPengeluaran;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pengeluran_frag = inflater.inflate(R.layout.fragment_pengeluaran, container, false);
        setHasOptionsMenu(true);
        mRecyclerView = pengeluran_frag.findViewById(R.id.rv_pengeluaran);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mPengeluaran = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("pengeluaran");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot :  dataSnapshot.getChildren()){
                    PengeluaranData pengeluaran = postSnapshot.getValue(PengeluaranData.class);

                    mPengeluaran.add(pengeluaran);
                }

                mAdapter = new PengeluaranAdapter(getContext(), mPengeluaran);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        ic_tambah_pengeluaran = pengeluran_frag.findViewById(R.id.ic_tambah_pengeluaran);
        ic_tambah_pengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TambahPengeluaranActivity.class);
                startActivity(intent);
            }
        });

        return pengeluran_frag;
    }
}
