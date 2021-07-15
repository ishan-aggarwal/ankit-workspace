package assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService service;

    @GetMapping
    public ResponseEntity getAppointments() {
        Iterable<Appointment> appointments = service.getAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createAppointment(@RequestBody  AppointmentDTO appointmentDTO) {
        service.createAppointment(appointmentDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
