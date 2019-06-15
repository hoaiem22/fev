package fev.management.controller;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.entity.FevVoteKey;
import fev.management.repository.VoteKeyRepository;

@Controller
public class VoteKeyController {

	/** For logging. */
	private final static Logger LOG = LoggerFactory.getLogger(VoteKeyController.class);

	@Autowired
	VoteKeyRepository vkRepository;
	
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
}
