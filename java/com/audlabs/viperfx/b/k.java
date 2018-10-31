package com.audlabs.viperfx.b;

import android.util.Log;
import com.audlabs.viperfx.base.V4AJniInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class k {
    private boolean a = false;
    private boolean b = false;

    public k() {
        if (!b()) {
            c();
        }
    }

    private boolean b() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        String str = "/proc/cpuinfo";
        this.a = false;
        this.b = false;
        try {
            Reader fileReader2 = new FileReader(str);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        readLine = readLine.trim();
                        if (readLine.startsWith("Features")) {
                            Log.i("ViPER4Android", "CpuInfo[java] = <" + readLine + ">");
                            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                            while (stringTokenizer.hasMoreElements()) {
                                readLine = stringTokenizer.nextToken();
                                if (readLine != null) {
                                    if (readLine.equalsIgnoreCase("neon")) {
                                        this.a = true;
                                    } else if (readLine.equalsIgnoreCase("vfp")) {
                                        this.b = true;
                                    }
                                }
                            }
                            continue;
                        }
                    } catch (IOException e) {
                        bufferedReader = bufferedReader2;
                        fileReader = fileReader2;
                    }
                }
                bufferedReader2.close();
                fileReader2.close();
                Log.i("ViPER4Android", "cpuInfo[java] = NEON:" + this.a + ", VFP:" + this.b);
                return this.a || this.b;
            } catch (IOException e2) {
                bufferedReader = null;
                Reader reader = fileReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        return false;
                    }
                }
                if (fileReader != null) {
                    return false;
                }
                fileReader.close();
                return false;
            }
        } catch (IOException e4) {
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                return false;
            }
            fileReader.close();
            return false;
        }
    }

    private void c() {
        this.a = V4AJniInterface.c();
        this.b = V4AJniInterface.d();
    }

    public boolean a() {
        return this.a;
    }
}
