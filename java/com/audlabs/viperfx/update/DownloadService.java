package com.audlabs.viperfx.update;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.bh;
import android.text.TextUtils;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.main.MainActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadService extends Service {
    private int a;
    private NotificationManager b;
    private boolean c;
    private String d;
    private String e;
    private String f;
    private c g;
    private boolean h = false;
    private Context i = this;
    private Thread j;
    private Notification k;
    private bh l;
    private Handler m = new a(this);
    private Runnable n = new b(this);

    private String a(String str) {
        return (str == null || TextUtils.isEmpty(str)) ? "" : str.substring(str.lastIndexOf("/"));
    }

    private void a() {
        this.c = false;
        c();
    }

    private void b() {
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 134217728);
        this.l = new bh(this);
        this.l.b(getResources().getString(2131099786)).b(false).a(true).b(0).a(2130903092).a(BitmapFactory.decodeResource(getResources(), 2130903056)).a(System.currentTimeMillis()).a(this.e).a(activity);
        this.k = this.l.a();
        this.k.flags = 2;
        this.b.notify(1, this.k);
    }

    private void c() {
        this.j = new Thread(this.n);
        this.j.start();
    }

    private void d() {
        File file = new File(this.f);
        if (file.exists()) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            this.i.startActivity(intent);
        }
    }

    public long a(String str, File file) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        int i = 0;
        long j = 0;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestProperty("User-Agent", "PacificHttpClient");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(20000);
                int contentLength = httpURLConnection2.getContentLength();
                if (httpURLConnection2.getResponseCode() == 404) {
                    throw new Exception("fail!");
                }
                FileOutputStream fileOutputStream2;
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                try {
                    fileOutputStream2 = new FileOutputStream(file, false);
                } catch (Throwable th2) {
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                    fileOutputStream = null;
                    inputStream = inputStream2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                        j += (long) read;
                        if (i == 0 || ((int) ((100 * j) / ((long) contentLength))) - 4 > i) {
                            i += 4;
                            Message obtainMessage = this.m.obtainMessage();
                            obtainMessage.what = 1;
                            obtainMessage.arg1 = i;
                            this.m.sendMessage(obtainMessage);
                        }
                    }
                    this.m.sendEmptyMessage(0);
                    this.c = true;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return j;
                } catch (Throwable th22) {
                    inputStream = inputStream2;
                    FileOutputStream fileOutputStream3 = fileOutputStream2;
                    httpURLConnection = httpURLConnection2;
                    th = th22;
                    fileOutputStream = fileOutputStream3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th222) {
                httpURLConnection = httpURLConnection2;
                th = th222;
                fileOutputStream = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public IBinder onBind(Intent intent) {
        this.d = intent.getStringExtra("download_url");
        this.f = d.c() + "/download/" + a(this.d);
        this.e = getResources().getString(2131099787);
        this.e = String.format(this.e, new Object[]{intent.getStringExtra("title")});
        return this.g;
    }

    public void onCreate() {
        super.onCreate();
        this.g = new c(this);
        this.b = (NotificationManager) getSystemService("notification");
        stopForeground(true);
    }
}
