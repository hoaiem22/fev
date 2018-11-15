package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevEventAlbum;

public interface EventAlbumBiz {
    boolean updateData(Iterable<FevEventAlbum> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevEventAlbum, Integer> getRepo();
}
