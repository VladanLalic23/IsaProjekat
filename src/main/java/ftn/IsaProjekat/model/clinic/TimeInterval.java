package ftn.IsaProjekat.model.clinic;

import java.sql.Date;

import javax.persistence.Embeddable;

@Embeddable
public class TimeInterval {

	private Date startTime;
	private Date endTime;
   
	public TimeInterval() {
		
	}
   
	public TimeInterval(Date startTime, Date endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Boolean Overlaps(Date startTime, Date endTime)
    {
        if (startTime == null || endTime == null)
            return false;
        if (this.endTime.compareTo(startTime) <= 0)
            return false;
        if (endTime.compareTo(this.startTime) <= 0)
            return false;
        return true;
    }

    public Boolean Contains(Date startTime, Date endTime)
    {
        if (startTime == null || endTime == null)
            return false;
        return this.startTime.compareTo(startTime) <= 0 && this.endTime.compareTo(endTime) >= 0;
    }

}
