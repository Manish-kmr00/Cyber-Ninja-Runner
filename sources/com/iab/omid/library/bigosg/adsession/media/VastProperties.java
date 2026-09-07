package com.iab.omid.library.bigosg.adsession.media;

import com.iab.omid.library.bigosg.d.c;
import com.iab.omid.library.bigosg.d.e;
import com.json.b9;
import io.bidmachine.unified.UnifiedMediationParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2553a;
    private final Float b;
    private final boolean c;
    private final Position d;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f2553a = z;
        this.b = f;
        this.c = z2;
        this.d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        e.a(position, "Position is null");
        return new VastProperties(false, null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f, boolean z, Position position) {
        e.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f2553a);
            if (this.f2553a) {
                jSONObject.put(UnifiedMediationParams.KEY_SKIP_OFFSET, this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put(b9.h.L, this.d);
        } catch (JSONException e) {
            c.a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    public final Position getPosition() {
        return this.d;
    }

    public final Float getSkipOffset() {
        return this.b;
    }

    public final boolean isAutoPlay() {
        return this.c;
    }

    public final boolean isSkippable() {
        return this.f2553a;
    }
}
