package nl.novi.michelle_dentro.service;

import java.util.Map;

public interface MemberOnExamDayService {

    public void signUpExamDayCoordinator(long examday_id, long member_id, Map<String, String> fields);
    public void signUpExamDayExaminator(long examday_id, long member_id, Map<String, String> fields);
    public void signUpExamDayStudent(long examday_id, long member_id, Map<String, String> fields);

}
