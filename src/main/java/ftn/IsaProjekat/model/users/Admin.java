package ftn.IsaProjekat.model.users;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "systemAdministrators")
public class Admin extends User {


	public Admin() {
    }
}
