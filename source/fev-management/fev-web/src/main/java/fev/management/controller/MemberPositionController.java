package fev.management.controller;

import java.util.List;
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

import fev.management.biz.MemberPositionBiz;
import fev.management.entity.FevMemberPosition;
import fev.management.model.MemberPositionModel;
import fev.management.repository.MemberPositionRepository;
import fev.management.util.AppUtil;

@Controller
public class MemberPositionController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(MemberPositionController.class);
    
    @Autowired
    MemberPositionRepository memPosRepo;
    
    @Autowired
    MemberPositionBiz memPosBiz;
    
    @GetMapping("/management/member/position")
    public String account_role() {
        return "management/member_position";
    }

    @GetMapping("/management/member/position/loadHand")
    @ResponseBody
    public List<FevMemberPosition> loadData() {
        LOG.info("Data: " );
        return (List<FevMemberPosition>) memPosRepo.findAll();
    }
    
    @PostMapping("/management/member/position/saveMemberPosition")
    @ResponseBody
    public List<FevMemberPosition> saveTeam(@Valid @RequestBody MemberPositionModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevMemberPosition> entities = AppUtil.parseMemberPosition(data);

            memPosBiz.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevMemberPosition> memberPoss = (List<FevMemberPosition>) memPosRepo.findAll();

        return memberPoss;

    }
}
