package com.guttester.volts_manager.Repository;

import java.util.UUID;
import com.guttester.volts_manager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RUser extends JpaRepository<User, UUID> {

}
