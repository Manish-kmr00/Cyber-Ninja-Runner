package com.apm.insight.runtime;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: ProcessTrack.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f299a;

    public static File a(long j) {
        return new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    public static HashMap<String, a> a(long j, String str) throws Throwable {
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, a> map = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray jSONArrayA = com.apm.insight.l.f.a(file2, length > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? length - PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 0L);
                    for (int length2 = jSONArrayA.length() - 1; length2 >= 0; length2--) {
                        String strOptString = jSONArrayA.optString(length2);
                        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(str)) {
                            map.put(str2.replace('_', AbstractJsonLexerKt.COLON).replace(".txt", ""), new a(strOptString));
                            break;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return map;
    }

    /* JADX INFO: compiled from: ProcessTrack.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f300a;
        private String b;
        private long c;

        a(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length == 3) {
                this.b = strArrSplit[0];
                this.f300a = strArrSplit[1];
                try {
                    this.c = Long.parseLong(strArrSplit[2]);
                    return;
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    k.a(new RuntimeException("err ProcessTrack line:".concat(String.valueOf(str)), th), "NPTH_CATCH");
                    return;
                }
            }
            com.apm.insight.c.a();
            k.a(new RuntimeException("err ProcessTrack line:".concat(String.valueOf(str))), "NPTH_CATCH");
        }
    }

    public static void a(String str, String str2) {
        File file;
        try {
            if (f299a == null) {
                String strD = com.apm.insight.l.a.d(com.apm.insight.e.g());
                if (strD == null) {
                    file = null;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f299a = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + '/' + strD.replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                    file = f299a;
                }
            } else {
                file = f299a;
            }
            if (file != null) {
                com.apm.insight.l.f.a(file, str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }
}
