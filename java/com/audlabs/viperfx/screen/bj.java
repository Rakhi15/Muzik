package com.audlabs.viperfx.screen;

import android.util.Log;
import com.audlabs.viperfx.a.a;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.b.e;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class bj extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ VDdcFragment b;

    bj(VDdcFragment vDdcFragment, String str) {
        this.b = vDdcFragment;
        this.a = str;
    }

    public void run() {
        this.b.d.clear();
        this.b.e.clear();
        this.b.g = -1;
        this.b.c = a.b(this.b.getActivity());
        if (this.b.c == null) {
            this.b.c = new LinkedHashMap();
        }
        File file = new File(d.e());
        if (file.exists()) {
            Log.i("ViPER4Android", "Custom DDC directory exists");
        } else {
            Log.i("ViPER4Android", "Custom DDC directory does not exists");
            file.mkdirs();
            file.mkdir();
        }
        ArrayList arrayList = new ArrayList();
        e.a(file, ".vdc", arrayList);
        if (!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.b.c.put("FILE:" + ((String) arrayList.get(i)), arrayList.get(i));
            }
        }
        int i2 = 0;
        for (Entry entry : this.b.c.entrySet()) {
            if ("".equals(this.a) || ((String) entry.getValue()).toLowerCase().contains(this.a.toLowerCase())) {
                if (this.b.f.equals(entry.getKey())) {
                    this.b.g = i2;
                }
                this.b.d.add(i2, entry.getValue());
                this.b.e.add(i2, entry.getKey());
                i2++;
            }
        }
        this.b.h.sendEmptyMessage(0);
    }
}
