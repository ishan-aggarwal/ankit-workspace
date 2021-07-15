package assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository repository;

    public void createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = createAppointmentFromRequest(appointmentDTO);
        repository.save(appointment);
    }

    private Appointment createAppointmentFromRequest(AppointmentDTO appointmentDTO) {
        return new Appointment();
    }

    public Iterable<Appointment> getAppointments() {
        Iterable<Appointment> all = repository.findAll();
        return all;
    }

}

