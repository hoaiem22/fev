package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.EventAlbumBiz;
import fev.management.entity.FevEvent;
import fev.management.entity.FevEventAlbum;
import fev.management.repository.EventAlbumRepository;
import fev.management.repository.EventRepository;

@Service
public class EventAlbumBizImpl implements EventAlbumBiz{

    @Autowired
    EventAlbumRepository eventAlbumRepo;
    
    @Autowired
    EventRepository eventRepo;
    
    @Override
    public boolean updateData(Iterable<FevEventAlbum> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        //Update event in event album if it's null
        FevEvent fevEvent;
        for (FevEventAlbum fevEventAlbum : list) {
            if(fevEventAlbum.getEvent() != null && fevEventAlbum.getEvent().getId() == null) {
                fevEvent = eventRepo.findByName(fevEventAlbum.getEvent().getName());
                fevEventAlbum.setEvent(fevEvent);
            }
        }
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                eventAlbumRepo.deleteById(deleteId);
            });
        }
        eventAlbumRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevEventAlbum, Integer> getRepo() {
        // TODO Auto-generated method stub
        return eventAlbumRepo;
    }

}
