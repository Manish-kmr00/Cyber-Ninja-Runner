package com.safedk.android.internal.partials;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.widget.VideoView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.io.IOException;

/* JADX INFO: compiled from: BidMachineSourceFile */
/* JADX INFO: loaded from: classes13.dex */
public class BidMachineVideoBridge {
    public static void VideoViewPlay(VideoView vv) {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->VideoViewPlay(Landroid/widget/VideoView;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewPlay: player " + vv + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", (Object) vv);
                CreativeInfoManager.a("io.bidmachine", BrandSafetyUtils.a(vv), false, "video-view");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewPlay: " + e.getMessage());
            }
        }
        vv.start();
    }

    public static void VideoViewSetVideoPath(VideoView vv, String url) {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->VideoViewSetVideoPath(Landroid/widget/VideoView;Ljava/lang/String;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "VideoViewSetVideoPath: player " + vv + ", path: " + url + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", vv, url);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in VideoViewSetVideoPath: " + e.getMessage());
            }
        }
        vv.setVideoPath(url);
    }

    public static void MediaPlayerStart(MediaPlayer mp) throws IllegalStateException {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerStart(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerStart: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", mp);
                CreativeInfoManager.a("io.bidmachine", (String) null, false, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.start();
    }

    public static void MediaPlayerStop(MediaPlayer mp) throws IllegalStateException {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerStop(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerStop: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", (String) null, true, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStop: " + e.getMessage());
            }
        }
        mp.stop();
    }

    public static void MediaPlayerPause(MediaPlayer mp) throws IllegalStateException {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerPause(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerPause: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", (String) null, true, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerPause: " + e.getMessage());
            }
        }
        mp.pause();
    }

    public static void MediaPlayerRelease(MediaPlayer mp) throws IllegalStateException {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerRelease(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerRelease: " + mp + ", isOnUiThread = " + n.c());
                if (CreativeInfoManager.a("io.bidmachine", AdNetworkConfiguration.SUPPORTS_MEDIA_PLAYER_RELEASE_EOV, false)) {
                    CreativeInfoManager.a("io.bidmachine", (String) null, true, "media-player");
                }
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.release();
    }

    public static void MediaPlayerSetDataSource(MediaPlayer mp, Context context, Uri uri) throws IllegalStateException, IOException, IllegalArgumentException {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerSetDataSource(Landroid/media/MediaPlayer;Landroid/content/Context;Landroid/net/Uri;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "media player set data source: player " + mp + ", context " + context + ",  uri= " + uri + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", mp, uri);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerSetDataSource: " + e.getMessage());
            }
        }
        mp.setDataSource(context, uri);
    }

    public static void MediaPlayerSetDataSource(MediaPlayer mp, String path) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerSetDataSource(Landroid/media/MediaPlayer;Ljava/lang/String;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerSetDataSource: player " + mp + ", path " + path + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("io.bidmachine", mp, path);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerSetDataSource: " + e.getMessage());
            }
        }
        mp.setDataSource(path);
    }

    public static void MediaPlayerSetSurface(MediaPlayer mp, Surface surface) {
        Logger.d("BidMachineVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/BidMachineVideoBridge;->MediaPlayerSetSurface(Landroid/media/MediaPlayer;Landroid/view/Surface;)V");
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
