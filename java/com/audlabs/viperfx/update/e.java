package com.audlabs.viperfx.update;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.support.v7.app.ad;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class e {
    private final String a;
    private Context b;
    private boolean c;
    private SharedPreferences d;
    private ProgressDialog e;

    public e(Context context) {
        this(context, false);
    }

    public e(Context context, boolean z) {
        this.a = "http://api.audlabs.com/viperfx/update.php";
        this.b = context;
        this.c = z;
        this.d = context.getSharedPreferences("com.audlabs.viperfx.settings", 0);
    }

    private void a(String str) {
        ad adVar = new ad(this.b);
        adVar.a(2131099837);
        adVar.b(2131099836);
        adVar.a(2131099816, new k(this, str));
        adVar.b(2131099775, null);
        adVar.c();
    }

    private void a(String str, String str2) {
        ad adVar = new ad(this.b);
        adVar.a(2131099835);
        adVar.b(str2);
        adVar.a(2131099830, new h(this, str));
        adVar.b(2131099833, new j(this));
        adVar.c();
    }

    private boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    private String b(String str) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Throwable th2;
        Object obj;
        Object obj2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        InputStream inputStream3 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setReadTimeout(5000);
                httpURLConnection3.setConnectTimeout(5000);
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.setRequestProperty("accept", "*/*");
                httpURLConnection3.setRequestProperty("connection", "Keep-Alive");
                if (httpURLConnection3.getResponseCode() == 200) {
                    inputStream = httpURLConnection3.getInputStream();
                    try {
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[128];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream3.write(bArr, 0, read);
                            }
                            byteArrayOutputStream3.flush();
                            String byteArrayOutputStream4 = byteArrayOutputStream3.toString();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                }
                            }
                            if (byteArrayOutputStream3 != null) {
                                try {
                                    byteArrayOutputStream3.close();
                                } catch (IOException e2) {
                                }
                            }
                            httpURLConnection3.disconnect();
                            return byteArrayOutputStream4;
                        } catch (Exception e3) {
                            Exception exception2 = e3;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            inputStream2 = inputStream;
                            httpURLConnection = httpURLConnection3;
                            exception = exception2;
                            try {
                                exception.printStackTrace();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                httpURLConnection.disconnect();
                                return byteArrayOutputStream2;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                httpURLConnection2 = httpURLConnection;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (IOException e7) {
                                    }
                                }
                                httpURLConnection2.disconnect();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            httpURLConnection2 = httpURLConnection3;
                            th = th4;
                            byteArrayOutputStream2 = byteArrayOutputStream3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            httpURLConnection2.disconnect();
                            throw th;
                        }
                    } catch (Exception e32) {
                        inputStream2 = inputStream;
                        httpURLConnection = httpURLConnection3;
                        exception = e32;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        exception.printStackTrace();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        httpURLConnection.disconnect();
                        return byteArrayOutputStream2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        httpURLConnection2 = httpURLConnection3;
                        th = th2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        httpURLConnection2.disconnect();
                        throw th;
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e8) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (IOException e9) {
                    }
                }
                httpURLConnection3.disconnect();
                return byteArrayOutputStream2;
            } catch (Exception e322) {
                obj = byteArrayOutputStream2;
                httpURLConnection = httpURLConnection3;
                exception = e322;
                byteArrayOutputStream = byteArrayOutputStream2;
                exception.printStackTrace();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                httpURLConnection.disconnect();
                return byteArrayOutputStream2;
            } catch (Throwable th52) {
                obj2 = byteArrayOutputStream2;
                th2 = th52;
                httpURLConnection2 = httpURLConnection3;
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                httpURLConnection2.disconnect();
                throw th;
            }
        } catch (Exception e10) {
            exception = e10;
            byteArrayOutputStream = byteArrayOutputStream2;
            obj = byteArrayOutputStream2;
            obj2 = byteArrayOutputStream2;
            exception.printStackTrace();
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            httpURLConnection.disconnect();
            return byteArrayOutputStream2;
        } catch (Throwable th6) {
            th = th6;
            inputStream = byteArrayOutputStream2;
            httpURLConnection2 = byteArrayOutputStream2;
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            httpURLConnection2.disconnect();
            throw th;
        }
    }

    private void b() {
        if (this.e == null) {
            this.e = new ProgressDialog(this.b);
            this.e.setMessage(this.b.getResources().getString(2131099832));
        }
        this.e.show();
    }

    private boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        return connectivityManager.getActiveNetworkInfo().getType() == 1;
    }

    private void c() {
        if (this.e != null) {
            this.e.dismiss();
        }
    }

    private void d() {
        Toast.makeText(this.b, 2131099834, 0).show();
    }

    private void e() {
        Toast.makeText(this.b, 2131099831, 0).show();
    }

    public void a() {
        if (this.c) {
            b();
        } else if (!this.d.getBoolean("viper4android.settings.is_check_update", true)) {
            return;
        }
        new g(this, new f(this)).start();
    }
}
