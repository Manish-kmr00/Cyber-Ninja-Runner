package com.fyber.inneractive.sdk.config;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.smaato.sdk.core.gdpr.CmpApiConstants;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3077g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f1694a = null;
    public Boolean b = null;
    public Boolean c = null;
    public String d = null;
    public String e = null;
    public InneractiveAdManager.GdprConsentSource f = null;
    public String g = null;
    public String h = null;
    public Boolean i = null;
    public Boolean j = null;
    public SharedPreferences k;
    public SharedPreferences l;

    public final boolean a(boolean z, String str) {
        if (AbstractC3251o.f2370a == null) {
            return false;
        }
        f();
        SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences == null) {
            return false;
        }
        sharedPreferences.edit().putBoolean(str, z).apply();
        return true;
    }

    public final void b() {
        IAlog.a("Clearing LGPD consent status", new Object[0]);
        if (AbstractC3251o.f2370a == null) {
            IAlog.f("clearLgpdConsentStatus was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            return;
        }
        f();
        this.i = null;
        SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("IALgpdConsentStatus").apply();
        }
    }

    public final void c() {
        IAlog.a("Clearing CCPA Consent String", new Object[0]);
        if (AbstractC3251o.f2370a == null) {
            IAlog.f("clearUSPrivacyString was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            return;
        }
        f();
        this.h = null;
        SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("IACCPAConsentData").apply();
        }
    }

    public final Boolean d() {
        if (this.f1694a == null) {
            this.b = g();
        }
        if (AbstractC3251o.f2370a == null) {
            return null;
        }
        Boolean bool = this.f1694a;
        return bool == null ? this.b : bool;
    }

    public final boolean e() {
        C3085o c3085o;
        SharedPreferences sharedPreferences;
        if (this.c == null) {
            C3088s c3088s = IAConfigManager.O.u;
            boolean z = false;
            if (c3088s != null && (c3085o = c3088s.b) != null && c3085o.a("TcfPurpose1", 1, Integer.MIN_VALUE) == 1 && (sharedPreferences = this.l) != null) {
                try {
                    String string = sharedPreferences.getString(CmpApiConstants.IABTCF_PURPOSE_CONSENTS, null);
                    if (string != null && !string.isEmpty() && string.charAt(0) == '0') {
                        z = true;
                    }
                } catch (Exception unused) {
                    IAlog.b("%sException caught when trying to resolveIsIabGdprPurpose1Disabled from prefs", IAlog.a(this));
                }
            }
            this.c = Boolean.valueOf(z);
        }
        return this.c.booleanValue();
    }

    public final void f() {
        Application application = AbstractC3251o.f2370a;
        if (application != null) {
            if (this.l == null) {
                this.l = application.getSharedPreferences(application.getPackageName() + "_preferences", 0);
            }
            if (this.k == null) {
                SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigurationPreferences", 0);
                this.k = sharedPreferences;
                if (sharedPreferences != null) {
                    if (sharedPreferences.contains("IAGDPRBool")) {
                        this.f1694a = Boolean.valueOf(sharedPreferences.getBoolean("IAGDPRBool", false));
                    } else {
                        this.b = g();
                    }
                    if (sharedPreferences.contains("IAGdprConsentData")) {
                        this.d = sharedPreferences.getString("IAGdprConsentData", null);
                    } else {
                        this.e = h();
                    }
                    if (sharedPreferences.contains("IACCPAConsentData")) {
                        this.h = sharedPreferences.getString("IACCPAConsentData", null);
                    }
                    if (sharedPreferences.contains("IAGdprSource")) {
                        try {
                            this.f = InneractiveAdManager.GdprConsentSource.valueOf(sharedPreferences.getString("IAGdprSource", InneractiveAdManager.GdprConsentSource.Internal.toString()));
                        } catch (Exception unused) {
                            this.f = InneractiveAdManager.GdprConsentSource.Internal;
                        }
                    }
                    if (sharedPreferences.contains("IALgpdConsentStatus")) {
                        this.i = Boolean.valueOf(sharedPreferences.getBoolean("IALgpdConsentStatus", false));
                    }
                    if (sharedPreferences.contains("keyUserID")) {
                        this.g = sharedPreferences.getString("keyUserID", null);
                    }
                }
            }
        }
    }

    public final Boolean g() {
        C3085o c3085o;
        SharedPreferences sharedPreferences;
        C3088s c3088s = IAConfigManager.O.u;
        if (c3088s != null && (c3085o = c3088s.b) != null) {
            int iA = c3085o.a("TcfVendorId", 262, Integer.MIN_VALUE);
            if (iA != 0 && (sharedPreferences = this.l) != null) {
                try {
                    String string = sharedPreferences.getString(CmpApiConstants.IABTCF_VENDOR_CONSENT, null);
                    if (string == null) {
                        return null;
                    }
                    int i = (iA >= 0 ? iA : 262) - 1;
                    return Boolean.valueOf(string.length() > i && string.charAt(i) == '1');
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public final String h() {
        SharedPreferences sharedPreferences;
        if (IAConfigManager.O.u.b.a("TcfVendorId", 262, Integer.MIN_VALUE) != 0 && (sharedPreferences = this.l) != null && sharedPreferences.contains("IABTCF_TCString")) {
            try {
                return this.l.getString("IABTCF_TCString", null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean a(String str, String str2) {
        if (AbstractC3251o.f2370a == null) {
            return false;
        }
        f();
        if (this.k == null) {
            return false;
        }
        IAlog.a("Saving %s value = %s to sharedPrefs", str, str2);
        this.k.edit().putString(str, str2).apply();
        return true;
    }

    public final void a(String str) {
        if (AbstractC3251o.f2370a != null) {
            f();
            if (TextUtils.isEmpty(str)) {
                this.g = str;
                SharedPreferences sharedPreferences = this.k;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().remove("keyUserID").apply();
                    return;
                }
                return;
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            SharedPreferences sharedPreferences2 = this.k;
            if (sharedPreferences2 != null) {
                this.g = str;
                sharedPreferences2.edit().putString("keyUserID", str).apply();
            }
        }
    }

    public final void a() {
        IAlog.a("Clearing GDPR Consent String and status", new Object[0]);
        if (AbstractC3251o.f2370a == null) {
            IAlog.f("ClearGdprConsent was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            return;
        }
        f();
        this.f1694a = null;
        this.d = null;
        SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("IAGdprConsentData").remove("IAGDPRBool").remove("IAGdprSource").apply();
        }
    }
}
