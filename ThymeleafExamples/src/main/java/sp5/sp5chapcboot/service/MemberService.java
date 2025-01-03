package sp5.sp5chapcboot.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp5.sp5chapcboot.controller.RegisterRequest;
import sp5.sp5chapcboot.dao.MemberDao;
import sp5.sp5chapcboot.domain.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}

	public List<Member> getMemberList(LocalDate from, LocalDate to) {
		return memberDao.selectByRegdate(from, to);
	}

	public Member getMember(Long memId) {
		return memberDao.selectById(memId);
	}
}
