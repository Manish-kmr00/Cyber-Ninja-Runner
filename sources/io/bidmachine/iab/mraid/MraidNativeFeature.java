package io.bidmachine.iab.mraid;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class MraidNativeFeature {
    public static final String FEATURE_CALENDAR = "calendar";
    public static final String FEATURE_INLINE_VIDEO = "inlineVideo";
    public static final String FEATURE_SMS = "sms";
    public static final String FEATURE_STORE_PICTURE = "storePicture";
    public static final String FEATURE_TEL = "tel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f12202a = {"sms", "tel", "inlineVideo", "calendar", "storePicture"};

    private MraidNativeFeature() {
    }

    private static ArrayList a(MraidNativeFeatureManager mraidNativeFeatureManager) {
        ArrayList arrayList = new ArrayList();
        if (mraidNativeFeatureManager.isTelFeatureAvailable()) {
            arrayList.add("tel");
        }
        if (mraidNativeFeatureManager.isSmsFeatureAvailable()) {
            arrayList.add("sms");
        }
        if (mraidNativeFeatureManager.isInlineVideoFeatureAvailable()) {
            arrayList.add("inlineVideo");
        }
        if (mraidNativeFeatureManager.isCalendarFeatureAvailable()) {
            arrayList.add("calendar");
        }
        if (mraidNativeFeatureManager.isStorePictureFeatureAvailable()) {
            arrayList.add("storePicture");
        }
        return arrayList;
    }

    public static String[] getSupportedFeatures(Context context) {
        return (String[]) a(new MraidNativeFeatureManager(context, f12202a)).toArray(new String[0]);
    }
}
