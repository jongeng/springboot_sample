import com.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@SpringApplicationConfiguration(classes = Application.class)
public class EmailTest {

@Autowired
private JavaMailSender mailSender;

/**
 * 修改application.properties的用户，才能发送。
 */
@Test
public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("958082306@qq.com");//发送者.
        message.setTo("gengjiong@youbanganda.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
        }

  /**
  * title:
  * param:
  * describe: TODO
  * @return :
  * @date: 2017/8/14 18:00
  **/
    @Test
    public void sendAttachmentsEmail() throws MessagingException {
        //这个是javax.mail.internet.MimeMessage下的，不要搞错了。
        MimeMessage mimeMessage =  mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //基本设置.
        helper.setFrom("412887952@qq.com");//发送者.
        helper.setTo("1473773560@qq.com");//接收者.
        helper.setSubject("测试附件（邮件主题）");//邮件主题.
        helper.setText("这是邮件内容（有附件哦.）");//邮件内容.

        //org.springframework.core.io.FileSystemResource下的:
        //附件1,获取文件对象.
        FileSystemResource file1 = new FileSystemResource(new File("D:/test/head/head1.jpg"));
        //添加附件，这里第一个参数是在邮件中显示的名称，也可以直接是head.jpg，但是一定要有文件后缀，不然就无法显示图片了。
        helper.addAttachment("头像1.jpg", file1);
        //附件2
        FileSystemResource file2 = new FileSystemResource(new File("D:/test/head/head2.jpg"));
        helper.addAttachment("头像2.jpg", file2);

        mailSender.send(mimeMessage);
    }
}
