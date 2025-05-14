package org.bigxp.bigxp.Repository;

import org.bigxp.bigxp.Model.Employee;
import org.bigxp.bigxp.Model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
    List<Shift> findByEmployee(Employee employee);
}
