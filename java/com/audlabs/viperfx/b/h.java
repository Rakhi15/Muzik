package com.audlabs.viperfx.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.audlabs.viperfx.base.c;
import java.util.ArrayList;
import java.util.Iterator;

final class h implements OnClickListener {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ c b;

    h(ArrayList arrayList, c cVar) {
        this.a = arrayList;
        this.b = cVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            this.b.a((String) it.next(), "false");
        }
        this.b.c(d.b());
        this.b.a();
    }
}
