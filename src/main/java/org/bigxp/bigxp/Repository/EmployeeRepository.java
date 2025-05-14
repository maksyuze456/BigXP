package org.bigxp.bigxp.Repository;

import org.bigxp.bigxp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
