package com.audlabs.viperfx.base;

import java.io.File;
import java.io.FileFilter;

final class k implements FileFilter {
    k() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
