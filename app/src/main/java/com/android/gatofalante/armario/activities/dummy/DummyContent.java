package com.android.gatofalante.armario.activities.dummy;

import android.util.Log;

import com.android.gatofalante.armario.models.Category;
import com.android.gatofalante.armario.utilities.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Category> ITEMS = new ArrayList<Category>();
    //public static List<Item> temp2= new ArrayList<Item>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Category> ITEM_MAP = new HashMap<String, Category>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.

        addCategories();
    }

    private static void addCategories() {
        Category temp = null;
        for (Category c : DatabaseHelper.getCategories()) {
            //temp2 = c.getItems();
            temp = new Category(c.getId(), c.getName());

        ITEMS.add(temp);
    }
        Log.i("IN DUMMY", String.valueOf(ITEMS.size()));
        int counter = 1;
        for(Category c :ITEMS) {
            c.setListItem(String.valueOf(counter));
            ITEM_MAP.put(String.valueOf(counter), c);
            counter++;
        }

    }


}
