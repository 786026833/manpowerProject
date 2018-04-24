package com.iotek.biz;

import com.iotek.model.InterviewInvitation;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface InterviewInvitationService {
    int deleteById(InterviewInvitation interviewInvitation);
    int addInterviewInvitation(InterviewInvitation interviewInvitation);
    List<InterviewInvitation> selectAllInterviewInvitation(InterviewInvitation interviewInvitation);
    int updateById(InterviewInvitation interviewInvitation);
}
