package com.marketplace.models.enums;

import java.util.Arrays;
import java.util.List;

public enum Role {
    //SELLER PERMISSION:
    SELLER(Arrays.asList(
            Permission.READ_ALL_PRODUCTS,
            Permission.GET_PRODUCTOS_BY_USER,
            Permission.GET_PROFILE_USER
    )),


    //ADMIN PERMISSION:
    ADMIN(Arrays.asList(
            //PRODUCTS:
            Permission.READ_ALL_PRODUCTS,
            Permission.READ_PRODUCT_BY_ID,
            Permission.SAVE_ONE_PRODUCT,
            Permission.DELETE_PRODUCT,
            Permission.UPDATE_PRODUCT,
            Permission.GET_PRODUCTOS_BY_USER,


            //USERS
            Permission.READ_ALL_USERS,
            Permission.UPDATE_USER,
            Permission.DELETE_USER,
            Permission.READ_USER_BY_ID,
            Permission.GET_PROFILE_USER

    )),

    //PURCHASER PERMISSION:
    USER(Arrays.asList(
            Permission.READ_ALL_USERS,
            Permission.GET_PROFILE_USER
    )
    );

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
