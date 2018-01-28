package com.android.gatofalante.armario.models;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by gatofalante on 12/27/17.
 */

public class Category extends RealmObject {
    @Required
    @PrimaryKey
    private String category_id;
    @Required
    private String category_name;
    private RealmList<Item> items;
    private String list_item;

    public Category() {
        category_id = UUID.randomUUID().toString();
        items = new RealmList<Item>();
    }

    public Category(String name) {
        category_id = UUID.randomUUID().toString();
        this.category_name = name;
        items = new RealmList<Item>();
    }

    public Category(String name, RealmList<Item> i) {
        category_id = UUID.randomUUID().toString();
        this.category_name = name;
        items = new RealmList<>();
        items = i;
    }

    public Category(String id, String name, RealmList<Item> i) {
        this.category_id = id;
        this.category_name = name;
        items = new RealmList<>();
        items = i;
    }

    public Category(String id, String name) {
        this.category_id = id;
        this.category_name = name;
        items = new RealmList<Item>();
    }


    public String getId() {
        return this.category_id;
    }
    public String getName() {
        return this.category_name;
    }
    public RealmList getItems() {
        return this.items;
    }
    public String getListItem() { return this.list_item;}

    public void setId(String id) {
        this.category_id = id;
    }
    public void setName(String name) {
        this.category_name = name;
    }
    public void setItems(RealmList items) {
        this.items.addAll(items);
    }
    public void addItem(Item i) {
        this.items.add(i);
    }
    public void setListItem(String listitem) {
        this.list_item = listitem;
    }
    public String toString() {
        return "Category with id=" + category_id + "; name=" + category_name + "; items=" +items.size();
    }
}
