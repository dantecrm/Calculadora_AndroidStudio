package calculadora.pe.edu.upeu.calculadoraexamen;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends ActionBarActivity {
    Button btnEstandar;
    Button btnCientifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
     //   btnEstandar=(Button)findViewById(R.id.btnS);
    }

    public void onEstandar(View v) {
        Intent inte=new Intent();
        inte.setClass(this, EstandarActivity.class);
        startActivity(inte);
    }

    public void onCientifica(View v){
        Intent inte=new Intent();
        inte.setClass(this, CientificaActivity.class);
        startActivity(inte);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_opt1){
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
