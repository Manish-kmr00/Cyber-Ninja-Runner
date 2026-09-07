package com.mbridge.msdk.video.module.listener.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.safedk.android.internal.special.SpecialsBridge;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: VideoViewDefaultListener.java */
/* JADX INFO: loaded from: classes8.dex */
public class m extends o {
    private Timer A;
    private Handler B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private MBridgeVideoView.u H;
    private MBridgeVideoView x;
    private MBridgeContainerView y;
    private int z;

    /* JADX INFO: compiled from: VideoViewDefaultListener.java */
    class a extends TimerTask {

        /* JADX INFO: renamed from: com.mbridge.msdk.video.module.listener.impl.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VideoViewDefaultListener.java */
        class RunnableC0518a implements Runnable {
            RunnableC0518a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m.this.y.showVideoClickView(-1);
                m.this.x.soundOperate(0, 2);
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                m.this.B.post(new RunnableC0518a());
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.listener.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        this.B = new Handler();
        this.C = false;
        this.D = false;
        this.E = false;
        this.x = mBridgeVideoView;
        this.y = mBridgeContainerView;
        this.G = i;
        this.z = i2;
        this.F = i4;
        if (mBridgeVideoView != null) {
            this.C = mBridgeVideoView.getVideoSkipTime() == 0;
        }
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f5843a = false;
        }
    }

