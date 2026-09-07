package com.pgl.ssdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.yk;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.pgl.ssdk.ces.out.DungeonFlag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f7530a = null;
    private static volatile String b = null;
    private static volatile boolean c = false;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static int g = -1;
    private static long h = 0;
    private static long i = 0;
    private static volatile long j = -1;

    public static void a(File file, boolean z) throws Throwable {
        e eVarA;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    if (TextUtils.isEmpty(f7530a) && (eVarA = a(file)) != null) {
                        f7530a = a(eVarA.a());
                        d = eVarA.b();
                        if (z) {
                            a();
                            try {
                                randomAccessFile2.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(e)) {
                        e = a(randomAccessFile2);
                    }
                    if (h == 0) {
                        h = randomAccessFile2.length() / 1024;
                    }
                    if (i == 0) {
                        i = b(file);
                    }
                    randomAccessFile2.close();
                } catch (FileNotFoundException unused2) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (IOException unused3) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
        }
    }

    public static String b() throws Throwable {
        String string;
        String string2;
        String string3;
        String string4;
        int i2;
        long j2;
        long j3;
        if (TextUtils.isEmpty(f7530a) || TextUtils.isEmpty(e) || g == -1) {
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            long j4 = -1;
            if (sharedPreferencesA != null) {
                j4 = sharedPreferencesA.getLong("mt", -1L);
                string2 = sharedPreferencesA.getString("sa", null);
                string3 = sharedPreferencesA.getString("sj", null);
                string4 = sharedPreferencesA.getString("md5", null);
                j2 = sharedPreferencesA.getLong("as", 0L);
                j3 = sharedPreferencesA.getLong(ApsMetricsDataMap.APSMETRICS_FIELD_SCREENSIZE, 0L);
                i2 = sharedPreferencesA.getInt("cpc", -1);
                string = sharedPreferencesA.getString(yk.SESSION_HISTORY_KEY_AD_PROVIDER, null);
            } else {
                string = null;
                string2 = null;
                string3 = null;
                string4 = null;
                i2 = 0;
                j2 = 0;
                j3 = 0;
            }
            String strC = c();
            if (strC == null) {
                return null;
            }
            File file = new File(strC);
            Object[] objArr = (Object[]) com.pgl.ssdk.ces.a.meta(158, x.b(), strC);
            Integer num = (Integer) objArr[0];
            String str = (String) objArr[1];
            long jLastModified = file.lastModified();
            if (jLastModified != j4 || string2 == null || i2 == -1) {
                j = jLastModified;
                if (str != null) {
                    f = str;
                }
                if (num != null) {
                    g = num.intValue();
                }
                a(file, false);
                a();
            } else {
                f7530a = string2;
                d = string3;
                h = j2;
                i = j3;
                e = string4;
                g = i2;
                f = string;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f7530a)) {
                jSONObject.put("sign", f7530a);
            }
            if (!TextUtils.isEmpty(d)) {
                jSONObject.put("subject", d);
            }
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("md5", e);
            }
            if (!TextUtils.isEmpty(f)) {
                jSONObject.put("path", f);
            }
            long j5 = h;
            if (j5 != 0) {
                jSONObject.put("apkSize", j5);
            }
            long j6 = i;
            if (j6 != 0) {
                jSONObject.put("dexSize", j6);
            }
            int i3 = g;
            if (i3 != -1) {
                jSONObject.put("code", i3);
            }
            f();
            jSONObject.put("signpm", b);
            if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(f7530a)) {
                if (!b.equals(f7530a)) {
                    c = true;
                }
                jSONObject.put("rebud", c);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String c() {
        if (x.b() == null) {
            return null;
        }
        String packageCodePath = x.b().getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public static void d() throws Throwable {
        if (TextUtils.isEmpty(f7530a)) {
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            String string = null;
            long j2 = -1;
            if (sharedPreferencesA != null) {
                j2 = sharedPreferencesA.getLong("mt", -1L);
                string = sharedPreferencesA.getString("sa", null);
            }
            String strC = c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            File file = new File(strC);
            long jLastModified = file.lastModified();
            if (jLastModified != j2 || string == null) {
                j = jLastModified;
                a(file, true);
                a();
            } else {
                f7530a = string;
            }
        }
        f();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(f7530a) || b.equals(f7530a)) {
            return;
        }
        c = true;
    }

    public static String e() throws Throwable {
        d();
        return f7530a;
    }

    public static String f() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            String strA = a(x.b().getPackageManager().getPackageInfo(x.b().getPackageName(), 64).signatures[0].toByteArray());
            b = strA;
            return strA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() throws Throwable {
        d();
        return c;
    }

    public static void a() {
        SharedPreferences sharedPreferencesA = u0.a(x.b());
        if (sharedPreferencesA != null) {
            if (!TextUtils.isEmpty(f7530a)) {
                sharedPreferencesA.edit().putString("sa", f7530a).apply();
            }
            if (!TextUtils.isEmpty(e)) {
                sharedPreferencesA.edit().putString("md5", e).apply();
            }
            if (!TextUtils.isEmpty(d)) {
                sharedPreferencesA.edit().putString("sj", d).apply();
            }
            if (h != 0) {
                sharedPreferencesA.edit().putLong("as", h).apply();
            }
            if (i != 0) {
                sharedPreferencesA.edit().putLong(ApsMetricsDataMap.APSMETRICS_FIELD_SCREENSIZE, i).apply();
            }
            if (j != -1) {
                sharedPreferencesA.edit().putLong("mt", j).apply();
            }
            if (g != -1) {
                sharedPreferencesA.edit().putInt("cpc", g).apply();
            }
            if (TextUtils.isEmpty(f)) {
                return;
            }
            sharedPreferencesA.edit().putString(yk.SESSION_HISTORY_KEY_AD_PROVIDER, f).apply();
        }
    }

    public static long b(File file) throws Throwable {
        String str;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                int i2 = 0;
                int size = 0;
                while (true) {
                    if (i2 == 0) {
                        str = "classes.dex";
                    } else {
                        str = String.format(Locale.getDefault(), "classes%d.dex", Integer.valueOf(i2));
                    }
                    try {
                        ZipEntry entry = zipFile2.getEntry(str);
                        if (entry == null) {
                            break;
                        }
                        size = (int) (((long) size) + entry.getSize());
                        i2++;
                    } catch (ZipException unused) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (IOException unused2) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                long j2 = size / 1000;
                try {
                    zipFile2.close();
                } catch (IOException unused4) {
                }
                return j2;
            } catch (ZipException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
            return 0L;
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @DungeonFlag
    private static e a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        List<e> listA;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    o oVarA = p.a(randomAccessFile, 0L, randomAccessFile.length());
                    listA = k.a(oVarA, c.a(oVarA));
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused) {
                    }
                } catch (f.a unused2) {
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    listA = null;
                } catch (Throwable unused3) {
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    listA = null;
                }
            } catch (f.a unused4) {
                randomAccessFile = null;
            } catch (Throwable unused5) {
                randomAccessFile = null;
            }
        } catch (IOException unused6) {
            listA = null;
        }
        if (listA == null || listA.isEmpty()) {
            listA = j.a(file);
        }
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return listA.get(0);
    }

    public static String a(RandomAccessFile randomAccessFile) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = randomAccessFile.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            while (string.length() < 32) {
                string = "0".concat(String.valueOf(string));
            }
            return string;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
