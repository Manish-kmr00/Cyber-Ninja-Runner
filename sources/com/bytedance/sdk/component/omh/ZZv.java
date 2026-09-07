package com.bytedance.sdk.component.omh;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.WV;
import com.json.b9;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes10.dex */
public class ZZv {
    private static AtomicInteger KZx = new AtomicInteger(0);
    public static final String[] pA = {h.u, "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] Og = {"tt_pangle", "bd_tracker"};
    private static int ZZv = 0;
    private static int ML = 0;

    public static void pA() {
        try {
            Og();
        } catch (Throwable unused) {
        }
    }

    private static void Og() {
        int i;
        KZx kZxBzk = JG.Bzk();
        if (kZxBzk == null) {
            return;
        }
        int i2 = 1;
        int iAddAndGet = KZx.addAndGet(1);
        if (JG.KZx < 0 || iAddAndGet % JG.KZx != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap map = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean zPA = WV.pA();
        int size = allStackTraces.size();
        if (size > ML) {
            ML = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i4 += i2;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb = new StringBuilder("\n");
            if (zPA) {
                sb.append("Thread Name is : " + key.getName());
                sb.append("\n");
            }
            int length = value.length;
            String str = null;
            int i5 = 0;
            while (i5 < length) {
                String string = value[i5].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (zPA) {
                    sb.append(string + "\n");
                }
                if (TextUtils.isEmpty(str) && (pA(string, pA) || pA(key.getName(), Og))) {
                    i3++;
                    str = string;
                }
                i5++;
                it = it2;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            if (zPA) {
                if (TextUtils.isEmpty(str)) {
                    i = 1;
                } else {
                    String str2 = str + b9.i.c + key.getName();
                    pA pAVar = (pA) map.get(str2);
                    if (pAVar != null) {
                        i = 1;
                        pAVar.pA(pAVar.pA() + 1);
                    } else {
                        i = 1;
                        pAVar = new pA(str2, 1, sb.toString(), key.getName());
                    }
                    map.put(str2, pAVar);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i4 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb.toString());
                }
            } else {
                i = 1;
            }
            i2 = i;
            it = it3;
        }
        if (i3 > ZZv) {
            ZZv = i3;
        }
        if (zPA) {
            Log.e("PoolTaskStatistics", "SDK current threads=" + i3 + ", SDK Max threads=" + ZZv + ", Application threads = " + size + ", Application max threads = " + ML);
            Iterator it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                Log.i("PoolTaskStatistics", ((pA) ((Map.Entry) it4.next()).getValue()).toString());
            }
        }
        kZxBzk.pA(new com.bytedance.sdk.component.omh.Og.pA(i3, ZZv, size, ML));
    }

    private static boolean pA(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class pA {
        public String KZx;
        public String Og;
        public String ZZv;
        public int pA;

        public pA(String str, int i, String str2, String str3) {
            this.KZx = str;
            this.pA = i;
            this.ZZv = str2;
            this.Og = str3;
        }

        public void pA(int i) {
            this.pA = i;
        }

        public int pA() {
            return this.pA;
        }

        public String toString() {
            return "ThreadModel{times=" + this.pA + ", name='" + this.Og + "', lastStackStack='" + this.KZx + "'}";
        }
    }
}
