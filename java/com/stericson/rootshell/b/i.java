package com.stericson.rootshell.b;

public enum i {
    NORMAL("normal"),
    SHELL("u:r:shell:s0"),
    SYSTEM_SERVER("u:r:system_server:s0"),
    SYSTEM_APP("u:r:system_app:s0"),
    PLATFORM_APP("u:r:platform_app:s0"),
    UNTRUSTED_APP("u:r:untrusted_app:s0"),
    RECOVERY("u:r:recovery:s0");
    
    private String h;

    private i(String str) {
        this.h = str;
    }

    public String a() {
        return this.h;
    }
}
