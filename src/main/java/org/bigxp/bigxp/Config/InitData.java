package org.bigxp.bigxp.Config;

import org.bigxp.bigxp.Model.*;
import org.bigxp.bigxp.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LogIndRepository logIndRepository;

    @Autowired
    ShiftRepository shiftRepository;

    @Override
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setName("Bowling");
        a1.setPrice(150.0);
        a1.setDuration(90.0);
        a1.setLane(5);
        a1.setImg("https://oplevelser-i-koebenhavn.dk/wp-content/uploads/2025/03/483910774_1185013790299971_8747905315546713637_n.jpg");
        activityRepository.save(a1);

        Activity a2 = new Activity();
        a2.setName("Air hockey");
        a2.setPrice(50.0);
        a2.setDuration(30.0);
        a2.setLane(1);
        a2.setImg("https://as1.ftcdn.net/v2/jpg/01/29/46/04/1000_F_129460406_WEmBjX8QYACyzeCeAbhtu5iRS3JfbjVy.jpg");
        activityRepository.save(a2);

        Booking b1 = new Booking();
        b1.setName("Bushra");
        b1.setEmail("Bushra200@gmail.com");
        b1.setTelefon(6836382);
        b1.setActivity(a1);

        Booking b2 = new Booking();
        b2.setName("Ali");
        b2.setEmail("ali123@gmail.com");
        b2.setTelefon(12345678);
        b2.setActivity(a1);

        Booking b3 = new Booking();
        b3.setName("Sara");
        b3.setEmail("sara@email.com");
        b3.setTelefon(87654321);
        b3.setActivity(a1);

        Booking b4 = new Booking();
        b4.setName("Hanan");
        b4.setEmail("hanan@kode.dk");
        b4.setTelefon(99887766);
        b4.setActivity(a2);

        Booking b5 = new Booking();
        b5.setName("Omar");
        b5.setEmail("omar@eksample.com");
        b5.setTelefon(44556677);
        b5.setActivity(a2);

        bookingRepository.saveAll(List.of(b1, b2, b3, b4, b5));

        Employee e1 = new Employee();
        e1.setEmployeeName("Khadija");
        e1.setEmployeeAdress("Bellahøj 26 2.th");
        e1.setEmployeePhone("6382648");
        e1.setEmployeeEmail("khadija2100@outlook.com");

        Employee e2 = new Employee();
        e2.setEmployeeName("Ali");
        e2.setEmployeeAdress("Nørrebro 55, 1.sal");
        e2.setEmployeePhone("12345678");
        e2.setEmployeeEmail("ali@gmail.com");

        Employee e3 = new Employee();
        e3.setEmployeeName("Fatima");
        e3.setEmployeeAdress("Frederiksberg Alle 14");
        e3.setEmployeePhone("87654321");
        e3.setEmployeeEmail("fatima@mail.com");

        Employee e4 = new Employee();
        e4.setEmployeeName("Omar");
        e4.setEmployeeAdress("Valby Langgade 12");
        e4.setEmployeePhone("23456789");
        e4.setEmployeeEmail("omar@live.dk");

        Employee e5 = new Employee();
        e5.setEmployeeName("Laila");
        e5.setEmployeeAdress("Brønshøjvej 66");
        e5.setEmployeePhone("34567890");
        e5.setEmployeeEmail("laila@work.dk");

        Employee e6 = new Employee();
        e6.setEmployeeName("Hassan");
        e6.setEmployeeAdress("Islands Brygge 40");
        e6.setEmployeePhone("45678901");
        e6.setEmployeeEmail("hassan@firma.dk");

        Employee e7 = new Employee();
        e7.setEmployeeName("Yasmin");
        e7.setEmployeeAdress("Glostrupvej 7");
        e7.setEmployeePhone("56789012");
        e7.setEmployeeEmail("yasmin@studie.dk");

        Employee e8 = new Employee();
        e8.setEmployeeName("Bilal");
        e8.setEmployeeAdress("Amagerbrogade 88");
        e8.setEmployeePhone("67890123");
        e8.setEmployeeEmail("bilal@job.dk");

        Employee e9 = new Employee();
        e9.setEmployeeName("Nadia");
        e9.setEmployeeAdress("Østerbrogade 99");
        e9.setEmployeePhone("78901234");
        e9.setEmployeeEmail("nadia@outlook.com");

        Employee e10 = new Employee();
        e10.setEmployeeName("Zain");
        e10.setEmployeeAdress("Herlev Hovedgade 2");
        e10.setEmployeePhone("89012345");
        e10.setEmployeeEmail("zain@eksempel.dk");

        employeeRepository.saveAll(List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));

        LogInd l1 = new LogInd();
        l1.setUsername("User123");
        l1.setPassword("Kode123");

        LogInd l2 = new LogInd();
        l2.setUsername("admine62");
        l2.setPassword("123");

        logIndRepository.saveAll(List.of(l1, l2));

        generateWeeklyShifts();
    }

    public void generateWeeklyShifts() {
        List<Employee> instructors = employeeRepository.findAll();
        List<Activity> activities = activityRepository.findAll();

        int instructorIndex = 0;

        LocalDate startDate = LocalDate.now().with(DayOfWeek.MONDAY);

        for (int i = 0; i < 5; i++) {
            LocalDate shiftDate = startDate.plusDays(i);

            for (Activity activity : activities) {
                Employee assignedEmployee = instructors.get(instructorIndex);

                Shift shift = new Shift();
                shift.setDate(shiftDate);
                shift.setActivity(activity);
                shift.setEmployee(assignedEmployee);

                shiftRepository.save(shift);

                instructorIndex = (instructorIndex + 1) % instructors.size();
            }
        }
    }
}

