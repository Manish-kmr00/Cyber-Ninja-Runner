package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.smaato.sdk.core.gdpr.CmpApiConstants;

/* JADX INFO: compiled from: TCStringManager.java */
/* JADX INFO: loaded from: classes10.dex */
public class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4909a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = 0;
    private boolean f = false;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private a l;
    private final SharedPreferences m;

    /* JADX INFO: compiled from: TCStringManager.java */
    public interface a {
        void a();
    }

    public e(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        a();
    }

    private void a() {
        SharedPreferences sharedPreferences = this.m;
        if (sharedPreferences != null) {
            d(sharedPreferences.getString("IABTCF_TCString", ""));
            a(this.m.getInt("IABTCF_gdprApplies", 0));
            c(this.m.getString(CmpApiConstants.IABTCF_PURPOSE_CONSENTS, ""));
            e(this.m.getString(CmpApiConstants.IABTCF_VENDOR_CONSENT, ""));
            b(this.m.getString("IABTCF_AddtlConsent", ""));
        }
    }

    public String b() {
        return this.f4909a;
    }

    public void c(String str) {
        this.g = a(str, 1);
        this.h = a(str, 2);
        this.b = str;
    }

    public void d(String str) {
        this.f4909a = str;
    }

    public void e(String str) {
        this.i = a(str, 867);
        this.c = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        byte b;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            switch (str) {
                case "IABTCF_PurposeConsents":
                    b = 2;
                    break;
                case "IABTCF_gdprApplies":
                    b = 1;
                    break;
                case "IABTCF_TCString":
                    b = 0;
                    break;
                case "IABTCF_AddtlConsent":
                    b = 4;
                    break;
                case "IABTCF_VendorConsents":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                d(sharedPreferences.getString("IABTCF_TCString", ""));
            } else if (b == 1) {
                a(sharedPreferences.getInt("IABTCF_gdprApplies", 0));
            } else if (b == 2) {
                c(sharedPreferences.getString(CmpApiConstants.IABTCF_PURPOSE_CONSENTS, ""));
            } else if (b == 3) {
                e(sharedPreferences.getString(CmpApiConstants.IABTCF_VENDOR_CONSENT, ""));
            } else if (b == 4) {
                b(sharedPreferences.getString("IABTCF_AddtlConsent", ""));
            }
            a aVar = this.l;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            o0.b("TCStringManager", th.getMessage());
        }
    }

    public void b(String str) {
        this.d = str;
        if (TextUtils.isEmpty(str)) {
            this.j = true;
            return;
        }
        if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.k = false;
            return;
        }
        this.k = true;
        try {
            String[] strArrSplit = str.split("~");
            if (strArrSplit.length > 1) {
                if (TextUtils.isEmpty(strArrSplit[1])) {
                    this.j = false;
                } else {
                    this.j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            }
        } catch (Throwable th) {
            o0.b("TCStringManager", th.getMessage());
        }
    }

    public boolean c() {
        if (this.e == 0) {
            a(true);
            return this.f;
        }
        if (a(this.b) && a(this.c)) {
            if (MBridgeConstans.VERIFY_ATP_CONSENT) {
                a((this.i || (this.k && this.j)) && this.g && this.h);
            } else {
                a(this.i && this.g && this.h);
            }
        } else {
            a(true);
        }
        return this.f;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.l = aVar;
        }
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(boolean z) {
        this.f = z;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[01]+");
    }

    private boolean a(String str, int i) {
        return a(str) && i <= str.length() && i >= 1 && '1' == str.charAt(i - 1);
    }
}
