package wgcv.me.controlgarita;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Enviar extends AppCompatActivity {
Toolbar menu;
    EditText et;
    String usadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);
        menu = new Toolbar(Enviar.this);
        et = (EditText) findViewById(R.id.usuario);

    }
public void enviar(View v){
usadd = et.getText().toString();
    AsyncCallWS task = new AsyncCallWS();
    //Call execute
    task.execute();
}
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menu.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        menu.onConfigurationChanged(newConfig);
    }
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            EditText txt = (EditText) findViewById(R.id.usuario);
            Ciudadela.crear(usadd, "crear");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
            //   tv.setText(displayText);
            //Make ProgressBar invisible
            //   pg.setVisibility(View.INVISIBLE);
            /*
                Intent intent = new Intent(Principal.this,Solicitudes.class);
                Bundle b = new Bundle();
                intent.putExtra("usuario", usuario);
                b.putString("usuario",usuario);
                intent.putExtras(b);
             startActivity(intent);
          */
            Toast.makeText(Enviar.this, "Se envio", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onPreExecute() {
            //Make ProgressBar invisible
            //  pg.setVisibility(View.INVISIBLE);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }
}
