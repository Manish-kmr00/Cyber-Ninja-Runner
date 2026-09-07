package net.pubnative.lite.sdk.utils.svgparser;

import net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase;

/* JADX INFO: loaded from: classes11.dex */
public class RenderOptions extends RenderOptionsBase {
    public static RenderOptions create() {
        return new RenderOptions();
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions css(String str) {
        return (RenderOptions) super.css(str);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions css(CSS css) {
        return (RenderOptions) super.css(css);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public boolean hasCss() {
        return super.hasCss();
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions preserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        return (RenderOptions) super.preserveAspectRatio(preserveAspectRatio);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public boolean hasPreserveAspectRatio() {
        return super.hasPreserveAspectRatio();
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions view(String str) {
        return (RenderOptions) super.view(str);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public boolean hasView() {
        return super.hasView();
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions viewBox(float f, float f2, float f3, float f4) {
        return (RenderOptions) super.viewBox(f, f2, f3, f4);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public boolean hasViewBox() {
        return super.hasViewBox();
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions viewPort(float f, float f2, float f3, float f4) {
        return (RenderOptions) super.viewPort(f, f2, f3, f4);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public boolean hasViewPort() {
        return super.hasViewPort();
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public RenderOptions target(String str) {
        return (RenderOptions) super.target(str);
    }

    @Override // net.pubnative.lite.sdk.utils.svgparser.utils.RenderOptionsBase
    public boolean hasTarget() {
        return super.hasTarget();
    }
}
