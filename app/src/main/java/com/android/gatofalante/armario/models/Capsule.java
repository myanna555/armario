package com.android.gatofalante.armario.models;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by gatofalante on 12/27/17.
 */

public class Capsule extends RealmObject {
    @Required
    @PrimaryKey
    private String capsule_id;
    @Required
    private String capsule_name;
    private RealmList<Item> items;

    public Capsule() {
        capsule_id = UUID.randomUUID().toString();
        items = new RealmList<Item>();
    }
    public Capsule(String name, RealmList<Item> i) {
        capsule_id = UUID.randomUUID().toString();
        this.capsule_name = name;
        items = new RealmList<>();
        items = i;
    }

    public Capsule(String id, String name, RealmList<Item> i) {
        this.capsule_id = id;
        this.capsule_name = name;
        items = new RealmList<>();
        items = i;
    }

    public String getId() {
        return this.capsule_id;
    }
    public String getName() {
        return this.capsule_name;
    }
    public RealmList getItems() {
        return this.items;
    }

    public void setId(String id) {
        this.capsule_id = id;
    }
    public void setName(String name) {
        this.capsule_name = name;
    }
    public void setItems(RealmList items) {
        this.items.addAll(items);
    }
    public void addItem(Item i){
        this.items.add(i);
    }


    public String toString() {
        return "Capsule with id=" + capsule_id + ";name=" + capsule_name + "items=" +items.size();
    }
}
