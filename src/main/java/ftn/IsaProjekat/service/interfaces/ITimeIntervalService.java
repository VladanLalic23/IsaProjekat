package ftn.IsaProjekat.service.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ftn.IsaProjekat.model.clinic.TimeInterval;

public interface ITimeIntervalService {
    
    
    Date formatDate(Date date);
	boolean checkAvailability(Date startAppointment, Date endAppointment, Date startInterval, Date endInterval);
    //Set<TimeInterval> createTimeIntervals(List<Date> startDates, List<Date> endDates);

    
}
