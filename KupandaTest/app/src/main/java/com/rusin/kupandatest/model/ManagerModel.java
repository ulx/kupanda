package com.rusin.kupandatest.model;

/**
 * Created by alexander on 22.07.15.
 */
public class ManagerModel {
    private ItemsModel itemsModel;
    private static ManagerModel instance;

    public static ManagerModel getInstance() {
        if (instance == null) {
            instance = new ManagerModel();
        }
        return instance;
    }

    public ItemsModel getItemsModel() {
        if (itemsModel == null) {
            itemsModel = new ItemsModel();
        }

        return itemsModel;
    }
}
