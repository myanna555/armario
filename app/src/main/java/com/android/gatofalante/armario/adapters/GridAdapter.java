package com.android.gatofalante.armario.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.activities.DetailActivity;
import com.android.gatofalante.armario.models.Category;
import com.android.gatofalante.armario.models.Item;
import com.android.gatofalante.armario.utilities.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import static com.android.gatofalante.armario.utilities.DatabaseHelper.getItemsByCategory;

/**
 * Created by gatofalante on 12/29/17.
 */

public class GridAdapter extends BaseAdapter {
    protected  List<Item> mItems = new ArrayList<Item>();//was <Img>
    protected final LayoutInflater mInflater;
    //private List<Item> dbResults = new ArrayList<Item>();
    protected Context context;


    public GridAdapter(Context ctx, String category) {
        context = ctx;
        //Log.i("INT", String.valueOf(i));
        mInflater = LayoutInflater.from(ctx);
        switch(category) {
            case "Tops":
                mItems = getItemsByCategory(new Category("Tops"));
                break;
            case "Bottoms":
                mItems = getItemsByCategory(new Category("Bottoms"));
                break;
            case "Shoes":
                mItems = getItemsByCategory(new Category("Shoes"));
                break;
            case "Accessories":
                mItems = DatabaseHelper.getItemsByCategory(new Category("Accessories"));
                break;
            default:
                break;

        }

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return  context.getResources().getIdentifier(mItems.get(i).getImageUrl(), "raw", context.getPackageName());


                //mItems.get(i).drawableId;
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
                Intent detail = new Intent(context, DetailActivity.class);
                detail.putExtra("id", item.getId());
                //Toast.makeText(co, "hello: " + item.getId(), Toast.LENGTH_SHORT).show();
                context.startActivity(detail);



            }
        });
        name.setText(item.getName());
        return v;

    }

}
