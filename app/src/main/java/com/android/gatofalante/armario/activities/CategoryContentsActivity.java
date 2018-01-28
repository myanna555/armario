package com.android.gatofalante.armario.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.adapters.GridAdapter;
import com.android.gatofalante.armario.models.*;
import com.android.gatofalante.armario.utilities.DatabaseHelper;

public class CategoryContentsActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_contents);
        Category tops_category = new Category("Tops");
        Category bottoms_category = new Category("Bottoms");
        Category shoes_category = new Category("Shoes");
        Category accessories_category = new Category("Accessories");
        Log.i("COUNT OF ITEMS IN TOPS", String.valueOf(DatabaseHelper.getItemsByCategory(tops_category).size()));
        Log.i("COUNT OF BOTTOMS", String.valueOf(DatabaseHelper.getItemsByCategory(bottoms_category).size()));
        Log.i("COUNT OF SHOES", String.valueOf(DatabaseHelper.getItemsByCategory(shoes_category).size()));
        Log.i("COUNT OF ACC", String.valueOf(DatabaseHelper.getItemsByCategory(accessories_category).size()));

        Log.i("NOW HOW MANY CATS?", String.valueOf(DatabaseHelper.getCategories().size()));

        GridView gv = (GridView)findViewById(R.id.gridview);
        gv.setAdapter(new GridAdapter(this, getIntent().getStringExtra("category")));
    }
}
