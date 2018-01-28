package com.android.gatofalante.armario.models;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by gatofalante on 12/27/17.
 */

public class Outfit extends RealmObject {
    @Required
    @PrimaryKey
    private String outfit_id;
    @Required
    private String outfit_name;
    private RealmList<Item> items;

    public Outfit() {
        outfit_id = UUID.randomUUID().toString();
        items = new RealmList<Item>();
    }
    public Outfit(String name, RealmList<Item> i) {
        outfit_id = UUID.randomUUID().toString();
        this.outfit_name = name;
        items = new RealmList<>();
        items = i;
    }

    public Outfit(String id, String name, RealmList<Item> i) {
        this.outfit_id = id;
        this.outfit_name = name;
        items = new RealmList<>();
        items = i;
    }

    public String getId() {
        return this.outfit_id;
    }
    public String getName() {
        return this.outfit_name;
    }
    public RealmList getItems() {
        return this.items;
    }

    public void setId(String id) {
        this.outfit_id = id;
    }
    public void setName(String name) {
        this.outfit_name = name;
    }
    public void setItems(RealmList items) {
        this.items.addAll(items);
    }
    public void addItem(Item i){
        this.items.add(i);
    }


    public String toString() {
        return "Outfit with id=" + outfit_id + ";name=" + outfit_name + "items=" +items.size();
    }
}
