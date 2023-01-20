package ftn.IsaProjekat.dto;

public class ScheduleAppointmentDTO {
	private Long donorId;
	private Long appointmentId;
	
	public ScheduleAppointmentDTO() {
		
	}
	
	public ScheduleAppointmentDTO(Long donorId, Long appointmentId) {
		this.donorId = donorId;
		this.appointmentId = appointmentId;
	}
	public Long getDonorId() {
		return donorId;
	}
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
}