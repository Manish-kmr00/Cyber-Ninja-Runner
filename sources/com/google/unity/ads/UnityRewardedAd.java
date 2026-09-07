package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class UnityRewardedAd {
    private Activity activity;
    private UnityRewardedAdCallback callback;
    private RewardedAd rewardedAd;

    public void destroy() {
    }

    public UnityRewardedAd(Activity activity, UnityRewardedAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedAd$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ UnityRewardedAd this$0;
        final /* synthetic */ String val$adUnitId;
        final /* synthetic */ AdRequest val$request;

        AnonymousClass1(final UnityRewardedAd this$0, final String val$adUnitId, final AdRequest val$request) {
            this.val$adUnitId = val$adUnitId;
            this.val$request = val$request;
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardedAd.load(this.this$0.activity, this.val$adUnitId, this.val$request, new C03121());
        }

        /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedAd$1$1, reason: invalid class name and collision with other inner class name */
        class C03121 extends RewardedAdLoadCallback {
            C03121() {
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedAd ad) {
                AnonymousClass1.this.this$0.rewardedAd = ad;
                AnonymousClass1.this.this$0.rewardedAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.1
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(final AdValue adValue) {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedAd.1.1.1.1
                            final /* synthetic */ C03131 this$3;

                            {
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.this$0.callback != null) {
                                    AnonymousClass1.this.this$0.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                                }
                            }
                        }).start();
                    }
                });
                AnonymousClass1.this.this$0.rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.2
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(final AdError error) {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedAd.1.1.2.1
                            final /* synthetic */ AnonymousClass2 this$3;

                            {
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.this$0.callback != null) {
                                    AnonymousClass1.this.this$0.callback.onAdFailedToShowFullScreenContent(error);
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.this$0.callback != null) {
                                    AnonymousClass1.this.this$0.callback.onAdShowedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.this$0.callback != null) {
                                    AnonymousClass1.this.this$0.callback.onAdDismissedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.2.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.this$0.callback != null) {
                                    AnonymousClass1.this.this$0.callback.onAdImpression();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.2.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.this$0.callback != null) {
                                    AnonymousClass1.this.this$0.callback.onAdClicked();
                                }
                            }
                        }).start();
                    }
                });
                new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAd.1.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.this$0.callback != null) {
                            AnonymousClass1.this.this$0.callback.onRewardedAdLoaded();
                        }
                    }
                }).start();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(final LoadAdError error) {
                new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedAd.1.1.4
                    final /* synthetic */ C03121 this$2;

                    {
                        this.this$2 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.this$0.callback != null) {
                            AnonymousClass1.this.this$0.callback.onRewardedAdFailedToLoad(error);
                        }
                    }
                }).start();
            }
        }
    }

    public void loadAd(final String adUnitId, final AdRequest request) {
        this.activity.runOnUiThread(new AnonymousClass1(this, adUnitId, request));
    }

    public void show() {
        if (this.rewardedAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show rewarded ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedAd$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UnityRewardedAd.this.rewardedAd.show(UnityRewardedAd.this.activity, new OnUserEarnedRewardListener() { // from class: com.google.unity.ads.UnityRewardedAd.2.1
                @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                public void onUserEarnedReward(final RewardItem rewardItem) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedAd.2.1.1
                        final /* synthetic */ AnonymousClass1 this$2;

                        {
                            this.this$2 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (UnityRewardedAd.this.callback != null) {
                                UnityRewardedAd.this.callback.onUserEarnedReward(rewardItem.getType(), rewardItem.getAmount());
                            }
                        }
                    }).start();
                }
            });
        }
    }

    public void setServerSideVerificationOptions(final ServerSideVerificationOptions serverSideVerificationOptions) {
        if (this.rewardedAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried set server side verification before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedAd.3
                final /* synthetic */ UnityRewardedAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.this$0.rewardedAd.setServerSideVerificationOptions(serverSideVerificationOptions);
                }
            });
        }
    }

    public String getAdUnitId() {
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd == null) {
            return null;
        }
        return rewardedAd.getAdUnitId();
    }

    public ResponseInfo getResponseInfo() {
        FutureTask futureTask = new FutureTask(new Callable<ResponseInfo>() { // from class: com.google.unity.ads.UnityRewardedAd.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ResponseInfo call() {
                return UnityRewardedAd.this.rewardedAd.getResponseInfo();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check unity rewarded ad response info: %s", e.getLocalizedMessage()));
            return null;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check unity rewarded ad response info: %s", e2.getLocalizedMessage()));
            return null;
        }
    }

    public RewardItem getRewardItem() {
        if (this.rewardedAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to get reward item before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
            return null;
        }
        FutureTask futureTask = new FutureTask(new Callable<RewardItem>() { // from class: com.google.unity.ads.UnityRewardedAd.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RewardItem call() {
                return UnityRewardedAd.this.rewardedAd.getRewardItem();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (RewardItem) futureTask.get();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to get reward item: %s", e.getLocalizedMessage()));
            return null;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to get reward item: %s", e2.getLocalizedMessage()));
            return null;
        }
    }
}
