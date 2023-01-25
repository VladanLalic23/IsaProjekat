package ftn.IsaProjekat.mappers;

import ftn.IsaProjekat.dto.UserDTO;
import ftn.IsaProjekat.model.users.Address;
import ftn.IsaProjekat.model.users.User;

public class UserMapper {
    
    public static void UserDTOToExistingUser(UserDTO userDTO, User user) {
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setAddress(new Address(userDTO.getCountry(), userDTO.getCity(), userDTO.getPostalCode(), 
				userDTO.getStreetNumber(), userDTO.getFlatNumber(), userDTO.getStreetName()));
		user.setPhone(userDTO.getPhoneNumber());
	}

    public static UserDTO UserToUserDTO(User user) {
		return new UserDTO(user);
	}
}
