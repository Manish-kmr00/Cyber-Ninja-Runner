package io.bidmachine.iab.mraid;

/* JADX INFO: loaded from: classes13.dex */
public final class MraidNativeFeatureSchemeValidator {
    public static final String SCHEME_CALENDAR = "calendar";
    public static final String SCHEME_SMS = "sms";
    public static final String SCHEME_STORE_PICTURE = "storePicture";
    public static final String SCHEME_TEL = "tel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MraidNativeFeatureManager f12204a;

    MraidNativeFeatureSchemeValidator(MraidNativeFeatureManager mraidNativeFeatureManager) {
        this.f12204a = mraidNativeFeatureManager;
    }

    boolean a(String str) {
        if (str == null) {
            return true;
        }
        if (str.startsWith("sms")) {
            return this.f12204a.isSmsFeatureAvailable();
        }
        if (str.startsWith("tel")) {
            return this.f12204a.isTelFeatureAvailable();
        }
        if (str.startsWith("calendar")) {
            return this.f12204a.isCalendarFeatureAvailable();
        }
        if (str.startsWith("storePicture")) {
            return this.f12204a.isStorePictureFeatureAvailable();
        }
        return true;
    }
}
