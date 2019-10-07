package org.d3ifcool.tabungkeun;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahPemasukanActivity extends AppCompatActivity {
    private EditText etNamaPemasukan, etJumlahPemasukan;
    private Button btnTambahPemasukan;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pemasukan);
        etNamaPemasukan = findViewById(R.id.etNamaPemasukan);
        etJumlahPemasukan = findViewById(R.id.etJumlahPemasukan);
        btnTambahPemasukan = findViewById(R.id.btnTambahPemasukan);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("pemasukan");

        btnTambahPemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Saldo = Integer.parseInt(etJumlahPemasukan.getText().toString().trim());
                Calendar c1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("d MMM", Locale.US);
                String tanggal = sdf1.format(c1.getTime());
                PemasukanData upload = new PemasukanData(etNamaPemasukan.getText().toString().trim(), Saldo, tanggal);

                String dataID = mDatabaseRef.push().getKey();
                mDatabaseRef.child(dataID).setValue(upload);
                Intent intent = new Intent(TambahPemasukanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
