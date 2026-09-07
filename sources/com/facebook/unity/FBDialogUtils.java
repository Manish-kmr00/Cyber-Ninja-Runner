package com.facebook.unity;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

/* JADX INFO: loaded from: classes13.dex */
class FBDialogUtils {
    FBDialogUtils() {
    }

    public static ShareLinkContent.Builder createShareContentBuilder(Bundle bundle) {
        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
        if (bundle.containsKey("content_title")) {
            builder.setQuote(bundle.getString("content_title"));
        }
        if (bundle.containsKey(ShareConstants.STORY_DEEP_LINK_URL)) {
            builder.setContentUrl(Uri.parse(bundle.getString(ShareConstants.STORY_DEEP_LINK_URL)));
        }
        return builder;
    }

    public static ShareFeedContent.Builder createFeedContentBuilder(Bundle bundle) {
        ShareFeedContent.Builder builder = new ShareFeedContent.Builder();
        if (bundle.containsKey("toId")) {
            builder.setToId(bundle.getString("toId"));
        }
        if (bundle.containsKey("link")) {
            builder.setLink(bundle.getString("link"));
        }
        if (bundle.containsKey("linkName")) {
            builder.setLinkName(bundle.getString("linkName"));
        }
        if (bundle.containsKey("linkCaption")) {
            builder.setLinkCaption(bundle.getString("linkCaption"));
        }
        if (bundle.containsKey("linkDescription")) {
            builder.setLinkDescription(bundle.getString("linkDescription"));
        }
        if (bundle.containsKey("picture")) {
            builder.setPicture(bundle.getString("picture"));
        }
        if (bundle.containsKey("mediaSource")) {
            builder.setMediaSource(bundle.getString("mediaSource"));
        }
        return builder;
    }

    public static ShareDialog.Mode intToMode(int i) {
        if (i == 0) {
            return ShareDialog.Mode.AUTOMATIC;
        }
        if (i == 1) {
            return ShareDialog.Mode.NATIVE;
        }
        if (i == 2) {
            return ShareDialog.Mode.WEB;
        }
        if (i != 3) {
            return null;
        }
        return ShareDialog.Mode.FEED;
    }
}
