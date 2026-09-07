package sg.bigo.ads.core.d.b;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f13547a = new ConcurrentHashMap();
    public final String b;

    public d(String str) {
        this.b = str;
    }

    public final void a(String str, int i) {
        this.f13547a.put(str, String.valueOf(i));
    }

    public final void a(String str, long j) {
        this.f13547a.put(str, String.valueOf(j));
    }

    public final void a(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return;
        }
        this.f13547a.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.f13547a.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("eventId = ");
        sb.append(this.b).append(":");
        for (Map.Entry<String, String> entry : this.f13547a.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(StringUtils.COMMA);
        }
        return sb.toString();
    }
}
