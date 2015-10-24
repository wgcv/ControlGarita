package wgcv.me.controlgarita;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    Toolbar menu;
String retorno;
    EditText user, password;
    String usuario,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        user = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
       // menu = new Toolbar(Principal.this);

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
    }*/
    public void login(View v){
    pass = password.getText().toString();
        usuario =  user.getText().toString();
        AsyncCallWS task = new AsyncCallWS();
        //Call execute
        task.execute();
    }
    public void registrarse(View v){
        pass = password.getText().toString();
        usuario =  user.getText().toString();
        registrar task = new registrar();
        //Call execute
        task.execute();
    }
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            retorno = Usuario.login(usuario, pass, "ingresar");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
         //   tv.setText(displayText);
            //Make ProgressBar invisible
         //   pg.setVisibility(View.INVISIBLE);
            if(retorno.equals("S") ) {

                residente task2 = new residente();
                //Call execute
                task2.execute();
            }
            else{
                Toast.makeText(Principal.this, "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
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
    private class registrar extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            Usuario.registrar(usuario, pass, "crear");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
            //   tv.setText(displayText);
            //Make ProgressBar invisible
            //   pg.setVisibility(View.INVISIBLE);
            Toast.makeText(Principal.this, "Se registro", Toast.LENGTH_SHORT).show();
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
    private class residente extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            retorno = Usuario.esresidente(usuario, "esresidente");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //Set response
            //   tv.setText(displayText);
            //Make ProgressBar invisible
            //   pg.setVisibility(View.INVISIBLE);
            if(retorno.equals("S") ) {

                Intent intent = new Intent(Principal.this,Abrir.class);
                Bundle b = new Bundle();
                intent.putExtra("usuario", usuario);
                b.putString("usuario", usuario);
                intent.putExtras(b);

                //Iniciar actividad
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(Principal.this,Solicitudes.class);
                Bundle b = new Bundle();
                intent.putExtra("usuario", usuario);
                b.putString("usuario", usuario);
                intent.putExtras(b);

                //Iniciar actividad
                startActivity(intent);
            }
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
