package com.facebook.ads.redexgen.core;

import android.media.AudioManager;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.M1, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/ContextAwareXHEAACDRCTypeUtil;", "", "<init>", "()V", "LATE_NIGHT_MODE", "", "LIMITED_PLAYBACK_RANGE", "DIALOG_ENHANCEMENT", "getDRCEffectTypeForLateNight", "lateNightLowerThreshold", "lateNightHigherThreshold", "getDRCEffectTypeForConnectedHeadSet", "audioManager", "Landroid/media/AudioManager;", "isHeadSetOn", "", "shouldUseLateNightMode", "lateNightHourLowerThreshold", "lateNightHourUpperThreshold", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwareXHEAACDRCTypeUtil {
    public static byte[] A00;
    public static final ContextAwareXHEAACDRCTypeUtil A01;

    static {
        A03();
        A01 = new ContextAwareXHEAACDRCTypeUtil();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{60, 40, 57, 52, 50, Ascii.DLE, 60, 51, 60, 58, 56, 47};
    }

    @JvmStatic
    public static final int A00(int i, int i2) {
        if (A01.A04(i, i2)) {
            return 1;
        }
        return 3;
    }

    @JvmStatic
    public static final int A01(AudioManager audioManager) {
        C2923nk.A09(audioManager, A02(0, 12, 34));
        if (A01.A05(audioManager)) {
            return 5;
        }
        return 3;
    }

    private final boolean A04(int i, int i2) {
        int i3 = Calendar.getInstance().get(11);
        return i3 >= i || i3 <= i2;
    }

    private final boolean A05(AudioManager audioManager) {
        return audioManager.isWiredHeadsetOn() || audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn();
    }
}
