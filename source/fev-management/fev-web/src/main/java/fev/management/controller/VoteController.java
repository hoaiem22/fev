package fev.management.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fev.management.biz.impl.MemberBizImpl;
import fev.management.dto.MemberCast;
import fev.management.entity.FevMember;
import fev.management.entity.FevVote;
import fev.management.entity.FevVoteKey;
import fev.management.model.MemberModel;
import fev.management.model.crud.FevCandidateLoad;
import fev.management.model.crud.FevVoteSend;
import fev.management.repository.MemberRepository;
import fev.management.repository.VoteCandidateRepository;
import fev.management.repository.VoteKeyRepository;
import fev.management.repository.VoteRepository;
import fev.management.util.AppUtil;

@Controller
public class VoteController {

	/** For logging. */
	private final static Logger LOG = LoggerFactory.getLogger(VoteController.class);

	@Autowired
	MemberRepository memberRepo;
	
	@Autowired 
	VoteKeyRepository voteKeyRepo;
	
	@Autowired
	VoteRepository voteRepo;
	
	@Autowired
	VoteCandidateRepository voteCandidateRepo;
	
	@GetMapping("/management/vote")
    public String get() {
        return "management/vote";
    }
	
	@PostMapping("/management/vote/sendVote")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> sendVote(@Valid @RequestBody FevVoteSend data, Errors errors,
			HttpServletRequest request) {
		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {
			LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
		}
		if(data.getKey().isEmpty()) {
			LOG.info("No key found");
			return new ResponseEntity<>("No key found", HttpStatus.ACCEPTED);
		}
		//Check if key and priority is not match
		FevVoteKey key = voteKeyRepo.findByName(data.getKey());
		if(key.getPriority() != data.getPriority()) {
			return new ResponseEntity<>("Key and priority not match:[" +  data.getKey() + " - " + data.getPriority()+ "]", HttpStatus.ACCEPTED);
		}
		//End check match
		//Validate success
		String msgSuccess = "Success: ";
		int used = 0;
		LOG.info(data.getKey() + " | " + data.getPriority() + " | " + data.getCandidateIDs());
		int i = 1;
		int position = 4;
		for (int id : data.getCandidateIDs()) {
			LOG.info("Id: " + id);
			FevVote vote = new FevVote();
			if(id > 0) {
				FevMember candidate = memberRepo.findByID(id);
				vote.setCandidate(candidate);
				vote.setKey(key);
				//Save Key
				voteRepo.save(vote);
				used++;
			}
			//Update unActive key and number of vote used
			LOG.info("Key: " + key.getId());
			voteKeyRepo.updateKey(key.getId(), 0, used);
			//Update candidate total
			LOG.info("" + id + data.getPriority() + i + position);
			voteCandidateRepo.updateTotal(id, data.getPriority(), i++, position);
		}
		return new ResponseEntity<>(msgSuccess + used, HttpStatus.OK);

	}
}
