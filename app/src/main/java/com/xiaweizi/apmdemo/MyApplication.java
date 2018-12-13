package com.xiaweizi.apmdemo;

import android.app.Application;
import android.content.Context;

import com.argusapm.android.api.ApmTask;
import com.argusapm.android.api.Client;
import com.argusapm.android.core.Config;
import com.argusapm.android.network.cloudrule.RuleSyncRequest;
import com.argusapm.android.network.upload.CollectDataSyncUpload;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.xiaweizi.apmdemo.MyApplication
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/13
 *     desc   :
 * </pre>
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Config.ConfigBuilder builder = new Config.ConfigBuilder()
                .setAppContext(this)
                .setRuleRequest(new RuleSyncRequest())
                .setUpload(new CollectDataSyncUpload())
                .setAppName("APPDemo")
                .setAppVersion("1.0.0")
                .setApmid("gqg0ocoehiz6");//该ID是在APM的后台进行申请的

        //builder.setEnabled(ApmTask.FLAG_COLLECT_ACTIVITY_AOP); //activity采用aop方案时打开，默认关闭即可。
        builder.setEnabled(ApmTask.FLAG_LOCAL_DEBUG); //是否读取本地配置，默认关闭即可。
        Client.attach(builder.build());
        Client.isDebugOpen(true);//设置成true的时候将会打开悬浮窗
        Client.startWork();
    }

}