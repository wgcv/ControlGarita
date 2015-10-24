package wgcv.me.controlgarita;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Abrir extends AppCompatActivity {
    Toolbar menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir);
        menu = new Toolbar(Abrir.this);
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
public void abrir(View v){
    AsyncCallWS task = new AsyncCallWS();
    //Call execute
    task.execute();
}
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            //Invoke webservice
            Ciudadela.abrir();
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