    private void n() {
        try {
            Timer timer = this.A;
            if (timer != null) {
                timer.cancel();
                this.A = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    private void o() {
        CampaignEx campaignEx;
        CampaignEx campaignEx2 = this.b;
        if (campaignEx2 == null || campaignEx2.getDynamicTempCode() != 5) {
            return;
        }
        MBridgeVideoView mBridgeVideoView = this.x;
        if (mBridgeVideoView == null || mBridgeVideoView.mCampOrderViewData == null) {
            campaignEx = null;
        } else {
            int i = 0;
            for (int i2 = 0; i2 < this.x.mCampOrderViewData.size(); i2++) {
                if (this.x.mCampOrderViewData.get(i2) != null && this.x.mCampOrderViewData.get(i2).getId() == this.b.getId()) {
                    i = i2 - 1;
                    break;
                }
            }
            if (i < 0 || this.x.mCampOrderViewData.get(i) == null) {
                campaignEx = null;
            } else {
                campaignEx = this.x.mCampOrderViewData.get(i);
            }
        }
        if (campaignEx != null) {
            MBridgeVideoView mBridgeVideoView2 = this.x;
            if (mBridgeVideoView2 != null) {
                mBridgeVideoView2.setCampaign(campaignEx);
            }
            MBridgeContainerView mBridgeContainerView = this.y;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setCampaign(campaignEx);
            }
            a(campaignEx);
        }
    }

    private void p() {
        try {
            n();
            this.A = new Timer();
            this.A.schedule(new a(), 3000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0251  */
    /* JADX WARN: Code duplicated, block: B:125:0x0269  */
    /* JADX WARN: Code duplicated, block: B:127:0x0271  */
    /* JADX WARN: Code duplicated, block: B:128:0x0278  */
    /* JADX WARN: Code duplicated, block: B:156:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:171:0x0338  */
    /* JADX WARN: Code duplicated, block: B:173:0x033c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0359  */
    @Override // com.mbridge.msdk.video.module.listener.impl.o, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        CampaignEx campaignEx;
        CampaignEx campaignEx2;
        int bufferTimeout;
        String playURL;
        int i2;
        if (this.f5843a) {
            if (i != 1) {
                if (i == 2) {
                    this.x.dismissAllAlert();
                    SpecialsBridge.MBridgeVideoView_videoOperate(this.x, 3);
                    campaignEx = this.b;
                    if (campaignEx == null && campaignEx.isDynamicView() && this.b.getDynamicTempCode() == 5) {
                        if (this.y != null) {
                            MBridgeVideoView mBridgeVideoView = this.x;
                            if (mBridgeVideoView.mCurrPlayNum == mBridgeVideoView.mCampaignSize) {
                                if (this.b.getAdSpaceT() == 2) {
                                    i = 16;
                                } else {
                                    this.y.setRewardStatus(true);
                                    this.y.showOrderCampView();
                                }
                            }
                        }
                        com.mbridge.msdk.video.bt.module.orglistener.f.a(this.b, this.g, this.x.mCurrentPlayProgressTime);
                        if (this.G == 2) {
                            i = 16;
                        } else {
                            i = 16;
                        }
                    } else if (this.G == 2 || this.y.endCardShowing() || this.b.getAdSpaceT() == 2) {
                        i = 16;
                    } else {
                        this.y.showEndcard(this.b.getVideo_end_type());
                    }
                } else if (i != 5) {
                    if (i == 6) {
                        this.x.dismissAllAlert();
                        SpecialsBridge.MBridgeVideoView_videoOperate(this.x, 3);
                        campaignEx = this.b;
                        if (campaignEx == null) {
                            if (this.G == 2) {
                                i = 16;
                            } else {
                                i = 16;
                            }
                        } else if (this.G == 2) {
                            i = 16;
                        } else {
                            i = 16;
                        }
                    } else if (i == 8) {
                        MBridgeContainerView mBridgeContainerView = this.y;
                        if (mBridgeContainerView == null) {
                            MBridgeVideoView mBridgeVideoView2 = this.x;
                            if (mBridgeVideoView2 != null) {
                                SpecialsBridge.MBridgeVideoView_showAlertView(mBridgeVideoView2);
                            }
                        } else if (mBridgeContainerView.showAlertWebView()) {
                            MBridgeVideoView mBridgeVideoView3 = this.x;
                            if (mBridgeVideoView3 != null) {
                                mBridgeVideoView3.alertWebViewShowed();
                            }
                        } else {
                            MBridgeVideoView mBridgeVideoView4 = this.x;
                            if (mBridgeVideoView4 != null) {
                                SpecialsBridge.MBridgeVideoView_showAlertView(mBridgeVideoView4);
                            }
                        }
                    } else if (i != 20) {
                        switch (i) {
                            case 10:
                                this.D = true;
                                this.x.soundOperate(0, 2);
                                this.x.progressOperate(0, 2);
                                break;
                            case 11:
                                SpecialsBridge.MBridgeVideoView_videoOperate(this.x, 3);
                                this.x.dismissAllAlert();
                                CampaignEx campaignEx3 = this.b;
                                if (campaignEx3 == null || campaignEx3.getVideo_end_type() == 3 || this.b.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() == 5002010) {
                                    this.x.setVisibility(0);
                                } else if (this.b.getAdSpaceT() != 2) {
                                    this.x.setVisibility(8);
                                }
                                CampaignEx campaignEx4 = this.b;
                                if (campaignEx4 != null && campaignEx4.getDynamicTempCode() == 5) {
                                    MBridgeVideoView mBridgeVideoView5 = this.x;
                                    if (mBridgeVideoView5.mCurrPlayNum != mBridgeVideoView5.mCampaignSize) {
                                        campaignEx2 = this.b;
                                        if (campaignEx2 == null) {
                                            if (this.b.getAdSpaceT() != 2) {
                                                this.y.showEndcard(this.b.getVideo_end_type());
                                            } else {
                                                this.y.showVideoEndCover();
                                            }
                                        } else if (this.b.getAdSpaceT() != 2) {
                                            this.y.showEndcard(this.b.getVideo_end_type());
                                        } else {
                                            this.y.showVideoEndCover();
                                        }
                                    } else {
                                        MBridgeContainerView mBridgeContainerView2 = this.y;
                                        if (mBridgeContainerView2 != null) {
                                            mBridgeContainerView2.setRewardStatus(true);
                                            this.y.showOrderCampView();
                                        }
                                    }
                                } else {
                                    campaignEx2 = this.b;
                                    if (campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() != 5002010) {
                                        if (this.b.getAdSpaceT() != 2) {
                                            this.y.showEndcard(this.b.getVideo_end_type());
                                        } else {
                                            this.y.showVideoEndCover();
                                        }
                                    }
                                }
                                break;
                            case 12:
                                k();
                                SpecialsBridge.MBridgeVideoView_videoOperate(this.x, 3);
                                this.x.dismissAllAlert();
                                if (this.b.getVideo_end_type() != 3) {
                                    this.x.setVisibility(8);
                                } else {
                                    this.x.setVisibility(0);
                                }
                                if (this.D || this.F != 0) {
                                    if (this.b.isDynamicView() && this.b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.b.getendcard_url())) {
                                        o();
                                        this.F = 0;
                                    }
                                    if (!this.D && this.F == 1) {
                                        j();
                                        h();
                                        i();
                                        if (q0.a().a("i_l_s_t_r_i", false) && !this.E) {
                                            this.E = true;
                                            MBridgeVideoView.u uVar = this.H;
                                            if (uVar != null) {
                                                uVar.a();
                                            }
                                        }
                                    }
                                    if (this.b.getAdSpaceT() == 2) {
                                        this.y.showVideoEndCover();
                                    } else {
                                        this.y.showEndcard(this.b.getVideo_end_type());
                                    }
                                }
                                break;
                            case 13:
                                MBridgeVideoView mBridgeVideoView6 = this.x;
                                if (mBridgeVideoView6 != null) {
                                    mBridgeVideoView6.closeVideoOperate(0, 2);
                                    playURL = this.x.getPlayURL();
                                    bufferTimeout = this.x.getBufferTimeout();
                                } else {
                                    bufferTimeout = -1;
                                    playURL = "";
                                }
                                CampaignEx campaignEx5 = this.b;
                                String videoUrlEncode = campaignEx5 != null ? campaignEx5.getVideoUrlEncode() : "";
                                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                                eVar.a("play_url", playURL);
                                eVar.a("video_url", videoUrlEncode);
                                eVar.a("timeout", Integer.valueOf(bufferTimeout));
                                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_video_buffer_timeout", this.b, eVar);
                                break;
                            case 14:
                                if (!this.C) {
                                    this.x.closeVideoOperate(0, 1);
                                }
                                break;
                            case 15:
                                if (obj != null && (obj instanceof MBridgeVideoView.v)) {
                                    MBridgeVideoView.v vVar = (MBridgeVideoView.v) obj;
                                    int videoInteractiveType = this.y.getVideoInteractiveType();
                                    if (this.b.getAdSpaceT() == 2) {
                                        SoundImageView soundImageView = this.x.mSoundImageView;
                                        if (soundImageView != null && (soundImageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.x.mSoundImageView.getLayoutParams();
                                            layoutParams.setMargins(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f), 0, 0, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 85.0f));
                                            this.x.mSoundImageView.setLayoutParams(layoutParams);
                                        }
                                        TextView textView = this.x.tvFlag;
                                        if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.x.tvFlag.getLayoutParams();
                                            layoutParams2.setMargins(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f), 0, 0, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 85.0f));
                                            this.x.tvFlag.setVisibility(0);
                                            this.x.tvFlag.setLayoutParams(layoutParams2);
                                        }
                                        this.y.showVideoClickView(1);
                                    } else if (videoInteractiveType >= 0 && vVar.f5837a >= videoInteractiveType) {
                                        this.y.showVideoClickView(1);
                                        this.x.soundOperate(0, 1);
                                    }
                                    this.C = vVar.c;
                                    if (this.b.getDynamicTempCode() != 5) {
                                        int i3 = this.z;
                                        if (((i3 >= 0 && ((i2 = vVar.f5837a) >= i3 || i2 == vVar.b)) || (this.b.getVideoCompleteTime() > 0 && (vVar.f5837a > this.b.getVideoCompleteTime() || vVar.f5837a == vVar.b))) && !this.C) {
                                            this.x.closeVideoOperate(0, 2);
                                            this.C = true;
                                        }
                                    } else {
                                        a(vVar.f5837a, vVar.b);
                                    }
                                }
                                break;
                        }
                    } else if (q0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                        this.H = (MBridgeVideoView.u) obj;
                    }
                } else if (obj != null && (obj instanceof Integer)) {
                    this.x.soundOperate((((Integer) obj).intValue() == 1 ? 2 : 1).intValue(), -1);
                }
            } else if (!this.y.endCardShowing()) {
                int videoInteractiveType2 = this.y.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.y.isLast()) {
                            this.y.showVideoClickView(1);
                            this.x.soundOperate(0, 1);
                            p();
                        } else {
                            this.y.showVideoClickView(-1);
                            this.x.soundOperate(0, 2);
                            n();
                        }
                    }
                } else if (this.y.miniCardLoaded()) {
                    this.y.showVideoClickView(2);
                }
            }
        }
        super.a(i, obj);
    }

    private void a(int i, int i2) {
        CampaignEx campaignEx;
        if (this.C || this.x == null || (campaignEx = this.b) == null) {
            return;
        }
        int i3 = this.z;
        int i4 = (i3 < 0 || i < i3) ? 1 : 2;
        if (i4 != 2 && (campaignEx.getVideoCompleteTime() != 0 ? i > this.b.getVideoCompleteTime() : this.x.mCurrPlayNum > 1)) {
            i4 = 2;
        }
        if (i4 != 2 && this.x.mCurrPlayNum > 1 && i == i2) {
            i4 = 2;
        }
        if (i4 == 2) {
            this.x.closeVideoOperate(0, i4);
            this.C = true;
        }
    }
}
