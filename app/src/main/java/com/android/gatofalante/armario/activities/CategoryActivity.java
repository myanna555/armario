package com.android.gatofalante.armario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.gatofalante.armario.R;

public class CategoryActivity extends AppBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

    }

    public void showTops(View view)
    {
        //Bundle b = new Bundle();
        //b.putInt("category", 1);
        Intent intent = new Intent(CategoryActivity.this, CategoryContentsActivity.class);
        intent.putExtra("category", "Tops");
        startActivity(intent);
    }

    public void showBottoms(View view)
    {
        //Bundle b = new Bundle();
        //b.putInt("category", 2);
        Intent intent = new Intent(CategoryActivity.this, CategoryContentsActivity.class);
        intent.putExtra("category", "Bottoms");
        startActivity(intent);
    }

    public void showShoes(View view)
    {
        //Bundle b = new Bundle();
        //b.putInt("category", 3);
        Intent intent = new Intent(CategoryActivity.this, CategoryContentsActivity.class);
        intent.putExtra("category", "Shoes");
        startActivity(intent);
    }

    public void showAccessories(View view)
    {
        //Bundle b = new Bundle();
        //b.putInt("category", 4);
        Intent intent = new Intent(CategoryActivity.this, CategoryContentsActivity.class);
        intent.putExtra("category", "Accessories");
        startActivity(intent);
    }

}
