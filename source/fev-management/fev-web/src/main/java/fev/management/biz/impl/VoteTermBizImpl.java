package fev.management.biz.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fev.management.biz.VoteTermBiz;
import fev.management.entity.FevVoteTerm;
import fev.management.repository.VoteTermRepository;

@Service
public class VoteTermBizImpl implements VoteTermBiz {

	@Autowired
	VoteTermRepository voteTermRepo;

	@Override
	public boolean updateData(Iterable<FevVoteTerm> list, List<Integer> tobeDeletedIds) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		for (FevVoteTerm term : list) {
			term.setName(term.getTerm() + " " + term.getYear());
			term.setLastmodifiedbyUsername(username);
			term.setLastmodified(new Date());
		}
		if (tobeDeletedIds != null) {
			tobeDeletedIds.forEach(deleteId -> {
				voteTermRepo.deleteById(deleteId);
			});
		}
		voteTermRepo.saveAll(list);

		return true;
	}

	@Override
	public CrudRepository<FevVoteTerm, Integer> getRepo() {
		// TODO Auto-generated method stub
		return voteTermRepo;
	}

}
