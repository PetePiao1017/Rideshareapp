package com.karru.countrypic;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heride.rider.R;
import com.heride.rider.R.drawable;
import com.karru.utility.Utility;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

/**
 * Created by embed on 6/9/16.
 *
 */
public class CountryListAdapter extends BaseAdapter
{

    private static final String TAG = "CountryListAdapter";
    /*********************************************************/

    private Context context;
    List<Country> countries;
    LayoutInflater inflater;

    private int getResId(String drawableName)
    {
        Utility.printLog(TAG+" getResId drawableName "+drawableName);
        Resources resources = context.getResources();
        return resources.getIdentifier(drawableName, "drawable",
                context.getPackageName());
    }

    CountryListAdapter(Context context, List<Country> countries) {
        super();
        this.context = context;
        this.countries = countries;
        inflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView = convertView;
        Cell cell;
        Country country = countries.get(position);
        Utility.printLog(TAG+" country list "+countries.get(position).getFlag());

        if (convertView == null)
        {
            cell = new Cell();
            cellView = inflater.inflate(R.layout.item_country_picker, null);
            cell.textView = cellView.findViewById(R.id.row_title);
            cell.imageView = cellView.findViewById(R.id.row_icon);
            cellView.setTag(cell);
        } else
            cell = (Cell) cellView.getTag();

        cell.textView.setText(country.getName());
        String drawableName = "flag_"
                + country.getCode().toLowerCase(Locale.ENGLISH);
        Utility.printLog(TAG+" drawableName  "+drawableName);
        int drawableId = getResId(drawableName);
        country.setFlag(drawableId);
        cell.imageView.setImageResource(getResId(drawableName));
        return cellView;
    }

    static class Cell {
        TextView textView;
        ImageView imageView;
    }
}
