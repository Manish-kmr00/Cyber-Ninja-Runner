package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import com.json.mediationsdk.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowInsets.android.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0000\u001a\f\u0010K\u001a\u00020L*\u00020HH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0010\"(\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\"\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010\"\u0015\u0010\u001d\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010\"\u001e\u0010\u001f\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u001e\u0010!\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u001e\u0010#\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0015\u0010%\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b&\u0010\u0010\"\u0015\u0010'\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b(\u0010\u0010\"\u001e\u0010)\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0010\"\u0015\u0010,\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b-\u0010\u0010\"\u0015\u0010.\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b/\u0010\u0010\"\u0015\u00100\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b1\u0010\u0010\"\u0015\u00102\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b3\u0010\u0010\"\u001e\u00104\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0010\"\u0015\u00107\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010\u0010\"\u001e\u00109\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0010\"\u0015\u0010<\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b=\u0010\u0010\"\u0015\u0010>\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b?\u0010\u0010\"\u001e\u0010@\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0010\"\u0015\u0010C\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bD\u0010\u0010¨\u0006M"}, d2 = {"areNavigationBarsVisible", "", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getAreNavigationBarsVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "getAreNavigationBarsVisible", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "getCaptionBarIgnoringVisibility", "value", "consumeWindowInsets", "Landroidx/compose/ui/platform/ComposeView;", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/ComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "displayCutout", "getDisplayCutout", "ime", "getIme", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "isImeVisible", "isImeVisible$annotations", "isTappableElementVisible", "isTappableElementVisible$annotations", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "safeContent", "getSafeContent", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", d.h, "getWaterfall", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", "Landroidx/core/graphics/Insets;", "name", "", "toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "foundation-layout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WindowInsets_androidKt {
    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion companion) {
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        Intrinsics.checkNotNullParameter(insets, "<this>");
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static final ValueInsets ValueInsets(Insets insets, String name) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ValueInsets(toInsetsValues(insets), name);
    }

    public static final boolean getConsumeWindowInsets(ComposeView composeView) {
        Intrinsics.checkNotNullParameter(composeView, "<this>");
        Object tag = composeView.getTag(androidx.compose.ui.R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void setConsumeWindowInsets(ComposeView composeView, boolean z) {
        Intrinsics.checkNotNullParameter(composeView, "<this>");
        composeView.setTag(androidx.compose.ui.R.id.consume_window_insets_tag, Boolean.valueOf(z));
    }

    public static final WindowInsets getCaptionBar(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1832025528);
        ComposerKt.sourceInformation(composer, "C125@4232L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets captionBar = WindowInsetsHolder.INSTANCE.current(composer, 8).getCaptionBar();
        composer.endReplaceableGroup();
        return captionBar;
    }

    public static final WindowInsets getDisplayCutout(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1324817724);
        ComposerKt.sourceInformation(composer, "C134@4573L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets displayCutout = WindowInsetsHolder.INSTANCE.current(composer, 8).getDisplayCutout();
        composer.endReplaceableGroup();
        return displayCutout;
    }

    public static final WindowInsets getIme(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1466917860);
        ComposerKt.sourceInformation(composer, "C148@5200L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets ime = WindowInsetsHolder.INSTANCE.current(composer, 8).getIme();
        composer.endReplaceableGroup();
        return ime;
    }

    public static final WindowInsets getMandatorySystemGestures(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1369492988);
        ComposerKt.sourceInformation(composer, "C157@5527L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets mandatorySystemGestures = WindowInsetsHolder.INSTANCE.current(composer, 8).getMandatorySystemGestures();
        composer.endReplaceableGroup();
        return mandatorySystemGestures;
    }

    public static final WindowInsets getNavigationBars(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1596175702);
        ComposerKt.sourceInformation(composer, "C167@5879L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets navigationBars = WindowInsetsHolder.INSTANCE.current(composer, 8).getNavigationBars();
        composer.endReplaceableGroup();
        return navigationBars;
    }

    public static final WindowInsets getStatusBars(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-675090670);
        ComposerKt.sourceInformation(composer, "C175@6091L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets statusBars = WindowInsetsHolder.INSTANCE.current(composer, 8).getStatusBars();
        composer.endReplaceableGroup();
        return statusBars;
    }

    public static final WindowInsets getSystemBars(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-282936756);
        ComposerKt.sourceInformation(composer, "C183@6299L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets systemBars = WindowInsetsHolder.INSTANCE.current(composer, 8).getSystemBars();
        composer.endReplaceableGroup();
        return systemBars;
    }

    public static final WindowInsets getSystemGestures(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(989216224);
        ComposerKt.sourceInformation(composer, "C191@6515L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets systemGestures = WindowInsetsHolder.INSTANCE.current(composer, 8).getSystemGestures();
        composer.endReplaceableGroup();
        return systemGestures;
    }

    public static final WindowInsets getTappableElement(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1994205284);
        ComposerKt.sourceInformation(composer, "C199@6737L9:WindowInsets.android.kt#2w3rfo");
        AndroidWindowInsets tappableElement = WindowInsetsHolder.INSTANCE.current(composer, 8).getTappableElement();
        composer.endReplaceableGroup();
        return tappableElement;
    }

    public static final WindowInsets getWaterfall(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1943241020);
        ComposerKt.sourceInformation(composer, "C207@6959L9:WindowInsets.android.kt#2w3rfo");
        ValueInsets waterfall = WindowInsetsHolder.INSTANCE.current(composer, 8).getWaterfall();
        composer.endReplaceableGroup();
        return waterfall;
    }

    public static final WindowInsets getSafeDrawing(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-49441252);
        ComposerKt.sourceInformation(composer, "C217@7314L9:WindowInsets.android.kt#2w3rfo");
        WindowInsets safeDrawing = WindowInsetsHolder.INSTANCE.current(composer, 8).getSafeDrawing();
        composer.endReplaceableGroup();
        return safeDrawing;
    }

    public static final WindowInsets getSafeGestures(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1594247780);
        ComposerKt.sourceInformation(composer, "C228@7741L9:WindowInsets.android.kt#2w3rfo");
        WindowInsets safeGestures = WindowInsetsHolder.INSTANCE.current(composer, 8).getSafeGestures();
        composer.endReplaceableGroup();
        return safeGestures;
    }

    public static final WindowInsets getSafeContent(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-2026663876);
        ComposerKt.sourceInformation(composer, "C237@8051L9:WindowInsets.android.kt#2w3rfo");
        WindowInsets safeContent = WindowInsetsHolder.INSTANCE.current(composer, 8).getSafeContent();
        composer.endReplaceableGroup();
        return safeContent;
    }

    @ExperimentalLayoutApi
    public static final WindowInsets getCaptionBarIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1731251574);
        ComposerKt.sourceInformation(composer, "C249@8459L9:WindowInsets.android.kt#2w3rfo");
        ValueInsets captionBarIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 8).getCaptionBarIgnoringVisibility();
        composer.endReplaceableGroup();
        return captionBarIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static final WindowInsets getNavigationBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1990981160);
        ComposerKt.sourceInformation(composer, "C263@9025L9:WindowInsets.android.kt#2w3rfo");
        ValueInsets navigationBarsIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 8).getNavigationBarsIgnoringVisibility();
        composer.endReplaceableGroup();
        return navigationBarsIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static final WindowInsets getStatusBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(594020756);
        ComposerKt.sourceInformation(composer, "C275@9466L9:WindowInsets.android.kt#2w3rfo");
        ValueInsets statusBarsIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 8).getStatusBarsIgnoringVisibility();
        composer.endReplaceableGroup();
        return statusBarsIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static final WindowInsets getSystemBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1564566798);
        ComposerKt.sourceInformation(composer, "C288@9903L9:WindowInsets.android.kt#2w3rfo");
        ValueInsets systemBarsIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 8).getSystemBarsIgnoringVisibility();
        composer.endReplaceableGroup();
        return systemBarsIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static final WindowInsets getTappableElementIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1488788292);
        ComposerKt.sourceInformation(composer, "C301@10348L9:WindowInsets.android.kt#2w3rfo");
        ValueInsets tappableElementIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 8).getTappableElementIgnoringVisibility();
        composer.endReplaceableGroup();
        return tappableElementIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static final boolean isCaptionBarVisible(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-501076620);
        ComposerKt.sourceInformation(composer, "C313@10754L9:WindowInsets.android.kt#2w3rfo");
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 8).getCaptionBar().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @ExperimentalLayoutApi
    public static final boolean isImeVisible(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1873571424);
        ComposerKt.sourceInformation(composer, "C325@11135L9:WindowInsets.android.kt#2w3rfo");
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 8).getIme().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @ExperimentalLayoutApi
    public static final boolean getAreStatusBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1613283456);
        ComposerKt.sourceInformation(composer, "C337@11512L9:WindowInsets.android.kt#2w3rfo");
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 8).getStatusBars().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @ExperimentalLayoutApi
    public static final boolean getAreNavigationBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(710310464);
        ComposerKt.sourceInformation(composer, "C349@11904L9:WindowInsets.android.kt#2w3rfo");
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 8).getNavigationBars().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @ExperimentalLayoutApi
    public static final boolean getAreSystemBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1985490720);
        ComposerKt.sourceInformation(composer, "C361@12292L9:WindowInsets.android.kt#2w3rfo");
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 8).getSystemBars().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @ExperimentalLayoutApi
    public static final boolean isTappableElementVisible(WindowInsets.Companion companion, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1737201120);
        ComposerKt.sourceInformation(composer, "C372@12683L9:WindowInsets.android.kt#2w3rfo");
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 8).getTappableElement().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }
}
