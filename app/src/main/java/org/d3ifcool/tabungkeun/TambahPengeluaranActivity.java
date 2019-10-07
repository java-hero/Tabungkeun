package org.d3ifcool.tabungkeun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahPengeluaranActivity extends AppCompatActivity {
    private EditText etNamaPengeluaran, etJumlahPengeluaran;
    private Button btnTambahPengeluaran;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengeluaran);

        etNamaPengeluaran = findViewById(R.id.etNamaPengeluaran);
        etJumlahPengeluaran = findViewById(R.id.etJumlahPengeluaran);
        btnTambahPengeluaran = findViewById(R.id.btnTambahPengeluaran);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("pengeluaran");

        btnTambahPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Saldo = Integer.parseInt(etJumlahPengeluaran.getText().toString().trim());
                Calendar c1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("d MMM", Locale.US);
                String tanggal = sdf1.format(c1.getTime());
                PengeluaranData upload = new PengeluaranData(etNamaPengeluaran.getText().toString().trim(), Saldo, tanggal);

                String dataID = mDatabaseRef.push().getKey();
                mDatabaseRef.child(dataID).setValue(upload);
                Intent intent = new Intent(TambahPengeluaranActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
