package com.bytedance.adsdk.Og;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bytedance.adsdk.Og.ML.WQf;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.smaato.sdk.core.dns.DnsName;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes6.dex */
public class omh {
    private static final Map<String, Wx<SD>> pA = new HashMap();
    private static final Set<Object> Og = new HashSet();
    private static final byte[] KZx = {80, 75, 3, 4};

    public static Wx<SD> pA(Context context, String str) {
        return pA(context, str, "url_".concat(String.valueOf(str)));
    }

    public static Wx<SD> pA(final Context context, final String str, final String str2) {
        return pA(str2, new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.omh.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public WV<SD> call() throws Exception {
                WV<SD> wvPA = ML.pA(context).pA(context, str, str2);
                if (str2 != null && wvPA.pA() != null) {
                    com.bytedance.adsdk.Og.KZx.ML.pA().pA(str2, wvPA.pA());
                }
                return wvPA;
            }
        });
    }

    public static Wx<SD> Og(Context context, String str) {
        return Og(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static Wx<SD> Og(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return pA(str2, new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.omh.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public WV<SD> call() throws Exception {
                return omh.KZx(applicationContext, str, str2);
            }
        });
    }

    public static WV<SD> KZx(Context context, String str) {
        return KZx(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static WV<SD> KZx(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return Og(context.getAssets().open(str), str2);
            }
            return pA(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new WV<>((Throwable) e);
        }
    }

    public static Wx<SD> pA(Context context, int i) {
        return pA(context, i, KZx(context, i));
    }

    public static Wx<SD> pA(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return pA(str, new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.omh.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public WV<SD> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return omh.Og(context2, i, str);
            }
        });
    }

    public static WV<SD> Og(Context context, int i) {
        return Og(context, i, KZx(context, i));
    }

    public static WV<SD> Og(Context context, int i, String str) {
        try {
            return Og(context.getResources().openRawResource(i), KZx(context, i));
        } catch (Resources.NotFoundException e) {
            return new WV<>((Throwable) e);
        }
    }

    private static String KZx(Context context, int i) {
        return "rawRes" + (pA(context) ? "_night_" : "_day_") + i;
    }

    private static boolean pA(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Wx<SD> pA(final InputStream inputStream, final String str) {
        return pA(str, new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.omh.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public WV<SD> call() throws Exception {
                return omh.Og(inputStream, str);
            }
        });
    }

    public static WV<SD> Og(InputStream inputStream, String str) {
        return pA(inputStream, str, true);
    }

    private static WV<SD> pA(InputStream inputStream, String str, boolean z) {
        try {
            return pA(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.Og.JG.JG.pA(inputStream);
            }
        }
    }

    public static WV<SD> pA(JsonReader jsonReader, String str) {
        return pA(jsonReader, str, true);
    }

    private static WV<SD> pA(JsonReader jsonReader, String str, boolean z) {
        try {
            SD sdPA = WQf.pA(jsonReader);
            com.bytedance.adsdk.Og.KZx.ML.pA().pA(str, sdPA);
            return new WV<>(sdPA);
        } catch (Exception e) {
            return new WV<>((Throwable) e);
        } finally {
            if (z) {
                pA(jsonReader);
            }
        }
    }

    public static void pA(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static WV<SD> pA(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return Og(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.Og.JG.JG.pA(zipInputStream);
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0107 A[Catch: IOException -> 0x0287, TryCatch #0 {IOException -> 0x0287, blocks: (B:3:0x000a, B:6:0x0014, B:8:0x0020, B:61:0x0137, B:9:0x0025, B:11:0x0031, B:12:0x0036, B:14:0x0042, B:15:0x0059, B:18:0x0065, B:20:0x006d, B:22:0x0075, B:25:0x007f, B:27:0x0087, B:30:0x0090, B:31:0x0095, B:33:0x009b, B:34:0x00a4, B:53:0x00fd, B:55:0x0107, B:56:0x0115, B:52:0x00e9, B:57:0x0119, B:59:0x011f, B:60:0x0128, B:35:0x00c2, B:42:0x00d9, B:51:0x00e8, B:50:0x00e5), top: B:113:0x000a, inners: #3 }] */
    private static WV<SD> Og(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            SD sdPA = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    sdPA = pA(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).pA();
                } else if (name.endsWith(".png") || name.endsWith(".webp") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                        map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                } else if (name.endsWith(".ttf") || name.endsWith(".otf")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit2 = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                        String str2 = strArrSplit2[strArrSplit2.length - 1];
                        String str3 = str2.split(DnsName.ESCAPED_DOT)[0];
                        File file = new File(context.getCacheDir(), str2);
                        new FileOutputStream(file);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable unused) {
                            new StringBuilder("Unable to save font ").append(str3).append(" to the temporary file: ").append(str2);
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                new StringBuilder("Failed to delete temp font file ").append(file.getAbsolutePath());
                            }
                            map2.put(str3, typefaceCreateFromFile);
                            nextEntry = zipInputStream.getNextEntry();
                        }
                        Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            new StringBuilder("Failed to delete temp font file ").append(file.getAbsolutePath());
                        }
                        map2.put(str3, typefaceCreateFromFile2);
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (sdPA == null) {
                return new WV<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                SGo sGoPA = pA(sdPA, (String) entry.getKey());
                if (sGoPA != null) {
                    sGoPA.pA(com.bytedance.adsdk.Og.JG.JG.pA((Bitmap) entry.getValue(), sGoPA.pA(), sGoPA.Og()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.Og.KZx.KZx kZx : sdPA.DX().values()) {
                    if (kZx.pA().equals(entry2.getKey())) {
                        kZx.pA((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, SGo>> it = sdPA.oX().entrySet().iterator();
                while (it.hasNext()) {
                    SGo value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strBzk = value.Bzk();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strBzk.startsWith("data:") && strBzk.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strBzk.substring(strBzk.indexOf(44) + 1), 0);
                            value.pA(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException unused2) {
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, SGo> entry3 : sdPA.oX().entrySet()) {
                if (entry3.getValue().BSW() == null) {
                    return new WV<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().Bzk()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.Og.KZx.ML.pA().pA(str, sdPA);
            }
            return new WV<>(sdPA);
        } catch (IOException e) {
            return new WV<>((Throwable) e);
        }
    }

    private static SGo pA(SD sd, String str) {
        for (SGo sGo : sd.oX().values()) {
            if (sGo.Bzk().equals(str)) {
                return sGo;
            }
        }
        return null;
    }

    private static Wx<SD> pA(final String str, Callable<WV<SD>> callable) {
        final SD sdPA = str == null ? null : com.bytedance.adsdk.Og.KZx.ML.pA().pA(str);
        if (sdPA != null) {
            return new Wx<>(new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.omh.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                public WV<SD> call() throws Exception {
                    return new WV<>(sdPA);
                }
            });
        }
        if (str != null) {
            Map<String, Wx<SD>> map = pA;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        Wx<SD> wx = new Wx<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            wx.pA(new BSW<SD>() { // from class: com.bytedance.adsdk.Og.omh.2
                @Override // com.bytedance.adsdk.Og.BSW
                public void pA(SD sd) {
                    omh.pA.remove(str);
                    atomicBoolean.set(true);
                    if (omh.pA.size() == 0) {
                        omh.Og(true);
                    }
                }
            });
            wx.KZx(new BSW<Throwable>() { // from class: com.bytedance.adsdk.Og.omh.3
                @Override // com.bytedance.adsdk.Og.BSW
                public void pA(Throwable th) {
                    omh.pA.remove(str);
                    atomicBoolean.set(true);
                    if (omh.pA.size() == 0) {
                        omh.Og(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, Wx<SD>> map2 = pA;
                map2.put(str, wx);
                if (map2.size() == 1) {
                    Og(false);
                }
            }
        }
        return wx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(boolean z) {
        ArrayList arrayList = new ArrayList(Og);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
