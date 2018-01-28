package com.android.gatofalante.armario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.models.Item;
import com.android.gatofalante.armario.utilities.DatabaseHelper;

public class DetailActivity extends AppBaseActivity {
    private Item displayItem;
    private String itemId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



       itemId= getIntent().getStringExtra("id");
       displayItem = DatabaseHelper.getItemById(itemId);

        ImageView iv = (ImageView)findViewById(R.id.item_image);
        iv.setImageResource(getResources().getIdentifier(displayItem.getImageUrl(), "raw", getPackageName()));
        TextView title = (TextView)findViewById(R.id.item_title);
        title.setText(displayItem.getName());
        TextView descr = (TextView)findViewById(R.id.item_detail);
        descr.setText(displayItem.getItemDescription());


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_back_to_list:
                        navigateUpTo(new Intent(DetailActivity.this, CategoryContentsActivity.class).putExtra("category", displayItem.getCategory()));
                        break;
                    case R.id.action_edit:
                        Toast.makeText(DetailActivity.this, "Edit - yet to implement", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_delete:
                        Toast.makeText(DetailActivity.this, "Delete - yet to implement", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

    }


}
