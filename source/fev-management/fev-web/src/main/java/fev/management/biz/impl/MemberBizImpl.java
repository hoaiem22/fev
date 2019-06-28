package fev.management.biz.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fev.management.biz.MemberBiz;
import fev.management.entity.FevMember;
import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevMemberStatus;
import fev.management.repository.MemberGroupRepository;
import fev.management.repository.MemberPositionRepository;
import fev.management.repository.MemberRepository;
import fev.management.repository.MemberStatusRepository;

@Service
public class MemberBizImpl implements MemberBiz{

    @Autowired
    MemberRepository memberRepository;
    
    @Autowired
    MemberPositionRepository memPosRepository;
    
    @Autowired
    MemberStatusRepository memStaRepository;
    
    @Autowired
    MemberGroupRepository memGrRepository;
    
    @Override
    public boolean updateData(Iterable<FevMember> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        FevMemberPosition memberPostion;
        FevMemberStatus memberStatus;
        FevMemberGroup memberGroup;
        // Get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username
    	
        for (FevMember fevMember : list) {
            if(fevMember.getPosition() != null && fevMember.getPosition().getPosition() != null) {
                memberPostion = memPosRepository.findByPosition(fevMember.getPosition().getPosition());
                fevMember.setPosition(memberPostion);
            }
            if(fevMember.getStatus() != null && fevMember.getStatus().getStatus() != null) {
                memberStatus = memStaRepository.findByStatus(fevMember.getStatus().getStatus());
                fevMember.setStatus(memberStatus);
            }
            if(fevMember.getGroup1() != null && fevMember.getGroup1().getGroup() != null) {
            	memberGroup = memGrRepository.findByGroup(fevMember.getGroup1().getGroup());
                fevMember.setGroup1(memberGroup);
            }
            fevMember.setLastmodifiedbyUsername(username);
            fevMember.setLastmodified(new Date());
        }
        
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                memberRepository.deleteById(deleteId);
            });
        }

        memberRepository.saveAll(list);
        
        return false;
    }

    @Override
    public CrudRepository<FevMember, Integer> getRepo() {
        // TODO Auto-generated method stub
        return memberRepository;
    }
    
    public boolean updateMember(Iterable<FevMember> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        FevMemberPosition memberPostion;
        FevMemberStatus memberStatus;
        FevMemberGroup memberGroup;
        for (FevMember fevMember : list) {
            if(fevMember.getPosition() != null && fevMember.getPosition().getPosition() != null) {
                memberPostion = memPosRepository.findByPosition(fevMember.getPosition().getPosition());
                fevMember.setPosition(memberPostion);
            }
            if(fevMember.getStatus() != null && fevMember.getStatus().getStatus() != null) {
                memberStatus = memStaRepository.findByStatus(fevMember.getStatus().getStatus());
                fevMember.setStatus(memberStatus);
            }
            if(fevMember.getGroup1() != null && fevMember.getGroup1().getGroup() != null) {
            	memberGroup = memGrRepository.findByGroup(fevMember.getGroup1().getGroup());
                fevMember.setGroup1(memberGroup);
            }
            
        }
        
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                memberRepository.deleteById(deleteId);
            });
        }

        memberRepository.saveAll(list);
        
        return false;
    }

}
