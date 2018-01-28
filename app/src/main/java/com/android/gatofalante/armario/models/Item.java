package com.android.gatofalante.armario.models;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by gatofalante on 12/27/17.
 */

public class Item extends RealmObject {
    @Required
    @PrimaryKey
    private String item_id;
    @Required
    private String item_name;
    private String item_description;
    private String category;
    private String image_url;

    public Item() {
        this.item_id = UUID.randomUUID().toString();
    }
    public Item(String name, String descr, Category c, String image) {
        this.item_id = UUID.randomUUID().toString();
        this.item_name = name;
        this.item_description = descr;
        this.category = c.getName();
        this.image_url = image;
    }

    public Item(String id, String name, String descr, Category c, String image) {
        this.item_id = id;
        this.item_name = name;
        this.item_description = descr;
        this.category = c.getName();
        this.image_url = image;
    }


    public String getId() {
        return this.item_id;
    }
    public String getName() {
        return this.item_name;
    }
    public String getItemDescription() {
        return this.item_description;
    }
    public String getCategory() {
        return this.category;
    }
    public String getImageUrl() {
        return this.image_url;
    }

    public void setId(String id) {
        this.item_id = id;
    }
    public void setName(String name) {
        this.item_name = name;
    }
    public void setItemDescription(String description) {
        this.item_description = description;
    }
    public void setCategory(Category category) {
        this.category = category.getName();
    }
    public void setImageUrl(String image) {
        this.image_url = image;
    }

    public String toString() {
        return "Item with id=" + item_id + ";name=" + item_name + ";description=" + item_description + ";category=" +category + ";image=" + image_url;
    }
}
