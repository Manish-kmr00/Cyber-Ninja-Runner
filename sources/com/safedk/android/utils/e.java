package com.safedk.android.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.io.File;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8158a = "MemoryUtils";
    private static final int b = 5000;
    private static final double c = 1.5d;
    private static final double d = 2.0d;
    private static final long e = 1024;
    private static final long f = 1048576;
    private static final long g = 1073741824;
    private static final long h = 1099511627776L;
    private static final long i = 1125899906842624L;
    private static final long j = 1152921504606846976L;
    private static ActivityManager.MemoryInfo k = null;
    private static long l = 0;
    private static final Object m = new Object();

    public static long a(Context context) {
        return Runtime.getRuntime().freeMemory();
    }

    private static void c(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - l > 5000 && SafeDK.getInstance() != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            k = memoryInfo;
            l = jElapsedRealtime;
            if (memoryInfo.lowMemory) {
                Logger.d(f8158a, "_MEMORY_LOAD_ critical RAM memory level reached: " + c());
                return;
            }
            if (memoryInfo.availMem < c * memoryInfo.threshold) {
                Logger.d(f8158a, "_MEMORY_LOAD_ low RAM memory level reached: " + c());
            } else if (memoryInfo.availMem < memoryInfo.threshold * d) {
                Logger.d(f8158a, "_MEMORY_LOAD_ medium RAM memory level reached: " + c());
            } else {
                Logger.d(f8158a, "_MEMORY_LOAD_ update memory info: " + c());
            }
        }
    }

    public static boolean b(Context context) {
        c(context);
        return k != null && k.lowMemory;
    }

    public static boolean a(com.safedk.android.analytics.brandsafety.c cVar) {
        if (b(SafeDK.getInstance().m())) {
            cVar.b(com.safedk.android.analytics.brandsafety.l.H, new com.safedk.android.analytics.brandsafety.l.a("lvl", com.safedk.android.analytics.brandsafety.l.ab));
            return true;
        }
        if (a()) {
            cVar.b(com.safedk.android.analytics.brandsafety.l.H, new com.safedk.android.analytics.brandsafety.l.a("lvl", "low"));
        } else if (b()) {
            cVar.b(com.safedk.android.analytics.brandsafety.l.H, new com.safedk.android.analytics.brandsafety.l.a("lvl", com.safedk.android.analytics.brandsafety.l.Z));
        }
        return false;
    }

    public static boolean a() {
        c(SafeDK.getInstance().m());
        return k != null && ((double) k.availMem) < c * ((double) k.threshold);
    }

    public static boolean b() {
        c(SafeDK.getInstance().m());
        return k != null && ((double) k.availMem) < d * ((double) k.threshold);
    }

    public static String c() {
        return k != null ? "{ available=" + a(k.availMem) + ", total=" + a(k.totalMem) + ", threshold=" + a(k.threshold) + " }" : "{ }";
    }

    public static String d() {
        try {
            return a(a(Environment.getDataDirectory()));
        } catch (Throwable th) {
            Logger.e(f8158a, "error in getHumanReadableFreeInternalMemory()");
            return "";
        }
    }

    public static long e() {
        return a(Environment.getDataDirectory());
    }

    private static long a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            } else {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
            return blockSize;
        } catch (Throwable th) {
            Logger.e(f8158a, "error in getAvailableMemoryInPath");
            return 0L;
        }
    }

    public static String a(long j2) {
        if (j2 < 1024) {
            return a(j2) + " byte";
        }
        if (j2 >= 1024 && j2 < 1048576) {
            return a(j2 / 1024.0d) + " Kb";
        }
        if (j2 >= 1048576 && j2 < g) {
            return a(j2 / 1048576.0d) + " Mb";
        }
        if (j2 >= g && j2 < h) {
            return a(j2 / 1.073741824E9d) + " Gb";
        }
        if (j2 >= h && j2 < i) {
            return a(j2 / 1.099511627776E12d) + " Tb";
        }
        if (j2 < i || j2 >= 1152921504606846976L) {
            return j2 >= 1152921504606846976L ? a(j2 / 1.152921504606847E18d) + " Eb" : "???";
        }
        return a(j2 / 1.125899906842624E15d) + " Pb";
    }

    private static String a(double d2) {
        return new DecimalFormat("#.##").format(d2);
    }

    public static long f() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    public static void a(String str) {
        String strA = a(str.getBytes().length);
        String strA2 = a(f());
        Logger.d(f8158a, "loaded from prefs: " + strA);
        Logger.d(f8158a, "available heap size: " + strA2);
        if (b(SafeDK.getInstance().m())) {
            Logger.e(f8158a, "android low memory!");
        }
    }

    public static void b(String str) {
        String strA = a(str.getBytes().length);
        String strA2 = a(f());
        Logger.d(f8158a, "saved in prefs: " + strA);
        boolean zB = b(SafeDK.getInstance().m());
        Logger.d(f8158a, "available heap size: " + strA2);
        if (zB) {
            Logger.e(f8158a, "android low memory!");
        }
    }

    public static void a(Map<?, ?> map, String str) {
        Long lB = b(map, str);
        if (map != null && lB != null && map.size() > lB.longValue()) {
            String string = UUID.randomUUID().toString();
            try {
                Map<BrandSafetyUtils.AdType, Integer> mapA = a(map, str, lB.longValue(), string);
                for (BrandSafetyUtils.AdType adType : mapA.keySet()) {
                    Integer num = mapA.get(adType);
                    if (num != null && num.intValue() > lB.longValue()) {
                        a(adType, map, str, lB.longValue(), string);
                    }
                }
            } catch (Throwable th) {
                Logger.d(f8158a, "Exception in clear CIs from memory " + string + " for " + str, th);
            }
        }
    }

    private static Long b(Map<?, ?> map, String str) {
        CreativeInfo creativeInfoA;
        long jV = SafeDK.getInstance().V();
        if (map != null && !map.isEmpty() && map.values().iterator().hasNext() && (creativeInfoA = a(map.values().iterator().next())) != null) {
            String strS = creativeInfoA.S();
            if (!CreativeInfoManager.a(strS, AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_EXPIRATION, true)) {
                Logger.d(f8158a, "clear CIs from memory, don't clean on CI expiration, sdk: " + strS);
                return null;
            }
            jV = CreativeInfoManager.a(strS, AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_THRESHOLD, jV);
            Logger.d(f8158a, "clear CIs from memory for " + str + ", map size:" + map.size() + ", sdk: " + strS + ", threshold: " + jV);
        }
        return Long.valueOf(jV);
    }

    private static Map<BrandSafetyUtils.AdType, Integer> a(Map<?, ?> map, String str, long j2, String str2) {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (map) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                CreativeInfo creativeInfoA = a(entry.getValue());
                if (creativeInfoA != null) {
                    BrandSafetyUtils.AdType adTypeM = creativeInfoA.M();
                    Integer num = (Integer) map2.get(adTypeM);
                    if (num == null) {
                        num = 0;
                    }
                    map2.put(adTypeM, Integer.valueOf(num.intValue() + 1));
                    if (creativeInfoA.ab() != null && creativeInfoA.ab().before(new Timestamp(jCurrentTimeMillis))) {
                        List arrayList = (List) map3.get(adTypeM);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map3.put(adTypeM, arrayList);
                        }
                        arrayList.add(entry.getKey());
                    }
                }
            }
        }
        Logger.d(f8158a, "clear CIs from memory (expired) " + str2 + ", total CI counts: " + map2);
        a(map, str2, str);
        for (BrandSafetyUtils.AdType adType : map3.keySet()) {
            Integer numValueOf = (Integer) map2.get(adType);
            if (numValueOf != null && numValueOf.intValue() > j2) {
                Logger.d(f8158a, "clear CIs from memory (expired) " + str2 + " for " + str + ", type:" + adType + ", total count: " + numValueOf);
                long jIntValue = ((long) numValueOf.intValue()) - j2;
                List list = (List) map3.get(adType);
                if (list != null) {
                    for (int i2 = 0; i2 < jIntValue && i2 < list.size(); i2++) {
                        Object obj = list.get(i2);
                        synchronized (map) {
                            if (map.remove(obj) != null) {
                                numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                                map2.put(adType, numValueOf);
                                Logger.d(f8158a, "clear CIs from memory (expired) " + str2 + ", removing item with key: " + obj + ", remaining items: " + numValueOf);
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        b(map, str2, str);
        return map2;
    }

    private static void a(BrandSafetyUtils.AdType adType, Map<?, ?> map, String str, long j2, String str2) {
        a(map, str2, str);
        Map<Long, List<Object>> mapA = a(map, adType, str2);
        int iC = c(mapA, str2);
        if (iC > j2) {
            long j3 = ((long) iC) - j2;
            if (j3 > 0) {
                ArrayList arrayList = new ArrayList(mapA.keySet());
                Collections.sort(arrayList);
                Logger.d(f8158a, "clear CIs from memory (oldest) " + str2 + " for " + str + ", type:" + adType + ", total count: " + iC);
                Iterator it = arrayList.iterator();
                while (true) {
                    long j4 = j3;
                    if (!it.hasNext()) {
                        break;
                    }
                    List<Object> list = mapA.get((Long) it.next());
                    if (list != null) {
                        for (Object obj : list) {
                            if (map.containsKey(obj)) {
                                synchronized (map) {
                                    map.remove(obj);
                                }
                                iC--;
                                Logger.d(f8158a, "clear CIs from memory (oldest) " + str2 + ", removing item with key: " + obj + ", remaining items: " + iC);
                                j4--;
                                if (j4 <= 0) {
                                    b(map, str2, str);
                                    return;
                                }
                            }
                        }
                    }
                    j3 = j4;
                }
            }
        }
        b(map, str2, str);
    }

    private static CreativeInfo a(Object obj) {
        if (obj instanceof CreativeInfo) {
            return (CreativeInfo) obj;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && (list.get(0) instanceof CreativeInfo)) {
                return (CreativeInfo) list.get(0);
            }
        }
        return null;
    }

    private static int c(Map<Long, List<Object>> map, String str) {
        int i2;
        int size = 0;
        if (map == null) {
            i2 = 0;
        } else {
            Iterator<List<Object>> it = map.values().iterator();
            while (true) {
                i2 = size;
                if (!it.hasNext()) {
                    break;
                }
                size = it.next().size() + i2;
            }
        }
        if (i2 > 0) {
            Logger.d(f8158a, "clear CIs from memory (oldest) " + str + ", total values in TS map: " + i2);
        }
        return i2;
    }

    private static Map<Long, List<Object>> a(Map<?, ?> map, BrandSafetyUtils.AdType adType, String str) {
        HashMap map2 = new HashMap();
        synchronized (map) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                CreativeInfo creativeInfoA = a(entry.getValue());
                if (creativeInfoA != null && ((creativeInfoA.M() == null && adType == null) || (creativeInfoA.M() != null && creativeInfoA.M().equals(adType)))) {
                    List arrayList = (List) map2.get(Long.valueOf(creativeInfoA.ae()));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map2.put(Long.valueOf(creativeInfoA.ae()), arrayList);
                    }
                    arrayList.add(entry.getKey());
                }
            }
        }
        if (!map2.isEmpty()) {
            Logger.d(f8158a, "clear CIs from memory (oldest) " + str + ", total keys in TS map: " + map2.size() + ", adType: " + (adType != null ? adType.name() : "null"));
        }
        return map2;
    }

    private static void a(Map<?, ?> map, String str, String str2) {
        if (map instanceof PersistentConcurrentHashMap) {
            ((PersistentConcurrentHashMap) map).a(false);
        }
    }

    private static void b(Map<?, ?> map, String str, String str2) {
        if (map instanceof PersistentConcurrentHashMap) {
            ((PersistentConcurrentHashMap) map).a(true);
        }
    }

    private static String a(Timestamp timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(timestamp.getTime()));
    }

    public static String b(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Object) new Date(j2));
    }
}
