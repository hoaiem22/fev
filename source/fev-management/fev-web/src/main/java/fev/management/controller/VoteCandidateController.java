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
public class VoteCandidateController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(VoteCandidateController.class);

}
