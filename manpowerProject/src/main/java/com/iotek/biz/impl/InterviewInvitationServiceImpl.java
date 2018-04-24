package com.iotek.biz.impl;

import com.iotek.biz.InterviewInvitationService;
import com.iotek.dao.InterviewInvitationMapper;
import com.iotek.model.InterviewInvitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
@Service
public class InterviewInvitationServiceImpl implements InterviewInvitationService {
@Autowired
    private InterviewInvitationMapper iim;

    @Override
    public int deleteById(InterviewInvitation interviewInvitation) {
        return iim.deleteById(interviewInvitation);
    }

    @Override
    public int addInterviewInvitation(InterviewInvitation interviewInvitation) {
        return iim.addInterviewInvitation(interviewInvitation);
    }

    @Override
    public List<InterviewInvitation> selectAllInterviewInvitation(InterviewInvitation interviewInvitation) {
        return iim.selectAllInterviewInvitation(interviewInvitation);
    }

    @Override
    public int updateById(InterviewInvitation interviewInvitation) {
        return iim.updateById(interviewInvitation);
    }
}
