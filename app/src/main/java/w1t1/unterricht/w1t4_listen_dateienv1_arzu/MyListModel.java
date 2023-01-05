package w1t1.unterricht.w1t4_listen_dateienv1_arzu;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * In einem Lsitmodel können die Daten festgelegt werden, die von einer ListView anzeigt
 * werden sollen. Die Daten können -je nach Bedingung - anzeigt oder herausgeliefert werden.
 * Ebend so wie der Inhalt der LsitView kann auch die Optik beeinflust werden,
 * was in der Methode <code>GetView</code> stattfindet
 */

public class MyListModel implements ListAdapter
{
    private Context context;
    private String[] daten;

    //-----------------------------------------------------------------------------------------
    public MyListModel(Context context, String[] daten)
    {
        this.context=context;
        this.daten=daten;
    }
    //-----------------------------------------------------------------------------------------

    /**
     * Sollen alle Elemente der Liste auswählbar sein?
     * @return
     */

    @Override
    public boolean areAllItemsEnabled()
    {
        return false;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Welhce solllen (in-)aktiv sein? Die Elemente werden über einen Index angesprochen.
     * Für jeden Index wird entschieden, ob das entsprehende Element anklikbar sein soll.
     * @param index Index des anzuzeigenden Elements
     * @return true für aktiv, sonst false
     */
    @Override
    public boolean isEnabled(int index)
    {
        return false;
    }
    //---------------------------------------------------------------------------------------
    /**
     * Überwachung der Daten für ggf. Sofort-Aktualisierung.
     * @param dataSetObserver
     */
    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver)
    {

    }
    //---------------------------------------------------------------------------------------

    /**
     * Überwachung der Daten ggf. Sofort-Aktualisierung
     * @param dataSetObserver
     */
    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver)
    {

    }
    //---------------------------------------------------------------------------------------

    /**
     * Wie viele Elemente hot die Liste?
     * @return
     */
    @Override
    public int getCount()
    {
        return daten.length;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Liefert den Inhalt an Listenposition <code>i</code>.
     * Hier: Element das Arrays an Index <code>i</code>
     * @param i der Index
     * @return Das Element an Index i
     */
    @Override
    public Object getItem(int i)
    {
        return null;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Jeder Listenintrag sollte eine eindeutige ID besitzen. Was wäre eindeutiger
     * als die Position im Array?
     * @param i Index
     * @return id
     */
    @Override
    public long getItemId(int i)
    {
        return i;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Sind die ID s während der Anzeige gleichenbleibend?
     * @return true für gleichbleibend, sonst false
     */
    @Override
    public boolean hasStableIds()
    {
        return true;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Hier werden die anzuzeigenden Daten für die Anzeige aufbereitet.
     * Es word hier genau die Information aufbereitet, die am angegebenen Index liegt.
     * Da das Platzangebot in einer ListView beschänkt ist, können in der Regel
     * nicht alle Elemente gleichzeitig anzeigt werden. Das heßt, es gibt immer
     * irgendwelche Elemente die gerade nicht anzeigt sind. Die Views können folglich
     * wiederverwendet werden. Es müssen nur so viele Views instanziert sein,
     * wie gleichzeitig anzeigt werden können, Die die gerade nicht anzeigt werden können
     * können also für andere Inhalte wiederverwendet werden.Die wiederverwendbaren Views
     * werden als <code>convertView</code> als Argument übergeben. Es muss also nur dann eine
     * <code>View</code> neue erzuegt werden, wenn <code>convertView</code> gleich
     * <code>null</code> ist.
     */
    @Override
    public View getView(int index, View convertView, ViewGroup viewGroup)
    {
        TextView view = null;

        String inhalt = daten[index];

        if (convertView == null)
        {
            Log.d("getView", index + "convertView ist null, also neue erzugen");
            view = new TextView(context);
        }
        else
        {
            view = (TextView) convertView;
            Log.d("getView", index + "convertView kann wiedervervendet werden");
        }//parantezi asagi aldigimda rturn ustune hareket etirince gorunuyor
            view.setTextSize(TypedValue.COMPLEX_UNIT_DIP,19);
            view.setText(inhalt);

            if(index % 2 == 0)
                view.setBackgroundColor(Color.WHITE);
            else
                view.setBackgroundColor(Color.rgb(240,240,240));

        return view;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Welcher View-Typ wird für diese Position verwendet. Wir haben lediglich einen,
     * also kommt dort eine 0 hin.
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position)
    {
        return 0;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Wie viele View-Typen müssen für diese ListView berüchsichtigt werden?
     *
     * @return
     */
    @Override
    public int getViewTypeCount()
    {
        return 1;
    }
    //---------------------------------------------------------------------------------------

    /**
     * Behindaltet user Model überhaubt Daten?
     * @return true, falls leer, sonst false
     */
    @Override
    public boolean isEmpty()
    {
        return (getCount() == 0);
    }
    //---------------------------------------------------------------------------------------
}
