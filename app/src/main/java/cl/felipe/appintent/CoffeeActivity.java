package cl.felipe.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {

    private String name;
    private TextView titulo,txtcantidad;
    private CheckBox opt1, opt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        titulo = findViewById(R.id.txttitulo);
        name = getIntent().getStringExtra(MainActivity.NAME);

        titulo.setText("Order of "+name);
        txtcantidad = findViewById(R.id.txtcantidad);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);

    }

    public void order(View view) {
        //opt1.isChecked() => true si esta marcado
        //opt1.getText().toString();
        //Negocio only coffee $3
        //       cream: $1  - chocolate: $2
        Uri uri = Uri.parse("mailto: contact@coffee.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(intent.EXTRA_TEXT,"contenido del correo");
        intent.putExtra(intent.EXTRA_SUBJECT,"Order of "+name);
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }
    }

    public void call(View view) {
        Uri uri = Uri.parse("tel:133");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}