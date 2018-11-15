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
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.biz.impl.MemberBizImpl;
import fev.management.dto.MemberCast;
import fev.management.entity.FevMember;
import fev.management.model.MemberModel;
import fev.management.repository.MemberRepository;
import fev.management.util.AppUtil;

@Controller
public class MemberController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberRepository memberRepo;

    @Autowired
    MemberBizImpl memberBizImpl;
    
    @GetMapping("/management/member")
    public String member() {
        return "management/member";
    }

    @GetMapping("/management/member/loadHand")
    @ResponseBody
    public List<MemberCast> loadData() {
        LOG.info("Data: ");
        List<Object[]> list = memberRepo.getAll();
        List<MemberCast> listMember = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String fullname = (String) objects[1];
            String studentID = String.valueOf(objects[2]);
            Date birthdate = (Date) objects[3];
            String sex = (String) objects[4];
            String address = (String) objects[5];
            String phone = (String) objects[6];
            String position = (String) objects[7];
            String status = (String) objects[8];
            int point = (int) objects[9];
            String note = (String) objects[10];
            listMember.add(new MemberCast(id, fullname, studentID, birthdate, sex, address, phone, point, note, 
                    position, status));
        }

        return (List<MemberCast>) listMember;
    }
    
    @PostMapping("/management/event/saveMember")
    @ResponseBody
    public List<FevMember> saveTeam(@Valid @RequestBody MemberModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevMember> entities = AppUtil.parseMember(data);

            memberBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevMember> member = (List<FevMember>) memberRepo.findAll();

        return member;

    }
}
