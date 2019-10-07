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
import java.util.List;


public class PemasukanFragment extends Fragment {
    private ImageView ic_tambah_pemasukan;
    private RecyclerView mRecyclerView;
    private PemasukanAdapter mAdapter;
    private DatabaseReference reference;
    private List<PemasukanData> mPemasukan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pemasukan_frag = inflater.inflate(R.layout.fragment_pemasukan, container, false);
        setHasOptionsMenu(true);
        mRecyclerView = pemasukan_frag.findViewById(R.id.rv_pemasukan);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPemasukan = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("pemasukan");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot :  dataSnapshot.getChildren()){
                    PemasukanData pemasukan = postSnapshot.getValue(PemasukanData.class);
                    mPemasukan.add(pemasukan);
                }

                mAdapter = new PemasukanAdapter(getContext(), mPemasukan);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        ic_tambah_pemasukan = pemasukan_frag.findViewById(R.id.ic_tambah_pemasukan);
        ic_tambah_pemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TambahPemasukanActivity.class);
                startActivity(intent);
            }
        });

        return pemasukan_frag;
    }
}
