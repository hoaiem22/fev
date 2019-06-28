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

import fev.management.biz.impl.VoteTermBizImpl;
import fev.management.entity.FevVoteTerm;
import fev.management.model.crud.save.BaseModelSave;
import fev.management.model.crud.save.FevVoteTermSave;
import fev.management.repository.VoteTermRepository;

@Controller
public class VoteTermController {

	/** For logging. */
	private final static Logger LOG = LoggerFactory.getLogger(VoteTermController.class);
	private ModelMapper mapper = new ModelMapper();

	@Autowired
	VoteTermRepository vTRepository;

	@Autowired
	VoteTermBizImpl vTBizImpl;

	@GetMapping("/management/vote/term")
	public String get() {
		return "management/vote_term";
	}

	@GetMapping("/management/vote/term/loadData")
	@ResponseBody
	public Iterable<FevVoteTerm> loadData() {

		return vTRepository.findAll();
	}

	@PostMapping("/management/vote/term/saveEntity")
	@ResponseBody
	public List<FevVoteTerm> saveEntity(@Valid @RequestBody BaseModelSave<FevVoteTermSave> data, Errors errors,
			HttpServletRequest request) {
		LOG.info("Save Vote Term . . .");

		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {

			LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return null;
		} else {

			List<FevVoteTerm> terms = new ArrayList<FevVoteTerm>();
			FevVoteTermSave last = data.getData().get(data.getData().size() - 1);
			if (!last.isValid()) {
				LOG.info("Last is NULLL");
			}
			for (FevVoteTermSave term : data.getData()) {
				if (!term.isValid()) {
					LOG.info("Continue");
					continue;
				}
				terms.add(mapper.map(term, FevVoteTerm.class));
			}
			vTBizImpl.updateData(terms, data.getDeletedIds());
		}

		// Reload data from db
		List<FevVoteTerm> list = (List<FevVoteTerm>) vTBizImpl.getRepo().findAll();

		return list;
	}
}
