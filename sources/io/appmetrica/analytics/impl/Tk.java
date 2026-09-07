package io.appmetrica.analytics.impl;

import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: loaded from: classes3.dex */
public final class Tk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ic f11367a;
    public final Hc b;

    public Tk(PublicLogger publicLogger, String str) {
        this(new Ic(str, publicLogger), new Hc(str, publicLogger));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized boolean a(Lc lc, String str, String str2) {
        int size = lc.size();
        int i = this.f11367a.c.f11100a;
        if (size < i || (i == lc.size() && lc.containsKey(str))) {
            this.b.getClass();
            int length = lc.f11242a;
            if (str2 != null) {
                length += str2.length();
            }
            if (lc.containsKey(str)) {
                String str3 = (String) lc.get(str);
                if (str3 != null) {
                    length -= str3.length();
                }
            } else {
                length += str.length();
            }
            if (length <= 4500) {
                lc.put(str, str2);
                return true;
            }
            Hc hc = this.b;
            hc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", hc.f11176a, Integer.valueOf(IronSourceConstants.NT_AUCTION_REQUEST), str);
        } else {
            Ic ic = this.f11367a;
            ic.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", ic.e, Integer.valueOf(ic.c.f11100a), str);
        }
        return false;
    }

    public final boolean b(Lc lc, String str, String str2) {
        if (lc == null) {
            return false;
        }
        String strA = this.f11367a.f11194a.a(str);
        String strA2 = this.f11367a.b.a(str2);
        if (!lc.containsKey(strA)) {
            if (strA2 != null) {
                return a(lc, strA, strA2);
            }
            return false;
        }
        String str3 = (String) lc.get(strA);
        if (strA2 == null || !strA2.equals(str3)) {
            return a(lc, strA, strA2);
        }
        return false;
    }

    public Tk(Ic ic, Hc hc) {
        this.f11367a = ic;
        this.b = hc;
    }
}
