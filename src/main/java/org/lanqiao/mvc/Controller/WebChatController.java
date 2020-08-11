package org.lanqiao.mvc.Controller;

import org.lanqiao.mvc.Util.SHA1;
import org.lanqiao.mvc.Util.WebChatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 微信开发者接入
 *
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/weixin/mywebchat")
public class WebChatController {
    // 开发者接入验证 确认请求来自微信服务器
    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        String echostr = request.getParameter("echostr");//成为开发者验证
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        PrintWriter out = response.getWriter();
        if(WebChatUtil.checkSignature(signature, timestamp, nonce)){
            System.out.println("接入成功");
            out.print(echostr);
            out.flush();
            out.close();
        }else{
            System.out.println("接入失败");
        }

    }
    @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO 消息的接收、处理、响应
        Map<String,String> requestMap = SHA1.parseRequest(request.getInputStream());
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//处理消息和事件推送
        System.out.println(requestMap);
//准备回复的数据包
        String respXml ="<xml><ToUserName><![CDATA["+requestMap.get("FromUserName")+"]]></ToUserName><FromUserName><![CDATA["+requestMap.get("ToUserName")+"]]></FromUserName><CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好,很高心为你服务]]></Content></xml>";
        PrintWriter out = response.getWriter();
        out.print(respXml);
        out.flush();
        out.close();
    }
}