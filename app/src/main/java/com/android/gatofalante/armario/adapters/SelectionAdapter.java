package com.android.gatofalante.armario.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.models.Item;

/**
 * Created by gatofalante on 1/27/18.
 */

public class SelectionAdapter extends GridAdapter {
    private static final String ArmarioPREFS = "ArmarioPrefs" ;
    private static final String TOPS = "tops";
    private static final String BOTS = "bottoms";
    private static final String SHOES = "shoes";
    private static final String ACC = "accessories";
    private SharedPreferences prefs = context.getSharedPreferences(ArmarioPREFS, Context.MODE_PRIVATE);

    public SelectionAdapter(Context ctx, String category) {
        super(ctx, category);

    }

    @Override
    public View getView(int i, View view, ViewGroup vg) {

        View v = view;
        ImageView picture;
        TextView name;
        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, vg, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

        final Item item = getItem(i);

        picture.setImageResource((int)this.getItemId(i));
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent detail = new Intent(context, DetailActivity.class);
                //detail.putExtra("id", item.getId());
                String id = item.getId();
                v.setAlpha((float)0.1);
                switch(item.getCategory()) {
                    case ("Tops"):
                        prefs.getStringSet(TOPS, null).add(id);
                        //topsIds.add(id);
                        //Toast.makeText(context, "hello tops: ", Toast.LENGTH_SHORT).show();
                        //Log.i("SA TOPS", String.valueOf(topsIds.size()));
                        break;
                    case ("Bottoms"):
                        prefs.getStringSet(BOTS, null).add(id);
                        //Toast.makeText(context, "hello bots: ", Toast.LENGTH_SHORT).show();
                        break;
                    case ("Shoes"):
                        prefs.getStringSet(SHOES, null).add(id);
                        //Toast.makeText(context, "hello shoes: ", Toast.LENGTH_SHORT).show();
                        break;
                    case ("Accessories"):
                        prefs.getStringSet(ACC, null).add(id);
                        break;
                    default:
                        Toast.makeText(context, "Err.. What did you just click?", Toast.LENGTH_SHORT).show();
                }

                //context.startActivity(detail);



            }
        });
        name.setText(item.getName());
        return v;

    }


}
