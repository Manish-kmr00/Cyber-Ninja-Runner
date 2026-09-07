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
import java.io.IOException;

/* JADX INFO: compiled from: DTExchangeSourceFile */
/* JADX INFO: loaded from: classes11.dex */
public class DTExchangeVideoBridge {
    public static void VideoViewPlay(VideoView vv) {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->VideoViewPlay(Landroid/widget/VideoView;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewPlay: player " + vv + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.p, (Object) vv);
                CreativeInfoManager.a(h.p, BrandSafetyUtils.a(vv), false, "video-view");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewPlay: " + e.getMessage());
            }
        }
        vv.start();
    }

    public static void VideoViewSetVideoPath(VideoView vv, String url) {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->VideoViewSetVideoPath(Landroid/widget/VideoView;Ljava/lang/String;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewSetVideoPath: player " + vv + ", path: " + url + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.p, vv, url);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewSetVideoPath: " + e.getMessage());
            }
        }
        vv.setVideoPath(url);
    }

    public static void MediaPlayerStart(MediaPlayer mp) throws IllegalStateException {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->MediaPlayerStart(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerStart: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.p, mp);
                CreativeInfoManager.a(h.p, (String) null, false, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.start();
    }

    public static void MediaPlayerStop(MediaPlayer mp) throws IllegalStateException {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->MediaPlayerStop(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerStop: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.p, (String) null, true, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStop: " + e.getMessage());
            }
        }
        mp.stop();
    }

    public static void MediaPlayerPause(MediaPlayer mp) throws IllegalStateException {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->MediaPlayerPause(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerPause: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.p, (String) null, true, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerPause: " + e.getMessage());
            }
        }
        mp.pause();
    }

    public static void MediaPlayerRelease(MediaPlayer mp) throws IllegalStateException {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->MediaPlayerRelease(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerRelease: " + mp + ", isOnUiThread = " + n.c());
                if (CreativeInfoManager.a(h.p, AdNetworkConfiguration.SUPPORTS_MEDIA_PLAYER_RELEASE_EOV, false)) {
                    CreativeInfoManager.a(h.p, (String) null, true, "media-player");
                }
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.release();
    }

    public static void MediaPlayerSetDataSource(MediaPlayer mp, String path) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->MediaPlayerSetDataSource(Landroid/media/MediaPlayer;Ljava/lang/String;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerSetDataSource: player " + mp + ", path " + path + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a(h.p, mp, path);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerSetDataSource: " + e.getMessage());
            }
        }
        mp.setDataSource(path);
    }

    public static void MediaPlayerSetSurface(MediaPlayer mp, Surface surface) {
        Logger.d("DTExchangeVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/DTExchangeVideoBridge;->MediaPlayerSetSurface(Landroid/media/MediaPlayer;Landroid/view/Surface;)V");
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
