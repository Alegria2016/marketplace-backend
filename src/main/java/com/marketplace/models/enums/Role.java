package com.marketplace.models.enums;

import java.util.Arrays;
import java.util.List;

public enum Role {
    //CUSTOMER PERMISSION:
    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),


    //ADMIN PERMISSION:
    ADMIN(Arrays.asList(
            //PRODUCTS:
            Permission.READ_ALL_PRODUCTS,
            Permission.READ_PRODUCT_BY_ID,
            Permission.SAVE_ONE_PRODUCT,
            Permission.DELETE_PRODUCT,
            Permission.UPDATE_PRODUCT,

            //USERS
            Permission.READ_ALL_USERS,
            Permission.UPDATE_USER,
            Permission.DELETE_USER,
            Permission.READ_USER_BY_ID
    )),

    //USER PERMISSION:
    USER(Arrays.asList(Permission.READ_ALL_USERS));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
