package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.EventMemberBiz;
import fev.management.entity.FevEvent;
import fev.management.entity.FevEventMember;
import fev.management.entity.FevMember;
import fev.management.repository.EventMemberRepository;
import fev.management.repository.EventRepository;
import fev.management.repository.MemberRepository;

@Service
public class EventMemberBizImpl implements EventMemberBiz {

    @Autowired
    EventMemberRepository eventMemRepo;

    @Autowired
    EventRepository eventRepo;

    @Autowired
    MemberRepository memberRepo;

    @Override
    public boolean updateData(Iterable<FevEventMember> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        FevEvent fevEvent;
        FevMember fevMember;
        
        for (FevEventMember fevEventMember : list) {
            // If event just have name, then update event
            if (fevEventMember.getEvent() != null && fevEventMember.getEvent().getId() == null) {
                fevEvent = eventRepo.findByName(fevEventMember.getEvent().getName());
                fevEventMember.setEvent(fevEvent);
            }

            // If member just have fullname, then update fullname
            if (fevEventMember.getMember1() != null && fevEventMember.getMember1().getId() == null) {
                fevMember = memberRepo.findByFullname(fevEventMember.getMember1().getFullname());
                fevEventMember.setMember1(fevMember);
            }
        }
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                eventMemRepo.deleteById(deleteId);
            });
        }

        eventMemRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevEventMember, Integer> getRepo() {
        // TODO Auto-generated method stub
        return eventMemRepo;
    }

}
