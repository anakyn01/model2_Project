package kyobo.kr.booksmall.controller;


import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kyobo.kr.booksmall.service.MemberService;
import kyobo.kr.booksmall.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService memberservice;
	
	@Autowired//���ϻ��� ������ ����
	private JavaMailSender mailSender;
	
	//ȸ������ ������ �̵�
	@GetMapping(value="join")
	public void joinGET() {
		logger.info("ȸ������ ������ ����");
	}
	//ȸ������ post
	@PostMapping(value="join")
	public String joinPOST(MemberVO member) throws Exception{
		logger.info("join ����");
		
		//ȸ������ ���� ����
		memberservice.memberJoin(member);
		logger.info("join Service ����");
		return "redirect:/main";
	}
	//���̵� �ߺ��˻�
	@PostMapping(value="/memberIdChk")
	@ResponseBody//�޼��带 ajax�� ��û�Ҷ� �ʼ��� ���� �մϴ�
	public String memberIdChkPOST(String memberId) throws Exception{
		logger.info("memberIdChk()����");
		
		int result = memberservice.idCheck(memberId);
		logger.info("����� = " + result);
		
		if(result != 0) {
			return "fail"; //�ߺ����̵� ����
		}else {
			return "success";
		}
	}
	
	//�̸��� ����
	@GetMapping(value="/mailCheck")
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		//��(view)�� ���� �Ѿ�� ������ Ȯ��
		logger.info("�̸��� ������ ����Ȯ��");
		logger.info("������ȣ : " + email);
		
		// ������ȣ (����) ����
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		//111111 ~ 999999 ������ ���ڸ� ��� ���� 
		logger.info("������ȣ " + checkNum);
		
		//�̸��� ������
		String setFrom = "anakyn@naver.com";
		String toMail = email;
		String title ="ȸ������ ���� �̸��� �Դϴ�";
		String content = "����Ʈ�� �湮�� �ּż� �����մϴ�"+"<br/>"+"������ȣ ��"+
		checkNum + "�Դϴ�." + "<br/>" +
		"�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		String num = Integer.toString(checkNum);
		return num;
	}
	
	
	//�α��� ������ �̵�
	@GetMapping(value="login")
	public void loginGET() {
		logger.info("�α��� ������ ����");
	}
}
