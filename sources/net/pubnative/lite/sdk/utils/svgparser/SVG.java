package net.pubnative.lite.sdk.utils.svgparser;

import android.graphics.Picture;
import java.io.InputStream;
import net.pubnative.lite.sdk.utils.svgparser.utils.SVGBase;

/* JADX INFO: loaded from: classes9.dex */
public class SVG {
    private static final String VERSION = "1.5";
    private SVGBase base;

    private SVG(SVGBase sVGBase) {
        this.base = sVGBase;
    }

    public static SVG getFromInputStream(InputStream inputStream) throws SVGParseException {
        return new SVG(SVGBase.getFromInputStream(inputStream));
    }

    public static SVG getFromString(String str) throws SVGParseException {
        return new SVG(SVGBase.getFromString(str));
    }

    public Picture renderToPicture() {
        return this.base.renderToPicture(null);
    }

    public Picture renderToPicture(int i, int i2) {
        return renderToPicture(i, i2, null);
    }

    public Picture renderToPicture(int i, int i2, RenderOptions renderOptions) {
        return this.base.renderToPicture(i, i2, renderOptions);
    }
}
