package ftn.IsaProjekat.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import ftn.IsaProjekat.service.interfaces.ITimeIntervalService;


@Service
public class TimeIntervalService implements ITimeIntervalService{
    


    @Override
	public boolean checkAvailability(Date startAppointment, Date endAppointment, Date startInterval, Date endInterval) {
		boolean available = true;
		if(startAppointment.after(startInterval) && startAppointment.before(endInterval)){
			available = false;
		}else if(endAppointment.after(startInterval) && endAppointment.before(endInterval)) {
			available = false;
		}else if(startAppointment.equals(startInterval) || endAppointment.equals(endInterval)) {
			available = false;
		}else if(startAppointment.before(startInterval) && endAppointment.after(endInterval)) {
			available = false;
		}	
		return available;
	}
    @Override
    public Date formatDate(Date date) {
		String pattern = "yyyy-MM-dd HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//System.out.println("Date: "+date.toString());
		String formatedDateString = simpleDateFormat.format(date);
		Date formatedDate = new Date();
		try {
			formatedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(formatedDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return formatedDate;
	}

}
