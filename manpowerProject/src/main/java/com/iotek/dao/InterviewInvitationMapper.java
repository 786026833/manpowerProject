package com.iotek.dao;

import com.iotek.model.InterviewInvitation;

import java.util.List;

public interface InterviewInvitationMapper {
    int deleteById(InterviewInvitation interviewInvitation);
    int addInterviewInvitation(InterviewInvitation interviewInvitation);
    List<InterviewInvitation> selectAllInterviewInvitation(InterviewInvitation interviewInvitation);
    int updateById(InterviewInvitation interviewInvitation);
}