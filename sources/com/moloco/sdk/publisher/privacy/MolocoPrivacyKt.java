package com.moloco.sdk.publisher.privacy;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.moloco.sdk.internal.android_context.b;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0002\u001a\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, d2 = {"gdprApplies", "", "()Ljava/lang/Boolean;", "getTCFConsent", "", "getUSPrivacyConsentString", "defaultUSPrivacy", "moloco-sdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MolocoPrivacyKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean gdprApplies() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(b.a(null, 1, null));
        if (!defaultSharedPreferences.contains("IABTCF_gdprApplies")) {
            return null;
        }
        try {
            int i = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            if (i == 0) {
                return Boolean.FALSE;
            }
            if (i != 1) {
                return null;
            }
            return Boolean.TRUE;
        } catch (ClassCastException unused) {
            return Boolean.valueOf(defaultSharedPreferences.getBoolean("IABTCF_gdprApplies", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getTCFConsent() {
        String string = PreferenceManager.getDefaultSharedPreferences(b.a(null, 1, null)).getString("IABTCF_TCString", null);
        if (string == null || StringsKt.isBlank(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getUSPrivacyConsentString(String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(b.a(null, 1, null)).getString("IABUSPrivacy_String", null);
        return (string == null || StringsKt.isBlank(string)) ? str : string;
    }
}
