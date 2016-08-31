package com.aka.adnot.utils;

import android.content.Context;

import com.squareup.picasso.Picasso;

/**
 * Created by S.Masoud on 2016/08/29.
 */
public final class PabloPicasso {
    private static Picasso instance;

    public static Picasso with(Context context) {
        if (instance == null) {
            instance = new Picasso.Builder(context.getApplicationContext()).build();
        }
        return instance;
    }

    private PabloPicasso() {
        throw new AssertionError("No instances.");
    }
}
