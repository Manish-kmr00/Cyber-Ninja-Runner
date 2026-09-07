package io.bidmachine.rendering.model;

/* JADX INFO: loaded from: classes5.dex */
public class SideBindParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SideType f12423a;
    private final String b;

    public SideBindParams(SideType targetSideType, String targetName) {
        this.f12423a = targetSideType;
        this.b = targetName.toLowerCase();
    }

    public String getTargetName() {
        return this.b;
    }

    public SideType getTargetSideType() {
        return this.f12423a;
    }
}
