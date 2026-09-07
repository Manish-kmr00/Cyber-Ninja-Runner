package com.smaato.sdk.video.vast.tracking.macro;

/* JADX INFO: loaded from: classes6.dex */
public final class PlayerState {
    public final Float clickPositionX;
    public final Float clickPositionY;
    public final Integer errorCode;
    public final Boolean isMuted;
    public final Long offsetMillis;

    private PlayerState(Float f, Float f2, Boolean bool, Long l, Integer num) {
        this.clickPositionX = f;
        this.clickPositionY = f2;
        this.isMuted = bool;
        this.offsetMillis = l;
        this.errorCode = num;
    }

    public static class Builder {
        private Float clickPositionX;
        private Float clickPositionY;
        private Integer code;
        private Boolean isMuted;
        private Long offsetMillis;

        public Builder setClickPositionX(float f) {
            this.clickPositionX = Float.valueOf(f);
            return this;
        }

        public Builder setClickPositionY(float f) {
            this.clickPositionY = Float.valueOf(f);
            return this;
        }

        public Builder setMuted(boolean z) {
            this.isMuted = Boolean.valueOf(z);
            return this;
        }

        public Builder setOffsetMillis(long j) {
            this.offsetMillis = Long.valueOf(j);
            return this;
        }

        public Builder setErrorCode(int i) {
            this.code = Integer.valueOf(i);
            return this;
        }

        public PlayerState build() {
            return new PlayerState(this.clickPositionX, this.clickPositionY, this.isMuted, this.offsetMillis, this.code);
        }
    }
}
