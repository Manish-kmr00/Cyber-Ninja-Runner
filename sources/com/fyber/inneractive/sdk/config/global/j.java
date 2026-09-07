package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.smaato.sdk.core.dns.DnsName;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1703a;
    public final boolean b;

    public j(boolean z, String str) {
        this.f1703a = str;
        this.b = z;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100  */
    /* JADX WARN: Code duplicated, block: B:50:0x0104  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.d
    public final boolean a(e eVar) {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.f1703a)) {
            return false;
        }
        String version = InneractiveAdManager.getVersion();
        IAlog.a("%s: shouldApply - running version: %s", "j", version);
        IAlog.a("%s: shouldApply - filter version: %s", "j", this.f1703a);
        String[] strArrSplit = version.split(DnsName.ESCAPED_DOT, 4);
        String[] strArrSplit2 = this.f1703a.split(DnsName.ESCAPED_DOT, 4);
        String str = strArrSplit2[strArrSplit2.length - 1];
        if (str.equals("*")) {
            int i = 0;
            while (true) {
                if (i >= strArrSplit2.length - 1) {
                    IAlog.a("%s: shouldApplyByAsterix - version aligned with filter. do not apply", "j");
                    z2 = false;
                    break;
                }
                if (strArrSplit.length < i) {
                    IAlog.a("%s: shouldApplyByAsterix - running version is shorter than filter. applying", "j");
                } else if (strArrSplit[i].equals(strArrSplit2[i])) {
                    i++;
                } else {
                    IAlog.a("%s: shouldApplyByAsterix - running version does not comply with filter. applying", "j");
                }
                z2 = true;
                break;
            }
            IAlog.a("%s: shouldApply - * version match: %b", "j", Boolean.valueOf(!z2));
            if (z2) {
                return this.b;
            }
            return !this.b;
        }
        if (!str.equals(Marker.ANY_NON_NULL_MARKER)) {
            boolean zEqualsIgnoreCase = this.f1703a.equalsIgnoreCase(version);
            IAlog.a("%s: shouldApply - exact version match: %b", "j", Boolean.valueOf(zEqualsIgnoreCase));
            if (zEqualsIgnoreCase) {
                return !this.b;
            }
            return this.b;
        }
        int i2 = 0;
        while (true) {
            if (i2 < strArrSplit2.length - 1) {
                if (strArrSplit.length < i2) {
                    IAlog.a("%s: shouldApplyByPlus - running version is shorter than filter. applying", "j");
                } else {
                    try {
                        int iIntValue = Integer.valueOf(strArrSplit2[i2]).intValue();
                        int iIntValue2 = Integer.valueOf(strArrSplit[i2]).intValue();
                        if (iIntValue2 > iIntValue) {
                            IAlog.a("%s: shouldApplyByPlus - running version is greater than the filter's version. no filter needed", "j");
                        } else if (iIntValue2 < iIntValue) {
                            IAlog.a("%s: shouldApplyByPlus - running version is lower than the filter's version. applying filter ", "j");
                        } else {
                            i2++;
                        }
                    } catch (NumberFormatException e) {
                        IAlog.a("%s: shouldApplyByPlus - Error in version string! Not a number. %s", "j", e.getMessage());
                    }
                }
                z = true;
                IAlog.a("%s: shouldApply - + version match: %b", "j", Boolean.valueOf(!z));
                if (z) {
                    return this.b;
                }
                if (this.b) {
                    return false;
                }
                return true;
            }
            IAlog.a("%s: shouldApplyByAsterix - version aligned with filter. do not apply", "j");
            z = false;
            IAlog.a("%s: shouldApply - + version match: %b", "j", Boolean.valueOf(!z));
            if (z) {
                return this.b;
            }
            if (this.b) {
                return true;
            }
            return false;
        }
    }

    public final String toString() {
        return "sdk - " + this.f1703a + " include: " + this.b;
    }
}
