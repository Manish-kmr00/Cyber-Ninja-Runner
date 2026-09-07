package com.inmobi.media;

import android.media.MediaPlayer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.q8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3528q8 implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3556s8 f3408a;

    public C3528q8(C3556s8 c3556s8) {
        this.f3408a = c3556s8;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mp) {
        HashMap map;
        C3456l8 c3456l8;
        HashMap map2;
        HashMap map3;
        Intrinsics.checkNotNullParameter(mp, "mp");
        if (this.f3408a.getMediaPlayer() == null) {
            return;
        }
        O7 mediaPlayer = this.f3408a.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.f3156a = 2;
        }
        C3556s8 c3556s8 = this.f3408a;
        c3556s8.r = true;
        c3556s8.q = true;
        c3556s8.p = true;
        C3456l8 c3456l9 = c3556s8.n;
        if (c3456l9 != null) {
            c3456l9.setEnabled(true);
        }
        this.f3408a.e = mp.getVideoWidth();
        this.f3408a.f = mp.getVideoHeight();
        Object tag = this.f3408a.getTag();
        C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
        int iIntValue = 0;
        if (c3426j8 != null) {
            Object obj = c3426j8.t.get("didCompleteQ4");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                this.f3408a.a(8, 0);
                Object obj2 = c3426j8.t.get("placementType");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
                if (((Byte) obj2).byteValue() == 1) {
                    return;
                }
            }
        }
        InterfaceC3486n8 playbackEventListener = this.f3408a.getPlaybackEventListener();
        if (playbackEventListener != null) {
            ((I7) playbackEventListener).a((byte) 0);
        }
        Object obj3 = (c3426j8 == null || (map3 = c3426j8.t) == null) ? null : map3.get("didCompleteQ4");
        if (Intrinsics.areEqual(obj3 instanceof Boolean ? (Boolean) obj3 : null, Boolean.FALSE)) {
            Object obj4 = c3426j8.t.get("seekPosition");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            iIntValue = ((Integer) obj4).intValue();
        }
        C3556s8 c3556s9 = this.f3408a;
        if (c3556s9.e == 0 || c3556s9.f == 0) {
            O7 mediaPlayer2 = c3556s9.getMediaPlayer();
            if (mediaPlayer2 == null || 3 != mediaPlayer2.b) {
                return;
            }
            Object obj5 = (c3426j8 == null || (map = c3426j8.t) == null) ? null : map.get("isFullScreen");
            if (Intrinsics.areEqual(obj5 instanceof Boolean ? (Boolean) obj5 : null, Boolean.TRUE)) {
                this.f3408a.start();
                return;
            }
            return;
        }
        O7 mediaPlayer3 = c3556s9.getMediaPlayer();
        if (mediaPlayer3 == null || 3 != mediaPlayer3.b) {
            if (this.f3408a.isPlaying()) {
                return;
            }
            if ((iIntValue != 0 || this.f3408a.getCurrentPosition() > 0) && (c3456l8 = this.f3408a.n) != null) {
                c3456l8.d();
                return;
            }
            return;
        }
        Object obj6 = (c3426j8 == null || (map2 = c3426j8.t) == null) ? null : map2.get("isFullScreen");
        if (Intrinsics.areEqual(obj6 instanceof Boolean ? (Boolean) obj6 : null, Boolean.TRUE)) {
            this.f3408a.start();
        }
        C3456l8 c3456l10 = this.f3408a.n;
        if (c3456l10 != null) {
            c3456l10.d();
        }
    }
}
