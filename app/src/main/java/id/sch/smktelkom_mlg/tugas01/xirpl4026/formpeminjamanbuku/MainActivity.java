package id.sch.smktelkom_mlg.tugas01.xirpl4026.formpeminjamanbuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNamaPeminjam;
    TextView tvhasil, tvhasil2, tvhasil3, tvhasil4;
    Button bok, bc;
    RadioButton rbPl, rbPu, rbKo, rbNo;
    Spinner spkriteria;
    CheckBox kp, kb, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbPl = (RadioButton) findViewById(R.id.pelajaran);
        rbPu = (RadioButton) findViewById(R.id.pengetahuanumum);
        rbKo = (RadioButton) findViewById(R.id.komik);
        rbNo = (RadioButton) findViewById(R.id.novel);
        kp = (CheckBox) findViewById(R.id.kp);
        kb = (CheckBox) findViewById(R.id.kb);
        id = (CheckBox) findViewById(R.id.id);
        bc = (Button) findViewById(R.id.cek);
        etNamaPeminjam = (EditText) findViewById(R.id.namapeminjam);
        tvhasil = (TextView) findViewById(R.id.hasil);
        bok = (Button) findViewById(R.id.ok);
        tvhasil2 = (TextView) findViewById(R.id.hasil2);
        tvhasil3 = (TextView) findViewById(R.id.hasil3);
        spkriteria = (Spinner) findViewById(R.id.kriteria);
        tvhasil4 = (TextView) findViewById(R.id.hasil4);

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick2();
            }
        });

        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();
                doClick();

            }
        });

    }

    private void doClick2() {
        String hasil4 = "CEK :\n ";
        int startln = hasil4.length();

        if (kp.isChecked()) hasil4 += kp.getText() + "(∨) ";
        if (kb.isChecked()) hasil4 += kb.getText() + "(∨) ";
        if (id.isChecked()) hasil4 += id.getText() + "(∨)";


        if (hasil4.length() == startln) hasil4 += "Anda Belum Melngkapi Apapun  (×)";
        tvhasil4.setText(hasil4);
    }

    private void doClick() {
        String hasil2 = null;
        if (rbPl.isChecked()) {
            hasil2 = rbPl.getText().toString();
        } else if (rbPu.isChecked()) {
            hasil2 = rbPu.getText().toString();
        } else if (rbKo.isChecked()) {
            hasil2 = rbKo.getText().toString();
        } else if (rbNo.isChecked()) {
            hasil2 = rbNo.getText().toString();
        }
        if (hasil2 == null) {
            tvhasil2.setText("Konten Belum Teriidentifikasi");
        } else {
            tvhasil2.setText("Jenis Buku : " + hasil2);
        }

        tvhasil3.setText("Status Anda : " + spkriteria.getSelectedItem().toString());


    }


    private void doProcess() {
        if (isValid()) {
            String nama = etNamaPeminjam.getText().toString();
            tvhasil.setText("Identitas Anda : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNamaPeminjam.getText().toString();

        if (nama.isEmpty()) {
            etNamaPeminjam.setError("Nama Belum diisi");
            valid = false;
        } else if (nama.length() < 4) {
            etNamaPeminjam.setError("Nama Minimal 4 Huruf");
            valid = false;
        } else {
            etNamaPeminjam.setError(null);
        }
        return valid;
    }
    //NaufalFakhrian
}
