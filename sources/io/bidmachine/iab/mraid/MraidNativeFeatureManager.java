package io.bidmachine.iab.mraid;

import android.content.Context;
import io.bidmachine.iab.utils.SystemFeatureAvailability;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class MraidNativeFeatureManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12203a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    public MraidNativeFeatureManager(Context context, List<String> nativeFeatures) {
        SystemFeatureAvailability systemFeatureAvailability = new SystemFeatureAvailability(context);
        this.f12203a = a("sms", nativeFeatures) && systemFeatureAvailability.hasTelephony();
        this.b = a("tel", nativeFeatures) && systemFeatureAvailability.hasTelephony();
        this.c = a("inlineVideo", nativeFeatures);
        this.d = a("calendar", nativeFeatures);
        this.e = a("storePicture", nativeFeatures);
    }

    private boolean a(String str, List list) {
        return list != null && list.contains(str);
    }

    public boolean isCalendarFeatureAvailable() {
        return this.d;
    }

    public boolean isInlineVideoFeatureAvailable() {
        return this.c;
    }

    public boolean isSmsFeatureAvailable() {
        return this.f12203a;
    }

    public boolean isStorePictureFeatureAvailable() {
        return this.e;
    }

    public boolean isTelFeatureAvailable() {
        return this.b;
    }

    public MraidNativeFeatureManager(Context context, String[] nativeFeatures) {
        this(context, (List<String>) (nativeFeatures != null ? Arrays.asList(nativeFeatures) : null));
    }
}
