package com.audlabs.viperfx.service;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.Log;
import android.util.SparseArray;
import com.audlabs.viperfx.a.a;
import com.audlabs.viperfx.b.e;
import com.audlabs.viperfx.b.j;
import com.audlabs.viperfx.main.MainActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class ViPER4AndroidService extends Service {
    public static boolean a;
    public static final UUID b = UUID.fromString("41d3c987-e6cf-11e3-a88a-11aba5d5c51b");
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static String g = "none";
    private final BroadcastReceiver A = new k(this);
    private final BroadcastReceiver B = new l(this);
    private final BroadcastReceiver C = new b(this);
    private final BroadcastReceiver D = new c(this);
    private final BroadcastReceiver E = new d(this);
    private final m c = new m(this);
    private float[] h;
    private boolean i;
    private o j;
    private final SparseArray k = new SparseArray();
    private final n l = new n();
    private o m;
    private boolean n;
    private boolean o;
    private float[] p;
    private boolean q;
    private boolean r;
    private final Timer s = new Timer();
    private final TimerTask t = new a(this);
    private final BroadcastReceiver u = new e(this);
    private final BroadcastReceiver v = new f(this);
    private final BroadcastReceiver w = new g(this);
    private final BroadcastReceiver x = new h(this);
    private final BroadcastReceiver y = new i(this);
    private final BroadcastReceiver z = new j(this);

    public static String a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("viper4android.settings.lock_effect", "none");
        return string.equalsIgnoreCase("none") ? e ? "bluetooth" : d ? "headset" : f ? "usb" : "speaker" : string;
    }

    private void a(String str) {
        if (getSharedPreferences("com.audlabs.viperfx.settings", 0).getBoolean("viper4android.settings.show_notify_icon", false)) {
            int identifier = getResources().getIdentifier("smalllogo", "mipmap", getApplicationInfo().packageName);
            CharSequence charSequence = "ViPER4Android FX " + str;
            CharSequence charSequence2 = "ViPER4Android FX";
            PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
            if (activity != null) {
                Notification notification = new Builder(this).setAutoCancel(false).setOngoing(true).setDefaults(0).setWhen(System.currentTimeMillis()).setSmallIcon(identifier).setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130903056)).setTicker(charSequence).setContentTitle(charSequence2).setContentText(str).setContentIntent(activity).getNotification();
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.notify(4660, notification);
                    return;
                }
                return;
            }
            return;
        }
        Log.i("ViPER4Android", "showNotification(): show_notify = false");
    }

    private void m() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(4660);
        }
    }

    void a(int i, int i2, boolean z, o oVar) {
        if (oVar != null && this.i) {
            if (z) {
                oVar.a(65552, i, i2);
            } else {
                oVar.a(65596, i, i2);
            }
        }
    }

    void a(SharedPreferences sharedPreferences, int i, o oVar, boolean z, boolean z2) {
        this.m = oVar;
        Log.i("ViPER4Android", "updateSystem(): Commiting effects type");
        oVar.a(65537, i);
        int i2;
        String[] split;
        boolean z3;
        if (i == 1) {
            Log.i("ViPER4Android", "updateSystem(): Commiting headphone-fx parameters");
            Log.i("ViPER4Android", "updateSystem(): Updating ViPER-DDC.");
            float[] b = b(sharedPreferences);
            if (b != null) {
                oVar.a(65547, b);
            }
            if (sharedPreferences.getBoolean("viper4android.headphonefx.viperddc.enable", false)) {
                oVar.a(65546, 1);
            } else {
                oVar.a(65546, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Spectrum Extension.");
            oVar.a(65550, Math.round((Float.valueOf(sharedPreferences.getString("viper4android.headphonefx.vse.value", "0.1")).floatValue() * 5.6f) * 100.0f));
            oVar.a(65549, 7600);
            if (sharedPreferences.getBoolean("viper4android.headphonefx.vse.enable", false)) {
                oVar.a(65548, 1);
            } else {
                oVar.a(65548, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating FIR Equalizer.");
            if (this.q) {
                if (this.p != null) {
                    for (i2 = 0; i2 < this.p.length; i2++) {
                        a(i2, Math.round(this.p[i2] * 100.0f), true, oVar);
                    }
                }
                if (this.o) {
                    oVar.a(65551, 1);
                } else {
                    oVar.a(65551, 0);
                }
            } else {
                if (this.h != null) {
                    for (i2 = 0; i2 < this.h.length; i2++) {
                        a(i2, Math.round(this.h[i2] * 100.0f), true, oVar);
                    }
                } else {
                    split = sharedPreferences.getString("viper4android.headphonefx.fireq.custom", "0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;").split(";");
                    for (i2 = 0; i2 < split.length; i2 = (short) (i2 + 1)) {
                        a(i2, Math.round(Float.valueOf(split[i2]).floatValue() * 100.0f), true, oVar);
                    }
                }
                if (sharedPreferences.getBoolean("viper4android.headphonefx.fireq.enable", false)) {
                    oVar.a(65551, 1);
                } else {
                    oVar.a(65551, 0);
                }
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Convolver.");
            oVar.a(sharedPreferences.getString("viper4android.headphonefx.convolver.kernel", ""), false);
            oVar.a(65543, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.convolver.crosschannel", "0")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.convolver.enable", false)) {
                oVar.a(65538, 1);
            } else {
                oVar.a(65538, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Field Surround (Colorful Music).");
            String[] split2 = sharedPreferences.getString("viper4android.headphonefx.colorfulmusic.coeffs", "120;200").split(";");
            if (split2.length == 2) {
                oVar.a(65554, Integer.valueOf(split2[0]).intValue());
                oVar.a(65556, Integer.valueOf(split2[1]).intValue());
            }
            oVar.a(65555, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.colorfulmusic.midimage", "150")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.colorfulmusic.enable", false)) {
                oVar.a(65553, 1);
            } else {
                oVar.a(65553, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Diff Surround.");
            oVar.a(65558, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.diffsurr.delay", "500")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.diffsurr.enable", false)) {
                oVar.a(65557, 1);
            } else {
                oVar.a(65557, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating ViPER's Headphone Surround Engine +.");
            oVar.a(65545, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.vhs.qual", "0")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.vhs.enable", false)) {
                oVar.a(65544, 1);
            } else {
                oVar.a(65544, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Reverberation.");
            oVar.a(65560, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.roomsize", "0")).intValue());
            oVar.a(65561, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.roomwidth", "0")).intValue());
            oVar.a(65562, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.damp", "0")).intValue());
            oVar.a(65563, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.wet", "0")).intValue());
            oVar.a(65564, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.dry", "50")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.reverb.enable", false)) {
                oVar.a(65559, 1);
            } else {
                oVar.a(65559, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Playback AGC.");
            oVar.a(65566, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.playbackgain.ratio", "50")).intValue());
            oVar.a(65567, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.playbackgain.volume", "80")).intValue());
            oVar.a(65568, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.playbackgain.maxscaler", "400")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.playbackgain.enable", false)) {
                oVar.a(65565, 1);
            } else {
                oVar.a(65565, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating FET Compressor.");
            oVar.a(65611, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.threshold", "100")).intValue());
            oVar.a(65612, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.ratio", "100")).intValue());
            oVar.a(65613, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.knee", "0")).intValue());
            oVar.a(65615, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.gain", "0")).intValue());
            oVar.a(65617, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.attack", "20")).intValue());
            oVar.a(65619, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.release", "50")).intValue());
            oVar.a(65621, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.kneemulti", "0")).intValue());
            oVar.a(65622, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.maxattack", "80")).intValue());
            oVar.a(65623, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.maxrelease", "100")).intValue());
            oVar.a(65624, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.crest", "20")).intValue());
            oVar.a(65625, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fetcompressor.adapt", "50")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fetcompressor.noclipenable", true)) {
                oVar.a(65626, 1);
            } else {
                oVar.a(65626, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fetcompressor.autoknee", true)) {
                oVar.a(65614, 1);
            } else {
                oVar.a(65614, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fetcompressor.autogain", true)) {
                oVar.a(65616, 1);
            } else {
                oVar.a(65616, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fetcompressor.autoattack", true)) {
                oVar.a(65618, 1);
            } else {
                oVar.a(65618, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fetcompressor.autorelease", true)) {
                oVar.a(65620, 1);
            } else {
                oVar.a(65620, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fetcompressor.enable", false)) {
                oVar.a(65610, 1);
            } else {
                oVar.a(65610, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Dynamic System.");
            split2 = sharedPreferences.getString("viper4android.headphonefx.dynamicsystem.coeffs", "100;5600;40;80;50;50").split(";");
            if (split2.length == 6) {
                oVar.a(65570, Integer.valueOf(split2[0]).intValue(), Integer.valueOf(split2[1]).intValue());
                oVar.a(65571, Integer.valueOf(split2[2]).intValue(), Integer.valueOf(split2[3]).intValue());
                oVar.a(65572, Integer.valueOf(split2[4]).intValue(), Integer.valueOf(split2[5]).intValue());
            }
            oVar.a(65573, (Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.dynamicsystem.bass", "0")).intValue() * 20) + 100);
            if (sharedPreferences.getBoolean("viper4android.headphonefx.dynamicsystem.enable", false)) {
                oVar.a(65569, 1);
            } else {
                oVar.a(65569, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Fidelity Control.");
            oVar.a(65575, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fidelity.bass.mode", "0")).intValue());
            oVar.a(65576, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fidelity.bass.freq", "40")).intValue());
            oVar.a(65577, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fidelity.bass.gain", "50")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fidelity.bass.enable", false)) {
                oVar.a(65574, 1);
            } else {
                oVar.a(65574, 0);
            }
            oVar.a(65579, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fidelity.clarity.mode", "0")).intValue());
            oVar.a(65580, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.fidelity.clarity.gain", "50")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.fidelity.clarity.enable", false)) {
                oVar.a(65578, 1);
            } else {
                oVar.a(65578, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Cure System.");
            oVar.a(65582, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.cure.crossfeed", "0")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.cure.enable", false)) {
                oVar.a(65581, 1);
            } else {
                oVar.a(65581, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Tube Simulator.");
            if (sharedPreferences.getBoolean("viper4android.headphonefx.tube.enable", false)) {
                oVar.a(65583, 1);
            } else {
                oVar.a(65583, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating AnalogX.");
            oVar.a(65585, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.analogx.mode", "0")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.analogx.enable", false)) {
                oVar.a(65584, 1);
            } else {
                oVar.a(65584, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Shutting down speaker optimizer.");
            oVar.a(65603, 0);
            Log.i("ViPER4Android", "updateSystem(): Updating Limiter.");
            oVar.a(65586, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.outvol", "100")).intValue());
            oVar.a(65587, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.channelpan", "0")).intValue());
            oVar.a(65588, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.limiter", "100")).intValue());
            if (!this.q) {
                if (sharedPreferences.getBoolean("viper4android.global.forceenable.enable", false)) {
                    oVar.a(36869, 1);
                } else {
                    oVar.a(36869, 0);
                }
                z3 = sharedPreferences.getBoolean("viper4android.headphonefx.enable", false);
                if (z2) {
                    z3 = false;
                }
                if (z3) {
                    oVar.a(36868, 1);
                } else {
                    oVar.a(36868, 0);
                }
                oVar.a.setEnabled(z3);
            } else if (this.n) {
                oVar.a(36868, 1);
                oVar.a.setEnabled(true);
            } else {
                oVar.a(36868, 0);
                oVar.a.setEnabled(false);
            }
        } else if (i == 2) {
            Log.i("ViPER4Android", "updateSystem(): Commiting speaker-fx parameters");
            Log.i("ViPER4Android", "updateSystem(): Updating ViPER-DDC.");
            oVar.a(65546, 0);
            Log.i("ViPER4Android", "updateSystem(): Updating Spectrum Extension.");
            oVar.a(65548, 0);
            Log.i("ViPER4Android", "updateSystem(): Updating FIR Equalizer.");
            if (this.q) {
                if (this.p != null) {
                    for (i2 = 0; i2 < this.p.length; i2++) {
                        a(i2, Math.round(this.p[i2] * 100.0f), false, oVar);
                    }
                }
                if (this.o) {
                    oVar.a(65595, 1);
                } else {
                    oVar.a(65595, 0);
                }
            } else {
                if (this.h != null) {
                    for (i2 = 0; i2 < this.h.length; i2++) {
                        a(i2, Math.round(this.h[i2] * 100.0f), false, oVar);
                    }
                } else {
                    split = sharedPreferences.getString("viper4android.headphonefx.fireq.custom", "0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;").split(";");
                    for (i2 = 0; i2 < split.length; i2 = (short) (i2 + 1)) {
                        a(i2, Math.round(Float.valueOf(split[i2]).floatValue() * 100.0f), false, oVar);
                    }
                }
                if (sharedPreferences.getBoolean("viper4android.headphonefx.fireq.enable", false)) {
                    oVar.a(65595, 1);
                } else {
                    oVar.a(65595, 0);
                }
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Reverberation.");
            oVar.a(65598, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.roomsize", "0")).intValue());
            oVar.a(65599, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.roomwidth", "0")).intValue());
            oVar.a(65600, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.damp", "0")).intValue());
            oVar.a(65601, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.wet", "0")).intValue());
            oVar.a(65602, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.reverb.dry", "50")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.reverb.enable", false)) {
                oVar.a(65597, 1);
            } else {
                oVar.a(65597, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Convolver.");
            oVar.a(sharedPreferences.getString("viper4android.headphonefx.convolver.kernel", ""), true);
            oVar.a(65594, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.convolver.crosschannel", "0")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.convolver.enable", false)) {
                oVar.a(65589, 1);
            } else {
                oVar.a(65589, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Shutting down tube simulator.");
            oVar.a(65583, 0);
            Log.i("ViPER4Android", "updateSystem(): Updating Speaker Optimizer.");
            if (sharedPreferences.getBoolean("viper4android.speakerfx.spkopt.enable", false)) {
                oVar.a(65603, 1);
            } else {
                oVar.a(65603, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating eXtraLoud.");
            oVar.a(65605, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.playbackgain.ratio", "50")).intValue());
            oVar.a(65606, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.playbackgain.volume", "80")).intValue());
            oVar.a(65607, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.playbackgain.maxscaler", "400")).intValue());
            if (sharedPreferences.getBoolean("viper4android.headphonefx.playbackgain.enable", false)) {
                oVar.a(65604, 1);
            } else {
                oVar.a(65604, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating FET Compressor.");
            oVar.a(65628, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.threshold", "100")).intValue());
            oVar.a(65629, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.ratio", "100")).intValue());
            oVar.a(65630, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.knee", "0")).intValue());
            oVar.a(65632, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.gain", "0")).intValue());
            oVar.a(65634, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.attack", "20")).intValue());
            oVar.a(65636, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.release", "50")).intValue());
            oVar.a(65638, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.kneemulti", "0")).intValue());
            oVar.a(65639, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.maxattack", "80")).intValue());
            oVar.a(65640, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.maxrelease", "100")).intValue());
            oVar.a(65641, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.crest", "20")).intValue());
            oVar.a(65642, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.fetcompressor.adapt", "50")).intValue());
            if (sharedPreferences.getBoolean("viper4android.speakerfx.fetcompressor.noclipenable", true)) {
                oVar.a(65643, 1);
            } else {
                oVar.a(65643, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.speakerfx.fetcompressor.autoknee", true)) {
                oVar.a(65631, 1);
            } else {
                oVar.a(65631, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.speakerfx.fetcompressor.autogain", true)) {
                oVar.a(65633, 1);
            } else {
                oVar.a(65633, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.speakerfx.fetcompressor.autoattack", true)) {
                oVar.a(65635, 1);
            } else {
                oVar.a(65635, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.speakerfx.fetcompressor.autorelease", true)) {
                oVar.a(65637, 1);
            } else {
                oVar.a(65637, 0);
            }
            if (sharedPreferences.getBoolean("viper4android.speakerfx.fetcompressor.enable", false)) {
                oVar.a(65627, 1);
            } else {
                oVar.a(65627, 0);
            }
            Log.i("ViPER4Android", "updateSystem(): Updating Limiter.");
            oVar.a(65608, Integer.valueOf(sharedPreferences.getString("viper4android.headphonefx.outvol", "100")).intValue());
            oVar.a(65609, Integer.valueOf(sharedPreferences.getString("viper4android.speakerfx.limiter", "100")).intValue());
            if (!this.q) {
                if (sharedPreferences.getBoolean("viper4android.global.forceenable.enable", false)) {
                    oVar.a(36869, 1);
                } else {
                    oVar.a(36869, 0);
                }
                z3 = sharedPreferences.getBoolean("viper4android.speakerfx.enable", false);
                if (z2) {
                    z3 = false;
                }
                if (z3) {
                    oVar.a(36868, 1);
                } else {
                    oVar.a(36868, 0);
                }
                oVar.a.setEnabled(z3);
            } else if (this.n) {
                oVar.a(36868, 1);
                oVar.a.setEnabled(true);
            } else {
                oVar.a(36868, 0);
                oVar.a.setEnabled(false);
            }
        }
        if (z) {
            oVar.a(36867, 1);
        }
        Log.i("ViPER4Android", "System updated.");
    }

    void a(SharedPreferences sharedPreferences, int i, boolean z, boolean z2) {
        if (this.j == null || this.j.a == null || !this.i) {
            Log.i("ViPER4Android", "updateSystem(): Effects is invalid!");
            return;
        }
        try {
            if (!this.j.a.hasControl()) {
                Log.i("ViPER4Android", "The effect is controlling by system now");
            } else if (z2) {
                a(sharedPreferences, i, this.j, z, true);
            } else {
                a(sharedPreferences, i, this.j, z, false);
            }
        } catch (Exception e) {
            Log.i("ViPER4Android", "updateSystem_Global(), Exception = " + e.getMessage());
        }
    }

    void a(boolean z) {
        boolean z2 = true;
        String a = a(getSharedPreferences("com.audlabs.viperfx.settings", 0));
        SharedPreferences sharedPreferences = getSharedPreferences("com.audlabs.viperfx." + a, 0);
        Log.i("ViPER4Android", "Begin system update(" + a + ")");
        int i = a.equalsIgnoreCase("speaker") ? 2 : 1;
        if (!a.equalsIgnoreCase(g)) {
            g = a;
            if (a.equalsIgnoreCase("headset")) {
                a(getString(getResources().getIdentifier("text_headset", "string", getApplicationInfo().packageName)));
            } else if (a.equalsIgnoreCase("bluetooth")) {
                a(getString(getResources().getIdentifier("text_bluetooth", "string", getApplicationInfo().packageName)));
            } else if (a.equalsIgnoreCase("usb")) {
                a(getString(getResources().getIdentifier("text_usb", "string", getApplicationInfo().packageName)));
            } else {
                a(getString(getResources().getIdentifier("text_speaker", "string", getApplicationInfo().packageName)));
            }
        }
        if (getSharedPreferences("com.audlabs.viperfx.settings", 0).getString("viper4android.settings.compatiblemode", "global").equals("global")) {
            z2 = false;
        }
        Log.i("ViPER4Android", "<+++++++++++++++ Update global effect +++++++++++++++>");
        a(sharedPreferences, i, z, z2);
        Log.i("ViPER4Android", "<++++++++++++++++++++++++++++++++++++++++++++++++++++>");
        Log.i("ViPER4Android", "<+++++++++++++++ Update local effect +++++++++++++++>");
        b(sharedPreferences, i, z, z2);
        Log.i("ViPER4Android", "<+++++++++++++++++++++++++++++++++++++++++++++++++++>");
    }

    public void a(float[] fArr) {
        this.h = fArr;
        a(false);
    }

    public boolean a() {
        return this.i;
    }

    public void b() {
        if (this.j != null && this.i) {
            this.j.a(36866, 1);
        }
    }

    void b(SharedPreferences sharedPreferences, int i, boolean z, boolean z2) {
        if (this.l.a()) {
            List<Integer> arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                Integer valueOf = Integer.valueOf(this.k.keyAt(i2));
                o oVar = (o) this.k.valueAt(i2);
                if (valueOf.intValue() >= 0 && oVar != null) {
                    if (z2) {
                        a(sharedPreferences, i, oVar, z, false);
                    } else {
                        try {
                            a(sharedPreferences, i, oVar, z, true);
                        } catch (Exception e) {
                            Log.i("ViPER4Android", String.format("Trouble trying to manage session %d, removing...", new Object[]{valueOf}));
                            arrayList.add(valueOf);
                        }
                    }
                }
            }
            for (Integer intValue : arrayList) {
                this.k.remove(intValue.intValue());
            }
            this.l.b();
            return;
        }
        Log.i("ViPER4Android", "Semaphore accquire failed.");
    }

    float[] b(SharedPreferences sharedPreferences) {
        float[] fArr = null;
        String string = sharedPreferences.getString("viper4android.headphonefx.viperddc.device", "");
        if (string == null || string.equals("")) {
            Log.i("ViPER4Android", "extractDDCCoeffs(): DeviceID not found.");
        } else {
            String string2 = sharedPreferences.getString("viper4android.ddcblock." + string, "");
            if (string2 == null || string2.equals("")) {
                String a = a.a(string, getApplicationContext());
                if (!(a == null || a.equals(""))) {
                    float[] a2 = a.a(a);
                    if (a2 != null && a2.length >= 2) {
                        Editor edit = sharedPreferences.edit();
                        edit.putString("viper4android.ddcblock." + string, a);
                        edit.apply();
                        fArr = a2;
                    }
                }
            } else {
                fArr = a.a(string2);
            }
            if (fArr == null) {
                Log.i("ViPER4Android", "extractDDCCoeffs(): DDC coeffs not found.");
            } else {
                Log.i("ViPER4Android", "extractDDCCoeffs(): DDC coeffs found, length = " + (fArr.length / 2));
            }
        }
        return fArr;
    }

    public void c() {
        if (this.j != null && this.i) {
            this.j.a(36866, 0);
        }
    }

    public boolean d() {
        return this.j != null && this.i && this.j.a(32770) == 1;
    }

    public boolean e() {
        return this.j != null && this.i && this.j.a(32771) == 1;
    }

    public boolean f() {
        return this.j != null && this.i && this.j.a(32772) == 1;
    }

    public boolean g() {
        return this.j != null && this.i && this.j.a(32773) == 1;
    }

    public boolean h() {
        return this.j != null && this.i && this.j.a(32774) == 1;
    }

    public int i() {
        return (this.j == null || !this.i) ? 0 : this.j.a(32776);
    }

    public IBinder onBind(Intent intent) {
        return this.c;
    }

    public void onCreate() {
        super.onCreate();
        a = true;
        Log.i("ViPER4Android", "Query ViPER4Android engine ...");
        e eVar = new e();
        eVar.getClass();
        j jVar = new j(eVar);
        if (jVar.a()) {
            int[] b = jVar.b();
            if (com.audlabs.viperfx.base.e.a(b[0] + "." + b[1] + "." + b[2] + "." + b[3])) {
                this.i = true;
                AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    e = audioManager.isBluetoothA2dpOn();
                    if (e) {
                        Log.i("ViPER4Android", "Current is a2dp mode [bluetooth]");
                        d = false;
                        f = false;
                    } else {
                        d = audioManager.isWiredHeadsetOn();
                        if (d) {
                            Log.i("ViPER4Android", "Current is headset mode");
                            f = false;
                        } else {
                            Log.i("ViPER4Android", "Current is speaker mode");
                            f = false;
                        }
                    }
                }
                Log.i("ViPER4Android", "Get current mode from system [" + a(getSharedPreferences("com.audlabs.viperfx.settings", 0)) + "]");
                if (this.j != null) {
                    Log.e("ViPER4Android", "onCreate, mGeneralFX != null");
                    this.j.a();
                    this.j = null;
                }
                SharedPreferences sharedPreferences = getSharedPreferences("com.audlabs.viperfx.settings", 0);
                if (!sharedPreferences.getBoolean("viper4android.settings.driverconfigured", false)) {
                    Editor edit = sharedPreferences.edit();
                    if (edit != null) {
                        edit.putBoolean("viper4android.settings.driverconfigured", true);
                        edit.apply();
                    }
                }
                if (sharedPreferences.getString("viper4android.settings.compatiblemode", "global").equalsIgnoreCase("global")) {
                    Log.i("ViPER4Android", "Creating global V4ADSPModule ...");
                    if (this.j == null) {
                        this.j = new o(this, 0);
                    }
                    if (this.j.a == null) {
                        Log.e("ViPER4Android", "Found v4a driver, but failed to load.");
                        this.j.a();
                        this.j = null;
                    }
                }
                if (VERSION.SDK_INT < 18) {
                    startForeground(1, new Notification());
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION");
                intentFilter.addAction("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");
                registerReceiver(this.A, intentFilter);
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                if (VERSION.SDK_INT >= 16) {
                    intentFilter.addAction("android.intent.action.ANALOG_AUDIO_DOCK_PLUG");
                }
                intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                registerReceiver(this.E, intentFilter);
                registerReceiver(this.B, new IntentFilter("com.audlabs.viperfx.UPDATE"));
                registerReceiver(this.C, new IntentFilter("com.audlabs.viperfx.SHOWNOTIFY"));
                registerReceiver(this.D, new IntentFilter("com.audlabs.viperfx.CANCELNOTIFY"));
                registerReceiver(this.u, new IntentFilter("com.audlabs.viperfx.viper4android_v2.QUERY_DRIVERSTATUS"));
                registerReceiver(this.v, new IntentFilter("com.audlabs.viperfx.viper4android_v2.QUERY_EQUALIZER"));
                registerReceiver(this.w, new IntentFilter("com.audlabs.viperfx.viper4android_v2.TAKEOVER_EFFECT"));
                registerReceiver(this.x, new IntentFilter("com.audlabs.viperfx.viper4android_v2.RELEASE_EFFECT"));
                registerReceiver(this.y, new IntentFilter("com.audlabs.viperfx.viper4android_v2.SET_ENABLED"));
                registerReceiver(this.z, new IntentFilter("com.audlabs.viperfx.viper4android_v2.SET_EQUALIZER"));
                Log.i("ViPER4Android", "Service launched.");
                a(true);
                this.s.schedule(this.t, 15000, 60000);
                return;
            }
            Log.i("ViPER4Android", "ViPER4Android engine is not compatible with service");
            this.i = false;
            return;
        }
        Log.i("ViPER4Android", "ViPER4Android engine not found, create empty service");
        this.i = false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.i) {
            this.s.cancel();
            if (VERSION.SDK_INT < 18) {
                stopForeground(true);
            }
            unregisterReceiver(this.A);
            unregisterReceiver(this.E);
            unregisterReceiver(this.B);
            unregisterReceiver(this.C);
            unregisterReceiver(this.D);
            unregisterReceiver(this.u);
            unregisterReceiver(this.v);
            unregisterReceiver(this.w);
            unregisterReceiver(this.x);
            unregisterReceiver(this.y);
            unregisterReceiver(this.z);
            m();
            if (this.j != null) {
                this.j.a();
            }
            this.j = null;
            if (this.l.a()) {
                for (int i = 0; i < this.k.size(); i++) {
                    o oVar = (o) this.k.valueAt(i);
                    if (Integer.valueOf(this.k.keyAt(i)).intValue() >= 0 && oVar != null) {
                        oVar.a();
                    }
                }
                this.k.clear();
                this.l.b();
            }
            Log.i("ViPER4Android", "Service destroyed.");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i("ViPER4Android", "Service::onStartCommand [Begin check driver]");
        if (!this.i) {
            Log.e("ViPER4Android", "Service::onStartCommand [V4A Engine not found]");
            return super.onStartCommand(intent, i, i2);
        } else if (!getSharedPreferences("com.audlabs.viperfx.settings", 0).getString("viper4android.settings.compatiblemode", "global").equalsIgnoreCase("global")) {
            Log.i("ViPER4Android", "Service::onStartCommand [V4A is local effect mode]");
            return super.onStartCommand(intent, i, i2);
        } else if (this.j == null) {
            Log.i("ViPER4Android", "Service::onStartCommand [Creating global V4ADSPModule ...]");
            this.j = new o(this, 0);
            if (this.j.a == null) {
                Log.e("ViPER4Android", "Service::onStartCommand [Found v4a driver, but failed to load]");
                this.j.a();
                this.j = null;
                return super.onStartCommand(intent, i, i2);
            }
            Log.i("ViPER4Android", "Service::onStartCommand [V4ADSPModule created]");
            a(true);
            return super.onStartCommand(intent, i, i2);
        } else if (this.j.a == null) {
            this.j.a();
            Log.i("ViPER4Android", "Service::onStartCommand [Recreating global V4ADSPModule ...]");
            this.j = new o(this, 0);
            if (this.j.a == null) {
                Log.e("ViPER4Android", "Service::onStartCommand [Found v4a driver, but failed to load]");
                this.j.a();
                this.j = null;
                return super.onStartCommand(intent, i, i2);
            }
            Log.i("ViPER4Android", "Service::onStartCommand [V4ADSPModule created]");
            a(true);
            return super.onStartCommand(intent, i, i2);
        } else if (g()) {
            Log.i("ViPER4Android", "Service::onStartCommand [Everything is ok]");
            return super.onStartCommand(intent, i, i2);
        } else {
            Log.i("ViPER4Android", "Service::onStartCommand [Begin self diagnose procedure ...]");
            this.j.a(36870, 0);
            if (g()) {
                Log.i("ViPER4Android", "Service::onStartCommand [Engine fixed]");
                a(true);
            } else {
                this.j.a();
                Log.i("ViPER4Android", "Service::onStartCommand [Recreating global V4ADSPModule ...]");
                this.j = new o(this, 0);
                if (this.j.a == null) {
                    Log.e("ViPER4Android", "Service::onStartCommand [Found v4a driver, but failed to load]");
                    this.j.a();
                    this.j = null;
                    return super.onStartCommand(intent, i, i2);
                }
                Log.i("ViPER4Android", "Service::onStartCommand [Engine fixed]");
                a(true);
            }
            return super.onStartCommand(intent, i, i2);
        }
    }
}
