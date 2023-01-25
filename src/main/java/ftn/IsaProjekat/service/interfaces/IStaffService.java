package ftn.IsaProjekat.service.interfaces;

import java.util.Set;

import ftn.IsaProjekat.dto.StaffDTO;
import ftn.IsaProjekat.model.users.Staff;

public interface IStaffService {

    Staff findById(long id);

    Set<StaffDTO> findAllByClinic(Long id);
}
