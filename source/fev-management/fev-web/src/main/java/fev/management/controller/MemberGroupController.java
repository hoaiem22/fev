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
public class MemberGroupController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(MemberGroupController.class);
    
    @GetMapping("/management/member/group")
    public String get() {
        return "management/member_group";
    }
}
