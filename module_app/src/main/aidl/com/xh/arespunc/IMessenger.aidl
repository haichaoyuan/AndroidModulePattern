// IMessengerInterface.aidl
package com.xh.arespunc;
import com.xh.arespunc.IMessengerCallback;
// Declare any non-default types here with import statements

interface IMessenger {
   /**
     * 发送单人消息
     *
     * @param contactId  对方的id(消息接收者)
     * @param msgContent 消息的内容
     * @param callback
     */
   void sendSingleMsg(int contactId, String msgContent, IMessengerCallback callback);
    /**
      * 发送群发消息
      *
      * @param contactIdList
      * @param noticeTitle   群发会新建一个群发在最近对话列表 该参数表示群的名称
      * @param groupType     群聊类型 0部门、1学生、2私友 所有成员必须类型统一 否则群发建立不成功
      * @param msgContent
      * @param callback
      */
   void sendGroupMsg(in int[] contactIdList, String noticeTitle, int groupType, String msgContent, IMessengerCallback callback);
}
