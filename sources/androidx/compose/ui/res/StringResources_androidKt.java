package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringResources.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001a+\u0010\u000f\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"pluralStringResource", "", "id", "", "count", "(IILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "(II[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "resources", "Landroid/content/res/Resources;", "(Landroidx/compose/runtime/Composer;I)Landroid/content/res/Resources;", "stringArrayResource", "(ILandroidx/compose/runtime/Composer;I)[Ljava/lang/String;", "stringResource", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StringResources_androidKt {
    public static final String stringResource(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1223887937, "C(stringResource)37@1281L11:StringResources.android.kt#ccshc7");
        String string = resources(composer, 0).getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    public static final String stringResource(int i, Object[] formatArgs, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ComposerKt.sourceInformationMarkerStart(composer, 2071230100, "C(stringResource)P(1)51@1645L11:StringResources.android.kt#ccshc7");
        String string = resources(composer, 0).getString(i, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    public static final String[] stringArrayResource(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1562162650, "C(stringArrayResource)64@1951L11:StringResources.android.kt#ccshc7");
        String[] stringArray = resources(composer, 0).getStringArray(i);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(id)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stringArray;
    }

    @ExperimentalComposeUiApi
    public static final String pluralStringResource(int i, int i2, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1784741530, "C(pluralStringResource)P(1)79@2321L11:StringResources.android.kt#ccshc7");
        String quantityString = resources(composer, 0).getQuantityString(i, i2);
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(id, count)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return quantityString;
    }

    @ExperimentalComposeUiApi
    public static final String pluralStringResource(int i, int i2, Object[] formatArgs, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ComposerKt.sourceInformationMarkerStart(composer, 523207213, "C(pluralStringResource)P(2)95@2813L11:StringResources.android.kt#ccshc7");
        String quantityString = resources(composer, 0).getQuantityString(i, i2, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…g(id, count, *formatArgs)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return quantityString;
    }

    private static final Resources resources(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 697814152, "C(resources)106@3106L7,107@3138L7:StringResources.android.kt#ccshc7");
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = ((Context) objConsume).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "LocalContext.current.resources");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return resources;
    }
}
