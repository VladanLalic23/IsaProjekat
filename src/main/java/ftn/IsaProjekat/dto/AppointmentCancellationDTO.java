package ftn.IsaProjekat.dto;

public class AppointmentCancellationDTO {
	private Long donorId;
	private Long appointmentId;
	
	public AppointmentCancellationDTO () {
		
	}
	
	public AppointmentCancellationDTO(Long donorId, Long appointmentId) {
		super();
		this.donorId = donorId;
		this.appointmentId = appointmentId;
	}

	public Long getDonorId() {
		return this.donorId;
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