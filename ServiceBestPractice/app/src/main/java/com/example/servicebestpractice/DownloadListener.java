package com.example.servicebestpractice;

/**
 * Created by heyujie on 2017/8/30.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
