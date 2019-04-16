package com.org.graduactionproject.commons;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    /*
     * 发送邮件工具类
     * @to 收件人  code 激活码
     */
    public static void sendMail(String to,String notice) throws MessagingException{
        /*
         * 1、获得一个session对象
         * 2、创建一个邮件对象message
         * 3、发送 Transport        *
         */
        //1、创建连接对象 sender
        Properties props=new Properties();
        props.put("mail.host","smtp.163.com" );
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", true);
        //1.创建sesssion
        Session session=Session.getInstance(props);
        //开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(true);


        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport ts=session.getTransport();
        //3.通过邮件用户名密码链接
        ts.connect("tonghangtingke", "dong1234");

        //2、创建邮件对象 message
        Message message=new MimeMessage(session);
        try
        {
            //设置发件人
            message.setFrom(new InternetAddress("tonghangtingke@163.com"));
            //设置收件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置抄送人
            message.setRecipient(Message.RecipientType.CC, new InternetAddress("tonghangtingke@163.com"));
            //设置标题
            message.setSubject("信息通知邮件");
            //设置正文
            message.setContent("<h1>点击下面链接查看</h1><h3><a href='地址未弄'>"+notice+"</a></h3>","text/html;charset=UTF-8");
            //发送邮件
            ts.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
