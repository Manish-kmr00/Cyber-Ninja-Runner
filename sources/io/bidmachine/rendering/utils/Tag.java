package io.bidmachine.rendering.utils;

/* JADX INFO: loaded from: classes12.dex */
public class Tag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12435a;
    private String b;

    public Tag(String name) {
        this.f12435a = name;
    }

    public String toString() {
        if (this.b == null) {
            this.b = this.f12435a + " @" + Integer.toHexString(hashCode());
        }
        return this.b;
    }
}
