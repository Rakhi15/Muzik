package com.audlabs.viperfx.screen;

class j extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ ConvolverFragment b;

    j(ConvolverFragment convolverFragment, String str) {
        this.b = convolverFragment;
        this.a = str;
    }

    public void run() {
        try {
            this.b.e.clear();
            int i = 0;
            while (i < this.b.f.size()) {
                if ("".equals(this.a) || ((String) this.b.f.get(i)).toLowerCase().contains(this.a.toLowerCase())) {
                    if (this.b.b.equals(this.b.f.get(i))) {
                        this.b.c = i;
                    }
                    this.b.e.add(this.b.f.get(i));
                }
                i++;
            }
            this.b.c = this.b.e.indexOf(this.b.b);
        } catch (Exception e) {
        }
        this.b.i.sendEmptyMessage(0);
    }
}
