package com.android.gatofalante.armario.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.utilities.ClosetCategoryFragment;
import com.android.gatofalante.armario.utilities.DatabaseHelper;

import java.util.Set;

public class MixAndMatchActivity extends AppBaseActivity  {
    private final String TAG = "MIX: ";
    private static final String ArmarioPREFS = "ArmarioPrefs" ;
    private static final String TOPS = "tops";
    private static final String BOTS = "bottoms";
    private static final String SHOES = "shoes";
    private static final String ACC = "accessories";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_and_match);
        SharedPreferences sp = this.getSharedPreferences(ArmarioPREFS, Context.MODE_PRIVATE);
        Set <String> s = sp.getStringSet(TOPS, null);
        for(String str : s) {
            Log.i(TAG, str);
        }





        // DONE (5) Only create new fragments when there is no previously saved state
        if(savedInstanceState == null) {

            // Create a new head BodyPartFragment
            ClosetCategoryFragment topFragment = new ClosetCategoryFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            topFragment.setImageIds(DatabaseHelper.getSelectedImageIds(this, sp.getStringSet(TOPS, null)));
            topFragment.setListIndex(0);

            // Add the fragment to its container using a FragmentManager and a Transaction
            // Create and display the body and leg BodyPartFragments

            ClosetCategoryFragment bottomFragment = new ClosetCategoryFragment();
            bottomFragment.setImageIds(DatabaseHelper.getSelectedImageIds(this, sp.getStringSet(BOTS, null)));


            ClosetCategoryFragment shoesFragment = new ClosetCategoryFragment();
            shoesFragment.setImageIds(DatabaseHelper.getSelectedImageIds(this, sp.getStringSet(SHOES, null)));

            ClosetCategoryFragment accessoriesFragment = new ClosetCategoryFragment();
            accessoriesFragment.setImageIds(DatabaseHelper.getSelectedImageIds(this, sp.getStringSet(ACC, null)));


            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.tops_container, topFragment)
                    .add(R.id.bottoms_container, bottomFragment)
                    .add(R.id.shoes_container, shoesFragment)
                    .add(R.id.accessories_container, accessoriesFragment)
                    .commit();
        }



    }


}
