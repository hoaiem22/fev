package fev.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.biz.impl.VoteKeyBizImpl;
import fev.management.entity.FevVoteKey;
import fev.management.entity.FevVoteTerm;
import fev.management.model.crud.save.BaseModelSave;
import fev.management.model.crud.save.FevVoteKeySave;
import fev.management.model.crud.save.FevVoteTermSave;
import fev.management.repository.VoteKeyRepository;

@Controller
public class VoteKeyController {

	/** For logging. */
	private final static Logger LOG = LoggerFactory.getLogger(VoteKeyController.class);
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	VoteKeyRepository vkRepository;
	
	@Autowired
	VoteKeyBizImpl vkBizImpl;
	
	@GetMapping("/management/vote/key")
    public String get() {
        return "management/vote_key";
    }
	
	@PostMapping("/management/vote/key/check")
	@ResponseBody
	public FevVoteKey checkKey(@Valid @RequestBody String key, Errors errors) {
		LOG.info("Key: " + key);
		// If error, just return a 400 bad request, along with the error message
		FevVoteKey vKey = null;
		if (errors.hasErrors()) {
			LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return null;
		} else {
			vKey = vkRepository.findByName(key);
			LOG.info("vKey: " + vKey);
		}
		return vKey;
	}
	
	@GetMapping("/management/vote/key/loadData")
	@ResponseBody
	public Iterable<FevVoteKey> loadData() {

		return vkRepository.findAll();
	}

	@PostMapping("/management/vote/key/saveEntity")
	@ResponseBody
	public List<FevVoteKey> saveEntity(@Valid @RequestBody BaseModelSave<FevVoteKeySave> data, Errors errors,
			HttpServletRequest request) {
		LOG.info("Save Vote Key . . .");

		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {

			LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return null;
		} else {
			List<FevVoteKey> keys = new ArrayList<FevVoteKey>();
			for (FevVoteKeySave key : data.getData()) {
				if (!key.isValid()) {
					LOG.info("Continue");
					continue;
				}
				keys.add(mapper.map(key, FevVoteKey.class));
			}
			vkBizImpl.updateData(keys, data.getDeletedIds());
		}

		// Reload data from db
		List<FevVoteKey> list = (List<FevVoteKey>) vkBizImpl.getRepo().findAll();

		return list;
	}
}
