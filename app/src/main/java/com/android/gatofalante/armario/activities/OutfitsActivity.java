package com.android.gatofalante.armario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.GridView;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.adapters.OutfitsAdapter;

public class OutfitsActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfits);

        GridView gv = (GridView)findViewById(R.id.gridview);
        gv.setAdapter(new OutfitsAdapter(this));


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.create_outfit_button:
                        startActivity(new Intent(OutfitsActivity.this, SelectionActivity.class));
                        break;


                }
                return true;
            }
        });


    }
}
