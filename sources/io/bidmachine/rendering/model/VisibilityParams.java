package io.bidmachine.rendering.model;

/* JADX INFO: loaded from: classes12.dex */
public class VisibilityParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12425a;
    private final boolean b;
    private final boolean c;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f12426a = 0.5f;
        private boolean b = false;
        private boolean c = false;

        public VisibilityParams build() {
            return new VisibilityParams(this.f12426a, this.b, this.c);
        }

        public Builder setIgnoreOverlap(boolean ignoreOverlap) {
            this.c = ignoreOverlap;
            return this;
        }

        public Builder setIgnoreWindowFocus(boolean ignoreWindowFocus) {
            this.b = ignoreWindowFocus;
            return this;
        }

        public Builder setVisibilityPercent(float visibilityPercent) {
            this.f12426a = visibilityPercent;
            return this;
        }
    }

    public VisibilityParams(float visibilityPercent, boolean ignoreWindowFocus, boolean ignoreOverlap) {
        this.f12425a = visibilityPercent;
        this.b = ignoreWindowFocus;
        this.c = ignoreOverlap;
    }

    public float getVisibilityPercent() {
        return this.f12425a;
    }

    public boolean isIgnoreOverlap() {
        return this.c;
    }

    public boolean isIgnoreWindowFocus() {
        return this.b;
    }
}
