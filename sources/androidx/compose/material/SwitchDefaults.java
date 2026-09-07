package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* JADX INFO: renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m1187colorsSQMK_m0(long j, long j2, float f, long j3, long j4, float f2, long j5, long j6, long j7, long j8, Composer composer, int i, int i2, int i3) {
        long jM1677compositeOverOWjLjI;
        long jM1677compositeOverOWjLjI2;
        int i4;
        long jM1677compositeOverOWjLjI3;
        long jM1677compositeOverOWjLjI4;
        composer.startReplaceableGroup(-1032127534);
        ComposerKt.sourceInformation(composer, "C(colors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color!1,7:c#ui.graphics.Color,9:c#ui.graphics.Color,8,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color)279@11288L6,282@11460L6,283@11527L6,286@11689L8,287@11740L6,289@11857L8,290@11908L6,292@12029L8,293@12080L6,295@12201L8,296@12252L6:Switch.kt#jmzs0o");
        long jM982getSecondaryVariant0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m982getSecondaryVariant0d7_KjU() : j;
        long j9 = (i3 & 2) != 0 ? jM982getSecondaryVariant0d7_KjU : j2;
        float f3 = (i3 & 4) != 0 ? 0.54f : f;
        long jM983getSurface0d7_KjU = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m983getSurface0d7_KjU() : j3;
        long jM978getOnSurface0d7_KjU = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m978getOnSurface0d7_KjU() : j4;
        float f4 = (i3 & 32) != 0 ? 0.38f : f2;
        if ((i3 & 64) != 0) {
            jM1677compositeOverOWjLjI = ColorKt.m1677compositeOverOWjLjI(Color.m1630copywmQWz5c$default(jM982getSecondaryVariant0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m983getSurface0d7_KjU());
        } else {
            jM1677compositeOverOWjLjI = j5;
        }
        if ((i3 & 128) != 0) {
            jM1677compositeOverOWjLjI2 = ColorKt.m1677compositeOverOWjLjI(Color.m1630copywmQWz5c$default(j9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m983getSurface0d7_KjU());
        } else {
            jM1677compositeOverOWjLjI2 = j6;
        }
        if ((i3 & 256) != 0) {
            i4 = 6;
            jM1677compositeOverOWjLjI3 = ColorKt.m1677compositeOverOWjLjI(Color.m1630copywmQWz5c$default(jM983getSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m983getSurface0d7_KjU());
        } else {
            i4 = 6;
            jM1677compositeOverOWjLjI3 = j7;
        }
        if ((i3 & 512) != 0) {
            jM1677compositeOverOWjLjI4 = ColorKt.m1677compositeOverOWjLjI(Color.m1630copywmQWz5c$default(jM978getOnSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, i4), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m983getSurface0d7_KjU());
        } else {
            jM1677compositeOverOWjLjI4 = j8;
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(jM982getSecondaryVariant0d7_KjU, Color.m1630copywmQWz5c$default(j9, f3, 0.0f, 0.0f, 0.0f, 14, null), jM983getSurface0d7_KjU, Color.m1630copywmQWz5c$default(jM978getOnSurface0d7_KjU, f4, 0.0f, 0.0f, 0.0f, 14, null), jM1677compositeOverOWjLjI, Color.m1630copywmQWz5c$default(jM1677compositeOverOWjLjI2, f3, 0.0f, 0.0f, 0.0f, 14, null), jM1677compositeOverOWjLjI3, Color.m1630copywmQWz5c$default(jM1677compositeOverOWjLjI4, f4, 0.0f, 0.0f, 0.0f, 14, null), null);
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
