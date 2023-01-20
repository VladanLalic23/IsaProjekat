package ftn.IsaProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.model.users.Staff;
import ftn.IsaProjekat.repository.StaffRepository;
import ftn.IsaProjekat.service.interfaces.IStaffService;



@Service
public class StaffService implements IStaffService {

    @Autowired
    private StaffRepository staffRepository;



    @Override
	public Staff findById(long id) {
		return staffRepository.findById(id).orElse(null);
	}






    
}
