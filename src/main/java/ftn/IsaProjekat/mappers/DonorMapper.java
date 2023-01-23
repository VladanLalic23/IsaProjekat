package ftn.IsaProjekat.mappers;

import ftn.IsaProjekat.dto.DonorDTO;
import ftn.IsaProjekat.dto.DonorProfileDTO;
import ftn.IsaProjekat.dto.UserRegistrationDTO;
import ftn.IsaProjekat.model.users.Address;
import ftn.IsaProjekat.model.users.Donor;
import ftn.IsaProjekat.model.users.Role;

public class DonorMapper {

    public static DonorDTO donorToDonorDTO(Donor donor) {
		return new DonorDTO(donor);
	}


    

    public static void createDonorFromRegistrationDTO(UserRegistrationDTO userRegistrationDTO, Donor donor) {
		donor.setEmail(userRegistrationDTO.getEmail());
		donor.setPassword(userRegistrationDTO.getPassword());
		donor.setName(userRegistrationDTO.getName());
		donor.setSurname(userRegistrationDTO.getSurname());
		donor.setAddress(new Address(userRegistrationDTO.getCountry(), userRegistrationDTO.getCity(),userRegistrationDTO.getPostalCode(),userRegistrationDTO.getStreetNumber(),userRegistrationDTO.getFlatNumber(),userRegistrationDTO.getStreetName()));
		donor.setPhone(userRegistrationDTO.getPhone());
		donor.setRole(Role.ROLE_DONOR);
		donor.setIsActivated(false);
		donor.setGender(userRegistrationDTO.getGender());
        donor.setJmbg(userRegistrationDTO.getjmbg());
        donor.setInfo(userRegistrationDTO.getInfo());
        donor.setProfession(userRegistrationDTO.getProfession());
	}

	public static DonorProfileDTO createDonorFromDonorProfileDTO(Donor donor) {
		return new DonorProfileDTO(donor);
	}
    
}
