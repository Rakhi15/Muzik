package com.stericson.rootshell;

/* synthetic */ class e {
    static final /* synthetic */ int[] a = new int[f.values().length];

    static {
        try {
            a[f.VERBOSE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[f.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[f.DEBUG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[f.WARN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
