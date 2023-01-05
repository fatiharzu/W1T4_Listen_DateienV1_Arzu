package w1t1.unterricht.w1t4_listen_dateienv1_arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private TextView lbl;
    private ListView lvOhneModel;
    private ListView lvMitModel;

    //-*---------------------------------------------------------------------------------------

    /**
     * Diese Methode generiert eine <code>ArrayList</code> von Zeichenketten, die von einer
     * <code>ListView</code> anzeigt werden soll.
     *
     * @return eine ArrayList beliebigen Inhalts
     */
    private ArrayList<String> createArrayList()
    {
        ArrayList<String> al = new ArrayList<>();
                al.add("2");
                al.add("3");
                al.add("5");
                al.add("7");
                al.add("11");
                al.add("13");
                al.add("17");

                al.add("20");
                al.add("21");
                al.add("25");
                al.add("27");
                al.add("29");
                al.add("31");
                al.add("35");
        return al;
    }
    //-*---------------------------------------------------------------------------------------
    private void listeOhneModelAnzeigen()
    //
    {
        ArrayList<String> al = createArrayList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,// android.R.layout.simple_list_item_multiple_choice,
                al);                                // android.R.layout.simple_selectable_list_item,
                                                    // android.R.layout.simple_expandable_list_item_1,
        lvOhneModel.setAdapter(adapter);
    }
    //-*---------------------------------------------------------------------------------------
    private void listeMitModelAnzeigen()
    {
        ArrayList<String> al = createArrayList();

        String[] arr = new String[al.size()];

        for (int i = 0; i < al.size(); i++)
        {
            arr[i] = al.get(i);
        }

        MyListModel lm = new MyListModel(this, arr);
        lvMitModel.setAdapter(lm);
    }
    //-*---------------------------------------------------------------------------------------
    private void initComponents()
    {
        lbl = (TextView) findViewById(R.id.lbl);
        lvOhneModel =  (ListView) findViewById(R.id.lvOhneModel);
        lvMitModel =  (ListView) findViewById(R.id.lvMitModel);
    }
    //-*---------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        listeOhneModelAnzeigen();
        listeMitModelAnzeigen();


    }




}