package org.lanqiao.mvc.Util;

import org.lanqiao.mvc.pojo.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 类名: MenuManager </br>
 * 描述:菜单管理器类 </br>
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wxf971c6b73396cde4";
        // 第三方用户唯一凭证密钥
        String appSecret = "e16b32432b405a7882bd293170bc0056";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {



        ViewButton btn21 = new ViewButton();
        btn21.setName("开启体验");
        btn21.setType("view");
        btn21.setUrl("http://jinyyou.vipgz2.idcfengye.com");

        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
//
//        ComplexButton mainBtn1 = new ComplexButton();
//        mainBtn1.setName("开启体验");
//        //一级下有4个子菜单
//        mainBtn1.setSub_button(new ViewButton[] { btn21 });

        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
//        menu.setButton(new Button[] { mainBtn1 });
        menu.setButton(new Button[] { btn21 });


        return menu;
    }
}
