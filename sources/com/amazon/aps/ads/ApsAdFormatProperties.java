package com.amazon.aps.ads;

import com.amazon.device.ads.DtbConstants;

/* JADX INFO: loaded from: classes6.dex */
public class ApsAdFormatProperties {
    private static final String LOGTAG = "ApsAdFormatProperties";
    private int playerHeight;
    private int playerWidth;

    public int getPlayerHeight() {
        int i = this.playerHeight;
        return i == 0 ? DtbConstants.DEFAULT_PLAYER_HEIGHT : i;
    }

    public int getPlayerWidth() {
        int i = this.playerWidth;
        if (i == 0) {
            return 320;
        }
        return i;
    }

    private ApsAdFormatProperties(Builder builder) {
        this.playerHeight = builder.playerHeight;
        this.playerWidth = builder.playerWidth;
    }

    public static class Builder {
        private int playerHeight;
        private int playerWidth;

        public Builder setPlayerHeight(int i) {
            this.playerHeight = i;
            return this;
        }

        public Builder setPlayerWidth(int i) {
            this.playerWidth = i;
            return this;
        }

        public ApsAdFormatProperties build() {
            return new ApsAdFormatProperties(this);
        }
    }
}
