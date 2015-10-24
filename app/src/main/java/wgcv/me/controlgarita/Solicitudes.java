package wgcv.me.controlgarita;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Solicitudes extends AppCompatActivity {
    String displayText;
    Toolbar menu;

    TextView tv;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes);
        Bundle bundle = this.getIntent().getExtras();
        usuario=bundle.getString("usuario");

        tv = (TextView) findViewById(R.id.cantidad);
       //Create instance for AsyncCallWS

        AsyncCallWS task = new AsyncCallWS();
        //Call execute
        task.execute();

       //  menu = new Toolbar(Solicitudes.this);


    }
/*
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

*/
    public void boton( View v){

        entrar task = new entrar();
        //Call execute
        task.execute();
    }
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            displayText = Ciudadela.solicitudes(usuario, "solicitudes");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
            tv.setText(displayText);
            if(!displayText.equals("0")){
                ImageButton  bt = (ImageButton) findViewById(R.id.btn);
                bt.setVisibility(View.VISIBLE);
            }
            //Make ProgressBar invisible
        }

        @Override
        protected void onPreExecute() {
            //Make ProgressBar invisible
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }
    private class entrar extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            displayText = Ciudadela.solicitudes(usuario, "ingresar");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
            Intent intent = new Intent(Solicitudes.this,Solicitudes.class);
            Bundle b = new Bundle();
            intent.putExtra("usuario", usuario);
            b.putString("usuario",usuario);
            intent.putExtras(b);

            //Iniciar actividad
            startActivity(intent);
            //Make ProgressBar invisible
        }

        @Override
        protected void onPreExecute() {
            //Make ProgressBar invisible
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }
}

