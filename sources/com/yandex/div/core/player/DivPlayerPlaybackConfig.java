package com.yandex.div.core.player;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivPlayerPlaybackConfig.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/player/DivPlayerPlaybackConfig;", "", "autoplay", "", "isMuted", "repeatable", "payload", "Lorg/json/JSONObject;", "(ZZZLorg/json/JSONObject;)V", "getAutoplay", "()Z", "getPayload", "()Lorg/json/JSONObject;", "getRepeatable", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivPlayerPlaybackConfig {
    private final boolean autoplay;
    private final boolean isMuted;
    private final JSONObject payload;
    private final boolean repeatable;

    public DivPlayerPlaybackConfig() {
        this(false, false, false, null, 15, null);
    }

    public static /* synthetic */ DivPlayerPlaybackConfig copy$default(DivPlayerPlaybackConfig divPlayerPlaybackConfig, boolean z, boolean z2, boolean z3, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            z = divPlayerPlaybackConfig.autoplay;
        }
        if ((i & 2) != 0) {
            z2 = divPlayerPlaybackConfig.isMuted;
        }
        if ((i & 4) != 0) {
            z3 = divPlayerPlaybackConfig.repeatable;
        }
        if ((i & 8) != 0) {
            jSONObject = divPlayerPlaybackConfig.payload;
        }
        return divPlayerPlaybackConfig.copy(z, z2, z3, jSONObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAutoplay() {
        return this.autoplay;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRepeatable() {
        return this.repeatable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final JSONObject getPayload() {
        return this.payload;
    }

    public final DivPlayerPlaybackConfig copy(boolean autoplay, boolean isMuted, boolean repeatable, JSONObject payload) {
        return new DivPlayerPlaybackConfig(autoplay, isMuted, repeatable, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivPlayerPlaybackConfig)) {
            return false;
        }
        DivPlayerPlaybackConfig divPlayerPlaybackConfig = (DivPlayerPlaybackConfig) other;
        return this.autoplay == divPlayerPlaybackConfig.autoplay && this.isMuted == divPlayerPlaybackConfig.isMuted && this.repeatable == divPlayerPlaybackConfig.repeatable && Intrinsics.areEqual(this.payload, divPlayerPlaybackConfig.payload);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z = this.autoplay;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.isMuted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.repeatable;
        int i3 = (i2 + (z3 ? 1 : z3)) * 31;
        JSONObject jSONObject = this.payload;
        return i3 + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "DivPlayerPlaybackConfig(autoplay=" + this.autoplay + ", isMuted=" + this.isMuted + ", repeatable=" + this.repeatable + ", payload=" + this.payload + ')';
    }

    public DivPlayerPlaybackConfig(boolean z, boolean z2, boolean z3, JSONObject jSONObject) {
        this.autoplay = z;
        this.isMuted = z2;
        this.repeatable = z3;
        this.payload = jSONObject;
    }

    public /* synthetic */ DivPlayerPlaybackConfig(boolean z, boolean z2, boolean z3, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? null : jSONObject);
    }

    public final boolean getAutoplay() {
        return this.autoplay;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean getRepeatable() {
        return this.repeatable;
    }

    public final JSONObject getPayload() {
        return this.payload;
    }
}
