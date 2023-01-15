package ftn.IsaProjekat.service.interfaces;

import ftn.IsaProjekat.dto.UserRegistrationDTO;

public interface DonorInterface {

    String registerDonor(UserRegistrationDTO userRegistrationDTO);
    void activateDonorAccount(Long userId);


    
}
