package com.android.gatofalante.armario.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.android.gatofalante.armario.R;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppBaseActivity {
    private static final String ArmarioPREFS = "ArmarioPrefs" ;
    private static final String TOPS = "tops";
    private static final String BOTS = "bottoms";
    private static final String SHOES = "shoes";
    private static final String ACC = "accessories";
    private Set <String> topIds = new HashSet<String>();
    private Set <String> bottomIds = new HashSet<String>();
    private Set <String> shoesIds = new HashSet<String>();
    private Set <String> accIds = new HashSet<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = this.getSharedPreferences(ArmarioPREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(!sp.contains(TOPS))
        editor.putStringSet(TOPS, topIds);
        if(!sp.contains(BOTS))
        editor.putStringSet(BOTS, bottomIds);
        if(!sp.contains(SHOES))
        editor.putStringSet(SHOES, shoesIds);
        if(!sp.contains(ACC))
        editor.putStringSet(ACC, accIds);
        editor.commit();



    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topmenu, menu);
        return true;
    }

    public void showCloset(View view)
    {
        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
        //Intent intent = new Intent(MainActivity.this, DataInsertActivity.class);
        startActivity(intent);
    }


    public void showOutfits(View view) {

        Intent intent = new Intent(MainActivity.this, OutfitsActivity.class);
        startActivity(intent);
    }
}
