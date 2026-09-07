package com.safedk.android.internal.partials;

import android.media.MediaPlayer;
import android.view.Surface;
import android.widget.VideoView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;

/* JADX INFO: compiled from: InMobiSourceFile */
/* JADX INFO: loaded from: classes12.dex */
public class InMobiVideoBridge {
    public static void VideoViewPlay(VideoView vv) {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->VideoViewPlay(Landroid/widget/VideoView;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewPlay: player " + vv + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.i, (Object) vv);
                CreativeInfoManager.a(h.i, BrandSafetyUtils.a(vv), false, "video-view");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewPlay: " + e.getMessage());
            }
        }
        vv.start();
    }

    public static void VideoViewStop(VideoView vv) {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->VideoViewStop(Landroid/widget/VideoView;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewStop: player " + vv + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.i, BrandSafetyUtils.a(vv), true, "video-view");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewStop : " + e.getMessage());
            }
        }
        vv.stopPlayback();
    }

    public static void VideoViewSetVideoPath(VideoView vv, String url) {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->VideoViewSetVideoPath(Landroid/widget/VideoView;Ljava/lang/String;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewSetVideoPath: player " + vv + ", path: " + url + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.i, vv, url);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewSetVideoPath: " + e.getMessage());
            }
        }
        vv.setVideoPath(url);
    }

    public static void MediaPlayerStart(MediaPlayer mp) throws IllegalStateException {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->MediaPlayerStart(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerStart: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.i, mp);
                CreativeInfoManager.a(h.i, (String) null, false, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.start();
    }

    public static void MediaPlayerPause(MediaPlayer mp) throws IllegalStateException {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->MediaPlayerPause(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerPause: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.i, (String) null, true, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerPause: " + e.getMessage());
            }
        }
        mp.pause();
    }

    public static void MediaPlayerRelease(MediaPlayer mp) throws IllegalStateException {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->MediaPlayerRelease(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerRelease: " + mp + ", isOnUiThread = " + n.c());
                if (CreativeInfoManager.a(h.i, AdNetworkConfiguration.SUPPORTS_MEDIA_PLAYER_RELEASE_EOV, false)) {
                    CreativeInfoManager.a(h.i, (String) null, true, "media-player");
                }
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.release();
    }

    public static void MediaPlayerSetSurface(MediaPlayer mp, Surface surface) {
        Logger.d("InMobiVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/InMobiVideoBridge;->MediaPlayerSetSurface(Landroid/media/MediaPlayer;Landroid/view/Surface;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerSetSurface: player " + mp + ", surface " + surface + ", isOnUiThread = " + n.c());
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerSetSurface: " + e.getMessage());
            }
        }
        mp.setSurface(surface);
    }
}
