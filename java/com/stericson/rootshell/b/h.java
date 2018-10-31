package com.stericson.rootshell.b;

import com.stericson.rootshell.a;
import com.stericson.rootshell.f;

class h implements Runnable {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public void run() {
        a aVar = null;
        while (true) {
            if (!this.a.r || this.a.n.ready() || this.a.u < this.a.q.size()) {
                this.a.c = false;
                String readLine = this.a.n.readLine();
                this.a.c = true;
                if (readLine != null) {
                    a aVar2;
                    if (aVar != null) {
                        aVar2 = aVar;
                    } else if (this.a.u < this.a.q.size()) {
                        aVar2 = (a) this.a.q.get(this.a.u);
                    } else if (this.a.r) {
                        break;
                    }
                    int indexOf = readLine.indexOf("F*D^W@#FGF");
                    if (indexOf == -1) {
                        aVar2.c(aVar2.p, readLine);
                    } else if (indexOf > 0) {
                        aVar2.c(aVar2.p, readLine.substring(0, indexOf));
                    }
                    if (indexOf >= 0) {
                        String[] split = readLine.substring(indexOf).split(" ");
                        if (split.length >= 2 && split[1] != null) {
                            int parseInt;
                            try {
                                indexOf = Integer.parseInt(split[1]);
                            } catch (NumberFormatException e) {
                                indexOf = 0;
                            }
                            try {
                                parseInt = Integer.parseInt(split[2]);
                            } catch (NumberFormatException e2) {
                                parseInt = -1;
                            }
                            try {
                                if (indexOf == this.a.x) {
                                    this.a.d(aVar2);
                                    indexOf = 0;
                                    while (aVar2.f > aVar2.g) {
                                        if (indexOf == 0) {
                                            indexOf++;
                                            a.c("Waiting for output to be processed. " + aVar2.g + " Of " + aVar2.f);
                                        }
                                        int i = indexOf;
                                        try {
                                            synchronized (this) {
                                                wait(2000);
                                            }
                                            indexOf = i;
                                        } catch (Exception e3) {
                                            a.c(e3.getMessage());
                                            indexOf = i;
                                        }
                                    }
                                    a.c("Read all output");
                                    aVar2.a(parseInt);
                                    aVar2.a();
                                    this.a.u = this.a.u + 1;
                                    this.a.x = this.a.x + 1;
                                    aVar = null;
                                }
                            } catch (Exception e32) {
                                a.a(e32.getMessage(), f.ERROR, e32);
                            } finally {
                                this.a.a(this.a.p);
                                this.a.a(this.a.o);
                                this.a.a(this.a.n);
                                a.c("Shell destroyed");
                                this.a.d = true;
                                this.a.c = false;
                            }
                        }
                    }
                    aVar = aVar2;
                }
            }
            try {
                break;
            } catch (Exception e4) {
            }
        }
        this.a.m.waitFor();
        this.a.m.destroy();
        while (this.a.u < this.a.q.size()) {
            if (aVar == null) {
                aVar = (a) this.a.q.get(this.a.u);
            }
            if (aVar.f < aVar.g) {
                aVar.b("All output not processed!");
                aVar.b("Did you forget the super.commandOutput call or are you waiting on the command object?");
            } else {
                aVar.b("Unexpected Termination.");
            }
            this.a.u = this.a.u + 1;
            aVar = null;
        }
        this.a.u = 0;
    }
}
