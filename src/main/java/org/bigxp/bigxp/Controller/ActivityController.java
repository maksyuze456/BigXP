package org.bigxp.bigxp.Controller;

import org.bigxp.bigxp.Model.Activity;
import org.bigxp.bigxp.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Activity
@CrossOrigin(origins = "*")
@RestController
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/activites")
    public ResponseEntity<List<Activity>> getActivities() {
        return new ResponseEntity<List<Activity>>(activityRepository.findAll(), HttpStatus.OK);
    }

}
