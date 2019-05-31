package sg.edu.rp.soi.p07quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList <String> al;


    int setting = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spinner = findViewById(R.id.spinner);
        lv = findViewById(R.id.lv);

        al = new ArrayList<>();


        aa = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, al );

        aa.add("apple");
        aa.add("ball");
        aa.add("cat");
        lv.setAdapter(aa);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        setting =0;
                        break;
                    case 1:
                        setting=1;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    setting =0;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(setting ==0){
                    Log.v("sg.edu.rp.soi.p07quiz","Item clicked "+al.get(position));
                }
                else if(setting==1){
                    Toast.makeText(MainActivity.this,"Item clicked "+al.get(position),Toast.LENGTH_LONG).show();
                }
            }
        });






    }
}
