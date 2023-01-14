package ftn.IsaProjekat.model.users;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="admin")

public class Admin extends User {
    private static final long serialVersionUID = 1L;

	public Admin() {
    }
}
