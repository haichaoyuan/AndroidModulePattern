// IMessengerCallback.aidl
package com.xh.arespunc;
//消息回调
interface IMessengerCallback {
     //调用成功之后回调
     void  onSuccess(String json);
     //调用失败的回调
     void  onFailed(String msg);
}
