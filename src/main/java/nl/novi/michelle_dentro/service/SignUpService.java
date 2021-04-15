package nl.novi.michelle_dentro.service;

import java.util.Map;

public interface SignUpService {

    public void signUpExamDayAsCoordinator(long examday_id, Map<String, String> fields);
    public void signUpExamDayAsExaminator(long examday_id, Map<String, String> fields);
    public void signUpExamDayAsStudent(long examday_id, Map<String, String> fields);

}
