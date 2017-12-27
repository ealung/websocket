package org.onezero.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by zhangchanglu on 2017/12/27
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
@Controller
public class CloudController {
    @Resource
    private SimpMessageSendingOperations simpMessageSendingOperations;
    @MessageMapping("/send/{roomId}")
    public void handle(@DestinationVariable Long roomId, String message) {
        simpMessageSendingOperations.convertAndSend("/chat/listener/"+roomId,message);
    }
}
