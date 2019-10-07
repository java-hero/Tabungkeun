package org.d3ifcool.tabungkeun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahWishlistActivity extends AppCompatActivity {
    private EditText etTambahJudulWishlist;
    private EditText etTambahHargaWishlist;
    private EditText etTambahDescWishlist;
    private Button btnTambahWishlist;
    private DatabaseReference mDatabaseRef;
    private String hargaAwal = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_wishlist);

        etTambahJudulWishlist = findViewById(R.id.et_tambah_judul_wishlist);
        etTambahHargaWishlist = findViewById(R.id.et_tambah_harga_wishlist);
        etTambahDescWishlist = findViewById(R.id.et_tambah_deskripsi_wishlist);
        btnTambahWishlist = findViewById(R.id.button_tambah_wishlist);


        mDatabaseRef = FirebaseDatabase.getInstance().getReference("wishlist");

        btnTambahWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WishlistData upload = new WishlistData(etTambahJudulWishlist.getText().toString().trim(), etTambahHargaWishlist.getText().toString().trim(),"0", etTambahDescWishlist.getText().toString().trim());
                String dataID = mDatabaseRef.push().getKey();
                mDatabaseRef.child(dataID).setValue(upload);
                Intent intent = new Intent(TambahWishlistActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
