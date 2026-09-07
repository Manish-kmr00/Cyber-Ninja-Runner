package com.yandex.div.svg;

import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SvgDecoder.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div/svg/SvgDecoder;", "", "useViewBoundsAsIntrinsicSize", "", "(Z)V", "decode", "Landroid/graphics/drawable/PictureDrawable;", "source", "Ljava/io/InputStream;", "div-svg_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SvgDecoder {
    private final boolean useViewBoundsAsIntrinsicSize;

    public SvgDecoder() {
        this(false, 1, null);
    }

    public SvgDecoder(boolean z) {
        this.useViewBoundsAsIntrinsicSize = z;
    }

    public /* synthetic */ SvgDecoder(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final PictureDrawable decode(InputStream source) {
        float documentWidth;
        float documentHeight;
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            SVG fromInputStream = SVG.getFromInputStream(source);
            Intrinsics.checkNotNullExpressionValue(fromInputStream, "getFromInputStream(source)");
            RectF documentViewBox = fromInputStream.getDocumentViewBox();
            if (this.useViewBoundsAsIntrinsicSize && documentViewBox != null) {
                documentWidth = documentViewBox.width();
                documentHeight = documentViewBox.height();
            } else {
                documentWidth = fromInputStream.getDocumentWidth();
                documentHeight = fromInputStream.getDocumentHeight();
            }
            if (documentViewBox == null && documentWidth > 0.0f && documentHeight > 0.0f) {
                fromInputStream.setDocumentViewBox(0.0f, 0.0f, documentWidth, documentHeight);
            }
            return new PictureDrawable(fromInputStream.renderToPicture());
        } catch (SVGParseException unused) {
            return null;
        }
    }
}
