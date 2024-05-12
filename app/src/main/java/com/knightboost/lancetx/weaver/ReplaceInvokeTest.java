package com.knightboost.lancetx.weaver;

import android.annotation.TargetApi;
import android.util.Log;

import com.knightboost.lancet.api.Scope;
import com.knightboost.lancet.api.annotations.Group;
import com.knightboost.lancet.api.annotations.ReplaceInvoke;
import com.knightboost.lancet.api.annotations.TargetClass;
import com.knightboost.lancet.api.annotations.TargetMethod;
import com.knightboost.lancet.api.annotations.Weaver;
import com.knightboost.lancetx.ClassA;
import com.knightboost.lancetx.GameMonitor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Weaver
@Group("replaceInvokeTest")
public class ReplaceInvokeTest {
    private static final String BASE_ACTIVITY = "android.app.Activity";

    @ReplaceInvoke(isStatic = true)
    @TargetClass(value = "android.util.Log",scope = Scope.SELF)
    @TargetMethod(methodName = "i")
    public static int replaceLogI2(String tag,String msg){
        msg = msg + "被替换";
        return Log.e("zxw",msg);
    }

    @ReplaceInvoke()
    @TargetClass(value = "com.knightboost.lancetx.ClassA",scope = Scope.SELF)
    @TargetMethod(methodName = "printMessage")
    public static void printMessage(ClassA a, String msg){
        msg = msg + "被替换 <- printMessage";
        Log.e("ClassA",msg);
    }

    @ReplaceInvoke()
    @TargetClass(value ="com.knightboost.lancetx.GameMonitor",scope = Scope.SELF)
    @TargetMethod(methodName = "startMonitor")
    public static void startMonitor(GameMonitor gameMonitor,String msg,int gameType) {
        String msgString = "GameMonitor的监听信息:" + msg;
        String gameTypeString = "GameMonitor监听的游戏类型:" + gameType;

        System.out.println(msgString);
        System.out.println(gameTypeString);
        gameMonitor.startMonitor(msg,gameType);

    }
}
