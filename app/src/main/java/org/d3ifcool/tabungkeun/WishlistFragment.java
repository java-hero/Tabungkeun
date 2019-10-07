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


public class WishlistFragment extends Fragment {

    private RecyclerView recyclerView;
    private WishlistAdapter wishlistAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView ic_tambah_wishlist;
    private DatabaseReference reference;
    private ArrayList<WishlistData> wishlistDataArrayList;
    private WishlistAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view_frag1 = inflater.inflate(R.layout.fragment_wishlist, container, false);
        setHasOptionsMenu(true);

        recyclerView = view_frag1.findViewById(R.id.recyclerView);
        ic_tambah_wishlist = view_frag1.findViewById(R.id.ic_tambah_wishlist);
        wishlistDataArrayList = new ArrayList<>();

        ic_tambah_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TambahWishlistActivity.class);
                startActivity(intent);
            }
        });

        reference = FirebaseDatabase.getInstance().getReference("wishlist");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot :  dataSnapshot.getChildren()){
                    WishlistData wishlistData = postSnapshot.getValue(WishlistData.class);
                    wishlistDataArrayList.add(wishlistData);
                }

                mAdapter = new WishlistAdapter(getContext(), wishlistDataArrayList);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return view_frag1;
    }
}
