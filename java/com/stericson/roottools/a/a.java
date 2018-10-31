package com.stericson.roottools.a;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class a {
    final File a;
    final File b;
    final String c;
    final Set d;

    public a(File file, File file2, String str, String str2) {
        this.a = file;
        this.b = file2;
        this.c = str;
        this.d = new LinkedHashSet(Arrays.asList(str2.split(",")));
    }

    public File a() {
        return this.a;
    }

    public File b() {
        return this.b;
    }

    public Set c() {
        return this.d;
    }

    public String toString() {
        return String.format("%s on %s type %s %s", new Object[]{this.a, this.b, this.c, this.d});
    }
}
