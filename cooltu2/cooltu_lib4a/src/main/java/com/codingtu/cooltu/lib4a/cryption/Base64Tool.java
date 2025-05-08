package com.codingtu.cooltu.lib4a.cryption;

import android.util.Base64;

public class Base64Tool {
    public static byte[] encode(byte[] bytes) {
        return Base64.encode(bytes, Base64.DEFAULT);
    }

    public static String encodeToStr(byte[] bytes) {
        return new String(encode(bytes));
    }

    public static byte[] decode(byte[] bytes) {
        return Base64.decode(bytes, Base64.DEFAULT);
    }

    public static String decodeToStr(byte[] bytes) {
        return new String(decode(bytes));
    }
}
