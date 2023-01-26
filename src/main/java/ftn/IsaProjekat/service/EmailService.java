package ftn.IsaProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.AppointmentSchedulingEmailDTO;
import ftn.IsaProjekat.dto.ComplaintEmailDTO;
import ftn.IsaProjekat.dto.UserRegistrationDTO;

@Service
public class EmailService {

    @Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment environment;
	

	
	@Async
	public void sendConfirmationEmail(UserRegistrationDTO userRegistrationDTO, long userId) {
		System.out.println("SENDING EMAIL...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userRegistrationDTO.getEmail());
		message.setFrom(environment.getProperty("spring.mail.username"));
		message.setSubject("Aktivacija racuna");
		message.setText("Hello " + userRegistrationDTO.getName() + ", please activate " +
						"your account by visiting this link: " + environment.getProperty("APP_SERVER") + "/auth/activate/" + String.valueOf(userId));
		javaMailSender.send(message);
		System.out.println("Poslao sam mejl!");
	}


	@Async
	public void sendAppointmentScheduledNotification(AppointmentSchedulingEmailDTO appointmentSchedulingEmailDTO) {
		System.out.println("SENDING EMAIL...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(appointmentSchedulingEmailDTO.getDonorEmail());
		message.setFrom(environment.getProperty("spring.mail.username"));
		message.setSubject("Appointment scheduling notification - Podrzi Zivot");
		message.setText("Hello , you have successfully " +
						"scheduled at: " + appointmentSchedulingEmailDTO.getClinicName() + ", "+ 
						appointmentSchedulingEmailDTO.getClinicAdress() + ". Appointment start time: " + appointmentSchedulingEmailDTO.getStartTime());
		javaMailSender.send(message);
		System.out.println("Poslao sam mejl!");
	}


	@Async
	public void sendAnswerNotification(ComplaintEmailDTO answerDTO) {
		System.out.println("SENDING EMAIL...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(answerDTO.getDonorEmail());
		message.setFrom(environment.getProperty("spring.mail.username"));
		message.setSubject("Complaint answer notification - Podrzi Zivot");
		message.setText(answerDTO.getAnswerText());
		javaMailSender.send(message);
		System.out.println("Poslao sam mejl!");
	}
    
}
