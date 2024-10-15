package com.boxproject.backend.Services;

import com.boxproject.backend.Entities.Activity;
import com.boxproject.backend.Entities.ActivityRequest;
import com.boxproject.backend.Exceptions.ActivityNotFoundException;
import com.boxproject.backend.Repos.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getall() {
        return activityRepository.findAll();
    }

    public List<String> getallcities() {
        return activityRepository.listofcities();
    }

    public Optional<Activity> getBYId(Integer id) throws ActivityNotFoundException {
        Optional<Activity> activity = activityRepository.findById(id);

        if (activity.isPresent())
            return activity;
        else {
            throw new ActivityNotFoundException("activity not found with id : " + id);
        }
    }

    public List<Activity> findBycityname(String cityname) throws ActivityNotFoundException {
        List<Activity> activityList = activityRepository.findByNameContaining(cityname);
        if (activityList.size() != 0)
            return activityList;
        else {
            throw new ActivityNotFoundException("activity not found with city : " + cityname);
        }
    }

    public Activity saveActivity(ActivityRequest actReq) {
        Activity activity = Activity.build(0, actReq.getActivity_name(), actReq.getActivity_city(),
                actReq.getActivity_address(), actReq.getActivity_state(), actReq.getActivity_price(),
                actReq.getActivity_rating(), actReq.getActivity_owner_name(), actReq.getActivity_ownwer_mobile(),
                actReq.getActivity_owner_address(), actReq.getSlots());
        return activityRepository.save(activity);
    }

    public Activity editActivity(Activity act) throws ActivityNotFoundException {
        int id = act.getActivity_id();
        Boolean activityID = activityRepository.existsById(id);
        if (activityID) {
            Activity activity = activityRepository.save(act);
            return activity;
        } else {
            throw new ActivityNotFoundException("activity not found with id : " + id);
        }

    }

    public List<String> getallactivitiesinCity(String Cityname) throws ActivityNotFoundException {
        List<String> cities = activityRepository.listofcities();
        if (cities.contains(Cityname)) {
            List<String> activitiesinCity = activityRepository.activitiesinCity(Cityname);
            return activitiesinCity;
        } else {
            throw new ActivityNotFoundException("no Activities found in the city You looking for");
        }
    }

    public String deleteActivityById(Integer id) throws ActivityNotFoundException {
        Boolean isActivityExixt = activityRepository.existsById(id);
        if (isActivityExixt) {
            activityRepository.deleteById(id);
            return "Activity deleted Successfully";
        } else {
            throw new ActivityNotFoundException("No activity found with id :" + id);
        }
    }
}
