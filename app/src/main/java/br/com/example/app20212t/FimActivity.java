package br.com.example.app20212t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FimActivity extends AppCompatActivity {

    private TextView tvRes;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        int num = b.getInt("num");
        String res = "Parabéns ! Acertou o num "+num;

        tvRes = (TextView)findViewById(R.id.tvRes);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);

        tvRes.setText(res);

        btnVoltar.setOnClickListener(x -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        this.finish();
    }

}