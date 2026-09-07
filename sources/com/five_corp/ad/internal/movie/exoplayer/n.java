package com.five_corp.ad.internal.movie.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.view.B;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Player.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExoPlayer f1447a;
    public final Handler b;
    public final B c;
    public final a d;
    public final Long e;
    public m f;

    public n(ExoPlayer exoPlayer, B b, Long l, a aVar) {
        this.f1447a = exoPlayer;
        exoPlayer.addListener(this);
        this.b = new Handler(Looper.getMainLooper());
        this.c = b;
        this.e = l;
        this.d = aVar;
        this.f = null;
    }

    public final void a() {
        m mVar = this.f;
        if (mVar != null) {
            this.b.removeCallbacksAndMessages(mVar);
            this.f = null;
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        if (i == 2) {
            this.d.k();
            return;
        }
        if (i == 3) {
            this.d.m();
        } else if (i != 4) {
            String.format("onPlaybackStateChanged: %d", Integer.valueOf(i));
        } else {
            this.d.l();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayerError(PlaybackException playbackException) {
        p pVar;
        a aVar = this.d;
        int i = playbackException.errorCode;
        if (i == 5001) {
            pVar = p.a6;
        } else if (i != 5002) {
            switch (i) {
                case 1000:
                    pVar = p.H6;
                    break;
                case 1001:
                    pVar = p.F6;
                    break;
                case 1002:
                    pVar = p.c6;
                    break;
                case 1003:
                    pVar = p.G6;
                    break;
                case 1004:
                    pVar = p.r6;
                    break;
                default:
                    switch (i) {
                        case 2000:
                            pVar = p.A6;
                            break;
                        case 2001:
                            pVar = p.w6;
                            break;
                        case 2002:
                            pVar = p.x6;
                            break;
                        case 2003:
                            pVar = p.v6;
                            break;
                        case 2004:
                            pVar = p.s6;
                            break;
                        case 2005:
                            pVar = p.u6;
                            break;
                        case 2006:
                            pVar = p.y6;
                            break;
                        case 2007:
                            pVar = p.t6;
                            break;
                        case 2008:
                            pVar = p.z6;
                            break;
                        default:
                            switch (i) {
                                case 3001:
                                    pVar = p.B6;
                                    break;
                                case 3002:
                                    pVar = p.D6;
                                    break;
                                case 3003:
                                    pVar = p.C6;
                                    break;
                                case 3004:
                                    pVar = p.E6;
                                    break;
                                default:
                                    switch (i) {
                                        case 4001:
                                            pVar = p.d6;
                                            break;
                                        case 4002:
                                            pVar = p.e6;
                                            break;
                                        case 4003:
                                            pVar = p.f6;
                                            break;
                                        case 4004:
                                            pVar = p.g6;
                                            break;
                                        case 4005:
                                            pVar = p.h6;
                                            break;
                                        default:
                                            switch (i) {
                                                case 6000:
                                                    pVar = p.q6;
                                                    break;
                                                case 6001:
                                                    pVar = p.o6;
                                                    break;
                                                case 6002:
                                                    pVar = p.n6;
                                                    break;
                                                case 6003:
                                                    pVar = p.i6;
                                                    break;
                                                case 6004:
                                                    pVar = p.l6;
                                                    break;
                                                case 6005:
                                                    pVar = p.k6;
                                                    break;
                                                case 6006:
                                                    pVar = p.p6;
                                                    break;
                                                case 6007:
                                                    pVar = p.j6;
                                                    break;
                                                case 6008:
                                                    pVar = p.m6;
                                                    break;
                                                default:
                                                    pVar = p.I6;
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            pVar = p.b6;
        }
        aVar.b(new o(pVar, null, playbackException, null));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(final m mVar) {
        if (SystemClock.uptimeMillis() > mVar.f1446a) {
            this.d.b(new o(p.J6, null, null, null));
        } else {
            this.b.postAtTime(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.n$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(mVar);
                }
            }, mVar, SystemClock.uptimeMillis() + 500);
        }
    }
}
