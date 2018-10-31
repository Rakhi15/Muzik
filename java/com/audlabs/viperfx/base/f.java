package com.audlabs.viperfx.base;

import java.io.File;
import java.io.FileFilter;

final class f implements FileFilter {
    f() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
