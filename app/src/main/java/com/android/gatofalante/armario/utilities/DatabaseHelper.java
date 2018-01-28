package com.android.gatofalante.armario.utilities;

import android.content.Context;
import android.util.Log;

import com.android.gatofalante.armario.models.Category;
import com.android.gatofalante.armario.models.Item;
import com.android.gatofalante.armario.models.Outfit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by gatofalante on 12/27/17.
 */

public class DatabaseHelper {

    private static RealmConfiguration dbConfig;

    private DatabaseHelper() {}

    public static Realm getRealmInstance() {
        if (dbConfig == null) {
            dbConfig = new RealmConfiguration.Builder()
                    .name("armario.realm")
                    .schemaVersion(0)
                    /*.deleteRealmIfMigrationNeeded()*/
                    .build();

        }
        final Realm dbRealm = Realm.getInstance(dbConfig);
        return dbRealm;
    }

    public static int countItems() {
        int total = 0;
        total = (int)getRealmInstance().where(Item.class).count();
        return total;
    }
    public static void updateDatabaseObject(final RealmObject o) {
        getRealmInstance().executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
                realm.insertOrUpdate(o);
            }
        });
    }

    public static List<Item> getItemsByCategory(Category c) {
        RealmResults<Item> results = null;
        results = getRealmInstance().where(Item.class).equalTo("category", c.getName()).findAll();
        List<Item> itemList = new ArrayList();
        itemList.addAll(results);
        return itemList;
    }

    public static List<Category> getCategories() {
        RealmResults<Category> results = null;
        results = getRealmInstance().where(Category.class).findAll();
        List<Category> catList = new ArrayList();
        catList.addAll(results);
        Log.i("RETURN: ", String.valueOf(catList.size()));
        return catList;
    }

    public static void deleteCategories() {
        getRealmInstance().executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
                RealmResults<Category> results = getRealmInstance().where(Category.class).findAll();
                results.deleteAllFromRealm();
            }
        });
    }

    public static void deleteItems() {
        getRealmInstance().executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
                RealmResults<Item> results = getRealmInstance().where(Item.class).findAll();
                results.deleteAllFromRealm();
            }
        });

    }

    public static ArrayList<Integer> getImageIds(Context ctx, Category c) {
        List<Item> idResults = getItemsByCategory(c);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for(Item i : idResults) {
            ids.add(ctx.getResources().getIdentifier(i.getImageUrl(), "raw", ctx.getPackageName()));
        }
        return ids;
    }

    public static ArrayList<Integer> getSelectedImageIds(Context ctx, Set<String> ids) {
        ArrayList<Integer> imageIds = new ArrayList<Integer>();
        for(String id : ids) {
            Item i = getItemById(id);
            imageIds.add(ctx.getResources().getIdentifier(i.getImageUrl(), "raw", ctx.getPackageName()));
        }
        return imageIds;
    }

    public static Item getItemById(String id) {
        Item item = getRealmInstance().where(Item.class).equalTo("item_id", id).findFirst();
        return item;
    }

    public static ArrayList<Outfit> getOutfits() {
        RealmResults<Outfit> results = null;
        results = getRealmInstance().where(Outfit.class).findAll();
        ArrayList<Outfit> outfitList = new ArrayList();
        outfitList.addAll(results);
        Log.i("OUTFITS: ", String.valueOf(outfitList.size()));
        return outfitList;

    }





}
