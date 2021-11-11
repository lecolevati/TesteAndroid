package br.com.example.app20212t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnTentar;
    private TextView tvMsg;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (int)((Math.random() * 100) + 1);

        etNumero = (EditText) findViewById(R.id.etNumero);
        btnTentar = (Button) findViewById(R.id.btnJogar);
        tvMsg = (TextView) findViewById(R.id.tvMsg);

        btnTentar.setOnClickListener(x -> joga());

    }

    private void joga() {
        int numJogador = Integer.parseInt(etNumero.getText().toString());
        if (numJogador > num) {
            tvMsg.setText("O numero é menor");
        }
        if (numJogador < num) {
            tvMsg.setText("O numero é maior");
        }
        if (numJogador == num) {
            finaliza();
        }

    }

    private void finaliza() {
        Bundle bundle = new Bundle();
        bundle.putInt("num", num);
        Intent i = new Intent(this, FimActivity.class);
        i.putExtras(bundle);
        startActivity(i);
        this.finish();
    }
}