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

import fev.management.biz.MemberStatusBiz;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevMemberStatus;
import fev.management.model.MemberPositionModel;
import fev.management.model.MemberStatusModel;
import fev.management.repository.MemberStatusRepository;
import fev.management.util.AppUtil;

@Controller
public class MemberStatusController {
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(MemberStatusController.class);
    
    @Autowired
    MemberStatusRepository memStaRepo;
    
    @Autowired
    MemberStatusBiz memStaBiz;
    
    @GetMapping("/management/member/status")
    public String memberStatus() {
        return "management/member_status";
    }

    @GetMapping("/management/member/status/loadHand")
    @ResponseBody
    public List<FevMemberStatus> loadData() {
        LOG.info("Data: " );
        return (List<FevMemberStatus>) memStaRepo.findAll();
    }
    
    @PostMapping("/management/member/status/saveMemberStatus")
    @ResponseBody
    public List<FevMemberStatus> saveMemberStatus(@Valid @RequestBody MemberStatusModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevMemberStatus> entities = AppUtil.parseMemberStatus(data);

            memStaBiz.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevMemberStatus> memberPoss = (List<FevMemberStatus>) memStaRepo.findAll();

        return memberPoss;

    }
}
