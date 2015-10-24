package wgcv.me.controlgarita;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by wgcv on 18/09/15.
 */
public class Toolbar {
    public android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    final AppCompatActivity principal;
    ListView expListView;
    private ArrayAdapter<String> listAdapter ;

    public Toolbar(final AppCompatActivity principal){
        this.principal = principal;
        nitView();
        if (toolbar != null) {
            toolbar.setTitle("");
            principal.setSupportActionBar(toolbar);
        }
        initDrawer();
        // get the listview
        expListView = (ListView) principal.findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();
        click();

    }

    public void syncState() {
        drawerToggle.syncState();

    }
    public void onConfigurationChanged(Configuration newConfig){
        drawerToggle.onConfigurationChanged(newConfig);

    }
    private void nitView() {
        toolbar = (android.support.v7.widget.Toolbar) principal.findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) principal.findViewById(R.id.drawerLayout);
    }

    private void initDrawer() {

        drawerToggle = new ActionBarDrawerToggle(principal, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }


    /*
   * Preparing the list data
   */
    private void prepareListData() {

        // Adding child data
        listAdapter = new ArrayAdapter<String>(principal, R.layout.simplerow,new ArrayList<String>());


        listAdapter.add("Abrir");
        listAdapter.add("Enviar");

        listAdapter.add("Cerrar Sesión");

        expListView.setAdapter(listAdapter);

    }
    private void click(){
        expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position==0){
                    Intent intent = new Intent(principal, Abrir.class);
                    principal.startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(principal, Enviar.class);
                    principal.startActivity(intent);
                }

                if(position==2){
                    Intent intent = new Intent(principal, Principal.class);
                    principal.startActivity(intent);
                }


            }
        });
    }
}
