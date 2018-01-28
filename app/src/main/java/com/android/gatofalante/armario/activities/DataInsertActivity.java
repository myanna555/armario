package com.android.gatofalante.armario.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.models.*;
import com.android.gatofalante.armario.utilities.DatabaseHelper;

import io.realm.RealmList;

public class DataInsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);
        DatabaseHelper.deleteCategories();
        DatabaseHelper.deleteItems();
        Category tops_category = new Category("Tops");
        Category bottoms_category = new Category("Bottoms");
        Category shoes_category = new Category("Shoes");
        Category accessories_category = new Category("Accessories");


        RealmList<Item> shoes = new RealmList<Item>();
        shoes.add(new Item("Shoes 01", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes1"));
        shoes.add(new Item("Shoes 02", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes2"));
        shoes.add(new Item("Shoes 03", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes3"));
        shoes.add(new Item("Shoes 04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes4"));
        shoes.add(new Item("Shoes 05", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes5"));
        shoes.add(new Item("Shoes 06", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes6"));
        shoes.add(new Item("Shoes 07", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes7"));
        shoes.add(new Item("Shoes 08", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", shoes_category, "shoes8"));
        shoes_category.setItems(shoes);
        DatabaseHelper.updateDatabaseObject(shoes_category);


        for(Item i : shoes) {
            DatabaseHelper.updateDatabaseObject(i);
        }



        RealmList<Item> tops = new RealmList<Item>();
        tops.add(new Item("Tops 01", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", tops_category, "tops1"));
        tops.add(new Item("Tops 02", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", tops_category, "tops2"));
        tops.add(new Item("Tops 03", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", tops_category, "tops3"));
        tops.add(new Item("Tops 04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", tops_category, "tops4"));
        tops.add(new Item("Tops 05", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", tops_category, "tops5"));
        tops.add(new Item("Tops 06", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", tops_category, "tops6"));
        tops_category.setItems(tops);
        DatabaseHelper.updateDatabaseObject(tops_category);

        for(Item i : tops) {
            DatabaseHelper.updateDatabaseObject(i);
        }

        RealmList<Item> bottoms = new RealmList<Item>();
        bottoms.add(new Item("Bottoms 01", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms1"));
        bottoms.add(new Item("Bottoms 02", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms2"));
        bottoms.add(new Item("Bottoms 03", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms3"));
        bottoms.add(new Item("Bottoms 04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms4"));
        bottoms.add(new Item("Bottoms 05", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms5"));
        bottoms.add(new Item("Bottoms 06", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms6"));
        bottoms.add(new Item("Bottoms 07", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", bottoms_category, "bottoms7"));

        bottoms_category.setItems(bottoms);
        DatabaseHelper.updateDatabaseObject(bottoms_category);


        for(Item i : bottoms) {
            DatabaseHelper.updateDatabaseObject(i);
        }







        RealmList<Item> accessories = new RealmList<Item>();
        accessories.add(new Item("Accessories 01", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories1"));
        accessories.add(new Item("Accessories 02", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories2"));
        accessories.add(new Item("Accessories 03", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories3"));
        accessories.add(new Item("Accessories 04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories4"));
        accessories.add(new Item("Accessories 05", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories5"));
        accessories.add(new Item("Accessories 06", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories6"));
        accessories.add(new Item("Accessories 07", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", accessories_category, "accessories7"));

        accessories_category.setItems(accessories);
        DatabaseHelper.updateDatabaseObject(accessories_category);


        for(Item i : accessories) {
            DatabaseHelper.updateDatabaseObject(i);
        }



        Log.i("COUNT OF ITEMS IN TOPS", String.valueOf(DatabaseHelper.getItemsByCategory(tops_category).size()));
        Log.i("COUNT OF BOTTOMS", String.valueOf(DatabaseHelper.getItemsByCategory(bottoms_category).size()));
        Log.i("COUNT OF SHOES", String.valueOf(DatabaseHelper.getItemsByCategory(shoes_category).size()));
        Log.i("COUNT OF ACC", String.valueOf(DatabaseHelper.getItemsByCategory(accessories_category).size()));

        Log.i("NOW HOW MANY CATS?", String.valueOf(DatabaseHelper.getCategories().size()));
    }
}
