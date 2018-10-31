package com.audlabs.viperfx.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.b.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class a {
    public static String a(String str, Context context) {
        Reader reader;
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        if (str == null) {
            return "";
        }
        if (str.isEmpty()) {
            return "";
        }
        String str2;
        if (str.startsWith("FILE:")) {
            File file = new File(d.e() + str.substring(5));
            if (!file.exists()) {
                return "";
            }
            if (!file.canRead()) {
                return "";
            }
            String str3 = "";
            String str4 = "";
            try {
                Reader fileReader2 = new FileReader(file);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    str2 = str4;
                    str4 = str3;
                    while (true) {
                        try {
                            str3 = bufferedReader2.readLine();
                            if (str3 == null) {
                                break;
                            }
                            str3 = str3.trim();
                            if (str3.startsWith("SR_44100:")) {
                                str4 = str3.substring(9);
                            } else if (str3.startsWith("SR_48000:")) {
                                str2 = str3.substring(9);
                            }
                        } catch (IOException e) {
                            bufferedReader = bufferedReader2;
                            reader = fileReader2;
                        }
                    }
                    bufferedReader2.close();
                    fileReader2.close();
                    return str4.isEmpty() ? "" : str2.isEmpty() ? "" : str4 + "," + str2;
                } catch (IOException e2) {
                    reader = fileReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            return "";
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return "";
                }
            } catch (IOException e4) {
                fileReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return "";
            }
        }
        str2 = e.c(context);
        try {
            String[] strArr = new String[]{"ID", "SR_44100_Coeffs", "SR_48000_Coeffs"};
            String[] strArr2 = new String[]{str};
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(str2.endsWith("/") ? str2 + "ViPERDDC.db" : str2 + "/ViPERDDC.db", null, 17);
            Cursor query = openDatabase.query("DDCData", strArr, "ID=?", strArr2, null, null, null);
            if (query == null || query.getCount() != 1) {
                openDatabase.close();
                return "";
            }
            query.moveToFirst();
            String trim = query.getString(1).trim();
            String trim2 = query.getString(2).trim();
            query.close();
            openDatabase.close();
            return (trim.length() <= 0 || trim2.length() <= 0) ? "" : trim + "," + trim2;
        } catch (Exception e5) {
            Log.i("ViPER4Android", "queryDDCBlock[ViPER-DDC] :" + e5.getMessage());
            return "";
        }
    }

    public static boolean a(Context context) {
        String c = e.c(context);
        File file = new File(c.endsWith("/") ? c + "ViPERDDC.db" : c + "/ViPERDDC.db");
        if (file.exists()) {
            file.delete();
        }
        return e.a(context, "ViPERDDC.db", "ViPERDDC.db");
    }

    public static float[] a(String str) {
        if (str == null || str.length() < 3 || !str.contains(",")) {
            return null;
        }
        try {
            String[] split = str.split(",");
            float[] fArr = new float[split.length];
            for (int i = 0; i < split.length; i++) {
                fArr[i] = Float.valueOf(split[i]).floatValue();
            }
            return fArr;
        } catch (Exception e) {
            return null;
        }
    }

    public static Map b(Context context) {
        String c = e.c(context);
        c = c.endsWith("/") ? c + "ViPERDDC.db" : c + "/ViPERDDC.db";
        Map linkedHashMap = new LinkedHashMap();
        try {
            String[] strArr = new String[]{"ID", "Company", "Model"};
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(c, null, 17);
            Cursor query = openDatabase.query("DDCData", strArr, null, null, null, null, "Company COLLATE NOCASE");
            if (query != null && query.moveToFirst()) {
                do {
                    if (!(query.isNull(0) || query.isNull(1) || query.isNull(2))) {
                        linkedHashMap.put(query.getString(0).trim(), query.getString(1).trim() + " - " + query.getString(2).trim());
                    }
                } while (query.moveToNext());
                query.close();
            }
            openDatabase.close();
            return linkedHashMap;
        } catch (SQLiteException e) {
            Log.i("ViPER4Android", "queryManufacturerAndModel[ViPER-DDC] :" + e.getMessage());
            return linkedHashMap;
        }
    }
}
