package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.text.ExperimentalTextApi;
import java.io.File;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0012\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-wCLgNak", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "Font-RetOiIg", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidFontKt {
    /* JADX INFO: renamed from: Font-wCLgNak$default, reason: not valid java name */
    public static /* synthetic */ Font m3524FontwCLgNak$default(AssetManager assetManager, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.INSTANCE.m3573getNormal_LCdwA();
        }
        return m3522FontwCLgNak(assetManager, str, fontWeight, i);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This experimental Font is replaced by Font(path, assetManager, ...)", replaceWith = @ReplaceWith(expression = "Font(path, assetManager, weight, style)", imports = {}))
    @ExperimentalTextApi
    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m3522FontwCLgNak(AssetManager assetManager, String path, FontWeight weight, int i) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(weight, "weight");
        return new AndroidAssetFont(assetManager, path, weight, i, null);
    }

    /* JADX INFO: renamed from: Font-wCLgNak$default, reason: not valid java name */
    public static /* synthetic */ Font m3525FontwCLgNak$default(String str, AssetManager assetManager, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.INSTANCE.m3573getNormal_LCdwA();
        }
        return m3523FontwCLgNak(str, assetManager, fontWeight, i);
    }

    @ExperimentalTextApi
    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m3523FontwCLgNak(String path, AssetManager assetManager, FontWeight weight, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(weight, "weight");
        return new AndroidAssetFont(assetManager, path, weight, i, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m3521FontRetOiIg$default(File file, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.INSTANCE.m3573getNormal_LCdwA();
        }
        return m3519FontRetOiIg(file, fontWeight, i);
    }

    @ExperimentalTextApi
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final Font m3519FontRetOiIg(File file, FontWeight weight, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(weight, "weight");
        return new AndroidFileFont(file, weight, i, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m3520FontRetOiIg$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.INSTANCE.m3573getNormal_LCdwA();
        }
        return m3518FontRetOiIg(parcelFileDescriptor, fontWeight, i);
    }

    @ExperimentalTextApi
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final Font m3518FontRetOiIg(ParcelFileDescriptor fileDescriptor, FontWeight weight, int i) {
        Intrinsics.checkNotNullParameter(fileDescriptor, "fileDescriptor");
        Intrinsics.checkNotNullParameter(weight, "weight");
        return new AndroidFileDescriptorFont(fileDescriptor, weight, i, null);
    }
}
