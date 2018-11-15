package fev.management.util;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.EffectiveSignatureAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import fev.management.entity.FevAccount;
import fev.management.entity.FevAccountRole;
import fev.management.entity.FevEvent;
import fev.management.entity.FevEventAlbum;
import fev.management.entity.FevEventMember;
import fev.management.entity.FevInventoryItem;
import fev.management.entity.FevInventoryStatus;
import fev.management.entity.FevMember;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevMemberStatus;
import fev.management.model.AccountModel;
import fev.management.model.AccountRoleModel;
import fev.management.model.EventAlbumModel;
import fev.management.model.EventMemberModel;
import fev.management.model.EventModel;
import fev.management.model.InventoryItemModel;
import fev.management.model.InventoryStatusModel;
import fev.management.model.MemberModel;
import fev.management.model.MemberPositionModel;
import fev.management.model.MemberStatusModel;
import mksgroup.java.common.BeanUtil;

public class AppUtil {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(AppUtil.class);

    /** Flag to parse data from handsontable: avoid the empty row. */
    final static boolean SKIP_EMPTYROW = true;

    public static Iterable<FevAccountRole> parseAccountRole(AccountRoleModel data) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "role", "note"};

        LOG.info("role data=" + data.getData());
        List<FevAccountRole> accountRoleList = (List<FevAccountRole>) BeanUtil.getDataList(data.getData(), HEADERS,
                FevAccountRole.class, SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return accountRoleList;
    }

    public static Iterable<FevEvent> parseEvent(EventModel data) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "name", "{name: start, format: yyyy-MM-dd}", "{name: end, format: yyyy-MM-dd}",
                "{name: time, format: yyyy-MM-dd}", "place", "{name: leader, subName: fullname}", "note"};

        LOG.info("role data=" + data.getData());
        List<FevEvent> eventList = (List<FevEvent>) BeanUtil.getDataList(data.getData(), HEADERS, FevEvent.class,
                SKIP_EMPTYROW, "createdbyUsername", username, "created");
        for (FevEvent fevEvent : eventList) {
            if (fevEvent.getLeader() == null) {
                LOG.info("Leader: "
                        + (String) ((List<Object[]>) data.getData().get(eventList.indexOf(fevEvent))).toArray()[6]);
                FevMember member = new FevMember();
                member.setFullname(
                        (String) ((List<Object[]>) data.getData().get(eventList.indexOf(fevEvent))).toArray()[6]);
                fevEvent.setLeader(member);
            }
        }

        return eventList;
    }

    public static Iterable<FevMember> parseMember(MemberModel data) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "fullname", "studentID", "{name: birthdate, format: yyyy-MM-dd}", "sex", "address", "phone",
                "{name: position, subName: position}", "{name: status, subName: status}", "point", "note"};

        LOG.info("role data=" + data.getData());
        List<FevMember> memberList = (List<FevMember>) BeanUtil.getDataList(data.getData(), HEADERS, FevMember.class,
                SKIP_EMPTYROW, "createdbyUsername", username, "created");
        for (FevMember fevMember : memberList) {
            LOG.info("Log something");
            if (fevMember.getPosition() == null) {
                FevMemberPosition position = new FevMemberPosition();
                position.setPosition(
                        (String) ((List<Object[]>) data.getData().get(memberList.indexOf(fevMember))).toArray()[7]);
                fevMember.setPosition(position);
            }
            if (fevMember.getStatus() == null) {
                FevMemberStatus status = new FevMemberStatus();
                status.setStatus(
                        (String) ((List<Object[]>) data.getData().get(memberList.indexOf(fevMember))).toArray()[8]);
                fevMember.setStatus(status);
            }
            if (fevMember.getPoint() == 0) {
                LOG.info("Set point for " + fevMember.getId()
                        + ((List<Object[]>) data.getData().get(memberList.indexOf(fevMember))).toArray()[9]);
                int point = ((int) ((List<Object[]>) data.getData().get(memberList.indexOf(fevMember))).toArray()[9]);
                LOG.info("Point: " + point);
//                fevMember.setPoint();
            }
        }

        return memberList;
    }
    
    public static Iterable<FevMemberPosition> parseMemberPosition(MemberPositionModel data) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "position", "note"};

        LOG.info("role data=" + data.getData());
        List<FevMemberPosition> memPosList = (List<FevMemberPosition>) BeanUtil.getDataList(data.getData(), HEADERS,
                FevMemberPosition.class, SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return memPosList;
    }
    
    public static Iterable<FevMemberStatus> parseMemberStatus(MemberStatusModel data) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "status", "note"};

        LOG.info("role data=" + data.getData());
        List<FevMemberStatus> memStaList = (List<FevMemberStatus>) BeanUtil.getDataList(data.getData(), HEADERS,
                FevMemberStatus.class, SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return memStaList;
    }
    
    public static Iterable<FevAccount> parseAccount(AccountModel data) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "username", "password", "{name: role, subName: role}", "note"};

        LOG.info("role data=" + data.getData());
        List<FevAccount> accountList = (List<FevAccount>) BeanUtil.getDataList(data.getData(), HEADERS, FevAccount.class,
                 SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return accountList;
    }
    
    public static Iterable<FevEventAlbum> parseEventAlbum(EventAlbumModel data) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "{name: event, subName: name}", "img"};

        LOG.info("role data=" + data.getData());
        List<FevEventAlbum> eventAlbumList = (List<FevEventAlbum>) BeanUtil.getDataList(data.getData(), HEADERS, FevEventAlbum.class,
                 SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return eventAlbumList;
    }

    public static Iterable<FevEventMember> parseEventMember(EventMemberModel data) {
        // TODO Auto-generated method stub
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "{name: event, subName: name}","{name: member1, subName: fullname}", "note"};

        LOG.info("role data=" + data.getData());
        List<FevEventMember> eventMemberList = (List<FevEventMember>) BeanUtil.getDataList(data.getData(), HEADERS, FevEventMember.class,
                 SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return eventMemberList;
    }
    
    public static Iterable<FevInventoryStatus> parseInventoryStatus(InventoryStatusModel data) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "status", "note"};

        LOG.info("role data=" + data.getData());
        List<FevInventoryStatus> inventStatusList = (List<FevInventoryStatus>) BeanUtil.getDataList(data.getData(), HEADERS,
                FevInventoryStatus.class, SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return inventStatusList;
    }
    
    public static Iterable<FevInventoryItem> parseInventoryItem(InventoryItemModel data) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get logged in username

        final String[] HEADERS = {"id", "name", "address", "price", "note"};

        LOG.info("role data=" + data.getData());
        List<FevInventoryItem> inventItemList = (List<FevInventoryItem>) BeanUtil.getDataList(data.getData(), HEADERS,
                FevInventoryItem.class, SKIP_EMPTYROW, "createdbyUsername", username, "created");

        return inventItemList;
    }
}
