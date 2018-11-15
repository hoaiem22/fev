package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.EventBiz;
import fev.management.entity.FevEvent;
import fev.management.entity.FevMember;
import fev.management.repository.EventRepository;
import fev.management.repository.MemberRepository;

@Service
public class EventBizImpl implements EventBiz{

    @Autowired
    EventRepository eventRepository;
    
    @Autowired
    MemberRepository memberRepository;
    
    @Override
    public boolean updateData(Iterable<FevEvent> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        FevMember member;
        for (FevEvent event : list) {
            if(event != null && event.getLeader().getId() == null) {
                member = memberRepository.findByFullname(event.getLeader().getFullname());
                event.setLeader(member);
            }
        }
        
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                eventRepository.deleteById(deleteId);
            });
        }

        eventRepository.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevEvent, Integer> getRepo() {
        // TODO Auto-generated method stub
        return eventRepository;
    }

}
