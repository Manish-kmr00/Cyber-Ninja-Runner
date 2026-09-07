package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "()V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "typefaceInternal", "Landroid/graphics/Typeface;", "getTypefaceInternal", "()Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AndroidPreloadedFont extends AndroidFont {
    public abstract String getCacheKey();

    public abstract android.graphics.Typeface getTypefaceInternal();

    public AndroidPreloadedFont() {
        super(FontLoadingStrategy.INSTANCE.m3560getBlockingPKNRLFQ(), AndroidPreloadedFontTypefaceLoader.INSTANCE, null);
    }
}
